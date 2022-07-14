package jdme.member.vo;

public class JDMEMemberVO {

	private String jmnum;
	private String jmname;
	private String jmid;
	private String jmpw;
	private String jmbirth;
	private String jmgender;
	private String jmhp;
	private String jmemail;
	private String jmzipcode;
	private String jmaddr;
	private String jmaddrdetail;
	private String jmimage;
	private String jmaccess;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	//아이디찾기 메일인증
	private String tempauthmemail;
	private String tempauthnum;
	
	
	public JDMEMemberVO(String jmnum, String jmname, String jmid, String jmpw, String jmbirth, String jmgender,
			String jmhp, String jmemail, String jmzipcode, String jmaddr, String jmaddrdetail, String jmimage,
			String jmaccess, String deleteyn, String insertdate, String updatedate, String tempauthmemail,
			String tempauthnum) {
		
		this.jmnum = jmnum;
		this.jmname = jmname;
		this.jmid = jmid;
		this.jmpw = jmpw;
		this.jmbirth = jmbirth;
		this.jmgender = jmgender;
		this.jmhp = jmhp;
		this.jmemail = jmemail;
		this.jmzipcode = jmzipcode;
		this.jmaddr = jmaddr;
		this.jmaddrdetail = jmaddrdetail;
		this.jmimage = jmimage;
		this.jmaccess = jmaccess;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.tempauthmemail = tempauthmemail;
		this.tempauthnum = tempauthnum;
	}


	public JDMEMemberVO() {
		
	}


	public String getJmnum() {
		return jmnum;
	}


	public void setJmnum(String jmnum) {
		this.jmnum = jmnum;
	}


	public String getJmname() {
		return jmname;
	}


	public void setJmname(String jmname) {
		this.jmname = jmname;
	}


	public String getJmid() {
		return jmid;
	}


	public void setJmid(String jmid) {
		this.jmid = jmid;
	}


	public String getJmpw() {
		return jmpw;
	}


	public void setJmpw(String jmpw) {
		this.jmpw = jmpw;
	}


	public String getJmbirth() {
		return jmbirth;
	}


	public void setJmbirth(String jmbirth) {
		this.jmbirth = jmbirth;
	}


	public String getJmgender() {
		return jmgender;
	}


	public void setJmgender(String jmgender) {
		this.jmgender = jmgender;
	}


	public String getJmhp() {
		return jmhp;
	}


	public void setJmhp(String jmhp) {
		this.jmhp = jmhp;
	}


	public String getJmemail() {
		return jmemail;
	}


	public void setJmemail(String jmemail) {
		this.jmemail = jmemail;
	}


	public String getJmzipcode() {
		return jmzipcode;
	}


	public void setJmzipcode(String jmzipcode) {
		this.jmzipcode = jmzipcode;
	}


	public String getJmaddr() {
		return jmaddr;
	}


	public void setJmaddr(String jmaddr) {
		this.jmaddr = jmaddr;
	}


	public String getJmaddrdetail() {
		return jmaddrdetail;
	}


	public void setJmaddrdetail(String jmaddrdetail) {
		this.jmaddrdetail = jmaddrdetail;
	}


	public String getJmimage() {
		return jmimage;
	}


	public void setJmimage(String jmimage) {
		this.jmimage = jmimage;
	}


	public String getJmaccess() {
		return jmaccess;
	}


	public void setJmaccess(String jmaccess) {
		this.jmaccess = jmaccess;
	}


	public String getDeleteyn() {
		return deleteyn;
	}


	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}


	public String getInsertdate() {
		return insertdate;
	}


	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}


	public String getUpdatedate() {
		return updatedate;
	}


	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}


	public String getTempauthmemail() {
		return tempauthmemail;
	}


	public void setTempauthmemail(String tempauthmemail) {
		this.tempauthmemail = tempauthmemail;
	}


	public String getTempauthnum() {
		return tempauthnum;
	}


	public void setTempauthnum(String tempauthnum) {
		this.tempauthnum = tempauthnum;
	}
	
	
	
}