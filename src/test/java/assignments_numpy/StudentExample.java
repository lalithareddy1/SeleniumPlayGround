package assignments_numpy;

public class StudentExample {
	
	int a = 10;
	
	public void sum() {
		
		System.out.println("calling default method");
	}
	
	public void sum(int a, int b , int c, int d) {
		System.out.println(a);
		
	}
	
	

	public static void main(String[] args) {
		StudentExample e1 = new StudentExample();
		e1.sum(10, 10, 20, 30);
		
		
	}

}
