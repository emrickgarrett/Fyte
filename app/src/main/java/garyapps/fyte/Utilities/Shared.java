package garyapps.fyte.Utilities;

import android.util.Log;

import garyapps.fyte.Mocks.FyteAPIMock;
import garyapps.fyte.Models.UserData.User;
import garyapps.fyte.Services.WebServices.FyteApi.FyteAPI;
import garyapps.fyte.Services.WebServices.FyteApi.IFyteAPI;

/**
 * Created by Garrett on 12/14/2017.
 */
public class Shared {

    public enum BuildType{
        Release(),
        Dev(),
        Test()
    }

    private Shared(){

    }

    public static void initSharedAttributes(BuildType environment){
        switch(environment){
            case Release:
                Shared.fyteAPI = new FyteAPI();
                Shared.Environment = BuildType.Release;
                break;
            case Dev:
                Shared.fyteAPI = new FyteAPI();
                Shared.Environment = BuildType.Dev;
                break;
            case Test:
                Shared.fyteAPI = new FyteAPIMock();
                Shared.Environment = BuildType.Test;
                break;
        }
    }

    public static void log(String className, Object o){
        Log.v(className, o.toString());
    }

    public static void log(String className, String s){
        Log.v(className, s);
    }

    public static User appUser;
    public static IFyteAPI fyteAPI;
    public static BuildType Environment;
}
