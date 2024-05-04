package demo.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExternalComparatorExample {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 30));
        persons.add(new Person("Charlie", 20));

        //
        Comparator<Person> ageComparator = new AgeComparator();

        Collections.sort(persons, ageComparator);

        for (Person person : persons) {
            System.out.println(person.getName() + ", " + person.getAge());
        }
    }

    static class Person {
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
    }

    static class AgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person person1, Person person2) {
            return Integer.compare(person1.getAge(), person2.getAge());
        }
    }
}
