package jdme.login.vo;

public class ChangePwVO {

	private String jmpw;
	private String jmtemppw;
	
	
	public ChangePwVO(String jmpw, String jmtemppw) {
		
		this.jmpw = jmpw;
		this.jmtemppw = jmtemppw;
	}


	public ChangePwVO() {
		
	}


	public String getJmpw() {
		return jmpw;
	}


	public void setJmpw(String jmpw) {
		this.jmpw = jmpw;
	}


	public String getJmtemppw() {
		return jmtemppw;
	}


	public void setJmtemppw(String jmtemppw) {
		this.jmtemppw = jmtemppw;
	}
	
	
	
	
	
	
	
}
