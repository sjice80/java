package test;

public class Consumer extends Thread {
	private Producer producer;
	public Consumer(Producer producer) {
		this.producer = producer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				String data = producer.consume();
				System.out.println("Consumed by: "+Thread.currentThread().getName()+", data:"+data);
				Thread.sleep(500);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
