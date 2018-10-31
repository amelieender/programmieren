import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Diese Klasse stellt einen Baum zur Verfuegung. 
 * 
 * Baeume sind ein Hindernis fuer Kara. Kara kann Baeume weder ueberqueren, noch
 * wegschieben.
 *
 * @author Marco Jakob
 * @version 20.01.2011
 */
public class Tree extends Actor
{

    // Ein Baum hat kein Verhalten, er steht nur herum

    /**
     * Diese Methode wird aufgerufen, sobald ein Baum-Objekt auf der Welt platziert wurde.
     * Es wird ueberprueft, ob der Baum auf dieses Feld gesetzt werden darf. Falls nicht, wird eine 
     * Fehlermeldung ausgegeben.
     */
    protected void addedToWorld(World world)
    {
        if (getOneObjectAtOffset(0, 0, Kara.class) != null) 
        {
            System.out.println("Achtung: Es sollte kein Baum auf Kara gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Mushroom.class) != null) 
        {
            System.out.println("Achtung: Es sollte kein Baum auf einen Pilz gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Tree.class) != null) 
        {
            System.out.println("Achtung: Es sollten nicht zwei Baeume auf ein Feld gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Leaf.class) != null) 
        {
            System.out.println("Achtung: Es sollte kein Baum auf ein Blatt gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
    }
}
