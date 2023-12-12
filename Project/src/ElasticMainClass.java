
public class ElasticMainClass {
	DataStrucutre chosendatastrucutre=null;
	int size;
	ERL_LinkedList history=new ERL_LinkedList();
	public ElasticMainClass() {
		// TODO Auto-generated constructor stub
		this.chosendatastrucutre=new ERL_LinkedList();
		
	}
	public void add(int key,String keyString) {
		this.history.add(keyString, key);
		
		if(this.size>10) {
			if(this.chosendatastrucutre instanceof ERL_LinkedList) {
				System.out.println("Changing the Data Structure from LinkedList to HashTable ...");
				Object[]nodes=((ERL_LinkedList) this.chosendatastrucutre).all_Nodes();
				this.chosendatastrucutre=new HashTable();
				System.out.println("Adding previous Elements from LinkedList to HashTable");
				
				for(Object obj:nodes) {
					Node node=(Node)obj;
					if(node!=null)
						this.chosendatastrucutre.add(node.value, node.key);
				}
				System.out.println("Finish adding previous elements....");
			}
			
		}
		this.chosendatastrucutre.add(keyString, key);
		this.size=this.size+1;
	}
	public int generate() {
		return this.chosendatastrucutre.generate();
	}
	public void remove(int key) {
		this.chosendatastrucutre.remove(key);
	}
	public void prev_key(int key) {
		this.chosendatastrucutre.prev_key(key);
	}
	public int next_key(int key) {
		
		return this.chosendatastrucutre.next_key(key);
	}
	public String getvalue(int key) {
		return this.chosendatastrucutre.getvalue(key);
	}
	public void printallkey() {
		this.chosendatastrucutre.printallkey();
	}
	public void rangeKey(int key1, int key2) {
		this.chosendatastrucutre.rangeKey(key1, key2);
	}
	public void HistoryofMyrecords() {
		this.history.HistoryRecords();
	}
	
}
