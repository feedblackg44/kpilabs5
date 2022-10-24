import com.google.gson.Gson;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person1 = new Person(
                "Ruslan",
                "Nezhenets",
                19,
                true
        );
        String json = gson.toJson(person1);
        Person person2 = gson.fromJson(json, Person.class);
        System.out.println(person1 == person2);
        System.out.println(Objects.equals(person1, person2));
    }
}