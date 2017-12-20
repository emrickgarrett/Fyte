package garyapps.fyte.Models.Cells;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;

import garyapps.fyte.Adapters.FyteTableRowAdapter;
import garyapps.fyte.Models.FyteProfileRowModel;
import garyapps.fyte.Models.FyteRowModel;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class AcknowledgementCell extends FyteInfoCell {

    public AcknowledgementCell(Activity context, FyteRowModel model){
        super(context, ((FyteProfileRowModel) model));

        createDefaultAcknowledgement();
    }

    private void createDefaultAcknowledgement(){
        this.cellTitle.setText("Default Acknowledgement");
        this.cellDesc.setText("This will be a simple acknowledgement that the user clicks to remove");
        this.cellImage.setImageResource(android.R.drawable.ic_menu_info_details);
        this.cellActionImage.setImageResource(android.R.drawable.btn_star);
    }

}
