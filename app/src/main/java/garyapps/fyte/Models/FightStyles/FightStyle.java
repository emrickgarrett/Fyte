package garyapps.fyte.Models.FightStyles;

import java.util.List;

import garyapps.fyte.Models.FightMove;

/**
 * Created by Garrett on 12/14/2017.
 */

public final class FightStyle {

    private String name;
    private List<FightMove> moves;

    public FightStyle(String name, List<FightMove> moves){

    }

    public List<FightMove> getMoves(){
        return moves;
    }

    public void setMoves(){
        this.moves = moves;
    }
}