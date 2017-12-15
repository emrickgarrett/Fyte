package garyapps.fyte.Mocks;

import java.util.ArrayList;
import java.util.List;

import garyapps.fyte.Models.FightMove;
import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.User;

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
        return new User("Garrett", "Emrick","emrickgj@miamioh.edu", getGyms(), getFightingStyles());
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
}
