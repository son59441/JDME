package jdme.board.reply.vo;

public class JDMEBoardReplyVO {

	private String jrnum;
	private String jbnum;
	private String jrid;
	private String jrcontent;
	private String jrpw;
	private String jrdate;
	
	

	public JDMEBoardReplyVO() {
	
	}
	
	
	public JDMEBoardReplyVO(String jrnum, String jbnum, String jrid, String jrcontent, String jrpw, String jrdate) {
		
		this.jrnum = jrnum;
		this.jbnum = jbnum;
		this.jrid = jrid;
		this.jrcontent = jrcontent;
		this.jrpw = jrpw;
		this.jrdate = jrdate;
	}


	// setter / getter
	public String getJrnum() {
		return jrnum;
	}


	public String getJbnum() {
		return jbnum;
	}


	public String getJrid() {
		return jrid;
	}


	public String getJrcontent() {
		return jrcontent;
	}


	public String getJrpw() {
		return jrpw;
	}


	public String getJrdate() {
		return jrdate;
	}


	public void setJrnum(String jrnum) {
		this.jrnum = jrnum;
	}


	public void setJbnum(String jbnum) {
		this.jbnum = jbnum;
	}


	public void setJrid(String jrid) {
		this.jrid = jrid;
	}


	public void setJrcontent(String jrcontent) {
		this.jrcontent = jrcontent;
	}


	public void setJrpw(String jrpw) {
		this.jrpw = jrpw;
	}


	public void setJrdate(String jrdate) {
		this.jrdate = jrdate;
	}

	
	
}
