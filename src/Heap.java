
//Array-List-based Heap
public class Heap<E, T1 extends Comparable<T1>, T2 extends Comparable<T2>> {
	private ArrayList<Entry<E,T1,T2>> arr;
	//constructor
	public Heap() {
		arr = new ArrayList<>();
	}
	//get the size of the heap
	public int size() {
		return arr.getSize();
	}
	//get the index of the left child of a parent node
	public int getLeftChildIndex(int parentIndex) {
		return (2*parentIndex+1);
	}
	//get the index of the right child of a parent node
	public int getRightChildIndex(int parentIndex) {
		return (2*parentIndex+2);
	}
	//get the index of the parent of a child node
	public int getParentIndex(int childIndex) {
		return ((childIndex-1)/2);
	}
	//check if the node has a lift child node
	public boolean hasLeftChild(int index) {
		return (getLeftChildIndex(index) < arr.getSize());
	}
	//check if the node has a right child node
	public boolean hasRightChild(int index) {
		return (getRightChildIndex(index) < arr.getSize());
	}
	//check if the node has a parent node
	public boolean hasParent(int index) {
		return (getParentIndex(index) >= 0);
	}
	//swap method
	public void swap(int i, int j) {
		Entry temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	//insert method to add a node
	public Entry insert(E value, T1 firstKey, T2 finalKey) {
		Entry<E,T1,T2> newEntry = new Entry<>(value, firstKey, finalKey);
		arr.addLast(newEntry);
		upHeap(arr.getSize()-1);
		return newEntry;
	}
	//up heap method
	public void upHeap(int i) {
		while(i > 0) {
			int p = getParentIndex(i);
			if(arr.get(i).compareTo(arr.get(p)) >= 0) {
				break;
			}
			swap(i, p);
			i = p;
		}
	}
	//down heap method
	public void downHeap(int i) {
		while(hasLeftChild(i)) {
			int leftIndex = getLeftChildIndex(i);
			int smallChildIndex = leftIndex;
			if(hasRightChild(i)) {
				int rightIndex = getRightChildIndex(i);
				if(arr.get(leftIndex).compareTo(arr.get(rightIndex)) > 0) {
					smallChildIndex = rightIndex;
				}
			}
			if(arr.get(smallChildIndex).compareTo(arr.get(i)) >= 0) {
				break;
			}
			swap(i, smallChildIndex);
			i = smallChildIndex;
		}
	}
	//get the entry with minimal key
	public Entry min() {
		if(arr.isEmpty()) {
			return null;
		}
		return arr.get(0);
	}
	//remove the entry with minimal key
	public Entry removeMin() {
		if(arr.isEmpty()) {
			return null;
		}
		Entry minElem = arr.get(0);
		swap(0, arr.getSize()-1);
		arr.remove(arr.getSize()-1);
		downHeap(0);
		return minElem;
	}
	//get the entry with maximal key
		public int max(int i) {
			int bigChildIndex = 0;
			while(hasLeftChild(i)) {//search the tree until find one element have not left child
				i = getLeftChildIndex(i);
				if(!hasLeftChild(i)&&!hasRightChild(i)) {//check this element no child node
					bigChildIndex = i;
					for(int j = i-1; j < arr.getSize(); j++) {//compare the elements from i-1 to the last node in the tree to find maximal
						if(arr.get(j).compareTo(arr.get(bigChildIndex)) > 0) {
							bigChildIndex = j;
						}
					}
				}
			}
			return bigChildIndex;
		}
	//remove the entry with maximal key
	public Entry removeMax() {
		if(arr.isEmpty()) {
			return null;
		}
		int maxIndex = max(0);
		Entry maxElem = arr.get(maxIndex);
		swap(maxIndex, arr.getSize()-1);
		arr.remove(arr.getSize()-1);
		upHeap(arr.getSize()-1);
		return maxElem;
	}
	//check if the heap is empty
	public boolean isEmpty() {
		return (arr.getSize() == 0);
	}
	
	
	
	//check
	public static void main(String[] args) {
		Entry[]arr = new Entry[10];
		Heap oo = new Heap();
		System.out.println(oo.isEmpty());
		System.out.println(oo.insert("a",10,4));
		System.out.println(oo.insert("b",9,4));
		System.out.println(oo.insert("c",8,9));
		System.out.println(oo.insert("d",7,3));
		System.out.println(oo.insert("e",6,2));
		System.out.println(oo.insert("f",5,4));
		System.out.println(oo.insert("g",7,122));
		System.out.println(oo.insert("h",2,4));
		System.out.println("+++++++++++++++++++++++");
		System.out.println(oo.removeMax());
		System.out.println(oo.removeMax());
		System.out.println(oo.insert("i",1,3));
		System.out.println("-----------------------");
		System.out.println(oo.removeMax());
		System.out.println(oo.removeMin());
		System.out.println(oo.removeMin());
		System.out.println(oo.removeMin());
		System.out.println(oo.removeMin());
		System.out.println(oo.removeMin());
		System.out.println(oo.isEmpty());
		System.out.println(oo.removeMin());
		System.out.println(oo.isEmpty());
		
	}
}
