import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<T> {
	final T item;
	Node<T> next;

	public Node(T obj) {
		this.item = obj;
		this.next = null;
	}
	public Node(T obj, Node<T> next){
		this.item = obj;
		this.next = next;
	}
	
	void setNext(Node<T> next){
		this.next = next;
	}
	T getItem(){
		return this.item;
	}
	Node<T> getNext(){
		return this.next;
	}
}

public class MyLinkedList<T extends Comparable<T>> implements Iterable<T> {

	Node<T> head = null;
	int num = 0;

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedListIterator<T>(this);
	}

	public boolean add(T obj) {
		Node<T> prev = null, curr;
		Node<T> newNode = new Node<T>(obj);
		
		if (head == null){
			head = new Node<T>(obj);
			num++;
			return true;
		} else {
			for (curr = head; curr != null; prev = curr, curr = curr.getNext()){
				int compare = newNode.getItem().compareTo(curr.getItem());
				if (compare == 0){
					return false;
				} else if (compare < 0){
					if (prev == null){
						newNode.setNext(curr);
						head = newNode;
						num++;
						return true;
					} else {
						prev.setNext(newNode);
						newNode.setNext(curr);
						num++;
						return true;
					}
				}
			}
			prev.setNext(newNode);
			num++;
		}
		return true;
	}

	public boolean remove(T obj) {
		Node<T> curr, prev;
		for (prev = null, curr = head; curr != null; prev = curr, curr = curr.getNext()){
			int compare = curr.getItem().compareTo(obj);
			if (compare == 0){
				if (prev == null){
					head = curr.getNext();
				} else {
					prev.setNext(curr.getNext());
				}
				num--;
				return true;
			}
		}
		return false;
	}

	public int size() {	
		return num;
	}

	public T first() {
		if (head != null)
			return head.item;
		else
			throw new NoSuchElementException();
	}

	public T last() {
		// FIXME implement this
		// This is a helper method.
		// You do not necessarily have to implement this but still might be useful to do so.
		throw new UnsupportedOperationException();
	}
}
