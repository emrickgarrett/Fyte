package garyapps.fyte.Services.WebServices.FyteApi;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.User;

/**
 * Created by Garrett on 12/14/2017.
 */
public interface IFyteAPI {

    public void createUser(User user);
    public List<User> getGymMembers(int id);
    public User getUser(String username);
    public User getUser(int id);
    public Gym getGym(int id);
    public List<FightStyle> getFightingStyles();
}
