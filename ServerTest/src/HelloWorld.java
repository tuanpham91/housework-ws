
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    public static int i = 0;

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        System.out.print("GET is called\n");
        // Return some cliched textual content
        return "Hello World " + new Date();
    }

    @Path("hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String foo() {
        System.out.print("GET is called\n");
        return "Hi , the date is " + new Date();
    }

    @Path("up")
    @POST
    @Produces("text/plain")
    public static String bar() throws JSONException {
        i++;
        JSONObject test = new JSONObject();
        test.put("name","phamtuanrk1991");
        test.put("password","tuan123");
        test.put("realname" , "Anh Tuan Pham");
        SqlProcessor.addUser(test);
        System.out.print("POST is called\n");
        return "Hi , current stand is " + i;
    }



    @Path("password/{userid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserPassword(@PathParam("userid") int id){
        User us = SqlProcessor.getUser(id);
        return "Tuan " + us.getPassword();
    }

    @Path("realname/{userid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserRealName(@PathParam("userid") int id){
        User us = SqlProcessor.getUser(id);
        return "Tuan " + us.getId() + " " + us.getRealName();
    }

    @Path("name/{userid}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUsername(@PathParam("userid") int id){
        User us = SqlProcessor.getUser(id);
        return "Tuan " + us.getId() + " " + us.getRealName();
    }

    @Path("get/{userid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userid") int id){
        User user = SqlProcessor.getUser(id);
        return user;
    }


    @Path("up")
    @GET
    @Produces("text/plain")
    public String barsss() {
        System.out.print("GET is called\n");
        return "Hi , current stand is " + i;
    }


    @Path("add/{userid}-{points}-{jobId}")
    @POST
    @Produces("text/plain")
    public String updatePoints(@PathParam("userid") int uID, @PathParam("points") int points, @PathParam("jobId") int jobId)
    {
        SqlProcessor.plusPoint(uID,points, jobId);
        return "ok";
    }



}