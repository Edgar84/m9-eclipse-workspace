package fils2;

public class CompteEnrereDosMain {

	public static void main(String[] args) throws InterruptedException {
		
		CompteEnrereDos t1 = new CompteEnrereDos(1);
		CompteEnrereDos t2 = new CompteEnrereDos(2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Soc el main i els fills ja han acabat");

	}

}
