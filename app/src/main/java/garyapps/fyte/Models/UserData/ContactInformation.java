package garyapps.fyte.Models.UserData;

import com.google.gson.annotations.SerializedName;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class ContactInformation {

    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("email")
    private String email;

    public ContactInformation(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
