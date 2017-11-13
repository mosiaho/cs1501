
public class Heap {
	Word[] heap;
	int n;
	
	
	public Heap(Word[] array){
		buildHeap(array);
	}
	
	public void buildHeap(Word[] array){
	// Problem #2
	// Fill in this method with an O(n) time algorithm
	// that builds an n element complete binary heap.
	// Note: You are allowed to add and modify fields
    // and helper methods.
		heap = array;
		n=array.length-1;
		for(int i=n/2;i>=0;i--) {
			mHeap(array,i);
		}
		
		
	}
	void mHeap(Word[] array, int i){
		int left=2*i;
		int right=2*i+1;
		int largest;
		if(left<=n && array[left].compareTo(array[i]) >0) {
			largest=left;
		}
		else {
			largest=i;
		}
		
		if(right<=n && array[right].compareTo(array[largest]) >0) {
			largest=right;
		}
		if(largest!=i) {
			swap(array, i, largest);
			mHeap(array, largest);
		}
	}
	
	public Word removeMax(){
	// Problem #3
	// Fill in this method with an O(log(n)) time algorithm
	// that removes the root element, restores the heap
	// structure, and finally returns the removed root element.
		Word max = heap[0];
		heap[0]=heap[n];
		mHeap(heap, 0);
		
		return max;
	}

	public static void swap(Word[] arr, int i, int j){
	        Word tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp; 
	    }    
	public Word[] select(int k){
		Word[] result = new Word[k];
		for(int i = 0; i < k; i++){
			result[i] = this.removeMax();
		}
		return result;
	}
}
