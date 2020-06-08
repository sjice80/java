package test;

public class ReportVo {
	private String insId;
	private int checkCard;
	private int failCard;
	public ReportVo() {
		
	}
	public ReportVo(String line) {
		insId = line.split(" ")[0];
		checkCard = Integer.parseInt(line.split(" ")[1]);
		failCard = Integer.parseInt(line.split(" ")[2]);
	}
	public String getInsId() {
		return insId;
	}
	public void setInsId(String insId) {
		this.insId = insId;
	}
	public int getCheckCard() {
		return checkCard;
	}
	public void setCheckCard(int checkCard) {
		this.checkCard = checkCard;
	}
	public int getFailCard() {
		return failCard;
	}
	public void setFailCard(int failCard) {
		this.failCard = failCard;
	}
	public void increaseCheckCard() {
		this.checkCard++;
	}
	public void increaseFailCard() {
		this.failCard++;
	}
	public String toString() {
		return insId+" "+checkCard+" "+failCard;
	}
}
