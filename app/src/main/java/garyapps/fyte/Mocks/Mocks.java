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
        list.add(new FightStyle("Wrestling", Mocks.getMoves()));

        return list;
    }

    public static User getUser(){
        return new User(new ContactInformation("Garrett", "Emrick","emrickgj@miamioh.edu"),
                getGyms(), getFightingStyles(), new TrainingData(226, 6, 185));
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
        JSONObject obj = new JSONObject();
        JSONArray yearArr = new JSONArray();
        JSONObject year = new JSONObject();
        int yearCount = 0;
        JSONArray monthArr = new JSONArray();
        for(int i = 0; i < 12; i++){
            JSONObject month = new JSONObject();
            int monthCount
                    = 0;
            JSONArray weekArr = new JSONArray();
            for(int j = 0; j < 5; j++){
                JSONObject week = new JSONObject();
                int weekCount = 0;
                JSONArray dayArr = new JSONArray();
                for(int k = 0; k < 7; k++){
                    JSONObject day = new JSONObject();
                    try {
                        int dayCount = (int) (Math.random() * 4);
                        weekCount += dayCount;
                        day.put("count", dayCount);
                        day.put("id", k);
                    }catch(Exception e){
                        Log.e("Mocks", "Error creating Tracker Data");
                        System.err.print(e);
                    }
                    dayArr.put(day);
                }
                try {
                    monthCount
                            += weekCount;
                    week.put("count", weekCount);
                    week.put("days", dayArr);
                }catch(Exception e){
                    Log.e("Mocks", "Error creating Tracker Data");
                    System.err.print(e);
                }
                weekArr.put(week);
            }
            try{
                yearCount += monthCount
                ;
                month.put("count", monthCount
                );
                month.put("weeks", weekArr);
            }catch(Exception e){
                Log.e("Mocks", "Error creating Tracker Data");
                System.err.print(e);
            }
            monthArr.put(month);
        }
        try{
            year.put("count", yearCount);
            year.put("year", 2017);
            year.put("months", monthArr);
            yearArr.put(year);
            obj.put("count", yearCount); // reuse year since we only do one
            obj.put("years", yearArr);
        }catch(Exception e){
            Log.e("Mocks", "Error creating Tracker Data");
            System.err.print(e);
        }

        return new TrackerData(obj);
    }

    public static TrackerData getWeightTrackerData(){
        JSONObject obj = new JSONObject();
        JSONArray yearArr = new JSONArray();
        JSONObject year = new JSONObject();
        float yearCount = 0;
        JSONArray monthArr = new JSONArray();
        for(int i = 0; i < 12; i++){
            JSONObject month = new JSONObject();
            float monthCount
                    = 0;
            JSONArray weekArr = new JSONArray();
            for(int j = 0; j < 5; j++){
                JSONObject week = new JSONObject();
                float weekCount = 0;
                JSONArray dayArr = new JSONArray();
                for(int k = 0; k < 7; k++){
                    JSONObject day = new JSONObject();
                    try {
                        float limit = 0.6f;
                        float dayCount = (float) (Math.random() * limit) -limit/2;
                        weekCount += dayCount;
                        day.put("count", dayCount);
                        day.put("id", k);
                    }catch(Exception e){
                        Log.e("Mocks", "Error creating Tracker Data");
                        System.err.print(e);
                    }
                    dayArr.put(day);
                }
                try {
                    monthCount
                            += weekCount;
                    week.put("count", weekCount);
                    week.put("days", dayArr);
                }catch(Exception e){
                    Log.e("Mocks", "Error creating Tracker Data");
                    System.err.print(e);
                }
                weekArr.put(week);
            }
            try{
                yearCount += monthCount
                ;
                month.put("count", monthCount
                );
                month.put("weeks", weekArr);
            }catch(Exception e){
                Log.e("Mocks", "Error creating Tracker Data");
                System.err.print(e);
            }
            monthArr.put(month);
        }
        try{
            year.put("count", yearCount);
            year.put("year", 2017);
            year.put("months", monthArr);
            yearArr.put(year);
            obj.put("count", yearCount); // reuse year since we only do one
            obj.put("years", yearArr);
        }catch(Exception e){
            Log.e("Mocks", "Error creating Weight Tracker Data");
            System.err.print(e);
        }


        return new TrackerData(obj);

    }
}
