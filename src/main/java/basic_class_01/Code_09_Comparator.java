package basic_class_01;

import java.util.*;

/**
 * 比较器
 *
 * @Author: FangJu
 * @Date: 2019/8/8
 */
public class Code_09_Comparator {
    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);
        Student[] students = {student3, student2, student1};
        printStudent("原数据",students);
        Arrays.sort(students, new IdAscendingComparator());
        printStudent("Id升序数据",students);
        Arrays.sort(students, new IdDescendingComparator());
        printStudent("Id降序数据",students);
        System.out.println("===========优先队列==========");
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);
        while (!heap.isEmpty()){
            Student student = heap.poll();
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        TreeSet<Student> treeSet = new TreeSet<>(new IdDescendingComparator());
        treeSet.add(student3);
        treeSet.add(student2);
        treeSet.add(student1);
        for (Student student : treeSet) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }

    static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    /**
     * 按Id升序
     */
    private static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    /**
     * Id降序
     */
    private static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }


    static void printStudent(String tips, Student[] students) {
        System.out.println("===========" + tips + "===========");
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }
}
