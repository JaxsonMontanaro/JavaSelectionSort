/*
 * Create a Java program that will store 10 student objects in an ArrayList, ArrayList<Student>. 
 * 
 * A student object consists of the following fields:
 * int rollno
 * String name
 * String address
 * 
 * Implement two comparator classes to sort student objects by name and by rollno (roll number). 
 */

import java.util.Comparator;
// import to use ArrayList and comparator

class Student {
    int rollno;
    String name;
    String address;
    // Student class with objects for array

    Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    // Constructor which takes in objects as arguments and initializes them

    public void display() {
        System.out.println("Roll Number: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Adress: " + address);
    }

    // Print objects to screen

    static class NameComparator implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.name.compareToIgnoreCase(b.name);
        }
    }
    // comparator class allows a user to specify a sorting rule
    // NameComparator implements Comparator to Students array by compareing Student a & Student b (arguments)
    // returns -1,0, or 1 depending on value assigned when student A name is compared to Student B name
    // ignore case ignores the case of the letters

    static class RollComparator implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return Integer.compare(a.rollno, b.rollno);
        }
    }
    // Same as NameComparator however since value is an int, Integer.compare works
}

/*
 * Recources:
 * https://www.w3schools.com/java/java_arraylist.asp
 * https://www.w3schools.com/java/java_advanced_sorting.asp#:~:text=The%20Comparator%20interface%20allows%20you,go%20first%20in%20a%20list.
 * https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 * https://stackoverflow.com/questions/21900376/the-type-new-comparator-must-implement-the-inherited-abstract-method-compara
 * https://www.w3schools.com/dsa/dsa_algo_selectionsort.php
 * https://www.geeksforgeeks.org/java-comparator-interface/
 * https://www.w3schools.com/dsa/dsa_algo_selectionsort.php
 * https://stackoverflow.com/questions/8362640/java-selection-sort-algorithm
 */