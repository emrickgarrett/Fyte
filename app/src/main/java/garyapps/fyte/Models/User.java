package garyapps.fyte.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;

/**
 * Created by Garrett on 12/14/2017.
 */

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("gyms")
    private List<Gym> gyms;
    @SerializedName("fightStyles")
    private List<FightStyle> fightingStyles;

    //MARK Constructors
    public User(int id, String firstName, String lastName, String email, List<Gym> gyms, List<FightStyle> fightingStyles){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gyms = gyms;
        this.fightingStyles = fightingStyles;
    }

    public User(String firstName, String lastName, String email, List<Gym> gyms, List<FightStyle> fightingStyles){
        this(-1, firstName, lastName, email, gyms, fightingStyles);
    }

    public User(int id, String firstName, String lastName, String email){
        this(firstName, lastName, email, null, null);
    }

    public User(int id, String firstName, String lastName){
        this(firstName, lastName, "");
    }

    public User(String firstName, String lastName, String email){
        this(-1, firstName, lastName, email);
    }

    public User(String firstName, String lastName){
        this(-1, firstName, lastName);
    }

    //METHODS

}
