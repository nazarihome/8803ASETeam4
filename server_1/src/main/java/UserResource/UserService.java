package UserResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jayway.restassured.RestAssured;



public class UserService {
	//handling login requests with backend
	public boolean login(User tmpuser){
		
		//reading backend address from config file
		BufferedReader tbr = null;
		FileReader tfr = null;
		String backend_adr = null;
		try {
			File testFile = new File("");


			tfr = new FileReader("config.txt");
			tbr = new BufferedReader(tfr);
			backend_adr=tbr.readLine();
			
		}catch (IOException e) {
			
			e.printStackTrace();
			//System.out.println(backend_adr);
		}

		///should ask backend about user, 
		Client client=ClientBuilder.newClient();
		
		Message response=client.target(backend_adr+"/api/users/v1/login?email="+tmpuser.email+
						"&password="+tmpuser.password).request(MediaType.APPLICATION_JSON).get(Message.class);
		
		
		if (response.message.contains("200"))
			return true;
		else 
			return false;
		
		
	}
	
	//handling signup requests with backend
	public boolean signup(User tmpuser){
		
		//reading backend address from config file
		BufferedReader tbr = null;
		FileReader tfr = null;
		String backend_adr = null;
		try {
			File testFile = new File("");


			tfr = new FileReader("config.txt");
			tbr = new BufferedReader(tfr);
			backend_adr=tbr.readLine();
			
		}catch (IOException e) {
			
			e.printStackTrace();
			//System.out.println(backend_adr);
		}

		///should ask backend to add user, now just sends back input
		bkUser bktmpUserWrapper=new bkUser(tmpuser);
		Client client=ClientBuilder.newClient();
		//SSystem.out.println(bktmpUserWrapper.email);
		Response response=client.target(backend_adr+"/api/users/v1/register")
				.request().post(Entity.json(bktmpUserWrapper));
		
		
		if(response.readEntity(Message.class).message.contains("200"))
			return true;
		else 
			return false;		
	}
	
	//handling deleting requests with backend
	public boolean deleteaccount(String email){
		//reading backend address from config file
				BufferedReader tbr = null;
				FileReader tfr = null;
				String backend_adr = null;
				try {
					File testFile = new File("");


					tfr = new FileReader("config.txt");
					tbr = new BufferedReader(tfr);
					backend_adr=tbr.readLine();
					
				}catch (IOException e) {
					
					e.printStackTrace();
					//System.out.println(backend_adr);
				}

		Client client=ClientBuilder.newClient();
		Message response=client.target(backend_adr+"/api/users/v1/delete?email="+email)
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
