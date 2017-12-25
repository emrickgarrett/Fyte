package garyapps.fyte.Models.UserData;

import com.google.gson.annotations.SerializedName;

import garyapps.fyte.Enums.PreferredUnits;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class TrainingData {

    @SerializedName("sessionCounter")
    private int sessionCounter;

    @SerializedName("dayStreak")
    private int dayStreak;

    @SerializedName("weight")
    private float weight;

    //default to Imperial system
    private PreferredUnits preferredUnit = PreferredUnits.Imperial;



    public TrainingData(int sessionCounter, int dayStreak, int weight){
        this.sessionCounter = sessionCounter;
        this.dayStreak = dayStreak;
        this.weight = weight;
    }

    public int getSessionCounter() { return sessionCounter; }
    public int getDayStreak() { return dayStreak; }
    public float getWeight() { return weight; }
    public String getUnit(){
            if(this.preferredUnit.getValue() == PreferredUnits.Imperial.getValue())
                return "lbs";
            if(this.preferredUnit.getValue() == PreferredUnits.Metric.getValue())
                return "kg";
            return "lbs";
    }
}

