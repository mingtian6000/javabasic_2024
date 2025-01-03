package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionInvokeExample {
    public static void main(String[] args) {
        try {
            Class<?> personClass = Class.forName("reflection.Person");
            Object person = personClass.getConstructor(String.class, int.class).newInstance("Alice", 30);

            Method publicMethod = personClass.getMethod("publicMethod");
            publicMethod.invoke(person);

            Method privateMethod = personClass.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(person);

            Field publicField = personClass.getField("age");
            publicField.set(person, 31);
            System.out.println("Updated age: " + publicField.get(person));

            Field privateField = personClass.getDeclaredField("name");
            privateField.setAccessible(true);
            privateField.set(person, "Bob");
            System.out.println("Updated name: " + privateField.get(person));
            // the object is totally changed
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
