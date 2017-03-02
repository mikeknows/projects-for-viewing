/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String switchvar;
        double correct = 0;
        double attempts = 0;
        while (true) {//Keeps the switch running

            Random rdm = new Random();
            Scanner sc = new Scanner(System.in);
            System.out.print("***Math Quiz for Beginners***\nPlease choose one of the following options for your math quiz: \n1. Addition with numbers 1-10\n2. Addition with numbers 1-100\n3. Subtraction with numbers 1-10\n4. Subtraction with numbers 1-100\n5. Multiplication with numbers 1-10\n6. Exit the program\n");
            switchvar = sc.next();

            while (!Character.isDigit(switchvar.charAt(0))) {//If the switch variable input is not a number, it will catch it and have the user input again

                System.out.println("Try 1 through 6");
                switchvar = sc.next();
            }

            switch (switchvar) {

                case "1"://Takes two random int variables that range from 1 to 10, adds them and puts them into another variable. The resulting variable is checked against the user input, if the user's input is different than the result variable, the user is given a messaging indicating they have given the wrong answer; if it matches the result variable the user receives a message letting them know it was correct.
                    for (int i = 1; i <= 5; i++) {
                        int addvar = rdm.nextInt(9) + 1;
                        int addvar1 = rdm.nextInt(9) + 1;
                        int addsum = addvar1 + addvar;
                        System.out.printf("%d + %d: ", addvar, addvar1);
                        int addanswer1 = sc.nextInt();
                        if (addanswer1 == addsum) {
                            correct++;//When the answer is correct it adds 1 to the attempts and to the amount correct
                            attempts++;
                            System.out.println("Correct answer!");
                        } else if (addanswer1 != addsum) {
                            attempts++;
                            System.out.printf("%d is the wrong answer\nThe correct answer is %d\n", addanswer1,addsum);                      
                        }
                    }
                    break;
                case "2":
                    for (int i = 1; i <= 5; i++) {
                        int addvar1 = rdm.nextInt(99) + 1;
                        int addvar = rdm.nextInt(99) + 1;
                        int addsum = addvar1 + addvar;
                        System.out.printf("%d + %d: ", addvar1, addvar);
                        int addanswer1 = sc.nextInt();
                        if (addanswer1 == addsum) {
                            correct++;
                            attempts++;
                            System.out.println("Correct answer!");
                        } else if (addanswer1 != addsum) {
                            attempts++;
                            System.out.printf("%d is the wrong answer\nThe correct answer is %d\n", addanswer1,addsum);
                        } 
                    }
                    break;
                case "3":
                    for (int i = 1; i <= 5; i++) {
                        int addvar1 = rdm.nextInt(9) + 1;
                        int addvar = rdm.nextInt(9) + 1;
                        int addsum = addvar1 - addvar;
                        System.out.printf("%d - %d: ", addvar1, addvar);
                        int addanswer1 = sc.nextInt();
                        if (addanswer1 == addsum) {
                            correct++;
                            attempts++;
                            System.out.println("Correct answer!");
                        } else if (addanswer1 != addsum) {
                            attempts++;
                            System.out.printf("%d is the wrong answer\nThe correct answer is %d\n", addanswer1,addsum);
                        } 
                    }
                    break;
                case "4":
                    for (int i = 1; i <= 5; i++) {
                        int addvar1 = rdm.nextInt(99) + 1;
                        int addvar = rdm.nextInt(99) + 1;
                        int addsum = addvar1 - addvar;
                        System.out.printf("%d - %d: ", addvar1, addvar);
                        int addanswer1 = sc.nextInt();
                        if (addanswer1 == addsum) {
                            correct++;
                            attempts++;
                            System.out.println("Correct answer!");
                        } else if (addanswer1 != addsum) {
                            attempts++;
                            System.out.printf("%d is the wrong answer\nThe correct answer is %d\n", addanswer1,addsum);
                        } 
                    }
                    break;
                case "5":
                    for (int i = 1; i <= 5; i++) {
                        int addvar1 = rdm.nextInt(9) + 1;
                        int addvar = rdm.nextInt(9) + 1;
                        int addsum = addvar * addvar1;
                        System.out.printf("%d * %d: ", addvar, addvar1);
                        int addanswer1 = sc.nextInt();
                        if (addanswer1 == addsum) {
                            correct++;
                            attempts++;
                            System.out.println("Correct answer!");
                        } else if (addanswer1 != addsum) {
                            attempts++;
                            System.out.printf("%d is the wrong answer\nThe correct answer is %d\n", addanswer1,addsum);
                        } 
                    }
                    break;
                case "6":
                    double performance = correct / attempts * 100;//Takes count and performance variables divides them and multiplies the result by 100 because it's a double
                    System.out.printf("You got %f problems correct out of %f problems attempted. That is %.2f percent correct. Goodbye!\n", correct, attempts, performance);//Prints result of above calculation
                    if(performance>=80.00){
                        System.out.println("Good job!\n");
                    }else if(performance<=20.00){
                        System.out.println("Try harder!\n");                       
                    }
                    System.exit(0);
                    break;

                default: {//If a user inputs something other than the listed case numbers, it returns here and informs the user to try again
                    System.out.println("Try 1 through 6");
                }

            }
        }
    }
}
