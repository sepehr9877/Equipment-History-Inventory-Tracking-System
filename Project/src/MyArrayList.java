
public class MyArrayList {
	int index=0;
	int size=1;
	int array[]=new int[1];
	Object Object_array[]=new Object[1];
	String values[]=new String[1];
	int values_size=1;
	int values_index=0;
	int Object_index=0;
	int Object_size=1;
	public int[]get_all_elements(){
		int[]main_array=new int[index];
		for(int j=0;j<index;++j) {
			main_array[j]=array[j];
		}
		return main_array;
	}
	public int[] sort() {

		int[]main_array=new int[index];
		for(int j=0;j<index;++j) {
			main_array[j]=array[j];
		}
		int[]sorted_array=this.partion(main_array,index);
		return sorted_array;
	}
	private int[] partion(int[]array,int length) {
		if(length==1)
			return array;
		
		int left_length=length/2;
		int right_length=length-left_length;
		int left[]=new int[left_length];
		int right[]=new int[right_length];
		int i=0;
		int l=0;
		int r=0;
		while(l<left.length) {
			left[l]=array[i];
			++l;
			++i;
		}
		while(r<right.length) {
			right[r]=array[i];
			++r;
			++i;
		}
		partion(left, left_length);
		partion(right, right_length);
		this.merge(array, left, right);
		return array;
	}
	private void merge(int []mainarray,int[]left,int[]right) {
		int i=0;
		int l=0;
		int r=0;
		while(r<right.length&&l<left.length) {
			if(left[l]<=right[r]) {
				mainarray[i]=left[l];
				++l;
			}
			else {
				mainarray[i]=right[r];
				++r;
			}
			++i;
		}
		while(l<left.length) {
			mainarray[i]=left[l];
			++l;
			++i;
		}
		while(r<right.length) {
			mainarray[i]=right[r];
			++r;
			++i;
		}
	}
	public void add_values(String values) {
		if(this.values_index==0) {
			this.values[values_index]=values;
			++values_index;
		}
		else {
			if(values_index==this.values_index) {
				this.expand();
				
			}
			this.values[values_index]=values;
			values_index++;
		}
	}
	public void add(int key) {
		if(index==0) {
			this.array[index]=key;
			++index;
		}
		else {
			if(index==this.size) {
				this.expand();
				
			}
			this.array[index]=key;
			index++;
		}
		
		
	}
	public Object[] get_all_objects() {
		Object[]main_array=new Object[Object_index];
		for(int j=0;j<index;++j) {
			main_array[j]=array[j];
		}
		return main_array;
	}
	public void add_object(Object node) {
		if(this.Object_index==0) {
			this.Object_array[this.Object_index]=node;
			++this.Object_index;
		}
		else {
			if(this.Object_index==this.Object_size) {
				this.expand_object_array();
				
			}
			this.Object_array[this.Object_index]=node;
			this.Object_index++;
		}
	}
	public void expand_object_array() {
		Object []expand=new Object[this.Object_array.length];
		this.Object_size=this.Object_size*2;
		int i=0;
		this.Object_index=0;
		while(i<Object_array.length) {
			expand[i]=this.Object_array[i];

			++i;
			++Object_index;
		}
		this.Object_array=new Object[this.Object_array.length*2];
		i=0;
		while(i<expand.length) {
			this.Object_array[i]=expand[i];
			++i;
		
	}
	}
	public Object get_last_object() {
		return this.Object_array[this.Object_index-1];
	}
	public Object get_first_object() {
		return this.Object_array[0];
	}
	private void expand_string_array() {
		String []expand=new String[this.values.length];
		this.values_size=this.values_size*2;
		int i=0;
		this.values_index=0;
		while(i<values.length) {
			expand[i]=this.values[i];

			++i;
			++values_index;
		}
		this.values=new String[this.values.length*2];
		i=0;
		while(i<expand.length) {
			this.values[i]=expand[i];
			++i;
		}
	}
	private void expand() {
		int []expand=new int[this.array.length];
		this.size=this.size*2;
		int i=0;
		this.index=0;
		while(i<array.length) {
			expand[i]=this.array[i];

			++i;
			++index;
		}
		this.array=new int[this.array.length*2];
		i=0;
		while(i<expand.length) {
			this.array[i]=expand[i];
			++i;
		}
	}
}
