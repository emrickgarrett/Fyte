package garyapps.fyte.Models;

import garyapps.fyte.Enums.FyteCellType;

/**
 * Created by garrettemrick on 12/19/17.
 */

public abstract class FyteRowModel {
    public FyteCellType type;

    protected FyteRowModel(FyteCellType type){
        this.type = type;
    }
}
