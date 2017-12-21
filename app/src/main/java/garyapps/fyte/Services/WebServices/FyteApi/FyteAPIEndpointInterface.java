package garyapps.fyte.Services.WebServices.FyteApi;

import org.json.JSONArray;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.UserData.TrackerData;
import garyapps.fyte.Models.UserData.User;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Garrett on 12/14/2017.
 */


public interface FyteAPIEndpointInterface {

    @GET("users/{username}")
    Call<Result<User>> getUser(@Path("username") String username);

    @GET("users/{id}")
    Call<Result<User>> getUser(@Path("id") int id);

    @GET("gym/{id}")
    Call<Result<Gym>> getGym(@Path("id") int id);

    @GET("gym/{id}/members")
    Call<Result<List<User>>> getGymMembers(@Path("id") int gymId, @Query("sort") String sort);

    @GET("fightstyles")
    Call<Result<List<FightStyle>>> getFightingStyles();

    @GET("users/{id}")
    Call<Result<TrackerData>> fetchUserTrackerData(@Path("id") int id);

    @GET("users/disciplinetracker")
    Call<Result<TrackerData>> fetchUserDisciplineTrackerData(@Query("id") int id, @Query("disciplineId") int disciplineId);

    @POST("users/new")
    Call<Result<User>> createUser(@Body User user);

    @FormUrlEncoded
    @POST("login")
    Call<Result<User>> login(@Field("username") String name, @Field("password") String password);
}