package garyapps.fyte.ViewControllers;

import android.app.Activity;

import garyapps.fyte.R;

/**
 * Created by Garrett on 12/15/2017.
 */

public class UserGymsViewController extends ViewController {

    public UserGymsViewController(Activity context){
        super(context);
    }

    @Override
    void inflateView() {
        view = context.getLayoutInflater().inflate(R.layout.usergyms_view, null);
    }
}
