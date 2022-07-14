package jdme.login.vo;

public class TempAuthNumVO {

	private int anum;
	private String authnum;
	private String jmemail;
	private String insertdate;
	
	
	public TempAuthNumVO() {
		
	}


	public TempAuthNumVO(int anum, String authnum, String jmemail, String insertdate) {
		
		this.anum = anum;
		this.authnum = authnum;
		this.jmemail = jmemail;
		this.insertdate = insertdate;
	}


	public int getAnum() {
		return anum;
	}


	public void setAnum(int anum) {
		this.anum = anum;
	}


	public String getAuthnum() {
		return authnum;
	}


	public void setAuthnum(String authnum) {
		this.authnum = authnum;
	}


	public String getJmemail() {
		return jmemail;
	}


	public void setJmemail(String jmemail) {
		this.jmemail = jmemail;
	}


	public String getInsertdate() {
		return insertdate;
	}


	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
	
	
	
}
