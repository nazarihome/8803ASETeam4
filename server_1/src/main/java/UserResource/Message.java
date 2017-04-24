package UserResource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	 public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	String message;
}
