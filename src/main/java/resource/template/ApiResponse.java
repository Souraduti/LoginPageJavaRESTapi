package resource.template;

import org.bson.Document;
import org.json.JSONObject;

public class ApiResponse {
    private int status;
    private Object responseObject;

    public ApiResponse() {}

    public ApiResponse(int status, JSONObject responseObject){
        this.status = status;
        this.responseObject = Document.parse(responseObject.toString());
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Object getResponseObject() {
        return responseObject;
    }
    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}

