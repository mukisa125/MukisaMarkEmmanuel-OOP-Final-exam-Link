/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mirrorfocallength_2;

/**
 *
 * @author Mukisa
 */
import java.util.Scanner;
public class MirrorFocalLength_2 {

  public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get object distance (u) - always negative for concave mirror
        System.out.print("Enter object distance u (cm): ");
        double u = input.nextDouble();
        u = -Math.abs(u); // Make sure u is negative
        
        // Get image distance (v) - positive for real images
        System.out.print("Enter image distance v (cm): ");
        double v = input.nextDouble();
        
        // Calculate focal length using mirror formula: 1/f = 1/v + 1/u
        double f = 1 / ((1/v) + (1/u));
        
        // Display results
        System.out.println("\nMirror Analysis Results:");
        System.out.println("Object distance (u): " + u + " cm");
        System.out.println("Image distance (v): " + v + " cm");
        System.out.printf("Focal length (f): %.2f cm\n", f);
        
        // Check if mirror is acceptable (f between 21.0cm and 25.0cm)
        if (f >= 21.0 && f <= 25.0) {
            System.out.println("Status: ACCEPTED - Focal length is within acceptable range");
        } else {
            System.out.println("Status: REJECTED - Focal length is outside acceptable range");
        }
        
        input.close();
    }
}