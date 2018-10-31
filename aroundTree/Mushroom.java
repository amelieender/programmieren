import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Diese Klasse stellt einen Pilz zur Verfuegung.
 * 
 * Kara kann Pilze schieben, falls hinter dem Pilz nicht ein weitere Pilz oder 
 * ein Baum steht.
 *
 * @author Marco Jakob
 * @version 20.01.2011
 */
public class Mushroom  extends Actor
{
    // Ein Pilz steht nur rum und wartet darauf, dass er herumgestossen wird.

    /**
     * Diese Methode wird aufgerufen, sobald ein Baum-Objekt auf der Welt platziert wurde.
     * Es wird ueberprueft, ob der Baum auf dieses Feld gesetzt werden darf. Falls nicht, wird eine 
     * Fehlermeldung ausgegeben.
     */
    protected void addedToWorld(World world)
    {
        if (getOneObjectAtOffset(0, 0, Kara.class) != null) 
        {
            System.out.println("Achtung: Es sollte kein Pilz auf Kara gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Tree.class) != null) 
        {
            System.out.println("Achtung: Es sollte kein Pilz auf einen Baum gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Mushroom.class) != null) 
        {
            System.out.println("Achtung: Es sollten nicht zwei Pilze auf ein Feld gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
    }
}
