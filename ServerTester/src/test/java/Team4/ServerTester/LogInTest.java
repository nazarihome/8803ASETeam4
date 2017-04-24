
package Team4.ServerTester;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import junit.framework.TestCase;

public class LogInTest extends TestCase {
	@BeforeClass
	  public void setBaseUri () {

	   // RestAssured.baseURI = "http://104.196.62.142";//:8080/server_1/webapi/users/login?email=rq@gatech.edu&password=1111";
	    
       /// RestAssured.port = Integer.valueOf(8080);
       //	System.out.println("Test Started...\n");
       

    }



	@Test
	  public void testLogInMessage () {
		//Reading test server address from file
		BufferedReader tbr = null;
		FileReader tfr = null;
		try {

			tfr = new FileReader("config.txt");
			tbr = new BufferedReader(tfr);
			RestAssured.baseURI =tbr.readLine();
			RestAssured.port =Long.valueOf(tbr.readLine()).intValue();
			
		}catch (IOException e) {

			e.printStackTrace();

		}
		
		//RestAssured.baseURI = "http://104.196.62.142";//:8080/server_1/webapi/users/login?email=rq@gatech.edu&password=1111";
		    
	   //RestAssured.port = Integer.valueOf(8080);
	     
		
		//Reading tests from login file
	    BufferedReader br = null;
		FileReader fr = null;
		try {

			fr = new FileReader("login.txt");
			br = new BufferedReader(fr);
			
			
		}catch (IOException e) {

			e.printStackTrace();

		}
		try{
			String line;
			long count=1;
			long passed_count=1;
			System.out.println( "Test started for Login API...");  
			while((line = br.readLine()) != null) {
				 
				//System.out.println( line);
				String username,password,status,teststatus;
				String[] part=line.split(" ");
				username=part[0]; 
				password=part[1]; 
				status=part[2];
				//Making parameter string and send them to server to recieve responce
				Response res  =given ().param ("email", username)
					    .param ("password", password)
					    .when()
					    .get ("/server_1/webapi/users/login")
					    .then().extract().
					    response();
					    
				
				
				//checking server response 
				long Token=Long.valueOf(res.getBody().asString());
				if (Token==0)
					teststatus="fail";
				else
					teststatus="success";
				
			
				//checking if test failed
				if(teststatus.equals(status)){
					System.out.println("Test"+Long.toString(count)+" passed!");
					passed_count++;
				}
				else
					System.out.println("Test"+Long.toString(count)+" did not passed!");
				
				count++;
			}
			//test fails if any test case fails
			if(count!=passed_count)
				System.exit(1);
			assertEquals(count,passed_count);
		}catch (IOException e) {

			e.printStackTrace();

		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
