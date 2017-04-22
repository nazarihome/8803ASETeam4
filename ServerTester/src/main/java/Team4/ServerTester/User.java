package Team4.ServerTester;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	String name;
	public String getName() {
		return name;
	}

	public void setName(String Username) {
		name = Username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		password = Password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		email = Email;
	}

	String password;
	String email;
	
	public User(){
		name="";
		password="";
		email="";
	}
	
	
}
