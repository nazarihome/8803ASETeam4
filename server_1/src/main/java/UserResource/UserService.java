package UserResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



public class UserService {
	public boolean login(User tmpuser){
		///should ask backend about user, now just sends true
		Client client=ClientBuilder.newClient();
		//Response response=client.target("http://playlist-backend2.appspot.com/_ah/api/users/v1/login?name="+tmpuser.Username+
		//		"&password="+tmpuser.Password).request().get();
		Message response=client.target("http://playlist-backend2.appspot.com/_ah/api/users/v1/login?email="+tmpuser.email+
						"&password="+tmpuser.password).request(MediaType.APPLICATION_JSON).get(Message.class);
		//if(response.readEntity(Message.class)()==Status.FOUND)
		
		if (response.message.contains("200"))
			return true;
		else 
			return false;
		
		
	}
	public boolean signup(User tmpuser){
		///should ask backend to add user, now just sends back input
		bkUser bktmpUserWrapper=new bkUser(tmpuser);
		Client client=ClientBuilder.newClient();
		//SSystem.out.println(bktmpUserWrapper.email);
		Response response=client.target("http://playlist-backend2.appspot.com/_ah/api/users/v1/register")
				.request().post(Entity.json(bktmpUserWrapper));
		
		
		if(response.readEntity(Message.class).message.contains("200"))
			return true;
		else 
			return false;		
	}
	
	public boolean deleteaccount(String email){
		Client client=ClientBuilder.newClient();
		Message response=client.target("http://playlist-backend2.appspot.com/_ah/api/users/v1/delete?email="+email)
				.request(MediaType.APPLICATION_JSON).delete(Message.class);
		
		if (response.message.contains("200"))
			return true;
		else 
			return false;
		
		
	}
	
	public String getinfo(String email){
		return "";
		/*
		///should ask backend to add user, now just sends back input
		bkUser bktmpUserWrapper=new bkUser();
		Client client=ClientBuilder.newClient();
		System.out.println(email);
		
		bkUser response=client.target("http://playlist-backend2.appspot.com/_ah/api/users/v1/getInfo?email="+email)
				.request(MediaType.APPLICATION_JSON).get(bkUser.class);
		
		
		if(bktmpUserWrapper.hasuser==true)
			return bktmpUserWrapper.firstname;
		else 
			return "";	
			*/	
	}
	
}
