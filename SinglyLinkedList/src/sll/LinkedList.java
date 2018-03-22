package sll;

import java.util.NoSuchElementException;

/**
 * This class provides a basic implementation of a singly linked list. It's
 * motivated by the implementation in Big Java, 5e, ch. 16.1.
 * 
 * @author TODO <YOUR_NAME> on <DATE>.
 * @param <T>
 *            The type of elements in the list
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

	private ListNode<T> first;
	// Note that in addition to a head (first) pointer
	// this list contains a last pointer.  Be sure to
	// BOTH first and last up to date in all your code.
	private ListNode<T> last;

	/**
	 * Constructs a new, empty linked list.
	 */
	public LinkedList() {
		this.first = null;
		this.last = null;
	}

	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}
		String result = "[";
		ListNode<T> current = this.first;
		while (current != this.last) {
			result += (current.getElement() + ", ");
			current = current.getNext();
		}
		return result + current.getElement() + "]";
	}

	@Override
	public boolean add(T x) {
		// TODO 01 Implement the add(T x) method.
		//if list is empty 
		if(this.first==null){
			this.first=new ListNode<T>(x);
			this.last=this.first;
		}else{
			this.last.setNext(new ListNode<T>(x));
			this.last=this.last.getNext();
		}
		
		return true;
	}

	@Override
	public int size() {
		int result = 0;
		ListNode<T> current = this.first;
		while(current != null) {
			result++;
			current = current.getNext();
		}
		return result;
	}

	@Override
	public void add(int i, T x) throws IndexOutOfBoundsException {
		// TODO 03 Implement the add(int i, T x) method.
                // Note that this adds at the specific index
		ListNode<T> current = this.first;
		ListNode<T> newStuff=new ListNode<T>(x);
		int index=0;
		if(i<0 ||i>this.size()){
			throw new IndexOutOfBoundsException();
		}
		if(i==this.size() || current==null){
			this.add(x);
		}else if(i==0){
			newStuff.setNext(current);
			this.first=newStuff;
		}else{
			if(index!=i-1){
				index++;
				current=current.getNext();
			}
			newStuff.setNext(current.getNext());
			current.setNext(newStuff);
			}
		}
		
		

	@Override
	public boolean contains(T x) {
		// TODO 04 Implement the contains(T x) method.
		ListNode<T> head =this.first;
		for(int i=0; i<this.size(); i++){
			if(head.getElement()==x){
				return true;
			}
			head=head.getNext();
		}
		return false;
	}

	@Override
	public boolean remove(T x) {
		// TODO 05 Implement the remove(T x) method.
		ListNode<T> head =this.first;
		if(head==null){
			return false;
		}
		if (head.getElement()==x){
			this.first=head.getNext();
			return true;
		}
		
		for(int i=0; i<this.size()-1; i++){
			if(head.getNext().getElement()==x){
				head.setNext(head.getNext().getNext());
				//this.first=head.getNext();
				return true;
			}
			head=head.getNext();
		}
		return false;
	}


	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		// TODO 06 Implement the get(int index) method.
		ListNode<T> head =this.first;
		if(index<0 || index>this.size()-1){
			throw new IndexOutOfBoundsException();
		}
		for(int i=0; i<index; i++){
			head=head.getNext();
		}
		return head.getElement();
	}


	@Override
	public int indexOf(T x) {
		// TODO 07 Implement the indexOf(T x) method.
		ListNode<T> head =this.first;
		int result=0;
		if(head==null){
			return -1;
		}
		if(head.getElement()==x){
			return result;
		}
		for(int i=0; i<this.size()-1; i++){
			if(head.getElement()!=x){
				head=head.getNext();
				result++;
			}else{
				return result;
			}
			
		}
		
		return -1;
	}

	@Override
	public T set(int index, T element) throws IndexOutOfBoundsException {
		// TODO 08 Implement the set(int index, T element) method.
		
		ListNode<T> head =this.first;
		if(index<0 || index>=this.size()){
			throw new IndexOutOfBoundsException();
		}
		
		for(int i=0; i<this.size()-1; i++){
			if(i==index){
				T result= head.getElement();
				head.setElement(element);
				return result;
			}
			head=head.getNext();
		}
		
		return head.getElement();
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator(this.first, this);
	}

	/**
	 * This is an iterator over this list.
	 * 
	 * @author TODO <YOUR_NAME> on <DATE>.
	 */
	private class LinkedListIterator implements Iterator<T> {

		private ListNode<T> current, previous;
		private LinkedList<T> list;
		private int times;

		private LinkedListIterator(ListNode<T> first, LinkedList<T> list) {
			this.current = first;
			this.previous = this.current;
			this.list=list;
			
		}

		@Override
		public boolean hasNext() {
			// TODO 09 Implement the hasNext() method.
			if(this.current!=null){
				return true;
			}
			return false;
		}

		@Override
		public T next() throws NoSuchElementException {
			if (this.current==null){
				throw new NoSuchElementException();
			}
			this.previous=this.current;
			this.current=this.current.getNext();
			this.times=0;
			return this.previous.getElement();
				
		}

		@Override
		public void remove() {
			// TODO 11 Implement the remove() method.
			this.times++;
			if (this.current==null ||this.times>1){
				throw new IllegalStateException();
			}
			this.list.remove(this.previous.getElement());

		}
	}

}
