package shoppingCartLogin;

import java.util.ArrayList;

public class UserJB {
	private long userId;
	private String fullname;
	private String username;
	private String password;
	private ArrayList<LineitemJB> lineitems=new ArrayList<LineitemJB>();
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<LineitemJB> getLineitems() {
		return lineitems;
	}
	public void setLineitems(ArrayList<LineitemJB> lineitems) {
		this.lineitems = lineitems;
	}

}
