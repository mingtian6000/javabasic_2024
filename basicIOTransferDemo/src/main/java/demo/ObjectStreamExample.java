package demo;

import java.io.*;

public class ObjectStreamExample {
    public static void main(String[] args) {
        String filename = "object.dat";

        writeObjectToFile(filename);

        readObjectFromFile(filename);
    }

    private static void writeObjectToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Person person = new Person("Alice", 25);
            oos.writeObject(person);
            System.out.println("Object has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person person = (Person) ois.readObject();
            System.out.println("Object read from the file: " + person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
