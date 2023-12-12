import java.util.Random;

public class ERL_LinkedList implements DataStrucutre{
	
	public Node head;
	int size=0;
	public ERL_LinkedList() {
		System.out.println("The chosen data strucutre is linkedlist");
		
	}
	@Override
	
	public void add(String value, int key) {
		size=size+1;
		if(this.head==null) {
			this.head=new Node(key,value);
		}
		else {
			this.addtolist(value, key);
		}
	}
	private void addtolist(String value,int key) {
		Node count=this.head;
		while(count.next!=null) {
			count=count.next;
		}
		count.setNext(new Node(key,value));
		count.next.setPrev(count);
	}
	
	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		Node count=this.head;
		boolean find=false;
		while(count!=null) {
			if(count.key==key) {
				System.out.println("the element with key:"+count.key +"and value:"+count.value+"has been removed");
				if(count.next!=null) {
					count.prev.setNext(count.next);
					count.next.setPrev(count.prev);
				}
				else {
					count.prev.setNext(null);
				}
				find=true;

				this.size=this.size-1;
				break;
			}
			count=count.next;
		}
		if(find==false)
			System.out.println("No element with this key has been found");
		
	}

	@Override
	public void prev_key(int key) {
		// TODO Auto-generated method stub
		Node count=this.head;
		boolean find=false;
		while(count!=null) {
			if(count.key==key) {
				find=true;
				if(count==head) {
					System.out.println("this is the header so it doesnt have pre element");
					System.out.println(count.key);
					
				}
				else {

					System.out.println("the previous key is(it is unosorted) :"+count.prev.key);
					
				}
				break;
			}
			count=count.next;
				
		}
		if(find==false) {
			System.out.println("The key that you inserted is not in the linkedlist");
		}
	}

	@Override
	public int next_key(int key) {
		
		Node count=this.head;
		while(count!=null) {
			if(count.key==key) {
				if(count.next!=null)
					return count.next.key;
			}
			count=count.next;
		}
		// TODO Auto-generated method stub
		return -1;
	}
	private void addtoarray(int key,MyArrayList array) {
		array.add(key);
	}
	public void HistoryRecords() {
		Node count=this.head;
		MyArrayList array=new MyArrayList();
		while(count!=null) {
			array.add(count.key);
			count=count.next;
		}
		System.out.println("all the records that were inserted:(from the first one to the most recent one)");
		for(int key:array.array) {
			if(key!=0)
				System.out.println(key);
		}
	}
	@Override
	public void printallkey() {
		Node count=this.head;
		MyArrayList arraylist=new MyArrayList();
		while(count!=null) {
			this.addtoarray(count.key,arraylist);
			count=count.next;
		}
		int []sorted_array=arraylist.sort();
		for(int i:sorted_array) {
				System.out.println(i);
		}
		
	}
	public int[] all_key_elements() {
		MyArrayList array=new MyArrayList();
		Node count=this.head;
		while(count!=null) {
			array.add(count.key);
			count=count.next;
		}
		return array.get_all_elements();
	}
	public Object[] all_Nodes() {
		MyArrayList array=new MyArrayList();
		Node count=this.head;
		while(count!=null) {
			array.add_object(count);
			count=count.next;
		}
		return   array.Object_array;
	}
	@Override
	public String getvalue(int key) {
		String value=null;
		Node count=this.head;
		while(count!=null) {
			if(count.key==key) {
				value=count.value;
				break;
			}
			count=count.next;
		}
		return value;
	}
	
	

	@Override
	public int generate() {
		// TODO Auto-generated method stub
		System.out.println("genrating new Key.....");
		 Random random = new Random();
	     int number = random.nextInt(90000000) + 10000000;
	     String value=this.getvalue(number);
	     if(value!=null) {
	    	 return number;
	     }
	     else {
	    	 System.out.println("The Key"+number+ "was already added");
	    	 return 0;
	     }
	}
	@Override
	public void rangeKey(int key1, int key2) {
		// TODO Auto-generated method stub
		MyArrayList array=new MyArrayList();
		Node count=this.head;
		while(count!=null) {
			array.add(count.key);
			count=count.next;
		}
		int[]sorted_array=array.sort();
		System.out.println("the elements between "+key1+ " and "+key2);
		for(int key:sorted_array) {
			if(key>=key1&&key<=key2) {
				System.out.println(key);
			}
		}
		
	}
	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	

}
