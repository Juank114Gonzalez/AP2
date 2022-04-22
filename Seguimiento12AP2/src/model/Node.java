package model;

public class Node<T> {
	//Value
	private T value;
	
	//Current turn indication
	private CurrentTurn currentTurn;
	
	//Links
	private Node<T> next;
	private Node<T> previous;

	/**
	 * Constructor of class Node
	 * @param value
	 */
	public Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public CurrentTurn getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(CurrentTurn currentTurn) {
		this.currentTurn = currentTurn;
	}
	
	

}
