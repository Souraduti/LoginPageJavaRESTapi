package resource;

import api.LoginQuery;
import org.json.JSONObject;
import resource.template.ApiResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1.0")
public class MyResource {
    @Path("trypost")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse fun(String str){
        ApiResponse response = null;
        try {
            JSONObject js = new JSONObject(str);
            response =  LoginQuery.CheckAgainstDB(js);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  response;
    }
}
