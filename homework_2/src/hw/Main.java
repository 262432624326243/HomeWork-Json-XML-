package hw;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = null;
        try (FileReader fr = new FileReader("json.txt")) {
            person = gson.fromJson(fr, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(person);
    }
}
