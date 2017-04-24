//handling messages(200 is success)
//backend did not use http status so they send messages in json format!
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
