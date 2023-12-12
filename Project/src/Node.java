

public  class Node{
		int key;
		String value;
		Node next;
		Node prev;
		public Node(int key,String value) {
			this.key=key;
			this.value=value;
		}
		public void setNext(Node node) {
			this.next=node;
		}
		public void setPrev(Node node) {
			this.prev=node;
		}
	}