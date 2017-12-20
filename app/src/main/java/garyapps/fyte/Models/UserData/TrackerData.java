package garyapps.fyte.Models.UserData;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

/**
 * Created by garrettemrick on 12/20/17.
 */

public class TrackerData {

    @SerializedName("json")
    private JSONArray jsonData;

    public TrackerData(JSONArray json){
        this.jsonData = json;
    }

    public JSONArray getJson(){ return jsonData; }
}
