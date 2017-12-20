package garyapps.fyte.Models;


import org.apache.commons.lang.NotImplementedException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import garyapps.fyte.Models.UserData.TrackerData;
import garyapps.fyte.Services.WebServices.FyteApi.IFyteAPI;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;
import garyapps.fyte.Utilities.Shared;

/**
 * Created by garrettemrick on 12/20/17.
 */

public class FyteCalendarData implements Serializable {
    private int sessionCounter;
    private Hashtable<Integer, Year> yearlyData;

    public FyteCalendarData(){
        this.sessionCounter = 0;
        this.yearlyData = new Hashtable<Integer, Year>();
    }

    public FyteCalendarData(int sessionCounter, Hashtable<Integer, Year> yearlyData){
        this.sessionCounter = sessionCounter;
        this.yearlyData = yearlyData;
    }

    public int getTotalSessions(){
        return sessionCounter;
    }

    public int getYearlySessions(int year){
        return yearlyData.get(year).sessionCounter;
    }

    public int getMonthSessionsForYear(int year, int month){
        return yearlyData.get(year).getMonth(month).sessionCounter;
    }

    public int getWeekSessionsForYear(int year, int month, int week){
        return yearlyData.get(year).getMonth(month).getWeek(week).sessionCounter;
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
        return getWeekDataForYear(Calendar.YEAR, Calendar.MONTH, Calendar.WEEK_OF_MONTH).getDays();
    }

    public void fetchData(IFyteAPI api){
        //fetch data from api
        final Result<TrackerData> result = api.fetchUserTrackerData(Shared.appUser.getId());
        loadJson(result.getResultObject().getJson());
    }

    private void loadJson(JSONObject json){
        //Now load the data!

        //Need to load it as if it was an array
            try {
                this.sessionCounter = json.getInt("sessionCount");
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

class Day implements Serializable{
    private int sessionCounter;
    private int day;
    private String shortName;
    private String longName;

    public Day(int day, int sessionCounter){
        this.day = day;
        this.sessionCounter = sessionCounter;
        this.shortName = DateHelper.parseShortDayName(day);
        this.longName = DateHelper.parseLongDayName(day);
    }

    public Day(int day, JSONObject obj){
        loadJSONObj(day, obj);
    }

    private void loadJSONObj(int day,JSONObject obj){
        try{
            this.sessionCounter = obj.getInt("sessionCount");
            this.day = day;
            this.longName = DateHelper.parseLongDayName(day);
            this.shortName = DateHelper.parseShortDayName(day);
        }catch(Exception e){
            e.printStackTrace();
            Shared.logError("FyteCalendarData", e.getStackTrace());
        }
    }
}

class Week implements Serializable{
    private ArrayList<Day> days = new ArrayList<Day>();
    public int sessionCounter;

    public Week(ArrayList<Day> days, int sessionCounter){
        this.days = days;
        this.sessionCounter = sessionCounter;
    }

    public Week(JSONObject obj){
        loadJson(obj);
    }

    private void loadJson(JSONObject obj){
        try{
            this.sessionCounter = obj.getInt("sessionCount");
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

class Month implements Serializable{

    private ArrayList<Week> weeks = new ArrayList<Week>();
    public int sessionCounter;
    public int month;
    public String monthShortName;
    public String monthLongName;

    public Month(int month){
        this(month, 0);
    }

    public Month(int month, int sessionCounter){
        this.month = month;
        this.sessionCounter = sessionCounter;
        this.monthShortName = DateHelper.parseMonthShortNameFromInt(month);
        this.monthLongName = DateHelper.parseMonthLongNameFromInt(month);
    }

    public Month(int month, JSONObject obj){
        loadJson(month, obj);
    }

    private void loadJson(int month, JSONObject obj){
        try{
            this.sessionCounter = obj.getInt("sessionCount");
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

class Year implements Serializable{
    private Month[] months = new Month[12];
    public int sessionCounter = 0;
    private int year;

    public Year(){

    }

    public Year(Month[] months, int sessionCounter){
        this.months = months;
        this.sessionCounter = sessionCounter;
    }

    public Year(JSONObject obj){
        loadJson(obj);
    }

    private void loadJson(JSONObject obj){
        try{
            this.year = obj.getInt("year");
            this.sessionCounter = obj.getInt("sessionCount");
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

class DateHelper{
    static String parseMonthShortNameFromInt(int month){
        switch(month){
            case 0:
                return "Jan";
            case 1:
                return "Feb";
            case 2:
                return "Mar";
            case 3:
                return "Apr";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "Aug";
            case 8:
                return "Sep";
            case 9:
                return "Oct";
            case 10:
                return "Nov";
            case 11:
                return "Dec";
            default:
                return null;
        }
    }

    static String parseMonthLongNameFromInt(int month){
        switch(month){
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return null;
        }
    }

    static String parseShortDayName(int num){
        switch(num){
            case 0:
                return "Sun";
            case 1:
                return "Mon";
            case 2:
                return "Tues";
            case 3:
                return "Wed";
            case 4:
                return "Thur";
            case 5:
                return "Fri";
            case 6:
                return "Sat";
            default:
                return null;
        }
    }

    static String parseLongDayName(int num){
        switch(num){
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return null;
        }
    }
}