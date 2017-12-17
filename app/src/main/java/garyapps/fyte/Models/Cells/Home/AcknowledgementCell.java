package garyapps.fyte.Models.Cells.Home;

import android.view.View;
import android.widget.AdapterView;

import garyapps.fyte.Models.HomeTableRowModel;

/**
 * Created by garrettemrick on 12/17/17.
 */

public class AcknowledgementCell extends HomeInfoCell {

    public AcknowledgementCell(View v, HomeTableRowModel model){
        super(v);

        createDefaultAcknowledgement();
    }

    private void createDefaultAcknowledgement(){
        this.cellTitle.setText("Default Acknowledgement");
        this.cellDesc.setText("This will be a simple acknowledgement that the user clicks to remove");
    }

    @Override
    public void onClick(AdapterView<?> parent, View view, int position, long id) {
        parent.removeViewInLayout(view);
    }
}
