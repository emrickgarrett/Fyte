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
    private int count;
    private Hashtable<Integer, Year> yearlyData;

    public FyteCalendarData(){
        this.count = 0;
        this.yearlyData = new Hashtable<Integer, Year>();
    }

    public FyteCalendarData(int count, Hashtable<Integer, Year> yearlyData){
        this.count = count;
        this.yearlyData = yearlyData;
    }

    public int getTotalSessions(){
        return count;
    }

    public float getYearlySessions(int year){
        return yearlyData.get(year).count;
    }

    public float getMonthSessionsForYear(int year, int month){
        return yearlyData.get(year).getMonth(month).count;
    }

    public float getWeekSessionsForYear(int year, int month, int week){
        return yearlyData.get(year).getMonth(month).getWeek(week).count;
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

    public void fetchWeightData() {
        final Result<TrackerData> result = Shared.fyteAPI.fetchUserWeightTrackerData(Shared.appUser.getId());
        loadJson(result.getResultObject().getJson());
    }

    private void loadJson(JSONObject json){
        //Now load the data!
         try {
            this.count = json.getInt("count");
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

