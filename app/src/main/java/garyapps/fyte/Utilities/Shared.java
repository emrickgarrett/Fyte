package garyapps.fyte.Utilities;

import android.annotation.SuppressLint;

import garyapps.fyte.Mocks.FyteAPIMock;
import garyapps.fyte.Models.User;
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
                break;
            case Dev:
                Shared.fyteAPI = new FyteAPI();
                break;
            case Test:
                Shared.fyteAPI = new FyteAPIMock();
                break;
        }
    }

    public static User appUser;
    public static IFyteAPI fyteAPI;
}