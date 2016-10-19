import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * Plan:
     * Spawn at Aimer, and shoot
     */
    
    Aimer aim;
    myWorld world;
    
    public Bullet() {
        GreenfootImage i = getImage();
        i.scale(5,5);
    }
    
    public void act()  // Add your action code here.
    {
        if (world == null) {
          world = (myWorld)getWorld();  
        }
        if (world.pause){return;} //if pause is true; stop this code
        findEnemy();
        move(5);
        if (isAtEdge() || isTouching(Enemy.class)) {
            world.removeObject(this);
        }
    }    
    
    public void findEnemy() {
        if (aim.enemyCheck() != null) {
            turnTowards(aim.enemyCheck()[0], aim.enemyCheck()[1]);
        }
    }
}
