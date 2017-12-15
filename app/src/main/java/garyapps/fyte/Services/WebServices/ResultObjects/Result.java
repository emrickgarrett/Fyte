package garyapps.fyte.Services.WebServices.ResultObjects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Garrett on 12/15/2017.
 */

public class Result<T> {

    @SerializedName("message")
    private String message;
    @SerializedName("error")
    private boolean hasError;
    @SerializedName("payload")
    private T payload;

    public Result(String message, boolean hasError, T payload){
        this.message = message;
        this.hasError = hasError;
        this.payload = payload;
    }

    public String getMessage(){ return message;}
    public boolean getError(){ return hasError; }
    public T getResultObject() { return payload; }
}
