package jdme.board.qnareply.vo;

public class JDMEBoardQnaReplyVO {

	private String jqrnum;
	private String jqnum;
	private String jqrid;
	private String jqrcontent;
	private String jqrpw;
	private String jqrdate;
	
	

	public JDMEBoardQnaReplyVO() {
	
	}



	public JDMEBoardQnaReplyVO(String jqrnum, String jqnum, String jqrid,
							   String jqrcontent, String jqrpw,
							   String jqrdate) {
		
		this.jqrnum = jqrnum;
		this.jqnum = jqnum;
		this.jqrid = jqrid;
		this.jqrcontent = jqrcontent;
		this.jqrpw = jqrpw;
		this.jqrdate = jqrdate;
	}


	// setter / getter
	public String getJqrnum() {
		return jqrnum;
	}



	public String getJqnum() {
		return jqnum;
	}



	public String getJqrid() {
		return jqrid;
	}



	public String getJqrcontent() {
		return jqrcontent;
	}



	public String getJqrpw() {
		return jqrpw;
	}



	public String getJqrdate() {
		return jqrdate;
	}



	public void setJqrnum(String jqrnum) {
		this.jqrnum = jqrnum;
	}



	public void setJqnum(String jqnum) {
		this.jqnum = jqnum;
	}



	public void setJqrid(String jqrid) {
		this.jqrid = jqrid;
	}



	public void setJqrcontent(String jqrcontent) {
		this.jqrcontent = jqrcontent;
	}



	public void setJqrpw(String jqrpw) {
		this.jqrpw = jqrpw;
	}



	public void setJqrdate(String jqrdate) {
		this.jqrdate = jqrdate;
	}
	
	
	
	
	
	
}
