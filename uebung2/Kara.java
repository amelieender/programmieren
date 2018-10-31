import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Diese Klasse ist die Oberklasse fuer alle Karas. Programme sollten nur in den 
 * Unterklassen geschrieben werden, da diese Klasse recht komplex ist.
 * 
 * Der Marienkaefer Kara kann sich felderweise in die vier Richtungen bewegen. Falls Kara 
 * ueber den Rand der Wiese hinausgeht, erscheint er auf der anderen Seite wieder.
 * Kara kann Pilze stossen, Blaetter auflesen und setzen, jedoch nicht durch Baeume
 * hindurchgehen.
 * Ueber Sensoren kann er Informationen ueber seine Umwelt erhalten.
 * 
 * @author Marco Jakob
 * @version 18.01.2011
 */
public class Kara extends Actor 
{
    private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_DOWN = 90;
    private static final int DIRECTION_LEFT = 180;
    private static final int DIRECTION_UP = 270; 

    /**
     * Kara macht einen Schritt in die aktuelle Richtung.
     * Das macht er nur, wenn ihm nichts im Weg steht (z.B. ein Baum oder ein Pilz, 
     * den er nicht stossen kann).
     * Falls Kara ueber den Rand der Wiese hinausgeht, erscheint er auf der anderen 
     * Seite wieder.
     */         
    public void move() 
    {
        if (canMove()) 
        {
            moveActor(this, getRotation());
            Greenfoot.delay(1);
        }
        else 
        {
            // Fehler: Kara kann sich nicht bewegen!
            System.out.println("Fehler: Ich kann mich nicht bewegen!");
        }
    }

    /**
     * Kara dreht sich um 90° nach links.
     */         
    public void turnLeft() 
    {
        setRotation(modulo(getRotation() -  90, 360));
        Greenfoot.delay(1);
    }

    /**
     * Kara dreht sich um 90° nach rechts.
     */         
    public void turnRight() 
    {
        setRotation(modulo(getRotation() +  90, 360));
        Greenfoot.delay(1);
    }

    /**
     * Kara legt ein neues Kleeblatt an die Position, auf der er sich befindet.
     */         
    public void putLeaf() 
    {
        if (! onLeaf()) 
        {
            Leaf leaf = new Leaf();
            getWorld().addObject(leaf, getX(), getY());
            Greenfoot.delay(1);
        }
        else
        {
            // Fehler: Kara darf nicht zwei Kleeblaetter auf ein Feld legen!
            System.out.println("Fehler: Ich kann kein Kleeblatt auf ein Feld legen, auf dem schon eines ist!");
        }
    }

    /**
     * Kara entfernt ein unter ihm liegendes Kleeblatt.
     */         
    public void removeLeaf() 
    {
        Leaf leaf = (Leaf)getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) 
        {
            // das Blatt essen...
            getWorld().removeObject(leaf);
            Greenfoot.delay(1);
        }
        else
        {
            // Fehler: Es hat kein Blatt, welches Kara auflesen koennte.
            System.out.println("Fehler: Hier ist kein Blatt!");
        }
    }

    /**
     * Kara schaut nach, ob er sich auf einem Kleeblatt befindet.
     * 
     * @return true, falls Kara auf einem Kleeblatt steht, andernfalls false     
     */         
    public boolean onLeaf() 
    {
        return getOneObjectAtOffset(0, 0, Leaf.class) != null; 
    }

    /**
     * Kara schaut nach, ob sich ein Baum vor ihm befindet.
     * 
     * @return true, falls Kara vor einem Baum steht, andernfalls false     
     */         
    public boolean treeFront() 
    {
        return getObjectInFront(getRotation(), 1, Tree.class) != null;
    }

    /**
     * Kara schaut nach, ob sich ein Baum links von ihm befindet.
     * 
     * @return true, falls links neben Kara ein Baum steht, andernfalls false     
     */         
    public boolean treeLeft() 
    {
        return getObjectInFront(modulo(getRotation() -  90, 360), 1, Tree.class) != null;
    }

    /**
     * Kara schaut nach, ob sich ein Baum rechts von ihm befindet.
     * 
     * @return true, falls rechts neben Kara ein Baum steht, andernfalls false     
     */         
    public boolean treeRight() 
    {
        return getObjectInFront(modulo(getRotation() +  90, 360), 1, Tree.class) != null;
    }

    /**
     * Kara schaut nach, ob er einen Pilz vor sich hat.
     * 
     * @return true, falls Kara vor einem Pilz steht, andernfalls false     
     */         
    public boolean mushroomFront() 
    {
        return getObjectInFront(getRotation(), 1, Mushroom.class) != null;
    }

    /**
     * Ueberprueft, ob sich Kara bewegen kann. Falls ein Pilz vor ihm steht, versucht er
     * ihn zu schieben.
     * 
     * @return true, wenn sich Kara bewegen kann, andernfalls false
     */     
    private boolean canMove()
    {
        // Nachschauen, ob ein Baum vor Kara steht.
        if (treeFront())
        {
            return false;   
        }   

        // Nachschauen, ob ein Pilz vor Kara steht.
        Mushroom mushroomFront = (Mushroom) getObjectInFront(getRotation(), 1, Mushroom.class);
        if (mushroomFront != null) 
        {
            // nachschauen, ob der Pilz auf das naechste Feld geschoben werden kann
            if (getObjectInFront(getRotation(), 2, Tree.class) == null && 
            getObjectInFront(getRotation(), 2, Mushroom.class) == null)
            {
                // schiebe den Pilz
                moveActor(mushroomFront, getRotation());
            }
            else 
            {
                // konte den Pilz nicht schieben
                return false;
            }
        }

        return true;
    }

    /**
     * Schaut nach, ob auf dem Feld in der angegebenen Richtung ein Objekt von einer bestimmten
     * Klasse vorhanden ist.
     * 
     * @param direction die Richtung, in der man schauen soll
     * @param steps     die Schritte, welche in die angegebene Richtung gemacht werden soll
     *                  (1 bedeutet das benachbarte Feld, 2 das uebernaechste Feld usw.)
     * @param cls       die Klasse, von welcher ein Objekt auf dem Feld gesucht werden
     * @return          das Objekt, das von dieser Klasse auf dem Feld ist oder null
     *                  wenn es nicht vorkommt.
     */
    private Object getObjectInFront(int direction, int steps, Class cls) 
    {
        int x = getX();
        int y = getY();

        // Aendere x und y in der entsprechenden Richtung
        switch (direction)
        {
            case DIRECTION_RIGHT:
            x = modulo((x + steps), getWorld().getWidth());
            break;

            case DIRECTION_DOWN:
            y = modulo((y + steps), getWorld().getHeight());
            break;

            case DIRECTION_LEFT:
            x = modulo((x - steps), getWorld().getWidth());
            break;

            case DIRECTION_UP:
            y = modulo((y - steps), getWorld().getHeight());
            break;

            default: // es wurde keine gueltige Richtung angegeben
            return null;
        }

        List objects = getWorld().getObjectsAt(x, y, cls);

        if (objects != null && objects.size() > 0)
        {
            return objects.get(0);
        }
        else 
        {
            return null;
        }
    }

    /**
     * Bewegt den Actor einen Schritt in die angegebene Richtung.
     * 
     * @param actor     der zu bewegende Actor
     * @param direction die Richtung
     */
    private void moveActor(Actor actor, int direction) 
    {
        switch(direction)
        {
            case DIRECTION_RIGHT:
            actor.setLocation(modulo((actor.getX() + 1), getWorld().getWidth()), actor.getY());
            break;

            case DIRECTION_DOWN:
            actor.setLocation(actor.getX(), modulo((actor.getY() + 1), getWorld().getHeight()));
            break;

            case DIRECTION_LEFT:
            actor.setLocation(modulo((actor.getX() - 1), getWorld().getWidth()), actor.getY());
            break;

            case DIRECTION_UP:
            actor.setLocation(actor.getX(), modulo((actor.getY() - 1), getWorld().getHeight()));
            break;
        }
    }

    /**
     * Dies ist eine spezielle Modulo-Operation, damit wir bei negativen Zahlen 
     * trotzdem wieder innerhalb der Welt landen. Die Java-Modulo-Operation wuerde 
     * z.B. bei -1 % 10 zu -1 fuehren, wir brauchen aber 9.
     * Hinweis: Je nach Programmiersprache ist die Modulo-Operation fuer negative 
     * Zahlen anders definiert.
     * 
     * @param a der erste Operand
     * @param b der zweite Operand
     * @return das Resultat der Modulo-Operation
     */
    private int modulo(int a, int b) 
    {
        return (a % b + b) % b;
    }

    /**
     * Diese Methode wird aufgerufen, sobald ein Kara-Objekt auf der Welt platziert wurde.
     * Es wird ueberprueft, ob Kara auf dieses Feld gesetzt werden darf. Falls nicht, wird eine 
     * Fehlermeldung ausgegeben.
     */
    protected void addedToWorld(World world)
    {
        if (getOneObjectAtOffset(0, 0, Tree.class) != null) 
        {
            System.out.println("Achtung: Kara sollte nicht auf einen Baum gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
        else if (getOneObjectAtOffset(0, 0, Mushroom.class) != null) 
        {
            System.out.println("Achtung: Kara sollte nicht auf einen Pilz gesetzt werden! (Feld " + getX() + ", " + getY() + ")");
        }
    }
}
