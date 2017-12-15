package garyapps.fyte.Services.WebServices.FyteApi;

import android.util.Log;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Garrett on 12/14/2017.
 */


public class FyteAPI implements IFyteAPI{

    public static final String BASE_URL = "http://examplehost.com/apiv1";
    private static final String TAG = "FyteAPI";
    private static FyteAPIEndpointInterface sharedAPI = createAPI();

    private static FyteAPIEndpointInterface createAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(FyteAPIEndpointInterface.class);
    }

    @Override
    public void createUser(User user){
        Call<User> call = sharedAPI.createUser(user);
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response){
                int statusCode = response.code();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t){
                //error
                LogFyteFailure(t);
            }
        });
    }

    @Override
    public List<User> getGymMembers(int id){
        Call<List<User>> call = sharedAPI.getGymMembers(id, "az");
        call.enqueue(new Callback<List<User>>(){
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response){
                int statusCode = response.code();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t){
                LogFyteFailure(t);
            }
        });

        return null;
    }

    @Override
    public User getUser(String username){
        Call<User> call = sharedAPI.getUser(username);
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response){
                int statusCode = response.code();
                //do work with body
            }

            @Override
            public void onFailure(Call<User> call, Throwable t){
                LogFyteFailure(t);
            }
        });
        return null;
    }

    @Override
    public User getUser(int id){
        Call<User> call = sharedAPI.getUser(id);
        call.enqueue(new Callback<User>(){
            @Override
            public void onResponse(Call<User> call, Response<User> response){
                int statusCode = response.code();
                //do work with body
            }

            @Override
            public void onFailure(Call<User> call, Throwable t){
                LogFyteFailure(t);
            }
        });
        return null;
    }

    @Override
    public Gym getGym(int id){
        Call<Gym> call = sharedAPI.getGym(id);
        call.enqueue(new Callback<Gym>(){
            @Override
            public void onResponse(Call<Gym> call, Response<Gym> response){
                int statusCode = response.code();
            }

            @Override
            public void onFailure(Call<Gym> call, Throwable t){
                LogFyteFailure(t);
            }
        });
        return null;
    }

    @Override
    public List<FightStyle> getFightingStyles(){
        Call<List<FightStyle>> call = sharedAPI.getFightingStyles();
        call.enqueue(new Callback<List<FightStyle>>(){
           @Override
            public void onResponse(Call<List<FightStyle>> call, Response<List<FightStyle>> response){
               int statusCode = response.code();
           }

           @Override
            public void onFailure(Call<List<FightStyle>> call, Throwable t){
                LogFyteFailure(t);
           }
        });
        return null;
    }

    private void LogFyteFailure(String msg, Throwable t){
        Log.e(FyteAPI.TAG, msg, t);
    }

    private void LogFyteFailure(Throwable t){
        LogFyteFailure("Fyte Api Failed", t);
    }
}