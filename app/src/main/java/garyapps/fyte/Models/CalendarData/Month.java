package garyapps.fyte.Models.CalendarData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import garyapps.fyte.Utilities.DateHelper;
import garyapps.fyte.Utilities.Shared;

public class Month implements Serializable {

    private ArrayList<Week> weeks = new ArrayList<Week>();
    public int sessionCount;
    public int month;
    public String monthShortName;
    public String monthLongName;

    public Month(int month){
        this(month, 0);
    }

    public Month(int month, int sessionCount){
        this.month = month;
        this.sessionCount = sessionCount;
        this.monthShortName = DateHelper.parseMonthShortNameFromInt(month);
        this.monthLongName = DateHelper.parseMonthLongNameFromInt(month);
    }

    public Month(int month, JSONObject obj){
        loadJson(month, obj);
    }

    private void loadJson(int month, JSONObject obj){
        try{
            this.sessionCount = obj.getInt("sessionCount");
            JSONArray dayArr = obj.getJSONArray("weeks");

            for(int i = 0; i < dayArr.length(); i++){
                Week week = new Week(dayArr.getJSONObject(i));

                this.weeks.add(i, week);
            }
        }catch(Exception e){
            e.printStackTrace();
            Shared.logError("FyteCalendarData", e.getStackTrace());
        }

    }

    public Week getWeek(int week){
        return weeks.get(week);
    }
}
