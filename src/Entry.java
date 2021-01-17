
public class Entry <E,T1 extends Comparable<T1>,T2 extends Comparable<T2>> implements Comparable<Entry<E,T1,T2>>{
	public E value;
	public T1 firstKey;
	public T2 finalKey;
	//constructor
	public Entry() {
		this.value = null;
		this.firstKey = null;
		this.finalKey = null;
	}
	public Entry(E value, T1 firstKey, T2 finalKey) {
		this.value = value;
		this.firstKey = firstKey;
		this.finalKey = finalKey;
	}
	//get the keys of the entry
	public T1 getFirstKey() {
		return firstKey;
	}
	public T2 getFinalKey() {
		return finalKey;
	}
	//modified the first key(job priority) of the entry, and return the old key(old job priority) of the entry
	public T1 setFirstKey(T1 k) {
		T1 oldFirstKey = this.firstKey;
		this.firstKey = k;
		return oldFirstKey;
	}
	//get the value the entry
	public E getValue() {
		return value;
	}
	@Override
	public int compareTo(Entry<E, T1, T2> o) {
		if(this.firstKey.compareTo(o.firstKey) == 0) {
			return (this.finalKey.compareTo(o.finalKey));
		}
		else {
			return (this.firstKey.compareTo(o.firstKey));
		}
	}
	
	
	
	//try
	public static void main(String[]args) {
		Entry<String, Integer, Integer> e1 = new Entry <String,Integer,Integer>();
		e1.value="LALA";
		e1.firstKey=3;
		e1.finalKey=2;
		Entry<String, Integer, Integer> e2 = new Entry <String,Integer,Integer>();
		e2.value="HAHA";
		e2.firstKey=2;
		e2.finalKey=3;
		System.out.println(e1.compareTo(e2));
		System.out.println(e1.value);
		System.out.println(e2.value);
	}
	public int CompareTo(Entry<E, T1, T2> e) {
		if(this.firstKey.compareTo(e.firstKey) == 0) {
			return (this.finalKey.compareTo(e.finalKey));
		}
		else {
			return (this.firstKey.compareTo(e.firstKey));
		}
	}

}
