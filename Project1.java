/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Project1  {
    static SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");
    static ArrayList<String> itemsList = new ArrayList<String>();
    static String fileName = "C:\\school\\todo.txt";
    public static ArrayList<String> getItemsList() {
        System.out.println(itemsList);
        return itemsList;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int menuSelection = -1;
        while(menuSelection != 0){
            menuSelection = selection();
            switch(menuSelection){
                case 1:
                    createItem();
                    break;
                case 2:
                    markItemInProgress();
                    break;
                case 3:
                    markItemCompleted();
                    break;
                case 4:
                    getItemsList();
                    break;
                case 5:
                    removeCompletedItem();
                    break;
                case 6:
                    quitAndSave();
                    break;
                default:
                    System.out.println("Wrong Input");
                    
            }
        }
    }
    static int selection(){
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1. Create a new item");
        System.out.println("2. Mark an item as in progress");
        System.out.println("3. Mark an item as completed");
        System.out.println("4. List the items");
        System.out.println("5. Remove completed items");
        System.out.println("6. Save and quit");
        choice = sc.nextInt();
        return choice;
    }
    static void listItems (){
        try{
        Scanner readFile = new Scanner(new FileReader(fileName));
        String lines;
        int position = 1;
        while(readFile.hasNextLine()){
            lines = readFile.nextLine();
            System.out.println(position + " ");
            System.out.println(lines);
            ++position;
        }
        readFile.close();
        
        }catch(IOException e){
            System.out.println("File error");
            
        }finally{
           
        }
        
    }

    static void createItem() {
        
        try{
            
            Scanner sc = new Scanner(System.in);
            PrintWriter writeFile = new PrintWriter(new FileWriter(fileName, true));
            System.out.println("What do you need to do?");
            String item = sc.nextLine();
            System.out.println("When do you need to do it?(Date format: mm-dd-yyyy");
            Date date;
            date = new Date(sc.nextInt());
            
            
            String fullItem = "You need to do " +item + " by this date "+ sdf.format(date);
            System.out.print(fullItem);
            itemsList.add(fullItem);
            writeFile.println(fullItem);
            writeFile.close();
        }catch(IOException e){
            System.out.println("File error");
        }
    }

    static void removeCompletedItem() {
        listItems();
        Scanner sc = new Scanner(System.in);
        System.out.println("Removing completed items...");
        for (int i = 0; i < itemsList.size(); i++) {
            if(itemsList.contains(" completed")){
                itemsList.remove(i);
            }else{
                getItemsList();
                System.out.println("Above Items are either in progress or not in progress yet");
            }
            
        }
        
    }

    static void markItemInProgress() {
        Scanner sc = new Scanner(System.in);
        int count2 =0;
        int count =0;
        System.out.println("Which item do you want to mark as in progress?(Starts at 1)");
        getItemsList();
        int progChoice = sc.nextInt();
        for (int i = 0; i < itemsList.size(); i++) {
            System.out.println(itemsList.get(i));
            if(!itemsList.contains("progress") || !itemsList.contains("complete")){
                itemsList.add(progChoice, itemsList.get(progChoice)+"progress");
            }else{
                System.out.println("All not in progress items are now in progress");
            }
            getItemsList();
        
    }
    }

    static void markItemCompleted() {
        
       Scanner sc = new Scanner(System.in);
       getItemsList();
        for (int i = 1; i < itemsList.size(); i++) {
            
        
       //int i = sc.nextInt()+1;
            
        
        if(itemsList.contains("progress")){
            itemsList.add(i, itemsList.get(i)+ " completed");
        }else{
            System.out.println("Item is complete");
        }
        }
            
        
    
    }

    private static void quitAndSave() {
        System.out.println("Saving your data...");
        try{
            PrintWriter writeFile = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < itemsList.size(); i++) {
               writeFile.println(itemsList.get(i)); 
            }
            writeFile.close();
            }catch(IOException e){
                    System.out.println("file error");

                
            
            }finally{
            System.out.println("Exiting...");
            System.exit(0);
        }
        
        
    

   
    
}
}
