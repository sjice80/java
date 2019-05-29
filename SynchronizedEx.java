import java.io.*;
import java.util.*;
import java.security.MessageDigest;

class ATM implements Runnable {
	private long depositMoney = 10000;
	public void run() {
		synchronized(this) {
			for(int i=0; i<10; i++) {
				notify();
				try {
					wait();
//					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(getDepositMoney() <= 0) {
					break;
				}
				withDraw(1000);
			}
		}
	}

	public void withDraw(long howMuch) {
		if(getDepositMoney()>0) {
			depositMoney -= howMuch;
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.printf("잔액:%d원\n", getDepositMoney());
		} else {
			System.out.print(Thread.currentThread().getName()+" , ");
			System.out.println("잔액이 부족합니다.");
		}
	}
	public long getDepositMoney() {
		return depositMoney;
	}
}
public class SynchronizedEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ATM atm = new ATM();
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		mother.start();
		son.start();
		String input1 = "MISSISSIPPI";
		getAlphabetCount(input1);
		parseAddress("INPUT_EMAIL.TXT");
	}
	public static void parseAddress(String file) throws IOException {
		FileReader f = new FileReader("./INFILE/INPUT_EMAIL.TXT");
		BufferedReader br = new BufferedReader(f);
		while(true) {
			String str = br.readLine();
			if(str!=null) {
				String[] arrLine = str.split(",");
				for(int i=0; i<arrLine.length; i++) {
					System.out.println(arrLine[i]+" ");
				}
			} else {
				break;
			}
		}
		br.close();
	}
	public static String getAlphabetCount(String input) {
		String result="";
		int cnt[] = new int[26];
		for(int i=0; i<input.length(); i++) {
//			for(int j=0; j<26; j++) {
				int idx = input.charAt(i) - 'A';
//				if(j == idx) {
					cnt[idx]++;
//				}
//			}
		}
		for(int i=0; i<26; i++) {
			if(cnt[i]!=0) {
				char ch = (char)(i+'A');
				result += String.valueOf(ch)+cnt[i];
			}
		}
		/*
		for(int i=0; i<input.length(); i++) {
			int idx = input.charAt(i) - 'A';
			if(!result.contains(String.valueOf(input.charAt(i)))) {
				result += String.valueOf(input.charAt(i)) + String.valueOf(cnt[idx]);
			}
		}
		*/
		System.out.println(result);
		return result;
	}
}

