/*
 * Implement your own selection sort method and place your code in a separate Java source file.
 * Do not use a sort method from the Java collections library.
 * 
 * selection sort compares the first open value in an array and compares it to all other values in the array
 * once it iterates through the array, if it finds a value smaller value then the one in the first postion it swaps them and repeats the process 
 */

import java.util.ArrayList;
import java.util.Comparator;
//import ArrayList & Compactor

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(5, "Jack", "42 Navy Road"));
        students.add(new Student(1, "Zavon", "96 Washington St"));
        students.add(new Student(3, "Lance", "78 Dragon Rd"));
        students.add(new Student(2, "Adi", "222 Mechanical Ave"));
        students.add(new Student(10, "Xander", "147 Bird Blvd"));
        students.add(new Student(7, "Alex", "23 Rival Dr"));
        students.add(new Student(6, "Kat", "40 Baker Ct"));
        students.add(new Student(8, "Sam", "30 Henderson Ln"));
        students.add(new Student(9, "Zach", "1 Piece Pkwy"));
        students.add(new Student(4, "Ryan", "101 Python Way"));
        // list of students objects added to ArrayList with name roll number and adress
        // ArrayList is different than array as size can not be modified

        SelectionSortMethod.selectionSort(students, new Student.NameComparator());
        for (Student s : students) {
            s.display();
            System.out.println(" ");
        }
        // Calling selectionSort from SelectionSortMethod using students & new Student.NameComparator() as parameters to sort the students by comparing their names
        // for Student s in students display student names in order (also add a new line so its easier to read)

        SelectionSortMethod.selectionSort(students, new Student.RollComparator());
        for (Student s : students) {
            s.display();
            System.out.println(" ");
        }
        // Calling selectionSort from SelectionSortMethod using students & new Student.RollComparator() as parameters to sort the students by comparing their Roll numbers
        // Same as above where for Student s in students display student roll numbers in order (also add a new line so its easier to read)
    }
}

class SelectionSortMethod {
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // selectionSort takes args ArrayList and Comparator from student n equals the list size
            // iterates through list and adds one each time as unsorted part will be getting smaller and smaller due to swapping

            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // i is smallest value, i + 1 is J, loop through the rest of the list
            // The comparator checks if any J value is less than min index (i). If it is then it makes j the new minindex

            if (minIndex != i) {
                Student temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
            // if min index does not = i (it would = j assuming there is a new smaller number later down the list)
            // sets I to new temporary placeholder
            // list gets the current student at i and replaces it with minindex and sets minindex to the temp value which was i
        }
    }
}