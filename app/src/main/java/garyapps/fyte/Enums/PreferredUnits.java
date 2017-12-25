package garyapps.fyte.Enums;

/**
 * Created by garrettemrick on 12/25/17.
 */

public enum PreferredUnits {
    Metric(0),
    Imperial(1);

    private final int value;
    private PreferredUnits(int value) { this.value = value; }

    public int getValue(){ return this.value; }
}

