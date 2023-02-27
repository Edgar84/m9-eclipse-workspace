package fills3;

public class CompteEnrereTres extends Thread {
	
	private int num;
	CompteEnrereTres t;
	
	public CompteEnrereTres(int a) {
		this.num = a;
	}
	public CompteEnrereTres(int a, CompteEnrereTres t1) throws InterruptedException {
		this.num = a;
		this.t = t1;
	}
	
	public void run() {
		if(t != null) {
			try {
				t.join();
				for (int i = 50; i >= 0; i--) {
					System.out.println("Fil" + num + " compte enrrere: " + i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			for (int i = 50; i >= 0; i--) {
				System.out.println("Fil" + num + " compte enrrere: " + i);
			}
		}
		
	}

}
