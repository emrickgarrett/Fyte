package garyapps.fyte.Services.WebServices;

import android.os.AsyncTask;

import garyapps.fyte.LoginActivity;
import garyapps.fyte.Mocks.Mocks;
import garyapps.fyte.Utilities.Shared;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world", "example:example"
    };

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
        // TODO: attempt authentication against a network service.

        try {
            // Simulate network access.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(mEmail)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(mPassword);
            }
        }

        // TODO: register the new account here.
        createUserAccount();
        return true;
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


    private void createUserAccount(){
        Shared.appUser = Mocks.getUser();
    }
}

