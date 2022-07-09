package jdme.board.qna.vo;

public class JDMEBoardQnaVO {

	private String jqnum;
	private String jmnum;
	private String jqsubject;
	private String jmid;
	private String jqcontent;
	private String jqfile;
	private String jqdyn;
	private String jqidate;
	private String jqudate;
	
	
	public JDMEBoardQnaVO() {
		
	}
	
	
	
	public JDMEBoardQnaVO(String jqnum, String jmnum, String jqsubject,String jmid, 
						  String jqcontent, String jqfile, String jqdyn,
						  String jqidate, String jqudate) {
		
		this.jqnum = jqnum;
		this.jmnum = jmnum;
		this.jqsubject = jqsubject;
		this.jmid = jmid;
		this.jqcontent = jqcontent;
		this.jqfile = jqfile;
		this.jqdyn = jqdyn;
		this.jqidate = jqidate;
		this.jqudate = jqudate;
	}




	// setter / getter
	
	public String getJmid() {
		return jmid;
	}



	public void setJmid(String jmid) {
		this.jmid = jmid;
	}

	
	public String getJqnum() {
		return jqnum;
	}



	public String getJmnum() {
		return jmnum;
	}



	public String getJqsubject() {
		return jqsubject;
	}



	public String getJqcontent() {
		return jqcontent;
	}



	public String getJqfile() {
		return jqfile;
	}



	public String getJqdyn() {
		return jqdyn;
	}



	public String getJqidate() {
		return jqidate;
	}



	public String getJqudate() {
		return jqudate;
	}



	public void setJqnum(String jqnum) {
		this.jqnum = jqnum;
	}



	public void setJmnum(String jmnum) {
		this.jmnum = jmnum;
	}



	public void setJqsubject(String jqsubject) {
		this.jqsubject = jqsubject;
	}



	public void setJqcontent(String jqcontent) {
		this.jqcontent = jqcontent;
	}



	public void setJqfile(String jqfile) {
		this.jqfile = jqfile;
	}



	public void setJqdyn(String jqdyn) {
		this.jqdyn = jqdyn;
	}



	public void setJqidate(String jqidate) {
		this.jqidate = jqidate;
	}



	public void setJqudate(String jqudate) {
		this.jqudate = jqudate;
	}

	
	
	
	
}
