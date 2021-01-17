
public class PQ_SortedList<E, T1 extends Comparable<T1>, T2 extends Comparable<T2>> {
	private List_DLNode<Entry<E,T1,T2>> list;
	//constructor
	public PQ_SortedList() {
		list = new List_DLNode<>();
	}
	//get the size of the list
	public int getSize() {
		return list.getSize();
	}
	//check if the list is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}
	//insert an entry into the list
	public Entry<E,T1,T2> insert(E value, T1 firstKey, T2 finalKey) {
		Entry<E,T1,T2> newEntry = new Entry<>(value, firstKey, finalKey);
		Position<Entry<E, T1, T2>> walk = list.last();
		if(list.isEmpty() || 0 > newEntry.compareTo((Entry)list.first().getElement())) {
			list.insertFirst(newEntry);
		}
		else {
			int count = 0;
			Iterator it = list.positions();
			while(it.hasNext()) {
				count++;
				it.getNext();
			}
			for(int i = 0; i < count; i++) {
				if(newEntry.compareTo((Entry)walk.getElement()) > 0) {
					list.insertAfter(walk, newEntry);
					break;
				}
				if(newEntry.compareTo((Entry)walk.getElement()) < 0) {
					walk = list.getPrev(walk);
				}
			}
		}
		return newEntry;
	}
	//return an entry with minimal key
	public Object min(){
		if(list.isEmpty()) {
			return null;
		}
		return list.first().getElement();
	}
	//Remove and return the entry which with minimal key
	public E removeMin() {
		if(list.isEmpty()) {
			return null;
		}
		Entry<E, T1, T2> curr = (Entry<E, T1, T2>) list.removeFirst();
		return (E) curr;
	}
	//Remove and return the entry which with maximal key
	public E removeMax() {
		if(list.isEmpty()) {
			return null;
		}
		Entry<E, T1, T2> curr = (Entry<E, T1, T2>) list.removeLast();
		return (E) curr;
	}
	//first position in the list
	public Position<Entry<E, T1, T2>> firstPosition() {
		if(list.isEmpty()) {
			return null;
		}
		else {
			Position<Entry<E, T1, T2>> one = list.first();
			return one;
		}
	}
	//last position in the list
		public Position<Entry<E, T1, T2>> lastPosition() {
			if(list.isEmpty()) {
				return null;
			}
			else {
				Position<Entry<E, T1, T2>> lastOne = list.last();
				return lastOne;
			}
		}
		//first element in the list
		public E firstElement() {
			if(list.isEmpty()) {
				return null;
			}
			else {
				Entry<E, T1, T2> one = (Entry<E, T1, T2>) list.first().getElement();
				return one.value;
			}
		}
		//last element in the list
			public E lastElement() {
				if(list.isEmpty()) {
					return null;
				}
				else {
					Entry<E, T1, T2> lastOne = (Entry<E, T1, T2>) list.last().getElement();
					return lastOne.value;
				}
			}
	//check
	public static void main(String[] args) {
		PQ_SortedList<String,Integer,Integer> list = new PQ_SortedList<>();
		System.out.println(list.insert("first", 1, 21));
		System.out.println(list.insert("sixth", 6, 98));
		System.out.println(list.insert("fourth", 4, 32));
		System.out.println(list.insert("2ed fourth", 4, 33));
		System.out.println(list.insert("second", 2, 1));
		System.out.println(list.insert("zero", -1, 1));
		System.out.println(list.insert("third", 3, 1));
		System.out.println("First: "+list.firstElement());
		System.out.println("Last: "+list.lastElement());
		System.out.println(list.getSize());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
		System.out.println(list.removeMin());
	}

}
