
public interface DataStrucutre {
	void add(String value, int key);
	int generate();
	void remove(int key);
	void prev_key(int key);
	int next_key(int key);
	String getvalue(int key);
	void printallkey();
	void rangeKey(int key1, int key2);
	int getsize();
}
