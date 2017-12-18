package garyapps.fyte.Models.UserData;

import com.google.gson.annotations.SerializedName;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class TrainingData {

    @SerializedName("sessionCounter")
    private int sessionCounter;

    @SerializedName("dayStreak")
    private int dayStreak;

    public TrainingData(int sessionCounter, int dayStreak){
        this.sessionCounter = sessionCounter;
        this.dayStreak = dayStreak;
    }

    public int getSessionCounter() { return sessionCounter; }
    public int getDayStreak() { return dayStreak; }
}

