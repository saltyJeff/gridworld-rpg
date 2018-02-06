package copypasta;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18leejefferso
 */
public class JumperBug extends Bug {
    public boolean adjacentOpen(Location start) {
        Location l = start.getAdjacentLocation(this.getDirection());
        return getGrid().isValid(l) && !(getGrid().get(l) instanceof Flower || getGrid().get(l) instanceof Rock);
    }
    public void act() {
        if(adjacentOpen(getLocation())) {
            move();
            //getGrid().
        }
        else if(adjacentOpen(getLocation().getAdjacentLocation(getDirection()))) {
            moveTo(getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection()));
        }
        else {
            turn();
        }
    }
}
