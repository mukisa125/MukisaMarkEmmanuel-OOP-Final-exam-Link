/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accommodationmanagement;

/**
 *
 * @author Mukisa
 */
import java.util.Scanner;

class GymArea {
    int occupants = 0;
    boolean light1 = false;
    boolean light2 = false;
    boolean light3 = false;
}

class SwimmingArea {
    int occupants = 0;
    boolean light1 = false;
    boolean light2 = false;
    boolean light3 = false;
}
public class AccommodationManagement {

   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        GymArea gym = new GymArea();
        SwimmingArea pool = new SwimmingArea();
        
        
        String activeArea = "gym";
        
        char choice;
        
        System.out.println("Accommodation Area Manager");
        
        do {
            System.out.println("\nMain Menu - Active Area: " + activeArea);
            System.out.println("S - Select area (G=P=Swim)");
            System.out.println("W - Add occupants");
            System.out.println("X - Remove occupants");
            System.out.println("Y - Switch ON light");
            System.out.println("Z - Switch OFF light");
            System.out.println("R - Report status");
            System.out.println("Q - Quit");
            System.out.print("Enter choice: ");
            
            choice = input.next().toUpperCase().charAt(0);
            
            switch(choice) {
                case 'S':
                    System.out.print("Select area (G for Gym, P for Pool): ");
                    char area = input.next().toUpperCase().charAt(0);
                    if (area == 'G') {
                        activeArea = "gym";
                        System.out.println("Active area: Gym");
                    } else if (area == 'P') {
                        activeArea = "pool";
                        System.out.println("Active area: Swimming Pool");
                    } else {
                        System.out.println("Invalid area!");
                    }
                    break;
                    
                case 'W':
                    System.out.print("Enter number of occupants to add: ");
                    if (input.hasNextInt()) {
                        int n = input.nextInt();
                        if (activeArea.equals("gym")) {
                            gym.occupants += n;
                            System.out.println(n + " occupants added. Total: " + gym.occupants);
                        } else {
                            pool.occupants += n;
                            System.out.println(n + " occupants added. Total: " + pool.occupants);
                        }
                    } else {
                        System.out.println("Invalid input! Enter integer only.");
                        input.next();
                    }
                    break;
                    
                case 'X':
                    System.out.print("Enter number of occupants to remove: ");
                    if (input.hasNextInt()) {
                        int n = input.nextInt();
                        if (activeArea.equals("gym")) {
                            if (n > gym.occupants) {
                                gym.occupants = 0;
                            } else {
                                gym.occupants -= n;
                            }
                            System.out.println("Occupants now: " + gym.occupants);
                        } else {
                            if (n > pool.occupants) {
                                pool.occupants = 0;
                            } else {
                                pool.occupants -= n;
                            }
                            System.out.println("Occupants now: " + pool.occupants);
                        }
                    } else {
                        System.out.println("Invalid input! Enter integer only.");
                        input.next();
                    }
                    break;
                    
                case 'Y':
                    System.out.print("Enter light number (1,2,3) to switch ON: ");
                    if (input.hasNextInt()) {
                        int light = input.nextInt();
                        if (light >= 1 && light <= 3) {
                            if (activeArea.equals("gym")) {
                                if (light == 1) gym.light1 = true;
                                if (light == 2) gym.light2 = true;
                                if (light == 3) gym.light3 = true;
                            } else {
                                if (light == 1) pool.light1 = true;
                                if (light == 2) pool.light2 = true;
                                if (light == 3) pool.light3 = true;
                            }
                            System.out.println("Light " + light + " switched ON");
                        } else {
                            System.out.println("Light number must be 1, 2 or 3");
                        }
                    } else {
                        System.out.println("Invalid input! Enter integer only.");
                        input.next();
                    }
                    break;
                    
                case 'Z':
                    System.out.print("Enter light number (1,2,3) to switch OFF: ");
                    if (input.hasNextInt()) {
                        int light = input.nextInt();
                        if (light >= 1 && light <= 3) {
                            if (activeArea.equals("gym")) {
                                if (light == 1) gym.light1 = false;
                                if (light == 2) gym.light2 = false;
                                if (light == 3) gym.light3 = false;
                            } else {
                                if (light == 1) pool.light1 = false;
                                if (light == 2) pool.light2 = false;
                                if (light == 3) pool.light3 = false;
                            }
                            System.out.println("Light " + light + " switched OFF");
                        } else {
                            System.out.println("Light number must be 1, 2 or 3");
                        }
                    } else {
                        System.out.println("Invalid input! Enter integer only.");
                        input.next();
                    }
                    break;
                    
                case 'R':
                    System.out.println("\nStatus Report:");
                    if (activeArea.equals("gym")) {
                        System.out.println("Area: Gym");
                        System.out.println("Occupants: " + gym.occupants);
                        System.out.println("Light 1: " + (gym.light1 ? "ON" : "OFF"));
                        System.out.println("Light 2: " + (gym.light2 ? "ON" : "OFF"));
                        System.out.println("Light 3: " + (gym.light3 ? "ON" : "OFF"));
                    } else {
                        System.out.println("Area: Swimming Pool");
                        System.out.println("Occupants: " + pool.occupants);
                        System.out.println("Light 1: " + (pool.light1 ? "ON" : "OFF"));
                        System.out.println("Light 2: " + (pool.light2 ? "ON" : "OFF"));
                        System.out.println("Light 3: " + (pool.light3 ? "ON" : "OFF"));
                    }
                    break;
                    
                case 'Q':
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
            
        } while(choice != 'Q');
        
  
    }
}
