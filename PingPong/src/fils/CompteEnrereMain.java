package fils;

public class CompteEnrereMain {

	public static void main(String[] args) {
		
		CompteEnrere ce1 = new CompteEnrere(1);
		CompteEnrere ce2 = new CompteEnrere(2);
		
		ce1.start();
		ce2.start();
		
		for (int i = 5; i >= 0; i--) {
			System.out.println("Main compte enrrere: " + i);
		}

	}

}
