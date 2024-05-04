package demo.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InternalComparatorExample {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 30));
        persons.add(new Person("Charlie", 20));

        Collections.sort(persons);

        for (Person person : persons) {
            System.out.println(person.getName() + ", " + person.getAge());
        }
    }

    static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.age, other.age);
        }
    }
}
