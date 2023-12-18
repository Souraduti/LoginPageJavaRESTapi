package api;

import connectionestablish.Connector;
import org.json.JSONObject;
import resource.template.ApiResponse;

import java.sql.*;

public class LoginQuery {
    public static ApiResponse CheckAgainstDB(JSONObject jsonObject){

        String id = jsonObject.optString("id","notFound");
        String pwd = jsonObject.optString("password","notFound");
        if(id.equals("notFound")||pwd.equals("notFound")){
            return  new ApiResponse(500,new JSONObject());
        }
        int status;
        JSONObject responseObject = new JSONObject();
        try(Connection con = Connector.getConnection()){
            Statement statement = con.createStatement();
            String sql = "select * from userdata where name = '" + id + "' and " + "password = '" + pwd + "'";
            ResultSet rs = statement.executeQuery(sql);
            boolean validate = rs.next();    // if name and password is valid there will be one row thus rs.next() will yeild true
            responseObject.put("found",validate);
            status = 200;
        }catch (Exception e){
            e.printStackTrace();
            status = 500;
            responseObject.put("message",e.getMessage());
        }
        return  new ApiResponse(status,responseObject);
    }
}
