package copypasta;

import info.gridworld.grid.Location;

public class QuickCrab extends CrabCritter {
    public void makeMove(Location l) {
        Location sideLoc = l.getAdjacentLocation(getLocation().getDirectionToward(l));
        if(getGrid().isValid(sideLoc) && getGrid().get(sideLoc) == null) {
            moveTo(sideLoc);
        }
        else {
            super.makeMove(l);
        }
    }
}
