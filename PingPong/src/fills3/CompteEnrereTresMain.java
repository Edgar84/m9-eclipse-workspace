package fills3;


public class CompteEnrereTresMain {

	public static void main(String[] args) throws InterruptedException {
		
		CompteEnrereTres t2 = new CompteEnrereTres(2);
		CompteEnrereTres t1 = new CompteEnrereTres(1,t2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t1.join();
		
		System.out.println("Soc el main i els fills ja han acabat");

	}

}
