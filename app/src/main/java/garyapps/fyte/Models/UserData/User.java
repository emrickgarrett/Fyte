package garyapps.fyte.Models.UserData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;

/**
 * Created by Garrett on 12/14/2017.
 */

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("contactInformation")
    private ContactInformation contactInformation;
    @SerializedName("gyms")
    private List<Gym> gyms;
    @SerializedName("fightStyles")
    private List<FightStyle> fightingStyles;
    @SerializedName("trainingData")
    private TrainingData trainingData;

    public User(int id, ContactInformation contactInformation, List<Gym> gyms, List<FightStyle> fightingStyles, TrainingData trainingData){
        this.contactInformation = contactInformation;
        this.gyms = gyms;
        this.fightingStyles = fightingStyles;
        this.trainingData = trainingData;
    }

    public User(ContactInformation contactInformation, List<Gym> gyms, List<FightStyle> fightingStyles, TrainingData trainingData){
        this.contactInformation = contactInformation;
        this.gyms = gyms;
        this.fightingStyles = fightingStyles;
        this.trainingData = trainingData;
    }

    //MARK Constructors
    public User(int id, ContactInformation contactInformation, List<Gym> gyms, List<FightStyle> fightingStyles){
        this(id, contactInformation, gyms, fightingStyles, null);
    }

    public User(ContactInformation contactInformation, List<Gym> gyms, List<FightStyle> fightingStyles){
        this(-1, contactInformation, gyms, fightingStyles);
    }

    public User(int id, ContactInformation contactInformation){
        this(contactInformation, null, null);
    }

    public User(int id, String firstName, String lastName){
        this(id, new ContactInformation(firstName, lastName, ""));
    }

    public User(ContactInformation contactInformation){
        this(-1, contactInformation);
    }

    public User(String firstName, String lastName){
        this(-1, new ContactInformation(firstName, lastName, ""));
    }

    public User(String firstName, String lastName, String email){
        this(-1, new ContactInformation(firstName, lastName, email));
    }

    //METHODS
    public String getFullName(){
        return contactInformation.getFirstName() + " " + contactInformation.getLastName();
    }

    public String getFightingStylesListAsString(){
        String ret = "";
        for(int i = 0; i < fightingStyles.size(); i++){
            if(i == 0){
                ret += fightingStyles.get(0).getName();
            }else{
                ret += ", " + fightingStyles.get(i).getName();
            }
        }

        return ret;
    }

    public int getSessionCounter(){
        return trainingData.getSessionCounter();
    }

    public int getDayStreak(){
        return trainingData.getDayStreak();
    }

    public int getId(){ return this.id; }

}
