
public class DLNode<E> implements Position<E>{
	private Object element;
	private DLNode<E> prev;
	private DLNode<E> next;
	//constructors
	public DLNode() {
		element = null;
		prev = null;
		next = null;
	}
	public DLNode(Object element, DLNode<E> prev, DLNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	//get the element stored in the position
	public Object getElement() {
		return element;
	}
	//store a element and return the old element which stored in the position
	public Object setElement(Object element) {
		Object oldElem = element;
		this.element = element;
		return oldElem;
	}
	//find the next node
	public DLNode<E> getNext() {
		return next;
	}
	//find the previous node
	public DLNode<E> getPrev() {
		return prev;
	}
	//set the next node
	public void setNext(DLNode<E> next) {
		this.next = next;
	}
	//set the previous node
	public void setPrev(DLNode<E> prev) {
		this.prev = prev;
	}

}
