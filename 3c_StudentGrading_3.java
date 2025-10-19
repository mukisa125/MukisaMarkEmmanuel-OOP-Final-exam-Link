/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgrading_3;

/**
 *
 * @author Mukisa
 */
import java.util.Scanner;
public class StudentGrading_3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Arrays to store grade counts
        int[] gradeCount = new int[10]; // grades 1-9
        
        System.out.println("Enter scores for 5 students:");
        
        int studentCount = 1;
        // Process 5 students using while loop
        while(studentCount <= 5) {
            System.out.print("\nStudent " + studentCount + " score (0-100): ");
            int score = input.nextInt();
            
            String grade;
            String remark;
            
            // Determine grade
            if(score >= 80 && score <= 100) {
                grade = "1";
                remark = "Distinction";
                gradeCount[1]++;
            } else if(score >= 75 && score <= 79) {
                grade = "2";
                remark = "Distinction";
                gradeCount[2]++;
            } else if(score >= 66 && score <= 74) {
                grade = "3";
                remark = "Credit";
                gradeCount[3]++;
            } else if(score >= 60 && score <= 65) {
                grade = "4";
                remark = "Credit";
                gradeCount[4]++;
            } else if(score >= 50 && score <= 59) {
                grade = "5";
                remark = "Credit";
                gradeCount[5]++;
            } else if(score >= 45 && score <= 49) {
                grade = "6";
                remark = "Credit";
                gradeCount[6]++;
            } else if(score >= 35 && score <= 44) {
                grade = "7";
                remark = "Pass";
                gradeCount[7]++;
            } else if(score >= 30 && score <= 34) {
                grade = "8";
                remark = "Pass";
                gradeCount[8]++;
            } else if(score >= 0 && score <= 29) {
                grade = "9";
                remark = "Fail";
                gradeCount[9]++;
            } else {
                grade = "Invalid";
                remark = "Invalid Score";
            }
            
            // Display individual student result
            System.out.println("Grade: " + grade + " | Remark: " + remark);
            
            studentCount++;
        }
        
        // Display summary
        System.out.println("\n=== GRADE SUMMARY ===");
        System.out.println("Grade Distribution:");
        for(int i = 1; i <= 9; i++) {
            System.out.println("Grade " + i + ": " + gradeCount[i] + " students");
        }
        
        input.close();
    }
}