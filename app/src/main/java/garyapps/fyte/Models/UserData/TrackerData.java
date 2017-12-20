package garyapps.fyte.Models.UserData;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by garrettemrick on 12/20/17.
 */

public class TrackerData {

    @SerializedName("json")
    private JSONObject jsonData;

    public TrackerData(JSONObject json){
        this.jsonData = json;
    }

    public JSONObject getJson(){ return jsonData; }
}
