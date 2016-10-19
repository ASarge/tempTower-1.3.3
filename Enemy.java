import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends AbstEnemy
{
    Waypoint location;
    int lCheck;
    ArrayList <Waypoint> path;
    int speed;
    
    public Enemy(ArrayList <Waypoint> p) { //switch statements here for health later!
        // if (level == 1) { //etc...
            world = (myWorld)getWorld();
            health = 1; //one shot kills
            lCheck = 0; //sets location of enemy
            speed = 1; //move 
            path = p; //sets local reference to whatever is passed in
            location = path.get(lCheck); //sets current location to 0th index
        // }
    }
    
    public boolean checkHit() {
        if (this.isTouching(Bullet.class)) {
            return true;
        }
        else return false;
    }
    
    public void takeDamage() { //must be able to detect what kind of bullet it was hit by
        if (checkHit()) {
            damage = 1;
        }
        else damage = 0;
        health -= damage;
        if (!checkAlive()) { 
            world.removeObject(this);
        }
    }
    
    public boolean checkAlive() {
        if (health <= 0){
            return false;
        }
        else return true;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        if (!isAtEdge()) {
            if(location.x - getX() < speed && location.y - getY() < speed) {
                lCheck++;
                nextStep();
            }
        }
        else {
            getWorld().removeObject(this);
            myWorld.enemies--;
        }
    }    
    
    public void nextStep() {
        if (lCheck < (path.size() - 1)) {
           location = path.get(lCheck);
           turnTowards(location.x, location.y);
        }
    }
}