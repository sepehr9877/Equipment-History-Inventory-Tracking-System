import java.util.Random;

public class HashTable implements DataStrucutre{
	DataStrucutre[]MyDataStructure=null;
	int size=0;
	public HashTable() {
		System.out.println("Now it is hashtable with linkedlist ");
		this.MyDataStructure=new DataStrucutre[50];
	}
	private int hashfunction(int key) {
		int hash=key%this.MyDataStructure.length;
		return hash;
	}
	@Override
	public int getsize() {
		
		return this.size;
	}
	@Override
	public void add(String value, int key) {
		// TODO Auto-generated method stub
		int hash=this.hashfunction(key);
		DataStrucutre selected_list=this.MyDataStructure[hash];
		
		if(selected_list==null) {
			this.MyDataStructure[hash]=new ERL_LinkedList();
		}
		
		else {
			if(selected_list instanceof ERL_LinkedList&&  selected_list.getsize()>50) {
				System.out.println("Changin to AVL in HashTable");
				Object allnodes[]=((ERL_LinkedList) selected_list).all_Nodes();
				
				this.MyDataStructure[hash]=new AVL_Tree();
				for(Object object:allnodes) {
					Node node = (Node) object;
					if(node!=null)
						this.MyDataStructure[hash].add(node.value, node.key);
				}
				System.out.println("Finsh adding elements to AVL from LinkedList in HashTable..");
			}
		}
		this.MyDataStructure[hash].add(value, key);
		this.size=this.size+1;
	}

	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		int hash=this.hashfunction(key);
		DataStrucutre datastructure=this.MyDataStructure[hash];
		if(datastructure!=null) {
			datastructure.remove(key);
		}
		else
			System.out.println("this element has not been found");
		
	}

	@Override
	public void prev_key(int key) {
		// TODO Auto-generated method stub
		int hash=this.hashfunction(key);
		DataStrucutre datastructure=this.MyDataStructure[hash];
		if(datastructure!=null) {
			datastructure.prev_key(key);
		}
		else {
			System.out.println("no element with this key");
		}
		
	}

	@Override
	public int next_key(int key) {
		// TODO Auto-generated method stub

		int hash=this.hashfunction(key);
		DataStrucutre datastructure=this.MyDataStructure[hash];
		if(datastructure!=null) {
			return datastructure.next_key(key);
		}
		return 0;
	}

	@Override
	public String getvalue(int key) {
		// TODO Auto-generated method stub
		String value=null;
		int hash=this.hashfunction(key);
		DataStrucutre datastructure=this.MyDataStructure[hash];
		if(datastructure!=null)
			value=datastructure.getvalue(key);
		return value;
	}

	@Override
	public void printallkey() {
		for(DataStrucutre datastructure:this.MyDataStructure) {
			if(datastructure!=null) {
				if(datastructure instanceof ERL_LinkedList&& ((ERL_LinkedList) datastructure).size>=1) {
					System.out.println("It is Linkedlist in HashTable...");
					datastructure.printallkey();
				}
				if(datastructure instanceof AVL_Tree) {
					System.out.println("It is AVL tree in HashTable....");
					datastructure.printallkey();
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public int generate() {
		// TODO Auto-generated method stub
		System.out.println("genrating new Key.....");
		 Random random = new Random();
	     int number = random.nextInt(90000000) + 10000000;
		return number;
	}
	@Override
	public void rangeKey(int key1, int key2) {
		// TODO Auto-generated method stub
		int hash_key1=this.hashfunction(key1);
		int hash_key2=this.hashfunction(key2);
		if(hash_key2!=hash_key1) {
			System.out.println("the keys are for different hash element");
		}
		else
			this.MyDataStructure[hash_key1].rangeKey(key1, key2);
		
		
	}
	
}
