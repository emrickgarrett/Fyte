package garyapps.fyte.Models.CalendarData;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import garyapps.fyte.Models.UserData.TrackerData;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;
import garyapps.fyte.Utilities.DateHelper;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/20/17.
 */

public class FyteCalendarData implements Serializable {
    private int sessionCount;
    private Hashtable<Integer, Year> yearlyData;

    public FyteCalendarData(){
        this.sessionCount = 0;
        this.yearlyData = new Hashtable<Integer, Year>();
    }

    public FyteCalendarData(int sessionCount, Hashtable<Integer, Year> yearlyData){
        this.sessionCount = sessionCount;
        this.yearlyData = yearlyData;
    }

    public int getTotalSessions(){
        return sessionCount;
    }

    public int getYearlySessions(int year){
        return yearlyData.get(year).sessionCount;
    }

    public int getMonthSessionsForYear(int year, int month){
        return yearlyData.get(year).getMonth(month).sessionCount;
    }

    public int getWeekSessionsForYear(int year, int month, int week){
        return yearlyData.get(year).getMonth(month).getWeek(week).sessionCount;
    }

    public Year getYearData(int year){
        return yearlyData.get(year);
    }

    public Month getMonthDataForYear(int year, int month){
        return yearlyData.get(year).getMonth(month);
    }

    public Week getWeekDataForYear(int year, int month, int week){
        return yearlyData.get(year).getMonth(month).getWeek(week);
    }

    public ArrayList<Day> getCurrentWeek(){
        return getWeekDataForYear(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH)-1,
                Calendar.getInstance().get(Calendar.WEEK_OF_MONTH)-1).getDays();
    }

    //TODO implement error handling on these fetch requests, also make them async
    public void fetchData(int userId){
        //fetch data from api
        final Result<TrackerData> result = Shared.fyteAPI.fetchUserTrackerData(userId);
        loadJson(result.getResultObject().getJson());
    }

    public void fetchData(int userId, int disciplineId){
        final Result<TrackerData> result = Shared.fyteAPI.fetchUserDisciplineTrackerData(userId, disciplineId);
        loadJson(result.getResultObject().getJson());
    }

    private void loadJson(JSONObject json){
        //Now load the data!
         try {
            this.sessionCount = json.getInt("sessionCount");
            JSONArray yearArr = json.getJSONArray("years");

            for(int i = 0; i < yearArr.length(); i++){

                Year year = new Year(yearArr.getJSONObject(i));
                yearlyData.put(year.getYear(), year);
            }

        }catch(Exception e){
            e.printStackTrace();
            Shared.logError("FyteCalendarData", e.getStackTrace());
        }
    }

}

