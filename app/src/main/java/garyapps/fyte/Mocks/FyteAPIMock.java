package garyapps.fyte.Mocks;

import org.json.JSONArray;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.UserData.TrackerData;
import garyapps.fyte.Models.UserData.User;
import garyapps.fyte.Services.WebServices.FyteApi.IFyteAPI;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;

/**
 * Created by Garrett on 12/14/2017.
 */

public class FyteAPIMock implements IFyteAPI {


    @Override
    public Result<Boolean> createUser(User user) {
        return new Result<Boolean>("",false,true);
    }

    @Override
    public Result<List<User>> getGymMembers(int id) {
        return new Result<List<User>>("",false, Mocks.getMembers());
    }

    @Override
    public Result<User> getUser(String username) {
        return new Result<User>("", false, Mocks.getUser());
    }

    @Override
    public Result<User> getUser(int id) {
        return new Result<User>("", false, Mocks.getUser());
    }

    @Override
    public Result<Gym> getGym(int id) {
        return new Result<Gym>("", false, Mocks.getGym());
    }

    @Override
    public Result<List<FightStyle>> getFightingStyles() {
        return new Result<List<FightStyle>>("", false, Mocks.getFightingStyles());
    }

    @Override
    public Result<User> loginUser(String username, String password) {
        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return new Result<User>("Exception Sleeping", true, null);
        }

        return new Result<User>("", false, Mocks.getUser());
    }

    @Override
    public Result<TrackerData> fetchUserTrackerData(int id){
        return new Result<TrackerData>("", false, Mocks.getTrackerData());
    }

    @Override
    public Result<TrackerData> fetchUserDisciplineTrackerData(int userId, int disciplineId){
        return new Result<TrackerData>("", false, Mocks.getTrackerData());
    }

    @Override
    public Result<TrackerData> fetchUserWeightTrackerData(int id){
        return new Result<TrackerData>("", false, Mocks.getWeightTrackerData());
    }
}
