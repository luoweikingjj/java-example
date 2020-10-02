package com.example.advance.serialize;

import com.example.advance.Student;

import java.io.*;
import java.util.ArrayList;

public class SerializeDemo {
    public static void main(String[] args) {
        serializeDemo();
        unSerializeDemo();
        practice();
    }

    private static void serializeDemo() {
        try {
            // 对象需实现 Serializable 接口
            Student student = new Student("张三", 18);
            student.setAge(20);
            student.setTransientVar("test");//transient瞬态修饰成员,不会被序列化
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\serialize.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("序列化保存完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void unSerializeDemo() {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\serialize.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Student student = (Student) objectInputStream.readObject();

            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getTransientVar());
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
        }
    }

    private static void practice() {
        Student student1 = new Student("张三", 20);
        Student student2 = new Student("李四", 21);
        Student student3 = new Student("王五", 22);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // 序列化
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\serialize.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 反序列化
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\serialize.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Student> newStudents = (ArrayList<Student>) objectInputStream.readObject();

            for (Student student : newStudents) {
                System.out.println(student.getName() + "|" + student.getAge() + "|" + student.getTransientVar());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
