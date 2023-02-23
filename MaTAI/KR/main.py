import pygad
import pygad.torchga as torchga
import torch
import torch.nn as trch
from math import sin
import numpy as np


def myFunc(x, y):
    return x * sin(x + y)


def getData(nFrom=0, delta=5, amount=500):
    X = list(np.linspace(nFrom, nFrom+delta, amount))
    Y = X.copy()
    Z = [float(myFunc(X[i], Y[i])) for i in range(len(X))]
    XnY = [[X[i], Y[i]] for i in range(len(X))]
    Zn = [[Z[i]] for i in range(len(Z))]
    return X, Y, Z, torch.tensor(XnY).to(torch.float32), torch.tensor(Zn).to(torch.float32)


def fitnessFunc(sol, solIdx):
    global XY, Z1, torchGa, myModel, loss_function

    model_weights_dict = torchga.model_weights_as_dict(model=myModel,
                                                       weights_vector=sol)
    myModel.load_state_dict(model_weights_dict)
    predicts = myModel(XY)
    solutionFitness = 1.0 / (loss_function(predicts, Z1).detach().numpy() + 0.00000001)

    return solutionFitness


def callbackGen(gaInst):
    print(f"Generation = {gaInst.generations_completed} | Fitness = {gaInst.best_solution()[1]}")
    print('-'*50)


reluLayer = trch.ReLU()
softmaxLayer = trch.Softmax()
layers = [trch.Linear(2, 4),
          trch.Linear(4, 4),
          trch.Linear(4, 10),
          trch.Linear(10, 4),
          trch.Linear(4, 6),
          trch.Linear(6, 1)]

myModel = trch.Sequential(layers[0], reluLayer,
                          layers[1], reluLayer,
                          layers[2], reluLayer,
                          layers[3], reluLayer,
                          layers[4], reluLayer,
                          layers[5])

print(myModel)

torchGa = torchga.TorchGA(model=myModel,
                          num_solutions=10)
X1, Y1, Z_1, XY, Z1 = getData(amount=50)

loss_function = trch.L1Loss()

numOfGens = 10000
numParentsMating = 5
initPopulation = torchGa.population_weights
typeParentSelect = "sss"
crossoverType = "single_point"
mutationType = "random"
mutationPercentGenes = 10
keepParents = -1

gaInstance = pygad.GA(num_generations=numOfGens,
                      num_parents_mating=numParentsMating,
                      initial_population=initPopulation,
                      fitness_func=fitnessFunc,
                      parent_selection_type=typeParentSelect,
                      crossover_type=crossoverType,
                      mutation_type=mutationType,
                      mutation_percent_genes=mutationPercentGenes,
                      keep_parents=keepParents,
                      on_generation=callbackGen)

gaInstance.run()

gaInstance.plot_fitness()

solution, fitnessSol, idxSol = gaInstance.best_solution()
print(f"Fitness value of the best solution = {fitnessSol}")
print(f"Index of the best solution: {idxSol}")

bestSolWeights = torchga.model_weights_as_dict(model=myModel,
                                               weights_vector=solution)

myModel.load_state_dict(bestSolWeights)
predictions1 = myModel(XY)
for i in range(len(Z_1)):
    print(f"Predictions: {list(predictions1.detach().numpy())[i][0]} : {Z_1[i]}")
absError1 = loss_function(predictions1, Z1)
print("Absolute Error: ", absError1.detach().numpy())

myModel.load_state_dict(bestSolWeights)
X2, Y2, Z_2, XY2, Z2 = getData(amount=100)
predictions2 = myModel(XY2)
for i in range(len(Z2)):
    print(f"Predictions: {list(predictions2.detach().numpy())[i][0]} : {Z_2[i]}")

absError2 = loss_function(predictions2, Z2)
print("Absolute Error: ", absError2.detach().numpy())
