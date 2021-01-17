
public class List_DLNode<E> {
	public int numOfElements;
	public DLNode<E> header, trailer;
	//constructor
	public List_DLNode() {
		numOfElements = 0;
		header = new DLNode<>(null,null,null);
		trailer = new DLNode<>(null,header,null);
		header.setNext(trailer);
	}
	//check if the position is valid, if it is valid then return it as a node
	private DLNode<E> checkPosition(Position<E> p) throws ExceptionPositionInvalid{
		if(null==p) {
			throw new ExceptionPositionInvalid("Error: Invalid position. ");
		}
		if(header==p||trailer==p) {
			return null;
		}
		DLNode<E> n = (DLNode<E>) p;
		return n;
	}
	
	//check the size of the list
	public int getSize() {
		return numOfElements;
	}
	//check if the list is empty
	public boolean isEmpty() {
		return (numOfElements == 0);
	}
	//get the first element
	public Position<E> first() {
		if(isEmpty()) {
			//System.out.println("This list is empty!");
			return null;
		}
		return header.getNext();
	}
	//get the last element
	public Position<E> last() {
		if(isEmpty()) {
			//System.out.println("This list is empty!!");
			return null;
		}
		return trailer.getPrev();
	}
	//get the previous element of a given position
	public Position<E> getPrev(Position<E> p) throws ExceptionPositionInvalid,ExceptionBoundaryViolation {
		DLNode<E> curr = checkPosition(p);
		DLNode<E> prev = curr.getPrev();
		if(prev == header) {
			throw new ExceptionBoundaryViolation("Error: out of boundary. ");
		}
		return prev;
	}
	//get the next element of the given position
	public Position<E> getNext(Position<E> p) throws ExceptionPositionInvalid,ExceptionBoundaryViolation {
		DLNode<E> curr = checkPosition(p);
		DLNode<E> next = curr.getNext();
		if(next == trailer) {
			throw new ExceptionBoundaryViolation("Error: out of boundary. ");
		}
		return next;
	}
	//insert an element in front of a given position
	public Position<E> insertBefore(Position<E> p, Object element) throws ExceptionPositionInvalid {
		DLNode<E> curr = checkPosition(p);
		numOfElements++;
		DLNode<E> newNode = new DLNode<>(element, curr.getPrev(), curr);
		curr.getPrev().setNext(newNode);
		curr.setPrev(newNode);
		return newNode;
	}
	//insert an element at the next of a given position
	public Position<E> insertAfter(Position<E> p, Object element) throws ExceptionPositionInvalid {
		DLNode<E> curr = checkPosition(p);
		numOfElements++;
		DLNode<E> newNode = new DLNode<>(element, curr, curr.getNext());
		curr.getNext().setPrev(newNode);
		curr.setNext(newNode);
		return newNode;
	}
	//insert an element at the begin of the list
	public Position<E> insertFirst(Object element) {
		numOfElements++;
		DLNode<E> newNode = new DLNode<>(element, header, header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		return newNode;
	}
	//insert an element at the end of the list
	public Position<E> insertLast(Object element) {
		numOfElements++;
		DLNode<E> newNode = new DLNode<>(element, trailer.getPrev(), trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		return newNode;
	}
	//delete the given position and return the element
	public Object remove(Position<E> p) throws ExceptionPositionInvalid {
		DLNode<E> curr = checkPosition(p);
		numOfElements--;
		curr.getPrev().setNext(curr.getNext());
		curr.getNext().setPrev(curr.getPrev());
		curr.setNext(null);
		curr.setPrev(null);
		return curr.getElement();
	}
	//delete the first one of the list and return the element
	public Object removeFirst() {
		return remove(header.getNext());
	}
	//delete the last one of the list and return the element
	public Object removeLast() {
		return remove(trailer.getPrev());
	}
	//replace the element which stored in the given position and return the old element
	public Object replace(Position<E> p, Object element) throws ExceptionPositionInvalid {
		DLNode<E> curr = checkPosition(p);
		Object oldElement = curr.getElement();
		curr.setElement(element);
		return oldElement;
	}
	//iteration of positions
	public Iterator positions() {
		return new IteratorPosition(this);
	}
	
	//check
	public static void main(String[] agrs) {
		List_DLNode<Object> animal = new List_DLNode<>();
		System.out.println(animal.last());
		Position<Object> one = animal.insertFirst("Lion");;
		animal.insertLast("Tiger");
		System.out.println(animal.getSize());
		System.out.println(animal.first().getElement());
		System.out.println(animal.getNext(one).getElement());
		animal.insertBefore(one, "Panada");
		System.out.println(animal.getSize());
		System.out.println(animal.first().getElement());
		Iterator it = animal.positions();
		int count = 0;
		while(it.hasNext()) {
			count++;
			System.out.println(it.getNext());
		}

		System.out.println(count);
	}

}
