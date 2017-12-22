package garyapps.fyte.Enums;

/**
 * Created by garrettemrick on 12/17/17.
 */

public enum FyteCellType {
    Alert(0),
    Acknowledge(1),
    Discipline(2),
    Tracker(3),
    Default(4);

    private final int value;
    private FyteCellType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
