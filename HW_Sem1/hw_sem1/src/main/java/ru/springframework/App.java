package ru.springframework;

import com.google.gson.Gson;

import java.io.*;

/**
 * Hello world!
 * Задание:
 * 1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
 * 2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
 * 3. Создайте класс Person с полями firstName, lastName и age.
 * 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
 * 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Person person = new Person("Vladislav", "Pugovkin", 23);
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("person.json"))){
            String personJson = gson.toJson(person);
            System.out.println("Write person to JSON: " + personJson);
            bw.write(personJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedReader br = new BufferedReader(new FileReader("person.json"))) {
            Person personFromJson = gson.fromJson(br, Person.class);
            System.out.println("Read person from JSON: " + personFromJson);
        }
    }
}
