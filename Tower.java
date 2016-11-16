import greenfoot.*;

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tower extends Actor
{
    /**
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Aimer aim;
    myWorld world;
    MouseInfo mi;
    public int damage;
    public int firingRate;
    public int xLoc;
    public int yLoc;
    int fX, fY;
        
    public Tower()
    {
        damage = 10;
        firingRate = 10;
        aim = new Aimer(5, this);
        world = (myWorld)getWorld();
    }
    
    public Tower(int x, int y) 
    {
        fX = x;
        fY = y;
        damage = 10;
        firingRate = 10;
        aim = new Aimer(5, this);
        world = (myWorld)getWorld();
    }
    
    public void setHome() {
        xLoc = fX * 13;
        yLoc = fY * 11;
    }
    
    public void act() 
    {
         if(areaCheck()) getWorld().removeObject(this); //checks if the tower is touching a waypoint and removes it
    }    
    
    public boolean areaCheck() {
        if (this.isTouching(Waypoint.class) || this.isTouching(Enemy.class))return true;
        return false;
    }
    
    public void fire() {
        world.addObject(new Bullet(), this.getX(), this.getY());
    }
}
