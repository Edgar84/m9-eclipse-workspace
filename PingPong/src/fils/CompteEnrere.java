package fils;

public class CompteEnrere extends Thread {
	
	private int num;
	
	public CompteEnrere(int a) {
		num = a;
	}
	
	public void run() {
		for (int i = 5; i >= 0; i--) {
			System.out.println("Fill" + num + " compte enrrere: " + i);
		}
	}
}
