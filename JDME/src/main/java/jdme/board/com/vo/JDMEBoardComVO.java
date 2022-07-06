package jdme.board.com.vo;

public class JDMEBoardComVO {

	private String jbnum;
	private String jmnum;
	private String jbsubject;
	private String jmid;
	private String jbcontent;
	private String jbpw;
	private String jbfile;
	private String jbdyn;
	private String jbidate;
	private String jbudate;
	
	
	public JDMEBoardComVO() {
		
	}
	
	
	public JDMEBoardComVO(String jbnum, String jmnum, String jbsubject,String jmid,
						  String jbcontent, String jbpw, String jbfile,
						  String jbdyn, String jbidate, String jbudate) {
		
		
		this.jbnum = jbnum;
		this.jmnum = jmnum;
		this.jbsubject = jbsubject;
		this.jmid = jmid;
		this.jbcontent = jbcontent;
		this.jbpw = jbpw;
		this.jbfile = jbfile;
		this.jbdyn = jbdyn;
		this.jbidate = jbidate;
		this.jbudate = jbudate;
	}

	

	// setter/getter
	
	public String getJmid() {
		return jmid;
	}


	public void setJmid(String jmid) {
		this.jmid = jmid;
	}
	
	
	public String getJbnum() {
		return jbnum;
	}


	public String getJmnum() {
		return jmnum;
	}


	public String getJbsubject() {
		return jbsubject;
	}


	public String getJbcontent() {
		return jbcontent;
	}


	public String getJbpw() {
		return jbpw;
	}


	public String getJbfile() {
		return jbfile;
	}


	public String getJbdyn() {
		return jbdyn;
	}


	public String getJbidate() {
		return jbidate;
	}


	public String getJbudate() {
		return jbudate;
	}


	public void setJbnum(String jbnum) {
		this.jbnum = jbnum;
	}


	public void setJmnum(String jmnum) {
		this.jmnum = jmnum;
	}


	public void setJbsubject(String jbsubject) {
		this.jbsubject = jbsubject;
	}


	public void setJbcontent(String jbcontent) {
		this.jbcontent = jbcontent;
	}


	public void setJbpw(String jbpw) {
		this.jbpw = jbpw;
	}


	public void setJbfile(String jbfile) {
		this.jbfile = jbfile;
	}


	public void setJbdyn(String jbdyn) {
		this.jbdyn = jbdyn;
	}


	public void setJbidate(String jbidate) {
		this.jbidate = jbidate;
	}


	public void setJbudate(String jbudate) {
		this.jbudate = jbudate;
	}
	
	
}
