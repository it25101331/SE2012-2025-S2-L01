package it25101331;

import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        // Store marks [student][subject]
        int[][] marks = new int[n][3];
        
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student mark");
            System.out.println("3. Average marks of a subject");
            System.out.println("4. Average marks of a student");
            System.out.println("5. Total marks of a student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                // Add student marks
                case 1:
                    System.out.print("Enter Student ID (1-" + n + "): ");
                    int studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid Student ID");
                        break;
                    }
                    System.out.print("Mathematics: ");
                    marks[studentID - 1][0] = sc.nextInt();
                    System.out.print("Chemistry: ");
                    marks[studentID - 1][1] = sc.nextInt();
                    System.out.print("Physics: ");
                    marks[studentID - 1][2] = sc.nextInt();
                    System.out.println("Marks Added Successfully!");
                    break;

                // Update student mark
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid ID");
                        break;
                    }
                    System.out.print("Enter Subject ID (1=Math, 2=Chemistry, 3=Physics): ");
                    int subjectID = sc.nextInt();
                    if (subjectID < 1 || subjectID > 3) {
                        System.out.println("Invalid ID");
                        break;
                    }
                    System.out.print("Enter New Mark: ");
                    int newMark = sc.nextInt();
                    marks[studentID - 1][subjectID - 1] = newMark;
                    System.out.println("Mark Updated Successfully!");
                    break;

                // Average marks of a subject
                case 3:
                    System.out.print("Enter Subject ID (1=Math, 2=Chemistry, 3=Physics): ");
                    subjectID = sc.nextInt();
                    if (subjectID < 1 || subjectID > 3) {
                        System.out.println("Invalid Subject ID");
                        break;
                    }
                    int subjectTotal = 0;
                    for (int i = 0; i < n; i++) {
                        subjectTotal += marks[i][subjectID - 1];
                    }
                    double subjectAverage = (double) subjectTotal / n;
                    System.out.println("Average Marks of Subject = " + subjectAverage);
                    break;

                // Average marks of a student
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid Student ID");
                        break;
                    }
                    int total = 0;
                    for (int i = 0; i < 3; i++) {
                        total += marks[studentID - 1][i];
                    }
                    double average = total / 3.0;
                    System.out.println("Student Average = " + average);
                    break;

                // Total marks of a student
                case 5:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid Student ID");
                        break;
                    }
                    total = 0;
                    for (int i = 0; i < 3; i++) {
                        total += marks[studentID - 1][i];
                    }
                    System.out.println("Total Marks = " + total);
                    break;

                // Exit program
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return; // Terminates main method loop cleanly

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}