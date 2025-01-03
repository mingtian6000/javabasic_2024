package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class BasicDemo {
    public static void main(String[] args) {
        try {
            //相对路径的包名。。
            Class<?> personClass = Class.forName("reflection.Person");

            System.out.println("Class name: " + personClass.getName());

            int modifiers = personClass.getModifiers();
            System.out.println("Modifiers: " + Modifier.toString(modifiers));

            Class<?> superclass = personClass.getSuperclass();
            System.out.println("Superclass: " + (superclass != null ? superclass.getName() : "None"));

            Class<?>[] interfaces = personClass.getInterfaces();
            System.out.println("Interfaces:");
            for (Class<?> i : interfaces) {
                System.out.println(i.getName());
            }

            Field[] fields = personClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field name: " + field.getName());
                System.out.println("Field modifiers: " + Modifier.toString(field.getModifiers()));
                System.out.println("Field type: " + field.getType());
            }
            Method[] methods = personClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method name: " + method.getName());
                System.out.println("Method modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println("Method return type: " + method.getReturnType());
                Parameter[] parameters = method.getParameters();
                System.out.print("Method parameters: ");
                for (Parameter parameter : parameters) {
                    System.out.print(parameter.getType() + " " + parameter.getName() + ", ");
                }
                System.out.println();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
