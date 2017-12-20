package garyapps.fyte.Models.Cells;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/19/17.
 */

public abstract class FyteCell {
    protected View view;
    protected boolean animating = false;

    public View getView(){
        return view;
    }

    public abstract FyteRowModel getModel();
    public abstract void onClick(final FyteTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id);


    protected Animation slideOutRightAnimation(){
        return AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_slide_out_right);
    }

    protected Animation slideInRighttAnimation(){
        return AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_slide_in_right);
    }

    protected Animation slideOutLeftAnimation(){
        return AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_slide_out_left);
    }

    protected Animation slideInLeftAnimation(){
        return AnimationUtils.loadAnimation(view.getContext(), R.anim.anim_slide_in_left);
    }
}
