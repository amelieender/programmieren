import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Diese Klasse erstellt eine Welt für Kara. Sie enthaelt Einstellungen ueber
 * die Hoehe und Breite der Welt und initialisiert alle Actors.
 * 
 * @author Marco Jakob
 * @version 04.04.2011
 */
public class Wiese extends World 
{   
    private static final int WORLD_WIDTH = 20;  // Anzahl der Zellen horizontal
    private static final int WORLD_HEIGHT = 15;  // Anzahl der Zellen vertikal

    private static final int CELL_SIZE = 28; // Groesse einer einzelnen Zelle

    /**
     * Erstellt eine Welt fuer Kara.
     */
    public Wiese() 
    {
        // Erzeugt eine neue Welt
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE);

        setPaintOrder(Kara.class, Tree.class, Mushroom.class, Leaf.class);
        Greenfoot.setSpeed(15);

        // Erzeuge die Anfangs-Objekte fuer die Welt.
        prepare();
    }

    /**
     * Bereite die Welt fuer den Programmstart vor. Das heisst: Erzeuge die Anfangs-
     * Objekte und fuege sie der Welt hinzu.
     * 
     * Tipp: Die Objekte zuerst mit der Maus in der Welt platzieren. Anschliessend 
     * Rechtsklick auf die Welt, dann 'Die Welt speichern' auswaehlen. So werden alle
     * Objekte automatisch in diese Methode geschrieben.
     */
    private void prepare() 
    {

        MyKara mykara = new MyKara();
        this.addObject(mykara, 3, 6);
        Tree tree = new Tree();
        this.addObject(tree, 10, 6);
        Tree tree2 = new Tree();
        this.addObject(tree2, 2, 6);
        removeObject(tree2);
        removeObject(tree);
        MyKara mykara2 = new MyKara();
        addObject(mykara2, 6, 8);
        Tree tree3 = new Tree();
        addObject(tree3, 7, 3);
        Tree tree4 = new Tree();
        addObject(tree4, 9, 6);
        tree3.setLocation(1, 6);
        Leaf leaf = new Leaf();
        addObject(leaf, 8, 8);
        Leaf leaf2 = new Leaf();
        addObject(leaf2, 2, 8);
        Leaf leaf3 = new Leaf();
        addObject(leaf3, 5, 6);
        removeObject(tree3);
        removeObject(leaf3);
        removeObject(tree4);
        removeObject(leaf);
        removeObject(mykara2);
        removeObject(leaf2);
        removeObject(mykara);
        MyKara mykara3 = new MyKara();
        addObject(mykara3, 4, 5);
        Tree tree5 = new Tree();
        addObject(tree5, 13, 5);
        removeObject(tree5);
        Tree tree6 = new Tree();
        addObject(tree6, 14, 5);
        Tree tree7 = new Tree();
        addObject(tree7, 6, 6);
        Tree tree8 = new Tree();
        addObject(tree8, 7, 6);
        Tree tree9 = new Tree();
        addObject(tree9, 8, 5);
        Tree tree10 = new Tree();
        addObject(tree10, 6, 5);
        Tree tree11 = new Tree();
        addObject(tree11, 6, 4);
        Tree tree12 = new Tree();
        addObject(tree12, 6, 3);
        Tree tree13 = new Tree();
        addObject(tree13, 7, 3);
        Tree tree14 = new Tree();
        addObject(tree14, 8, 3);
        Tree tree15 = new Tree();
        addObject(tree15, 9, 3);
        Tree tree16 = new Tree();
        addObject(tree16, 10, 3);
        Tree tree17 = new Tree();
        addObject(tree17, 11, 3);
        Tree tree18 = new Tree();
        addObject(tree18, 12, 4);
        Tree tree19 = new Tree();
        addObject(tree19, 13, 4);
        tree6.setLocation(12, 5);
        Tree tree20 = new Tree();
        addObject(tree20, 11, 6);
        Tree tree21 = new Tree();
        addObject(tree21, 12, 7);
        Tree tree22 = new Tree();
        addObject(tree22, 13, 8);
        Tree tree23 = new Tree();
        addObject(tree23, 10, 7);
        Tree tree24 = new Tree();
        addObject(tree24, 10, 8);
        Tree tree25 = new Tree();
        addObject(tree25, 10, 9);
        Tree tree26 = new Tree();
        addObject(tree26, 10, 10);
        Tree tree27 = new Tree();
        addObject(tree27, 10, 11);
        Tree tree28 = new Tree();
        addObject(tree28, 11, 11);
        Tree tree29 = new Tree();
        addObject(tree29, 12, 11);
        tree28.setLocation(11, 10);
        tree29.setLocation(12, 10);
        removeObject(tree27);
        mykara3.setLocation(5, 7);
        mykara3.setLocation(9, 8);
    }
}
