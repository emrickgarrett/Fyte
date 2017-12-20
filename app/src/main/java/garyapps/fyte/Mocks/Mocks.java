package garyapps.fyte.Mocks;

import android.util.Log;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import garyapps.fyte.Models.FightMove;
import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.UserData.ContactInformation;
import garyapps.fyte.Models.UserData.TrackerData;
import garyapps.fyte.Models.UserData.TrainingData;
import garyapps.fyte.Models.UserData.User;

/**
 * Created by Garrett on 12/14/2017.
 */

public class Mocks {

    public static List<FightStyle> getFightingStyles(){
        List<FightStyle> list = new ArrayList<FightStyle>();
        list.add(new FightStyle("BJJ", Mocks.getMoves()));

        return list;
    }

    public static User getUser(){
        return new User(new ContactInformation("Garrett", "Emrick","emrickgj@miamioh.edu"),
                getGyms(), getFightingStyles(), new TrainingData(226, 6));
    }

    public static List<User> getMembers(){
        List<User> list = new ArrayList<User>();
        list.add(new User("Garrett", "Emrick", "emrickgj@miamioh.edu"));
        list.add(new User("Karl", "Buechler"));
        list.add(new User("Randy", "Lee"));

        return list;
    }

    public static List<Gym> getGyms(){
        List<Gym> list = new ArrayList<Gym>();
        list.add(new Gym("Cies MMA", new User("Mike", "Cies"), getMembers()));

        return list;
    }

    public static Gym getGym(){
        return getGyms().get(0);
    }

    public static List<FightMove> getMoves(){
        List<FightMove> list = new ArrayList<FightMove>();
        list.add(new FightMove("Triangle From Guard", 30, ""));
        list.add(new FightMove("Arm Triangle From Mount"));
        list.add(new FightMove("Armbar from Guard"));

        return list;
    }

    public static FightMove getAMove(){
        return Mocks.getMoves().get(0);
    }

    //Not accurate, just assumes each month has 28 days (4 weeks) and populates it.
    public static TrackerData getTrackerData(){
        JSONArray arr = new JSONArray();
        JSONObject year = new JSONObject();
        int yearSessionCount = 0;
        JSONArray monthArr = new JSONArray();
        for(int i = 0; i < 12; i++){
            JSONObject month = new JSONObject();
            int monthSessionCount = 0;
            JSONArray weekArr = new JSONArray();
            for(int j = 0; j < 4; j++){
                JSONObject week = new JSONObject();
                int weekSessionCount = 0;
                JSONArray dayArr = new JSONArray();
                for(int k = 0; k < 7; k++){
                    JSONObject day = new JSONObject();
                    try {
                        int daySessionCount = (int) (Math.random() * 4);
                        weekSessionCount += daySessionCount;
                        day.put("sessionCount", daySessionCount);
                        day.put("id", k);
                    }catch(Exception e){
                        Log.e("Mocks", "Error creating Tracker Data");
                        System.err.print(e);
                    }
                    dayArr.put(day);
                }
                try {
                    monthSessionCount += weekSessionCount;
                    week.put("sessionCount", weekSessionCount);
                    week.put("days", dayArr);
                }catch(Exception e){
                    Log.e("Mocks", "Error creating Tracker Data");
                    System.err.print(e);
                }
                weekArr.put(week);
            }
            try{
                yearSessionCount += monthSessionCount;
                month.put("sessionCount", monthSessionCount);
                month.put("weeks", weekArr);
            }catch(Exception e){
                Log.e("Mocks", "Error creating Tracker Data");
                System.err.print(e);
            }
            monthArr.put(month);
        }
        try{
            year.put("sessionCount", yearSessionCount);
            year.put("year", 2017);
            year.put("months", monthArr);
            arr.put(yearSessionCount); // reuse year since we only do one
            arr.put(year);
        }catch(Exception e){
            Log.e("Mocks", "Error creating Tracker Data");
            System.err.print(e);
        }

        return new TrackerData(arr);
    }
}
