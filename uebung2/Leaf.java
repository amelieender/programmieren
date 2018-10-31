import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Diese Klasse stellt ein Kleeblatt zur Verfuegung.
 * 
 * Kara kann Kleeblaetter aufnehmen und auch Kleeblaetter auf Felder platziern.
 * 
 * @author Marco Jakob
 * @version 20.01.2011
 */
public class Leaf  extends Actor
{

    // Ein Kleeblatt steht nur rum und wartet darauf, gefressen zu werden.

    /**
     * Diese Methode wird aufgerufen, sobald ein Blatt-Objekt auf der Welt platziert wurde.
     * Es wird ueberprueft, ob das Blatt auf dieses Feld gesetzt werden darf. Falls nicht, wird eine 
     * Fehlermeldung ausgegeben.
     */
    protected void addedToWorld(World world)
    {
        if (getOneObjectAtOffset(0, 0, Tree.class) != null) 
        {
            System.out.println("Acktung: Es sollte kein Blatt auf einen Baum gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Leaf.class) != null) 
        {
            System.out.println("Achtung: Es sollten nicht zwei Blaetter auf ein Feld gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
    }
}
