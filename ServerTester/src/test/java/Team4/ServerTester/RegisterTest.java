package Team4.ServerTester;

import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import junit.framework.TestCase;
import net.minidev.json.parser.JSONParser;



public class RegisterTest extends TestCase {

	@SuppressWarnings("unchecked")
	@Test
	  public void testRegisterMessage () {
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
	     
	     	BufferedReader br = null;
			FileReader fr = null;
			try {

				fr = new FileReader("register.txt");
				br = new BufferedReader(fr);
				
				
			}catch (IOException e) {

				e.printStackTrace();

			}
			try{
				String line;
				long count=1;
				long passed_count=1;
				System.out.println( "Test started for Register API...");  
				while((line = br.readLine()) != null) {
					 
					//System.out.println( line);
					String status,teststatus;
					String[] part=line.split(" ");
					User tmpuser= new User();
					tmpuser.email=part[0]; 
					tmpuser.password=part[1];
					tmpuser.name=part[2];
					status=part[3];
					Response restmp;
					
					
					
					Response res  =given ().body(tmpuser)
						    .when()
						    .contentType (ContentType.JSON)
						    .post ("/server_1/webapi/users/")
						    .then().extract().
						    response();
						    
					
					//System.out.println(res.getBody().print());
						    //.contentType(ContentType.TEXT_PLAIN)
						   // .extract().response();
					long Token=Long.valueOf(res.getBody().asString());
					if (Token==0)
						teststatus="existed";
					else
						teststatus="notexisted";
					
				
					
					if(teststatus.equals(status)){
						System.out.println("Test"+Long.toString(count)+" passed!");
						passed_count++;
					}
					else
						System.out.println("Test"+Long.toString(count)+" did not passed!");
					
					count++;
					if (status.equals("notexisted"))
						restmp  =given ().param("email",tmpuser.email).when().delete("/server_1/webapi/users/delete")
						.then().extract().response();
				}
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
