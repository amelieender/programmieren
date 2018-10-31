import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Klasse Kara implementiert Methoden, die Kara ausführen kann
 * @author : Joern Freiheit 
 */
public class MyKara extends Kara
{
    /**
     * Bei Druecken des Knopfes '>Act' wird die Methode act() aufgerufen
     */
    public void act() 
    {
        int i = 0;
        putLeaf();
        while(!onLeaf() || i == 0){
            i = i + 1;
            if (i > 100) break;
            if (treeFront()){
                turnLeft();
                if (!treeFront()){
                    move();
                }
            }
            if (!treeRight()){
                turnRight();
                if (!treeFront()){
                    move();
                }
            }
            else {
                if (!treeFront()){
                    move();
                }
            }
        }
    }
}
