package garyapps.fyte.Models.CalendarData;

import org.json.JSONObject;

import java.io.Serializable;

import garyapps.fyte.Utilities.DateHelper;
import garyapps.fyte.Utilities.Shared;

public class Day implements Serializable {
    private float count;
    private int day;
    private String shortName;
    private String longName;

    public Day(int day, float count){
        this.day = day;
        this.count = count;
        this.shortName = DateHelper.parseShortDayName(day);
        this.longName = DateHelper.parseLongDayName(day);
    }

    public Day(int day, JSONObject obj){
        loadJSONObj(day, obj);
    }

    private void loadJSONObj(int day,JSONObject obj){
        try{
            this.count = (float) obj.getDouble("count");
            this.day = day;
            this.longName = DateHelper.parseLongDayName(day);
            this.shortName = DateHelper.parseShortDayName(day);
        }catch(Exception e){
            e.printStackTrace();
            Shared.logError("FyteCalendarData", e.getStackTrace());
        }
    }

    public String getShortName() { return this.shortName; }
    public String getLongName() { return this.longName; }
    public float getCount() { return this.count; }
    public int getIntValue() { return this.day; }
}
