package test;
import java.io.*;
import java.util.*;
import java.text.*;

public class ValidatorReport {
	private static String LINE_BREAK = System.getProperty("line.seperator");
	public boolean reportValidator() throws IOException {
		HashMap<String, ReportVo> map = new HashMap<>();
		final String strToday = getCurrentDateString();
		File directory = new File("..//SERVER");
		File[] list = directory.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile() && file.getName().length() == 27 &&
						file.getName().substring(9, 17).equals(strToday);
			}
		});
		for(File file:list) {
			analysisData(map, file.getPath());
		}
		return true;
	}
	private void analysisData(HashMap<String, ReportVo> map, String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine())!=null) {
				ReportVo userReport = new ReportVo();
				String key = line.substring(0, 8);
				if(map.get(key)==null) {
					userReport.setInsId(key);
					userReport.setCheckCard(1);
					if(line.charAt(49)=='1') {
						userReport.setFailCard(0);
					} else {
						userReport.setFailCard(1);
					}
					map.put(key, userReport);
				} else {
					map.get(key).increaseCheckCard();
					if(line.charAt(49)!='1') {
						map.get(key).increaseFailCard();
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(br!=null) {
				br.close();
			}
		}
	}
	private void saveReportFile(HashMap<String, ReportVo> map, String today) throws IOException {
		String filename = "..//SERVER//REPORT_"+today+".TXT";
		FileWriter fw = null;
		try {
			fw = new FileWriter(filename);
			for(String key:map.keySet()) {
				fw.write(map.get(key).toString());
				fw.write(LINE_BREAK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public void printReport(String date, String option) throws IOException {
		ArrayList<ReportVo> reportList = new ArrayList<>();
		BufferedReader br = null;
		String line;
		try {
			br = new BufferedReader(new FileReader("..//SERVER//REPORT_"+date+".TXT"));
			while((line = br.readLine())!=null) {
				ReportVo userReport = new ReportVo(line);
				reportList.add(userReport);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(br!=null) {
				br.close();
			}
		}
		if("C".equals(option)) {
			Comparator<ReportVo> co = new Comparator<ReportVo>() {
				public int compare(ReportVo v1, ReportVo v2) {
					return v2.getCheckCard() - v1.getCheckCard();
				}
			};
			Collections.sort(reportList, co);
		}
		for (int i = 0; i < reportList.size(); i++) {
			System.out.println(reportList.get(i).toString());
		}
	}
	public static String getCurrentDateString() {
		long time = System.currentTimeMillis();
		SimpleDateFormat today = new SimpleDateFormat("yyyyMMdd");
		String strToday = today.format(new Date(time));
		return strToday;
	}
}
