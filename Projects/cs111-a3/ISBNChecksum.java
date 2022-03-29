/*************************************************************************
 *  Compilation:  javac ISBNChecksum.java
 *  Execution:    java ISBNChecksum 020131452
 *
 *  @author:
 *
 *  Takes a 9-digit integer as a command line argument, then computes
 *  and prints the checksum character
 *
 *  % java ISBNChecksum 020131452
 *  5
 *
 *  Print only the checksum character, nothing else.
 *
 *************************************************************************/

public class ISBNChecksum {

    public static void main (String[] args) {

        // WRITE YOUR CODE HERE
        int isbn = Integer.parseInt(args[0]);
        int counter = 2;
        int sum = 0;
        int digit = 0;
        while (counter <= 10){
            digit = isbn%10;
            sum = sum + (digit*counter);
            isbn = isbn/10;
            counter++;
        }
        int newSum = sum%11;
        if (newSum == 0){
            System.out.println("0");
        }else{
            newSum = 11 - newSum;
        }
        if (newSum ==10){
            System.out.println("X");
        }else{
            System.out.println(newSum);
        }

    }
}