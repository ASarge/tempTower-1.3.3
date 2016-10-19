import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TowerHolder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerHolder extends Actor
{
    /**
     * Act - do whatever the TowerHolder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /*
     * To do list:
     * make clones of towers to display diff. kinds
     * display this menu
     */
    
    GreenfootImage img;
    Color menuColor;
    myWorld world;
    mouseTrack m;
    int f;
    
    public TowerHolder() {
        f = 50;
        world = (myWorld)getWorld();
        img = new GreenfootImage(f*14, 0);
        img.setColor(java.awt.Color.BLACK);
        img.fillRect(f*14, 0, world.getWidth(), world.getHeight());
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
        
    }    
}
