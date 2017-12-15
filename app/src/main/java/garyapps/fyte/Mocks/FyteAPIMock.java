package garyapps.fyte.Mocks;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.User;
import garyapps.fyte.Services.WebServices.FyteApi.IFyteAPI;

/**
 * Created by Garrett on 12/14/2017.
 */

public class FyteAPIMock implements IFyteAPI {


    @Override
    public void createUser(User user) {

    }

    @Override
    public List<User> getGymMembers(int id) {
        return Mocks.getMembers();
    }

    @Override
    public User getUser(String username) {
        return Mocks.getUser();
    }

    @Override
    public User getUser(int id) {
        return Mocks.getUser();
    }

    @Override
    public Gym getGym(int id) {
        return Mocks.getAGym();
    }

    @Override
    public List<FightStyle> getFightingStyles() {
        return Mocks.getFightingStyles();
    }
}
