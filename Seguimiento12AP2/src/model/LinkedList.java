package model;

public class LinkedList<T>{
	
	//Head
	private Node<T> head;
	

	public void add() {
		
		if(head == null) {
			Node<Integer> node = new Node<>(1);
			head = (Node<T>) node;
			head.setNext(head);
			head.setPrevious(head);
		}else {
			Node<Integer> node = new Node<>((Integer)head.getPrevious().getValue()+1);
			Node tail = node;
			
			tail.setNext(head);
			tail.setPrevious(head.getPrevious());
			
			tail.setValue(((Integer)tail.getPrevious().getValue())+1);
			
			head.getPrevious().setNext(tail);
			head.setPrevious(tail);
			
		}
	}
	
	
	public void print() {
		print(head);
	}
	
	private void print(Node node) {
		//Condiciones de parada
		
		if(node.getNext() == head) {
			//System.out.println(node.getValue());
			if(node.getValue() != null) {
				System.out.println(node.getValue());
			}
			return;
		}
		
		if(node.getValue() != null) {
			System.out.println(node.getValue());
		}
		//Algoritmo recursivo
		print(node.getNext());
	}
	
	
	public void passTurn() {
		Node currentTurnNode = findCurrentTurn(head);
		
		CurrentTurn p = currentTurnNode.getCurrentTurn();
		currentTurnNode.setCurrentTurn(null);
		passTurn(currentTurnNode,p);
		
		
	}
	
	private void passTurn(Node current,CurrentTurn currentTurn) {
			current.getNext().setCurrentTurn(currentTurn);
			current.setCurrentTurn(null);
	}

	private Node findCurrentTurn(Node current) {
		if(current.getCurrentTurn() != null) {
			return current;
		}
		return findCurrentTurn(current.getNext());
	}
}
