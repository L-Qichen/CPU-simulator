
public class IteratorPosition implements Iterator {
	private List_DLNode list;
	private Position nextPosition;
	//constructors
	public IteratorPosition() {
		list = new List_DLNode<>();
	}
	public IteratorPosition(List_DLNode list) {
		this.list = list;
		if(list.isEmpty()) {
			nextPosition = null;
		}
		else {
			nextPosition = list.first();
		}
	}
	//check if there is any other position
	public boolean hasNext() {
		return (nextPosition != null);
	}
	public Object getNext() throws ExceptionNosuchElement {
		if(!hasNext()) throw new ExceptionNosuchElement("There is no next position in the list.");
		Position currentPosition = nextPosition;
		if(currentPosition == list.last()) {
			nextPosition = null;
		}
		else {
			nextPosition = list.getNext(currentPosition);
		}
		return currentPosition.getElement();
	}

}
