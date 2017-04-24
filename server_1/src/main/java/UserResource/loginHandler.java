package UserResource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.SSLEngineResult.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/users")
public class loginHandler {
Map<String, Integer> TokenMap=new HashMap<String, Integer>();
UserService loginreqhandler=new UserService();
	

	@GET
	@Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public long loginHadler(@QueryParam("email") String email, @QueryParam("password") String password) {
		
	
		
    	User reqUser=new User();
    	reqUser.email=email;
    	reqUser.password=password;
		if (loginreqhandler.login(reqUser)){ 
    		Random rand = new Random(); 
    		int T =rand.nextInt(5000000)+1; 
    		
    		
    		if (TokenMap.containsKey(reqUser.email)){
    			return TokenMap.get(reqUser.email);
    		}
    		TokenMap.put(reqUser.email,T);
    		
    		
    		return T;
    	}
		return 0;
    }
    
    @GET
    @Path("/{userEmail}")
    @Produces(MediaType.TEXT_PLAIN)
    public String handleemil(@PathParam("userEmail") String userEmail) {
    	return loginreqhandler.getinfo(userEmail);
		
    }    

    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public User test() {
    	User n=new User();
    	n.email="fgfgg";n.password="fdfdf";n.name="fdfs";
    	
        return n;
    }  
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public long signup(User newUser) {
    	
    	
    	 if (loginreqhandler.signup(newUser)){ 
    	
    		Random rand = new Random(); 
    		int T =rand.nextInt(5000000)+1; 
    				
    		TokenMap.put(newUser.name,T);
    		return T;
    	}
		return 0; 
    }
    
    @DELETE
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    public long deleteaccount(@QueryParam("email") String email) {
    	
    if (loginreqhandler.deleteaccount(email))
    	return 1;
    else
    	return 0;
   
    }
    
    ///////////Fake Backend APIs////////////////
    //not used any more
    @GET
	@Path("/bklogin")
    @Produces(MediaType.TEXT_PLAIN)
    public Response backendloginHadler(@QueryParam("email") String email, @QueryParam("password") String password) {
		
    	return Response.status(Response.Status.FOUND)
    			.entity("empty").build();
    	
    }
    
    @POST
    @Path("/bk")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message bksignup(bkUser newUser) {
    	Message m=new Message();
    	m.message="200";
    	return m;
    }
}
