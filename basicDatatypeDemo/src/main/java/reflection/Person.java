package reflection;

public class Person {
    public int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    public void publicMethod() {
        System.out.println("This is a public method.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "person is: " + this.name + " , " + this.age;
    }
}
