import java.util.Random;

public class AVL_Tree implements DataStrucutre{
	Node root;
	String seachvalue;
	Node find_left=null;
	Node  find_right=null;
	Node find_leaf=null;
	int index=0;
	MyArrayList inorder=new MyArrayList();
	public AVL_Tree() {
		System.out.println("Data Structure in HashTable Element changed from Linkedlist to AVL Tree");
	}
	
	private Node get_node_z(Node z) {
		int left_height=0;
		int right_height=0;
		boolean balance=false;
		Node root=z;
		while(balance==false) {
			if(root==null)break;
			if(root.left==null&&root.right==null)break;
			if(root.left!=null)left_height=root.left.height;
			if(root.right!=null)right_height=root.right.height;
			int diff=Math.abs(left_height-right_height);
			if(diff>1) {
				balance=true;
				return root;
			}
			if(left_height>=right_height)root=root.left;
			else root=root.right;
		}
		return null;
		
	}
	private void UpdateHeight(Node root) {
		if(root!=null) {
			root.height=1;
			if(root.left!=null) {
				root.height=1;
				UpdateHeight(root.left);
				
				
			}
			if(root.right!=null) {
				root.height=1;
				UpdateHeight(root.right);
			}
			}
		}
		

	private void Balance(Node z) {
		if(z!=null) {
		Node y=null;
		Node x=null;
		if(z.left==null&&z.right!=null) {
			y=z.right;
		}
		if(z.right==null&&z.left!=null) {
			y=z.left;
		}
		else if(z.left!=null &&z.right!=null) {
			if(z.left.height>=z.right.height) {
				y=z.left;
			}
			else
				y=z.right;
		}
		
		if(y.left==null&&y.right!=null) {
			x=y.right;
		}
		if(y.right==null&&y.left!=null) {
			x=y.left;
		}
		else if(y.left!=null &&y.right!=null) {
			if(y.left.height>=y.right.height) {
				x=y.left;
			}
			else
				x=y.right;
		}
		if(z.right==y) {
			if(y.right==x) {
				Node t1=y.left;
				
				Node z_root=z.root;
				if(z==this.root) {


					this.root=y;
					this.root.height=1;
				}
				else {
					if(z_root.right==z)
						z_root.setRight(y);
					else
						z_root.setLeft(y);
					
					y.setRoot(z_root);
				}
				z.setRight(t1);
				y.setLeft(z);
				z.setRoot(y);
				if(t1!=null)
					t1.setRoot(z);
				
			}
			else {
				Node t1=x.left;
				Node t2=x.right;
				Node z_root=z.root;
				
				y.setLeft(t2);
				
				if(t2!=null)
					t2.setRoot(y);
				if(z==this.root) {
					this.root=x;
					this.root.height=1;
				}
				else {
					if(z_root.right==z) {
						z_root.setRight(x);	
					}
					else
						z_root.setLeft(x);
					x.setRoot(z_root);
					
				}
				z.setRight(t1);
				x.setLeft(z);
				x.setRight(y);
				z.setRoot(x);
				y.setRoot(z);
				if(t1!=null)
					t1.setRoot(z);
				
			}
		}
		if(z.left==y) {
			if(y.left==x) {
				Node t2=y.right;
				Node z_root=z.root;
				
				
				if(z==this.root) {
					this.root=y;
					this.root.height=1;
				}
				else {
					if(z_root.left==z)
						z_root.setLeft(y);
					else
						z_root.setRight(y);
					y.setRoot(z_root);;
				}
				z.setLeft(t2);
				z.setRoot(y);
				if(t2!=null) {
					t2.setRoot(z);
				}
				y.setRight(z);
			}
			else {
				Node t1=x.left;
				Node t2=x.right;
				Node z_root=z.root;
				if(z==this.root) {
					this.root=x;
					this.root.height=1;
				}
				else {
					if(z_root.left==z)
						z_root.setLeft(x);
					else
						z_root.setRight(x);

					x.setRoot(z_root);
				}
				y.setRight(t1);
				if(t1!=null)t1.setRoot(y);
				z.setLeft(t2);
				if(t2!=null)t2.setRoot(z);
				x.setLeft(y);
				x.setRight(z);
				y.setRoot(x);
				z.setRoot(x);
				
				
				
			}
		}	
		}
		this.UpdateHeight(this.root);
		this.addHeight(this.root);
		
	}
	private Node addToTree(Node root,Node node) {
		
		if(root.left==null&&root.key>=node.key) {
			root.setLeft(node);
			node.setRoot(root);
			return node;
		}
		if(root.right==null&&root.key<node.key) {
			
			root.setRight(node);
			node.setRoot(root);
			return node;
			
		}
		if(root.key>=node.key) {

			addToTree(root.left, node);
			return node;
		}
		else if(root.key<node.key){
			addToTree(root.right, node);
			return node;

		}
		this.UpdateHeight(this.root);
		this.addHeight(this.root);
		Node n=this.get_node_z(this.root);
		this.Balance(n);
		return node;
	}
	
	private void addHeight(Node root) {
		int left_height=1;
		int right_height=1;
		if(root!=null) {
			
			if(root.left!=null) {

				

				
				addHeight(root.left);
				root.height=root.left.height+1;
			}
			left_height=root.height;
			if(root.right!=null) {
				addHeight(root.right);
				root.height=root.right.height+1;
			}
			right_height=root.height;
			if(left_height>=right_height) {
				root.height=left_height;
			}
			else {
				root.height=right_height;
			}
			}
		}

	@Override
	public void add(String value, int key) {
		// TODO Auto-generated method stub
		if(this.root==null) {
			this.root=new Node(key,value);
		}
		else {
			this.addToTree(this.root,new Node(key,value));
		}
	}

	@Override
	public int generate() {
			System.out.println("genrating new Key.....");
			 Random random = new Random();
		     int number = random.nextInt(90000000) + 10000000;
		     String value=this.getvalue(number);
		     if(value!=null) {
		    	 return number;
		     }
		     else {
		    	 System.out.println("The key was already added into AVL tree ..");
		    	 return 0;
		     }
	}
	private Node traverse_left(int key,Node left) {
		if(left!=null) {
			if(left.key==key) {
				this.find_left=left;
				return left;
			}
			if(left.left!=null) {
				traverse_left(key, left.left);
			}
			if(left.right!=null) {
				traverse_left(key,left.right);
			}
		}
		return null;
	}
	private Node traverse_right(int key,Node right) {
		if(right!=null) {
			if(right.key==key) {
				this.find_right=right;
				return right;
			}
			if(right.left!=null) {
				traverse_right(key, right.left);
			}
			if(right.right!=null) {
				traverse_right(key, right.right);
			}
		}
		return null;
	}
	private void deletemyleaf(Node root,int key) {
		if(root!=null) {
			
			if(root.left!=null) {
				if(root.left.key==key) {
					System.out.println("Find my elementt left");
					root.setLeft(null);
				}
				deletemyleaf(root.left, key);
			}
			if(root.right!=null) {
				if(root.right.key==key) {
					System.out.println("Find my element right");
					root.setLeft(null);
				}
				deletemyleaf(root.right, key);
			}
		}
	}
	@Override
	public void remove(int key) {
		// TODO Auto-generated method stub
		if(this.root.key==key) {
			System.out.println("The element you want to remove is in the root!!...");
			System.out.println("Find the element:");
			System.out.println(this.root.key);
			this.swap_with_root();
		}
		else {
			this.traverse_left(key,root.left);
			this.traverse_right(key,root.right);
			System.out.println("Finding the element ....");
			if(this.find_left!=null) {
				System.out.println(this.find_left.key);
			}
			if(this.find_right!=null) {
				System.out.println(this.find_right.key);
			}
			if(this.find_left==null&&this.find_right==null) {
				System.out.println("The element that you want to delete doesnt exist in AVL tree");
			}
		}
		Node m=null;
		if(find_left!=null) {
			Node find=this.get_last_rightNode(find_left);
			if(find!=null) {
				System.out.println("the element that should be replaced with removed element is:");
				System.out.println(find.key);
				this.swaping_left(find, find_left);
			}
			else
				this.deletemyleaf(this.root,key);
		}
		if(find_right!=null) {
			Node find=this.get_last_leftNode(find_right);
			if(find!=null) {
				System.out.println("the element that should be replaced with removed element is:");
				System.out.println(find.key);
				this.swaping_right(find,this.find_right);
			}
			else
				this.deletemyleaf(this.root, key);
			
		}
		this.UpdateHeight(this.root);
		this.addHeight(this.root);
		Node z=this.get_node_z(this.root);
		this.Balance(z);
		
		this.find_left=null;
		this.find_right=null;
		this.index=0;
		this.inorder=new MyArrayList();
		
	}
	private void inorder(Node root) {
		if(root!=null){
			if(root.left!=null)
				inorder(root.left);
			System.out.println("My node");
			System.out.println(root.key);
			
			if(root.right!=null) {

				inorder(root.right);
			}
	}
	}
	private Node get_last_leftNode(Node root) {
		Node current=root;
		Node lastleft=null;
		while(current!=null) {
			if(current.left!=null) {
				current=current.left;
				lastleft=current;
			}
			else {
				current=current.right;
			}
		}
		return lastleft;
	}
	private Node get_last_rightNode(Node root) {
		Node current=root;
		Node last_right=null;
		while(current!=null) {
			if(current.right!=null) {
				System.out.println("ddd");
				current=current.right;
				last_right=current;
			}
			else {
				current=current.left;
			}
		}
		return last_right;
	}
	private void swaping_left(Node leaf,Node selected) {
		
		if(leaf!=null&&selected!=null) {
			selected.setKey(leaf.key);
			leaf.root.setRight(null);
		}
	}
	private void swaping_right(Node leaf,Node selected) {
		if(leaf!=null&&selected!=null) {
			selected.setKey(leaf.key);
			leaf.root.setLeft(null);
		}
	}
	private void swap_with_root() {
		// TODO Auto-generated method stub
		Node last_left=this.get_last_rightNode(root);
		if(last_left!=null) {
			System.out.println("The element to replace the main root of AVL is "+ last_left.key);
			this.root.setKey(last_left.key);
			System.out.println("the root of 11 is");
			System.out.println(last_left.root.key);
			last_left.root.setRight(null);
		}
		else {
			Node last_right=this.get_last_rightNode(this.root);
			System.out.println("The element to replace the main root of AVL is "+last_right.key);
			this.swaping_right(last_right, this.root);
		}
		
	}
	@Override
	public void prev_key(int key) {
		// TODO Auto-generated method stub
		System.out.println("You are Using AVL tree so prev key doesnt exist");
	}

	@Override
	public int next_key(int key) {
		// TODO Auto-generated method stub
		System.out.println("You are Using AVL tree so prev key doesnt exist");
		return 0;
	}
	private String search(Node root,int key) {
		boolean find=false;
		if(find==false&&root!=null) {
			
			if(root.key==key) {
				find=true;
				System.out.println("searching the element");
				this.seachvalue=root.value;
			}
			if(root.left!=null&&find==false) {
				search(root.left,key);
			}
			if(root.right!=null&&find==false) {
				search(root.right,key);
			}
		}
		
		return this.seachvalue;
	}
	@Override
	public String getvalue(int key) {
		// TODO Auto-generated method stub
		String value=this.search(this.root,key);
		
		return value;
	}

	@Override
	public void printallkey() {
		// TODO Auto-generated method stub
		this.inorder(this.root);
		
	}
	private Object[] add_keys_to_array( MyArrayList array,Node root) {
		if(root!=null){
			if(root.left!=null)
				add_keys_to_array(array,root.left);
			array.add_object(root.key);
			if(root.right!=null) {

				add_keys_to_array(array,root.right);
			}
	}
		return array.Object_array;
	}
	@Override
	public void rangeKey(int key1, int key2) {
		// TODO Auto-generated method stub
		System.out.println("These elements are in AVl tree");
		MyArrayList array=new MyArrayList();
		Object[] keys=this.add_keys_to_array(array,this.root);
		for(Object key:keys) {
			if(key!=null&&(int)key<=key2&&(int)key>=key1) {
				System.out.println((int)key);
			}
		}
		
	}

	@Override
	public int getsize() {
		// TODO Auto-generated method stub
		return 0;
	}
	class Node{
		int key;
		int height=1;
		String value;
		Node left;
		Node right;
		Node root;
		public Node(int key,String value) {
			this.key=key;
			this.value=value;
		}
		public void setLeft(Node node) {
			this.left=node;
		}
		public void setRight(Node node) {
			this.right=node;
		}
		public void setKey(int key) {
			this.key=key;
		}
		public void setRoot(Node node) {
			this.root=node;
		}
	}

}
