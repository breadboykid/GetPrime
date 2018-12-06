/*
 *Copyright 2018 Zi Feng Pan
 */
package getprime;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * @author breadboykid
 **/

public class GetPrime {

    int currentNumber, counter, N;
    List<Integer> list;

    public GetPrime(int n){
        this.N = n;
        this.currentNumber = 7;
        this.counter = 0;
        this.list = new LinkedList<Integer>();
    }

    //Getters
    private int getCurrentNumber(){
        return this.currentNumber;
    }

    /*
    private int getCounter(){
        return this.counter;
    }*/

    private int getQueryNumber(){
        return this.N;
    }

    //Setters
    private void setNextNumber(){
        if(counter == 4){
            this.currentNumber += 4;
        }else{
            this.currentNumber += 2;
        }
    }

    private void setNextCounter(){
        if(this.counter == 4){
            this.counter = 0;
        }else{
            this.counter++;
        }
    }

    //if the user input number is >=7 it will add 2, 3, 5 onto the list of prime numbers and iterate from 7
    public void setInitialList(){
        this.list.add(2);
        this.list.add(3);
        this.list.add(5);
    }

    //checks if number in question is a prime by iterating through
    public boolean isPrime(int p){
        for(int element : list){
            /* Code optimization. Algorithm to increase efficiency, Especially for larger numbers.
             Only need to iterate below element <= Sqrt(p). Getting error. Will implement later.
            if(element > Math.sqrt(p)){
                break;
            }*/
            if(p%element == 0) {
                return false;
            }
        }
        return true;
    }

    public void addCurrentToList(int cur){
        list.add(cur);
    }

    public static void main(String[] args) throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        boolean play = true;
        int query;

        while(play){

            System.out.println("Please enter a number n to output all prime numbers from 0 to n: ");

            try{
                query = scan.nextInt();

                //main chunk of program
                GetPrime gp = new GetPrime(query);


                if(gp.getQueryNumber() < 2){
                    System.out.println("No Prime numbers found");
                }else if(gp.getQueryNumber() >= 2 && gp.getQueryNumber() < 3){
                    gp.list.add(2);
                    System.out.println("Prime numbers is: " + gp.list.toString());
                }else if(gp.getQueryNumber() >= 3 && gp.getQueryNumber() < 5){
                    gp.list.add(2);
                    gp.list.add(3);
                    System.out.println("Prime numbers is: " + gp.list.toString());
                }else if(gp.getQueryNumber() >= 5 && gp.getQueryNumber() < 7){
                    gp.list.add(2);
                    gp.list.add(3);
                    gp.list.add(5);
                    System.out.println("Prime numbers is: " + gp.list.toString());
                }else{
                    gp.setInitialList();
                    while(gp.getCurrentNumber() <= gp.getQueryNumber()){
                        //checks if current number is a prime
                        if(gp.isPrime(gp.getCurrentNumber())){
                            gp.addCurrentToList(gp.getCurrentNumber());
                        }else{//iterates to next query to check on next loop
                            gp.setNextCounter();
                            gp.setNextNumber();
                        }
                    }
                }

                System.out.println();
                System.out.println(gp.list.toString());
                System.out.println("\nAll numbers have been found.");

                //Checks if user wants to enter another number
                boolean miniLoop = true;

                while(miniLoop){

                    System.out.println("Would you like to try another number (Y/N)?");
                    char characterQuery = (scan.next().toLowerCase()).charAt(0);

                    switch(characterQuery){
                        case 'y':
                            System.out.println("You have chosen to enter another number");
                            System.out.println();
                            miniLoop = false;
                            break;
                        case 'n':
                            System.out.println("You have chosen to end program");
                            miniLoop = false;
                            play = false;
                            break;
                        default:
                            System.out.println("\nInvalid answer, try again.");
                    }
                }

            }catch(InputMismatchException e){//Catches input mismatch for numnber input and with loop round while loop to try again
                System.out.println("Invalid input: " + e);
            }



        }

    }
}
