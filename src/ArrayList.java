
public class ArrayList<E> {
	public static final int CAPACITY = 10;
	private E[] arr;
	private int size = 0;
	//constructors
	public ArrayList() {
		this(CAPACITY);
	}
	public ArrayList(int capacity) {
		arr = (E[]) new Object[capacity];
	}
	//get the size of the array list
	public int getSize() {
		return size;
	}
	//check if this is a empty array list
	public boolean isEmpty() {
		return (size == 0);
	}
	//check if the given index is valid
	public void checkIndex(int index, int n) {
		if(index < 0 || index >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + index);
		}
	}
	//get the value by a given index
	public E get(int index) {
		checkIndex(index, size);
		return arr[index];
	}
	//replace the element at a given index with value e,  and return the old element
	public E set(int index, E e) {
		checkIndex(index, size);
		E oldElement = arr[index];
		arr[index] = e;
		return oldElement;
	}
	//make the capacity of the array bigger
	public void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity];
		for(int k = 0; k < size; k++) {
			temp[k] = arr[k];
		}
		arr = temp;
	}
	//insert an element to a given index
	public void add(int index, E e) {
		checkIndex(index, size+1);
		if(size == arr.length) {
			 resize(2*arr.length);
		}
		for(int k = size-1; k >= index; k--) {
			arr[k+1] = arr[k];
		}
		arr[index] = e;
		size++;
	}
	//remove the element of a given index
	public E remove(int index) {
		checkIndex(index, size);
		E e = arr[index];
		for(int k = index; k < size-1; k++) {
			arr[k] = arr[k+1];
		}
		arr[size-1] = null;
		size--;
		return e;
	}
	//add the element to the end of the list
	public void addLast(E e) {
		if(size == arr.length) {
			 resize(2*arr.length);
		}
		arr[size] = e;
		size++;
	}
	
	
	
	//check
	public static void main(String[] args) {
		ArrayList<Entry<String, Integer, Integer>> list = new ArrayList<>();
		Entry<String, Integer, Integer> e1 = new Entry<>("first", 1, 21);
		Entry<String, Integer, Integer> e2 = new Entry<>("sixth", 6, 98);
		Entry<String, Integer, Integer> e3 = new Entry<>("fourth", 4, 32);
		Entry<String, Integer, Integer> e4 = new Entry<>("2ed fourth", 4, 33);
		Entry<String, Integer, Integer> e5 = new Entry<>("second", 2, 1);
		Entry<String, Integer, Integer> e6 = new Entry<>("zero", -1, 1);
		list.add(0, e1);
		list.add(1, e2);
		list.add(2, e3);
		list.add(3, e4);
		list.add(4, e5);
		System.out.println(list.size);
		list.remove(1);
		System.out.println(list.size);
		list.add(0, e3);
		System.out.println(list.size);
		System.out.println(list.get(1).value);
		list.addLast(e6);
		list.add(5, e2);
		System.out.println(list.get(5).value);
		System.out.println(list.get(6).value);
	}

}
