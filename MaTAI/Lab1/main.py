import skfuzzy
import matplotlib.pyplot as plt
import random
import numpy as np
from skfuzzy import fuzzymath

def getRandomNumbers(nfrom, nto, amount, sorted = True) -> list:
    arrand = []
    while len(arrand) < amount:
        temp = random.randint(nfrom, nto + 1)
        if temp not in arrand and temp != 0:
            arrand.append(temp)
    if sorted:
        arrand.sort()
    return arrand

x = np.arange(-5, 15, 0.25)
plt.style.use('bmh')

# Пункт №1
# Трикутна функція приналежності
a, b, c, d = getRandomNumbers(1, 11, 4)
print("Функції приналежності")
print(a, b, c, d)
fig1, (ax11, ax12) = plt.subplots(1, 2)
fig1.suptitle("Функції приналежності")
y_tri = skfuzzy.trimf(x, [a, b, c])
ax11.plot(x, y_tri)
ax11.set_title("Трикутна")
# Трапецієвидна функція приналежності
y_trap = skfuzzy.trapmf(x, [a, b, c, d])
ax12.plot(x, y_trap)
ax12.set_title("Трапецієподібна")
plt.show()

# Пункт №2
# Проста функція приналежності Гаусса
a, b, c, d = getRandomNumbers(1, 11, 4)
print("Функції приналежності Гаусса")
print(a, b, c, d)
fig2, (ax21, ax22) = plt.subplots(1, 2)
fig2.suptitle("Функції приналежності Гаусса")
y_gauss = skfuzzy.gaussmf(x, a, b)
ax21.plot(x, y_gauss)
ax21.set_title("Проста")
# Двостороння функція приналежності Гаусса
y_gauss2 = skfuzzy.gauss2mf(x, a, b, c, d)
ax22.plot(x, y_gauss2)
ax22.set_title("Двостороння")
plt.show()

# Пункт №3
# Функція приналежності "Узагальнений дзвін"
a, b, c = getRandomNumbers(1, 11, 3)
print("Функція приналежності 'Узагальнений дзвін'")
print(a, b, c)
y_gbell = skfuzzy.gbellmf(x, a, b, c)
plt.plot(x, y_gbell)
plt.title("Функція приналежності 'Узагальнений дзвін'")
plt.show()

# Пункт №4
# Основна одностороння сигмоїдна функція
a, b, c, d = getRandomNumbers(1, 11, 4)
print("Cигмоїдні функції")
print(a, b, c, d)
fig4, (ax41, ax42) = plt.subplots(1, 2)
fig4.suptitle("Cигмоїдні функції")
y_sigm = skfuzzy.sigmf(x, b, c)
ax41.plot(x, y_sigm)
ax41.set_title("Основна одностороння")
# Додаткова двостороння сигмоїдна функція
y_dsig = skfuzzy.dsigmf(x, a, b, c, d)
ax42.plot(x, y_dsig)
ax42.set_title("Додаткова двостороння")
plt.show()
# Додаткова несиметрична сигмоїдна функція
y_psig = skfuzzy.psigmf(x, a, b, c, d)
plt.plot(x, y_psig)
plt.title("Додаткова несиметрична")
plt.show()

# Пункт №5
# Z-функція приналежності
a, b, c, d = getRandomNumbers(1, 11, 4)
print("Функції приналежності")
print(a, b, c, d)
fig5, (ax51, ax52, ax53) = plt.subplots(1, 3)
fig5.suptitle("Функції приналежності")
y_z = skfuzzy.zmf(x, a, b)
ax51.plot(x, y_z)
ax51.set_title("Z")
# PI-функція приналежності
y_pi = skfuzzy.pimf(x, a, b, c, d)
ax52.plot(x, y_pi)
ax52.set_title("PI")
# S-функція приналежності
y_s = skfuzzy.smf(x, a, b)
ax53.plot(x, y_s)
ax53.set_title("S")
plt.show()

# Пункт №6
# Мінімаксна інтерпретація логічних операторів
a, b, c, d = getRandomNumbers(1, 11, 4)
print("Мінімаксна інтерпретація логічних операторів")
print(a, b, c, d)
fig6, (ax61, ax62) = plt.subplots(1, 2)
fig6.suptitle("Мінімаксна інтерпретація логічних операторів")
# з використанням операцій пошуку мінімуму
y1_gauss = skfuzzy.gaussmf(x, a, b)
y2_gauss = skfuzzy.gaussmf(x, c, d)
z1, z2 = fuzzymath.fuzzy_logic.fuzzy_or(x, y1_gauss, x, y2_gauss)
z3, z4 = fuzzymath.fuzzy_logic.fuzzy_and(x, y1_gauss, x, y2_gauss)
ax61.plot(z3, z4)
ax61.plot(z1, z2, linestyle='-.')
ax61.set_title("Мінімум")
# з використанням операцій пошуку максимуму
y1_gauss = skfuzzy.gaussmf(x, a, b)
y2_gauss = skfuzzy.gaussmf(x, c, d)
z1, z2 = fuzzymath.fuzzy_logic.fuzzy_or(x, y1_gauss, x, y2_gauss)
z3, z4 = fuzzymath.fuzzy_logic.fuzzy_and(x, y1_gauss, x, y2_gauss)
ax62.plot(z1, z2)
ax62.plot(z3, z4, linestyle='-.')
ax62.set_title("Максимум")
plt.show()

# Пункт №7
# Вірогідна інтерпретація
a, b, c, d = getRandomNumbers(1, 11, 4)
print("Вірогідна інтерпретація кон'юнктивних і диз'юнктивних операторів")
print(a, b, c, d)
y1 = skfuzzy.gaussmf(x, a, b)
y2 = skfuzzy.gaussmf(x, c, d)
# Кон'юнктивних операторів
y_product = y1 * y2
plt.plot(x, y_product)
plt.plot(x, y1, linestyle='--', linewidth=2, color='crimson')
plt.plot(x, y2, linestyle='--', linewidth=2, color='purple')
plt.title("Перетин функцій")
plt.show()
# Диз'юнктивних операторів
y_sum = y1 + y2 - y_product
plt.plot(x, y_sum)
plt.plot(x, y1, linewidth=2, linestyle='--', color='crimson')
plt.plot(x, y2, linestyle='--', linewidth=2, color='purple')
plt.title("Об'єднання функцій")
plt.show()

# Пункт №8
# Доповнення нечіткої множини
a, b = getRandomNumbers(1, 11, 2)
print("Доповнення нечіткої множини")
print(a, b)
y = skfuzzy.gaussmf(x, a, b)
plt.title("Доповнення нечіткої множини")
plt.plot(y, linestyle='--', linewidth=2, color='crimson')
plt.plot(1 - y)
plt.show()
