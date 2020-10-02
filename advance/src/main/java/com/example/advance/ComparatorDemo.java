package com.example.advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        test();
        practice();
    }

    private static void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("cba");
        list.add("aba");
        list.add("sba");
        list.add("nba");

        //排序方法，默认字母升序排序
        Collections.sort(list);

        System.out.println(list);//[aba, cba, nba, sba]

        //自定义排序规则，按字母降序排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        System.out.println(list);//[sba, nba, cba, aba]
    }

    private static void practice() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("rose", 18));
        students.add(new Student("jack", 16));
        students.add(new Student("abc", 16));
        students.add(new Student("ace", 17));
        students.add(new Student("mark", 16));

        // 使用该方式排序，需在 Student 类中实现 Comparable 接口
        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.getName() + "|" + student.getAge());
            // jack|16
            // abc|16
            // mark|16
            // ace|17
            // rose|18
        }
        System.out.println("----------------");

        // 自定义排序规则，按照年龄升序排序
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 年龄降序
                int result = o2.getAge() - o1.getAge();//年龄降序

                if (result == 0) {
                    //第一个规则判断完了 下一个规则 姓名的首字母 升序
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }

                return result;
            }
        });
        for (Student student : students) {
            System.out.println(student.getName() + "|" + student.getAge());
            // rose|18
            // ace|17
            // abc|16
            // jack|16
            // mark|16
        }
    }
}
