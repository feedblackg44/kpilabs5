import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private int age;
    private boolean hasPet;

    public Person(String name, String surname, int age, boolean hasPet) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasPet = hasPet;
    }
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public int getAge() {
        return this.age;
    }
    public boolean hasPet() {
        return this.hasPet;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Person person = (Person) obj;

        return  Objects.equals(getName(), person.getName()) &&
                Objects.equals(getSurname(), person.getSurname()) &&
                getAge() == person.getAge() && hasPet() == person.hasPet();
    }
}
