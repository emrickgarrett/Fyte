package garyapps.fyte.Models.Cells.Home;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import garyapps.fyte.Adapters.HomeViewTableRowAdapter;
import garyapps.fyte.Models.HomeTableRowModel;
import garyapps.fyte.R;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class HomeInfoCell{

    protected ImageView cellImage;
    protected TextView cellTitle;
    protected TextView cellDesc;
    protected ImageView cellActionImage;
    protected View view;
    protected HomeTableRowModel model;

    public HomeInfoCell(View v, HomeTableRowModel model){
        bindViews(v, model);
    }

    public View getView(){ return view; }

    private void bindViews(View v){
        this.view = v;
        cellImage = v.findViewById(R.id.home_info_cell_image);
        cellTitle = v.findViewById(R.id.home_info_cell_title);
        cellDesc = v.findViewById(R.id.home_info_cell_desc);
        cellActionImage = v.findViewById(R.id.home_info_cell_action_image);
    }

    private void bindViews(View v, HomeTableRowModel model) {
        this.bindViews(v);
        this.model = model;

        if (model.imageId != -1) {
            cellImage.setImageDrawable(Drawable.createFromPath(""));
        }
        if (model.title != "") {
            cellTitle.setText(model.title);
        }
        if (model.desc != "") {
            cellDesc.setText(model.desc);
        }
        if(model.actionImageId != -1){
            cellActionImage.setImageDrawable(Drawable.createFromPath(""));
        }
    }

    public void onClick(final HomeViewTableRowAdapter adapter, final AdapterView<?> parent, final View view, final int position, final long id) {
        Animation anim = slideOutRightAnimation();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                adapter.removeCell(position);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        view.startAnimation(anim);
    }

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

    public HomeTableRowModel getModel(){
        return model;
    }
}
