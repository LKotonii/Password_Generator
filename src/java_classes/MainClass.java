package java_classes;

public class MainClass {

	static boolean isTen(int r) {
			return r==1;
	
	}
	
	public static void main(String[] args) throws TooWeakPasswordException {
		
		int [] randoms = Random.getNofRandomInt(4, 500, 3500);

		for (int i: randoms) {
		System.out.println(i);
		}
		
		
		
	}

}
