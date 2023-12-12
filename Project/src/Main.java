import java.io.File;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		ElasticMainClass elastic_adt=new ElasticMainClass();
		
		try {
			File file=new File("MyFile.txt");
			Scanner scanner =new Scanner(file);
			while(scanner.hasNext()) {
				
				String element=scanner.nextLine();
				int key=Integer.parseInt(element);
				elastic_adt.add(key, element);
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		elastic_adt.printallkey();
		System.out.println("Calling rangekey function......");
		elastic_adt.rangeKey(70191498, 97428898);
		elastic_adt.remove(84364648);
		elastic_adt.rangeKey(70191498, 97428898);
		System.out.println( elastic_adt.getvalue(77349495));
		System.out.println("Generate new Key:");
		int key=elastic_adt.generate();
		System.out.println("My new Key:");
		System.out.println(key);
		elastic_adt.HistoryofMyrecords();
	}

}
