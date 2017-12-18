package garyapps.fyte.Models;

import java.util.List;

import garyapps.fyte.Models.UserData.User;

/**
 * Created by Garrett on 12/14/2017.
 */

public class Gym {

    private String name;
    private User owner;
    private List<User> members;

    public Gym(String name, User owner, List<User> members){
        this.name = name;
        this.owner = owner;
        this.members = members;
    }
}
