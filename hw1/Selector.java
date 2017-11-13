import java.util.*;
import java.io.*;
import java.lang.*;
public class Selector {
	
	private static void swap(Word[] array, int i, int j){
		if(i == j) return;
		
		Word temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static Word[] select(Word[] array, int k){
	// Problem #1
	// Fill in this method with an O(n*k) time algorithm
	// that returns the k largest elements of array in
	// order from largest to smallest.
	// Note: This should return an array with k elements. 
	//count the frequency for each element
	
		Word[] sortedArray = new Word[k];
		int n = array.length;
		int v;
		int v2;
		int num=1;
		int j =-1;
	
		for (int i=0; i <k; i++){   	
			for (j = i+1; j<n-1;j++){
				v = array[j].frequency;
				v2 = array[num].frequency;
				if(v > v2){
					num = j;
				}  
			}  
			swap(array, i,num);
			sortedArray[i] = array[i];
		}
		return sortedArray;
	}
}
