
public class Main {
	public static void main(String[] args){
		Datum[] dataArray = DataReader.loadData();
		ChainingHashMap map = new ChainingHashMap(1000);
		
		// Populate the map with words and their corresponding frequencies
		for(int i=0; i<dataArray.length; i++)
			map.put(dataArray[i].word, dataArray[i].frequency);
            
		
		// Evaluate the effectiveness of the hash function
		int sizeOfLargestList = collisionTest(map);
		int numberOfEmptyLists = sparsityTest(map);
		
		// Print the results
		System.out.println("The size of the largest linkedlist is: " + sizeOfLargestList);
		System.out.println("The total number of empty linkedlists is: " + numberOfEmptyLists);
	}
	
	public static int collisionTest(ChainingHashMap map){
	// Problem #2A
	// Fill in this method to compute the size of the largest
	// linkedlist. You must use the getSize and countCollisions
	// methods to get full credit.
        int size = map.getSize();
        int num;
        int largest =0;
        
        for (int i=0; i <size;i++){
                num = map.countCollisions(i);
                if (num > largest){
                    largest = num;
                }   
        }
        return largest;
	}
	
	public static int sparsityTest(ChainingHashMap map){
	// Problem #2B
	// Fill in this method to compute the number of empty
	// linkedlists. You must use the getSize and countCollisions
	// methods to get full credit
        int count=0;
        int num;
        int size = map.getSize();
        for (int i=0;i <size;i++){
            if (map.countCollisions(i) ==0){
                count++;
            }
        }
        return count;
	}
}
