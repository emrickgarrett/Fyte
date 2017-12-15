package garyapps.fyte.Services.WebServices.FyteApi;

import android.util.Log;

import java.util.List;

import garyapps.fyte.Models.FightStyles.FightStyle;
import garyapps.fyte.Models.Gym;
import garyapps.fyte.Models.User;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;
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
    public Result<Boolean> createUser(User user){
        Call<Result<User>> call = sharedAPI.createUser(user);
        call.enqueue(new Callback<Result<User>>(){
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response){
                int statusCode = response.code();

            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t){
                //error
                LogFyteFailure(t);
            }
        });

        return new Result<Boolean>("",false,true);
    }

    @Override
    public Result<List<User>> getGymMembers(int id){
        Call<Result<List<User>>> call = sharedAPI.getGymMembers(id, "az");
        call.enqueue(new Callback<Result<List<User>>>(){
            @Override
            public void onResponse(Call<Result<List<User>>> call, Response<Result<List<User>>> response){
                int statusCode = response.code();
            }

            @Override
            public void onFailure(Call<Result<List<User>>> call, Throwable t){
                LogFyteFailure(t);
            }
        });

        return null;
    }

    @Override
    public Result<User> getUser(String username){
        Call<Result<User>> call = sharedAPI.getUser(username);
        call.enqueue(new Callback<Result<User>>(){
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response){
                int statusCode = response.code();
                //do work with body
            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t){
                LogFyteFailure(t);
            }
        });
        return null;
    }

    @Override
    public Result<User> getUser(int id){
        Call<Result<User>> call = sharedAPI.getUser(id);
        call.enqueue(new Callback<Result<User>>(){
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response){
                int statusCode = response.code();
                //do work with body
            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t){
                LogFyteFailure(t);
            }
        });
        return null;
    }

    @Override
    public Result<Gym> getGym(int id){
        Call<Result<Gym>> call = sharedAPI.getGym(id);
        call.enqueue(new Callback<Result<Gym>>(){
            @Override
            public void onResponse(Call<Result<Gym>> call, Response<Result<Gym>> response){
                int statusCode = response.code();
            }

            @Override
            public void onFailure(Call<Result<Gym>> call, Throwable t){
                LogFyteFailure(t);
            }
        });
        return null;
    }

    @Override
    public Result<List<FightStyle>> getFightingStyles(){
        Call<Result<List<FightStyle>>> call = sharedAPI.getFightingStyles();
        call.enqueue(new Callback<Result<List<FightStyle>>>(){
           @Override
            public void onResponse(Call<Result<List<FightStyle>>> call, Response<Result<List<FightStyle>>> response){
               int statusCode = response.code();
           }

           @Override
            public void onFailure(Call<Result<List<FightStyle>>> call, Throwable t){
                LogFyteFailure(t);
           }
        });
        return null;
    }

    @Override
    public Result<User> loginUser(String username, String password){
        Call<Result<User>> call = sharedAPI.login(username, password);
        call.enqueue(new Callback<Result<User>>(){
            @Override
            public void onResponse(Call<Result<User>> call, Response<Result<User>> response){
                //dowork
            }

            @Override
            public void onFailure(Call<Result<User>> call, Throwable t){

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