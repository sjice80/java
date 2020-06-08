package test;
import java.util.*;
import java.time.*;

public class Producer extends Thread {
	private static final int MAX_SIZE = 3;
	private final List<String> messages = new ArrayList<>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				produce();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private synchronized void produce() throws Exception {
		while(messages.size() == MAX_SIZE) {
			System.out.println("Queue limit reached. Waiting for consumer");
			wait();
			System.out.println("Producer got notification from consumer");
		}
		String data = LocalDateTime.now().toString();
		messages.add(data);
		System.out.println("Producer produced data");
		notify();
	}
	public synchronized String consume() throws Exception {
		notify();
		while(messages.isEmpty()) {
			wait();
		}
		String data = messages.get(0);
		messages.remove(data);
		return data;
	}
}
