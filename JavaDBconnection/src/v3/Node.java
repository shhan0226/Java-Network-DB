package v3;

public class Node {
	String userID;
	String userIP;
	String CpuUse;
	String CpuCapa;
	String MemUse;
	String MemCapa;
	String State;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	public String getCpuUse() {
		return CpuUse;
	}
	public void setCpuUse(String cpuUse) {
		CpuUse = cpuUse;
	}
	public String getCpuCapa() {
		return CpuCapa;
	}
	public void setCpuCapa(String cpuCapa) {
		CpuCapa = cpuCapa;
	}
	public String getMemUse() {
		return MemUse;
	}
	public void setMemUse(String memUse) {
		MemUse = memUse;
	}
	public String getMemCapa() {
		return MemCapa;
	}
	public void setMemCapa(String memCapa) {
		MemCapa = memCapa;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}

}
