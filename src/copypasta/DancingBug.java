package copypasta;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
    private int[] moves;
    private int hasMoved = 0;
    private int thisMove = 0;
    private int toMove = 0;
    public DancingBug(int[] m)
    {
        moves = m;
        toMove = moves[hasMoved];
    }

    public void act()
    {
        if(thisMove < toMove) {
            turn();
            thisMove++;
        }
        else {
            if(canMove()) {
                super.act();
            }
            thisMove = 0;
            toMove = moves[(++hasMoved) % moves.length];
        }
    }
}
