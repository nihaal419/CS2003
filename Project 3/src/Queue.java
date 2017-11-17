import java.util.LinkedList;

public class Queue<E> {
	/**
	 * LinkedList which will be used to store elements and simulate a queue
	 */
	private LinkedList<E> list = new LinkedList<E>();
	
	/**
	 * Max size of the queue, default size is 10
	 */
	private int maxSize = 10;
	
	/**
	 * Add a item to the queue
	 * @param e is the item which is being added to the queue
	 * @return a boolean value stating whether of not the item was added to the queue
	 */
	public boolean enQueue(E e) {
		if(list.size() < maxSize) {
			list.addLast(e);
			return true;
		}
		else {
			System.out.println("Max size of queue reached.");
			return false;
		}
	}
	
	/**
	 * Removes an item from the queue
	 * @return a boolean value depending on if the item was removed or not
	 */
	public E deQueue() {
		if(list.isEmpty()) {
			System.out.println("Queue is already empty.");
			return null;
		}
		else {
			E item = list.getFirst();
			list.removeFirst();
			return item;
		}
	}
	
	/**
	 * Get and remove the item at the front of the queue
	 * @return the item which is being removed from the queue
	 */
	public E get() {
		if(list.isEmpty()) {
			return null;
		}
		return list.removeFirst();
	}
	
	/**
	 * Peek at the item at the front of the queue
	 * @return First item in the queue
	 */
	public E peek() {
		return list.getFirst();
	}
	
	/**
	 * Check if the queue is empty
	 * @return a boolean value of if the queue is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Check the size of the queue
	 * @return Size of the queue
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * Get the max size of the queue
	 * @return max size of the queue
	 */
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * Set the max size of the queue
	 * @param s int value which will be the new max size of the queue
	 */
	public void setMaxSize(int s) {
		maxSize = s;
	}
	
	/**
	 * Creates the percentage full of the queue
	 * @return double value representing the percent full value of the queue
	 */
	public double percent() {
		if(list.isEmpty()) {
			return 0.0;
		}
		else {
			return list.size()/maxSize;
		}
	}

	/**
	 * Determines if the queue has reached its max size
	 * @return a boolean value of true if queue is at max size, and false if queue if not at max size
	 */
	public boolean isMaxed() {
		if(list.isEmpty()) {
			return false;
		}
		else if(list.size()<maxSize) {
			return false;
		}
		else {
			return true;
		}
	}
}