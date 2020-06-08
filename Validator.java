package test;
import java.io.*;
import java.text.*;
import java.util.Date;
import java.net.*;
import java.security.*;

public class Validator {
	public static final int FILENAME_LEN = 27;
	private String insId;
	private String onBusId;
	private String onBusTime;
	public boolean login(String id, String psw) throws NoSuchAlgorithmException, IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("..//CLIENT//INSPECTOR.TXT"));
			String line;
			String encPsw = psw+"enc";
			while((line=in.readLine())!=null) {
				String fileId = line.substring(0, 8);
				String filePsw = line.substring(9);
				if(id.equals(fileId) && filePsw.equals(encPsw)) {
					insId = id;
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(in!=null) {
				in.close();
			}
		}
		return false;
	}
	public void logout() throws IOException {
		sendToServer();
		insId = null;
	}
	public void sendToServer() throws IOException {
		Socket socket = null;
		DataOutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 27015);
			os = new DataOutputStream(socket.getOutputStream());
			byte[] buffer = new byte[4096];
			int length;
			File directory = new File("..//"+insId);
			File[] fList = directory.listFiles();
			for(File file:fList) {
				if(file.isFile()) {
					os.writeUTF(file.getName());
					os.writeInt((int)file.length());
					FileInputStream is = null;
					try {
						is = new FileInputStream(file.getPath());
						while((length = is.read(buffer))!=-1) {
							os.write(buffer, 0, length);
						}
					} finally {
						if(is!=null) {
							is.close();
						}
					}
					moveFileToBackup(file.getPath(), file.getName());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(os != null) {
				os.close();
			}
			if(socket!=null) {
				socket.close();
			}
		}
	}
	public void getOnBus(String busId) {
		if(busId.length()<7 || busId.substring(0, 4).equals("BUS_") != true) {
			System.out.println("Wrong Bus ID");
			return;
		}
		onBusId = busId;
		onBusTime = getCurrentDateTimeString();
	}
	public void getOffBus() {
		onBusId = null;
		onBusTime = null;
	}
	public void inspectCard(String cardInfo) throws IOException, ParseException {
		if(cardInfo.length() != 30) {
			System.out.println("Wrong Card Info");
			return;
		}
		if(onBusId != null) {
			String validateCode;
			String cardBusID = cardInfo.substring(8, 15);
			String code = cardInfo.substring(15, 16);
			String rideTime = cardInfo.substring(16);
			String inspectTime = getCurrentDateTimeString();
			if(onBusId.equals(cardBusID)) {
				if(code.equals("N")) {
					if(hourDiff(inspectTime, rideTime)<3) {
						validateCode = "R1";
					} else {
						validateCode = "R4";
					}
				} else {
					validateCode = "R3";
				}
			} else {
				validateCode = "R2";
			}
			saveFile(cardInfo, validateCode, inspectTime);
		}
	}
	private void saveFile(String cardInfo, String validateCode, String inspectTime) throws IOException {
		File destFolder = new File("..//"+insId);
		if(!destFolder.exists()) {
			destFolder.mkdirs();
		}
		String strFilename = destFolder+"//"+insId+"_"+onBusTime+".TXT";
		FileWriter fw = null;
		try {
			fw = new FileWriter(strFilename, true);
			fw.write(insId+"#"+onBusId+"#"+cardInfo+"#"+validateCode+"#"+inspectTime+"\r\n");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public static long hourDiff(String strTime2, String strTime1) throws ParseException {
		SimpleDateFormat today = new SimpleDateFormat("yyyyMMddHHmmss");
		java.util.Date date1 = today.parse(strTime1);
		java.util.Date date2 = today.parse(strTime2);
		long gap = date2.getTime() - date1.getTime();
		return gap/60/60/1000;
	}
	public static String getCurrentDateTimeString() {
		long time = System.currentTimeMillis();
		SimpleDateFormat today = new SimpleDateFormat("yyyyMMddHHmmss");
		String strTime = today.format(new Date(time));
		return strTime;
	}
	private void moveFileToBackup(String path, String name) {
		File fileFrom = new File(path);
		File fileTo = new File("..//BACKUP//"+name);
		fileTo.delete();
		fileFrom.renameTo(fileTo);
	}
}
