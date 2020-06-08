package test;
import java.net.*;
import java.io.*;

public class CardServer implements Runnable {
	public static final int BUF_SIZE = 4096;
	private ServerSocket serverSocket;
	private boolean isStop;
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		serverSocket = null;
		try {
			serverSocket = new ServerSocket(27015);
			byte[] buffer = new byte[BUF_SIZE];
			int length;
			while(!isStop) {
				Socket socket = null;
				DataInputStream is = null;
				try {
					socket = serverSocket.accept();
					is = new DataInputStream(socket.getInputStream());
					while(true) {
						String fileName = is.readUTF();
						int fileSize = is.readInt();
						while(fileSize>0) {
							length = is.read(buffer, 0, Math.min(fileSize, buffer.length));
							fileSize -= length;
							writeFile(fileName, buffer, 0, length);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void writeFile(String fileName, byte[] buffer, int offset, int length) throws IOException {
		FileOutputStream fw = null;
		try {
			fw = new FileOutputStream("..//SERVER//"+fileName, true);
			fw.write(buffer, offset, length);
		} finally {
			// TODO: handle finally clause
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public synchronized void close() {
		isStop = true;
		try {
			if(serverSocket!=null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
