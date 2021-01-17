
public interface Position<E> {
	//return the elements stored in the position
	public Object getElement();
	//store a element and return the old element which stored in the position
	public Object setElement(Object element);

}
