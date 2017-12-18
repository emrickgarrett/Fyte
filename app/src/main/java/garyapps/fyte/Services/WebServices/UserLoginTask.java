package garyapps.fyte.Services.WebServices;

import android.os.AsyncTask;

import garyapps.fyte.LoginActivity;
import garyapps.fyte.Models.UserData.User;
import garyapps.fyte.Services.WebServices.ResultObjects.Result;
import garyapps.fyte.Utilities.Shared;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

    private final String mEmail;
    private final String mPassword;
    private final LoginActivity mActivity;

    public UserLoginTask(String email, String password, LoginActivity activity) {
        mEmail = email;
        mPassword = password;
        mActivity = activity;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        Result<User> result = Shared.fyteAPI.loginUser(mEmail, mPassword);

        if(!result.getError()) {
            Shared.appUser = result.getResultObject();
            return true;
        }

        return false;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        if (success) {
            mActivity.onLoginSuccess();
        } else {
            mActivity.onLoginFail();
        }
    }

    @Override
    protected void onCancelled() {
        mActivity.onLoginCancel();
    }
}

