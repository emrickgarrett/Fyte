package garyapps.fyte.Models.CalendarData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

import garyapps.fyte.Utilities.Shared;

public class Year implements Serializable {
    private Month[] months = new Month[12];
    public float count = 0;
    private int year;

    public Year(){

    }

    public Year(Month[] months, float count){
        this.months = months;
        this.count = count;
    }

    public Year(JSONObject obj){
        loadJson(obj);
    }

    private void loadJson(JSONObject obj){
        try{
            this.year = obj.getInt("year");
            this.count = (float) obj.getDouble("count");
            JSONArray arr = obj.getJSONArray("months");
            for(int i = 0; i < arr.length(); i++){
                Month month = new Month(i, arr.getJSONObject(i));
                this.months[i] = month;
            }
        }catch(Exception e){
            e.printStackTrace();
            Shared.logError("FyteCalendarData", e.getStackTrace());
        }
    }

    public Month getMonth(int num){
        return months[num];
    }

    public int getYear(){
        return year;
    }

    public Month getMonth(String month){
        switch(month.toLowerCase()){
            case "jan":
            case "january":
                    return getMonth(0);
            case "feb":
            case "february":
                return getMonth(1);
            case "mar":
            case "march":
                return getMonth(2);
            case "apr":
            case "april":
                return getMonth(3);
            case "may":
                return getMonth(4);
            case "june":
                return getMonth(5);
            case "july":
                return getMonth(6);
            case "aug":
            case "august":
                return getMonth(7);
            case "sep":
            case "september":
                return getMonth(8);
            case "oct":
            case "october":
                return getMonth(9);
            case "nov":
            case "november":
                return getMonth(10);
            case "dec":
            case "december":
                return getMonth(11);
            default:
                return null;

        }
    }
}
