package org.example.json.gsonDemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.entity.Grade;
import org.example.entity.Student;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //convert object list to json array
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("Alice", 12, Grade.GRADE2));
        stuList.add(new Student("Bob", 15, Grade.GRADE5));
        stuList.add(new Student("Charlie", 12, Grade.GRADE2));
        String jsonArray = gson.toJson(stuList);
        System.out.println(jsonArray);

        //convert array to object list
        String jsonArr = """
                [{"name":"Alice1","age":12,"grade":"GRADE3"},{"name":"Bob1","age":15,"grade":"GRADE4"}]
                """;
        Type stuListType = new TypeToken<List<Student>>(){}.getType();
        List<Student> studentList = gson.fromJson(jsonArr, stuListType); // it must need a typeToken or class when convert back to object
        for (Student s : studentList) {
            System.out.println("Name: " + s.getName() + ", Age: " + s.getAge() + ", Grade: " + s.getGrade());
        }
    }
}
