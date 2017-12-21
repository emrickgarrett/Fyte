package garyapps.fyte.Services.WebServices.FyteApi;

import org.json.JSONArray;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.UserData.TrackerData;
import garyapps.fyte.Models.UserData.User;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;

/**
 * Created by Garrett on 12/14/2017.
 */
public interface IFyteAPI {

    public Result<Boolean> createUser(User user);
    public Result<List<User>> getGymMembers(int id);
    public Result<User> getUser(String username);
    public Result<User> getUser(int id);
    public Result<Gym> getGym(int id);
    public Result<List<FightStyle>> getFightingStyles();
    public Result<User> loginUser(String username, String password);
    public Result<TrackerData> fetchUserTrackerData(int id);
    public Result<TrackerData> fetchUserDisciplineTrackerData(int userId, int disciplineId);
}
