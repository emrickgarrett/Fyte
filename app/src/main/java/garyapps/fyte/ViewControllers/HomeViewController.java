package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.view.View;

import garyapps.fyte.R;

/**
 * Created by Garrett on 12/14/2017.
 */

public class HomeViewController extends ViewController {

    public HomeViewController(Activity context){
        super(context);

        //Do Work
    }


    @Override
    void inflateView(){
        this.view = context.getLayoutInflater().inflate(R.layout.home_view, null);
    }


}
