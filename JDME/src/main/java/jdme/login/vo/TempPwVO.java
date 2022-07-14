package jdme.login.vo;

public class TempPwVO {
	
	
	private String jmnum;
	private String jmtemppw;
	private String jmid;
	private String insertdate;
	
	
	
	public TempPwVO() {
		super();
	}



	public TempPwVO(String jmnum, String jmtemppw, String jmid, String insertdate) {
		
		this.jmnum = jmnum;
		this.jmtemppw = jmtemppw;
		this.jmid = jmid;
		this.insertdate = insertdate;
	}



	public String getJmnum() {
		return jmnum;
	}



	public void setJmnum(String jmnum) {
		this.jmnum = jmnum;
	}



	public String getJmtemppw() {
		return jmtemppw;
	}



	public void setJmtemppw(String jmtemppw) {
		this.jmtemppw = jmtemppw;
	}



	public String getJmid() {
		return jmid;
	}



	public void setJmid(String jmid) {
		this.jmid = jmid;
	}



	public String getInsertdate() {
		return insertdate;
	}



	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
	
	
	
}
