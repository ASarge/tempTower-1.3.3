import greenfoot.*;

/**
 * Write a description of class mouseTrack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mouseTrack extends Actor
{
    /**
     * Act - do whatever the mouseTrack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    MouseInfo mi;
    myWorld world;
    boolean mouseSearch;
    
    public mouseTrack(MouseInfo m) {
        mi = m;
        world = (myWorld)getWorld();
    }
    
    public boolean checkCursor () { //fix this
        if (this.isTouching(Waypoint.class)) {
            mouseSearch = true;
        }
        else mouseSearch = false;
        return mouseSearch;
    }
    
    public void towerMenu() {
        if (isTouching(TowerHolder.class)) {
            world.pause = true;
        }
    }
    
    public void act() 
    {
        setLocation(mi.getX(), mi.getY());
    }    
}
