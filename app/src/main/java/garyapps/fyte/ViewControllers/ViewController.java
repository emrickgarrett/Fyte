package garyapps.fyte.ViewControllers;

import android.app.Activity;
import android.view.View;

/**
 * Created by Garrett on 12/15/2017.
 */

public abstract class ViewController {

    protected View view;
    Activity context;

    public ViewController(Activity context){
        this.context = context;

        inflateView();
    }

    abstract void inflateView();


    public View getView(){
        return this.view;
    }
}
