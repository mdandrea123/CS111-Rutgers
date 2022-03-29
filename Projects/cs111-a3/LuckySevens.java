/*************************************************************************
 * Compilation: javac LuckySevens.java Execution: java LuckySevens 421
 *
 * @author:
 *
 *          LuckySevens takes an int as a command-line argument and displays how
 *          many digits in the integer number are 7s.
 *
 *          Note: the number can be negative.
 *
 *          % java LuckySevens 3482 0
 *
 *          % java LuckySevens 372777 4
 * 
 *          % java LuckySevens -2378272 2
 *************************************************************************/

public class LuckySevens {

    public static void main(String[] args) {

        // WRITE YOUR CODE HERE
        int num = Integer.parseInt(args[0]);
        String number = Integer.toString(num);
        int numSevens = 0;
        int counter = 0;

        while (counter < number.length()){
            if (num % 10 == 7 || num % 10 == -7){
                numSevens++;
            }
            
            num = num/10;
            counter++;
        }
        System.out.println(numSevens);

        
    }
}
