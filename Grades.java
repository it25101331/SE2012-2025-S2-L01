package it25101331;2
import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] subjects = {"Mathematics", "Chemistry", "Physics"};

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            for (int j = 0; j < 3; j++) {
                System.out.print("Marks for " + subjects[j] + ": ");
                marks[i][j] = sc.nextInt();
            }
        }

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Update Student Marks");
            System.out.println("2. Subject Average");
            System.out.println("3. Student Average");
            System.out.println("4. Student Total");
            System.out.println("5. Display Subjects Grade");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID (1-" + n + "): ");
                    int id = sc.nextInt() - 1;

                    System.out.println("Select Subject:");
                    System.out.println("1. Mathematics");
                    System.out.println("2. Chemistry");
                    System.out.println("3. Physics");
                    System.out.print("Enter Subject ID: ");
                    int sub = sc.nextInt() - 1;

                    System.out.print("Enter New Marks for " + subjects[sub] + ": ");
                    marks[id][sub] = sc.nextInt();

                    System.out.println(subjects[sub] + " mark updated successfully.");
                    break;

                case 2:
                    System.out.println("Select Subject:");
                    System.out.println("1. Mathematics");
                    System.out.println("2. Chemistry");
                    System.out.println("3. Physics");
                    System.out.print("Enter Subject ID: ");
                    sub = sc.nextInt() - 1;

                    int subjectSum = 0;

                    for (int i = 0; i < n; i++) {
                        subjectSum += marks[i][sub];
                    }

                    double subjectAvg = (double) subjectSum / n;

                    System.out.println(subjects[sub] + " Average = " + subjectAvg);
                    break;

                case 3:
                    System.out.print("Enter Student ID (1-" + n + "): ");
                    id = sc.nextInt() - 1;

                    int studentSum = 0;

                    for (int j = 0; j < 3; j++) {
                        studentSum += marks[id][j];
                    }

                    double studentAvg = (double) studentSum / 3;

                    System.out.println("Student Average = " + studentAvg);
                    break;

                case 4:
                    System.out.print("Enter Student ID (1-" + n + "): ");
                    id = sc.nextInt() - 1;

                    int total = 0;

                    for (int j = 0; j < 3; j++) {
                        total += marks[id][j];
                    }

                    System.out.println("Student Total = " + total);
                    break;
                
                case 5:
                    System.out.println("\nStudent Grades");
                    System.out.printf("%-10s %-15s %-15s %-15s%n", "Student", "Mathematics", "Chemistry", "Physics");

                    for(int i = 0; i < n; i++){

                        System.out.printf("%-12s", "Student " +(i + 1));

                        for(int j = 0; j < 3; j++){

                            int mark = marks[i][j];
                            String grade;

                            if (mark >= 90){
                                grade = "Grade A";
                            }
                            else if (mark >= 80) {
                                grade = "Grade B";
                            }
                            else if (mark >= 70) {
                                grade = "Grade C";
                            }
                            else if (mark >= 60) {
                                grade = "Grade D";
                            }
                            else
                            {
                                grade = "Fail";
                            }
                            System.out.printf("%-15s", grade);
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}