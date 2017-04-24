//this class is container for backend user structure

package UserResource;

import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class bkUser {
	public bkUser() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public bkUser(User tmpuser) {
		// TODO Auto-generated constructor stub
		email=tmpuser.email;
		firstname=tmpuser.name;
		password=tmpuser.password;
		Random rand = new Random(); 
		int T =rand.nextInt(5000000)+1;
		username="default"+Integer.toString(T);
		lastname="default";
		//hasuser=false;
	}
	/*
	public boolean isHasuser() {
		return hasuser;
	}
	public void setHasuser(boolean hasuser) {
		this.hasuser = hasuser;
	}
	boolean hasuser;*/
	String	email;
	String  firstname;
	String	lastname;
	String  username;
	String	password;
}
