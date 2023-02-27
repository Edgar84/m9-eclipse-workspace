package fils4;

public class PingPong_sinc extends Thread {
	
	private String word;
	
	public PingPong_sinc(String s) {
		this.word = s;
	}
	
	public void run() {
		
		synchronized(getClass()) {
			for(int i=0; i<100; i++) {
				System.out.println( i + " " + word);
				getClass().notifyAll();
				try {
					getClass().wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			getClass().notifyAll();
		}
	}

}
