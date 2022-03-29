/*************************************************************************
 *  Compilation:  javac FindDuplicate.java
 *  Execution:    java FindDuplicate
 *
 *  @author:
 *
 * FindDuplicate that reads n integer arguments from the command line 
 * into an integer array of length n, where each value is between is 1 and n, 
 * and displays true if there are any duplicate values, false otherwise.
 *
 *  % java FindDuplicate 2 10 8 5 4 1 3 6 7 9
 *  false
 *
 *  % java FindDuplicate 4 5 2 1 2 
 *  true
 *************************************************************************/

public class FindDuplicate {

    public static void main(String[] args) {
		boolean duplicates = false;
		int[] arr = new int[args.length];
		for(int i = 0; i < args.length; i++){
			arr[i] = Integer.parseInt(args[i]);
		}


		for (int i = 0; i < arr.length -1; i++){
			for (int x = 0; x < arr.length -i -1; x++){
				if (arr[x] > arr[x + 1]){
					int temp = arr[x];
					arr[x] = arr[x + 1];
					arr[x + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length - 1; i++){
			if (arr[i] == arr[i + 1]){
				duplicates = true;
			}
		}
		System.out.println(duplicates);
		//WRITE YOUR CODE HERE
	}
}
