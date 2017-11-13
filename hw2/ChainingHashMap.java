
public class ChainingHashMap{
	Node[] array;
	int size;
	
	public ChainingHashMap(int size){
		this.size = size;
		array = new Node[size];
	}

	public Integer get(Word key) {
	// Problem #1A
	// Fill in this method to get the value corresponding
	// with the key. Note: if the key is not found, then
	// return null
        int index = Math.abs(key.hashCode() % size);
        Node temp = array[index];
        while (temp!= null){
            if (key.equals(temp.word)){
                return temp.frequency;
            }
            temp = temp.next;
        }
        return null;
	}

	public void put(Word key, Integer value) {
	// Problem #1B
	// Fill in this method to insert a new key-value pair into
	// the map or update the existing key-value pair if the
	// key is already in the map.
        int index = Math.abs(key.hashCode() % size);
        Node temp = array[index];
        if (temp == null){
            array[index] = new Node(key, value, temp);
        }
        else {
            Node t = array[index];
            while (t!= null && t.word.value!=key.value){
                t = t.next;
            }
            if (t==null){
                array[index] = new Node(key, value, temp);
            }
            else {
                t.frequency = value;  
            }
        }
	}

	public Integer remove(Word key) {
	// Problem #1C
	// Fill in this method to remove a key-value pair from the
	// map and return the corresponding value. If the key is not
	// found, then return null.
        int num;
        int index = Math.abs(key.hashCode() % size);
        Node temp = array[index];
        Node prev = null;
        if (temp == null){return null; }
        while (temp!= null){
            if (key.equals(temp.word)){
                num = temp.frequency;
                if (prev ==null){
                    array[index] = temp.next;
                }
                else{
                    prev.next = temp.next;
                }
                return num;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        return null;
	}
	
	// This method returns the total size of the underlying array.
	// In other words, it returns the total number of linkedlists.
	public int getSize(){
		return size;
	}
	
	// This method counts how many keys are stored at the given array index.
	// In other words, it computes the size of the linkedlist at the given index.
	public int countCollisions(int index){
		if(index < 0 || index >= size) return -1;
		
		int count = 0;
		Node temp = array[index];
		while(temp != null){
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
}
