package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //types of defining arraylist
        List myList = new ArrayList();
        ArrayList<String> myStringArrayList = new ArrayList<>();

        //Array Methods
        myList.add(1);
        myList.add(2);
        myList.add(3);

        // System.out.println(myList.contains(2));          -> true
        // System.out.println(myList.contains(4));          -> false
        // System.out.println(myList.get(2));               -> 3

        //System.out.println(myStringArrayList.isEmpty());
        myStringArrayList.add("Hakan");
        myStringArrayList.add("Zeynep");
        myStringArrayList.add("Mehmet");
        //System.out.println(myStringArrayList.isEmpty());

        myStringArrayList.remove(1);
        System.out.println(myStringArrayList);

        System.out.println(myStringArrayList.size());
        System.out.println(myStringArrayList.indexOf("Hakan"));

        Object[] myArray = myStringArrayList.toArray();
        System.out.println(myArray[0]);

        myStringArrayList.set(1,"Ali");
        System.out.println(myStringArrayList);

        //Sorting objects by field using comparator
        Student student1 = new Student(10,"Hakan");
        Student student2 = new Student(50,"Melis");
        Student student3 = new Student(20,"Ali");
        Student student4 = new Student(30,"Ece");
        Student student5 = new Student(60,"Oguz");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println(students.size());
        students.remove(0);
        students.remove(0);
        students.remove(0);
        students.remove(0);
        System.out.println(students.size());

        students.sort(new IdSorter());

        Collections.sort(students, (o1, o2) -> {
            if(o1.getId() == o2.getId())
                return 0;
            return o1.getId() < o2.getId() ? -1 : 1;
        });
        System.out.println(students);

    }
}
class Student {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student" +
                " id=" + id +
                ", name='" + name + '\'';
    }
}
class IdSorter implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getId().compareTo(o1.getId());
    }
}