/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.investmentwhileloop;

/**
 *
 * @author Mukisa
 */
import java.util.Scanner;

public class InvestmentWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter principal amount: ");
        double principal = input.nextDouble();
        
        System.out.print("Enter time in years: ");
        int time = input.nextInt();
        
        double rate = 0.05;
        double amount = principal;
        int year = 1;
        
        
        while (year <= time) {
            amount = amount + (amount * rate);
            year++;
        }
        
        System.out.println("Principal: " + principal);
        System.out.println("Time: " + time + " years");
        System.out.println("Rate: 5%");
        System.out.println("Final Amount: " + amount);
        
        input.close();
    }
}