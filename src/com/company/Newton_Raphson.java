package com.company;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Newton_Raphson {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Please enter the function's degree: ");
        int degree = input.nextInt();
        System.out.println(" Please enter the beginner point : ");
        double beginner_point = input.nextDouble();
        System.out.println(" Please enter how many times do you need calculation : ");
        int step_number = input.nextInt();
       double [] results  = new double[step_number];
       double [] coefficient = new double[degree+1];
        System.out.println(" Please enter the coefficients : ");
       for(int i = 0 ; i<coefficient.length ; i++){
           coefficient[i] = input.nextDouble();
       }
       double function_sum = 0 ;
       for(int j = 0 ; j< coefficient.length ; j++){
           function_sum +=coefficient[j]*beginner_point;
       }
       results[0] = beginner_point ;
       for(int i = 1 ; i<step_number ; i++){
           results[i] = results[i-1] - (function_sum/derivative(degree,coefficient,beginner_point));
       }
        System.out.println(Arrays.toString(results));
    }

    public static double derivative(int degree,double [] array,double beginner_point) {
        double[] derivatived = new double[array.length-1];
        for(int j = 0 ;j< derivatived.length ; j++){
            derivatived[j] = array[j]*(degree-j);
        }
        double derivative_sum = 0 ;
        for(int i = 0 ; i< derivatived.length ; i++){
            derivative_sum +=derivatived[i]*beginner_point;
        }
        return derivative_sum ;
    }


    public static void display(double[] array) {
        for (double i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }
}
