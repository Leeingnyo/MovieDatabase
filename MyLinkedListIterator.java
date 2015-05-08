import java.util.Iterator;

public class MyLinkedListIterator<T extends Comparable<T>> implements Iterator<T> {

	private final MyLinkedList<T> l;
	
	Node<T>	node;

	public MyLinkedListIterator(MyLinkedList<T> myLinkedList) {
		this.l = myLinkedList;
		node = l.head;
	}

	@Override
	public boolean hasNext() {
		return node != null;
	}

	@Override
	public T next() {
		T temp = node.getItem();
		node = node.getNext();
		return temp;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
