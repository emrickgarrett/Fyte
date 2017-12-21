package garyapps.fyte.Models.CalendarData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import garyapps.fyte.Utilities.Shared;

public class Week implements Serializable {
    private ArrayList<Day> days = new ArrayList<Day>();
    public int sessionCount;

    public Week(ArrayList<Day> days, int sessionCount){
        this.days = days;
        this.sessionCount = sessionCount;
    }

    public Week(JSONObject obj){
        loadJson(obj);
    }

    private void loadJson(JSONObject obj){
        try{
            this.sessionCount = obj.getInt("sessionCount");
            JSONArray dayArr = obj.getJSONArray("days");

            for(int i = 0; i < dayArr.length(); i++){
                Day day = new Day(i, dayArr.getJSONObject(i));
                this.days.add(i, day);
            }
        }catch(Exception e){
            e.printStackTrace();
            Shared.logError("FyteCalendarData", e.getStackTrace());
        }
    }

    public Day getDay(int day){
        return days.get(day);
    }

    public ArrayList<Day> getDays(){
        return days;
    }
}
