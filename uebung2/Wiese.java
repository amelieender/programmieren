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
    private static final int WORLD_WIDTH = 55;  // Anzahl der Zellen horizontal
    private static final int WORLD_HEIGHT = 55;  // Anzahl der Zellen vertikal

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
        addObject(tree, 2, 2);
        Tree tree2 = new Tree();
        addObject(tree2, 3, 2);
        Tree tree3 = new Tree();
        addObject(tree3, 4, 2);
        Tree tree4 = new Tree();
        addObject(tree4, 5, 2);
        Tree tree5 = new Tree();
        addObject(tree5, 6, 2);
        Tree tree6 = new Tree();
        addObject(tree6, 7, 2);
        Tree tree7 = new Tree();
        addObject(tree7, 2, 3);
        Tree tree8 = new Tree();
        addObject(tree8, 2, 4);
        Tree tree9 = new Tree();
        addObject(tree9, 2, 5);
        Tree tree10 = new Tree();
        addObject(tree10, 2, 6);
        Tree tree11 = new Tree();
        addObject(tree11, 2, 7);
        Tree tree12 = new Tree();
        addObject(tree12, 2, 8);
        Tree tree13 = new Tree();
        addObject(tree13, 2, 9);
        mykara.setLocation(3, 3);
        Tree tree14 = new Tree();
        addObject(tree14, 8, 2);
        Tree tree15 = new Tree();
        addObject(tree15, 9, 2);
        Tree tree16 = new Tree();
        addObject(tree16, 9, 3);
        Tree tree17 = new Tree();
        addObject(tree17, 9, 4);
        Tree tree18 = new Tree();
        addObject(tree18, 9, 5);
        Tree tree19 = new Tree();
        addObject(tree19, 9, 6);
        Tree tree20 = new Tree();
        addObject(tree20, 9, 7);
        Tree tree21 = new Tree();
        addObject(tree21, 9, 8);
        Tree tree22 = new Tree();
        addObject(tree22, 9, 9);
        Tree tree23 = new Tree();
        addObject(tree23, 8, 9);
        Tree tree24 = new Tree();
        addObject(tree24, 7, 9);
        Tree tree25 = new Tree();
        addObject(tree25, 6, 9);
        Tree tree26 = new Tree();
        addObject(tree26, 5, 9);
        Tree tree27 = new Tree();
        addObject(tree27, 4, 9);
        Tree tree28 = new Tree();
        addObject(tree28, 3, 9);
        Tree tree29 = new Tree();
        addObject(tree29, 12, 2);
        Tree tree30 = new Tree();
        addObject(tree30, 13, 2);
        Tree tree31 = new Tree();
        addObject(tree31, 12, 3);
        Tree tree32 = new Tree();
        addObject(tree32, 12, 4);
        Tree tree33 = new Tree();
        addObject(tree33, 14, 2);
        Tree tree34 = new Tree();
        addObject(tree34, 14, 3);
        Tree tree35 = new Tree();
        addObject(tree35, 14, 4);
        Tree tree36 = new Tree();
        addObject(tree36, 13, 4);
        Tree tree37 = new Tree();
        addObject(tree37, 12, 6);
        Tree tree38 = new Tree();
        addObject(tree38, 13, 6);
        Tree tree39 = new Tree();
        addObject(tree39, 14, 6);
        Tree tree40 = new Tree();
        addObject(tree40, 15, 6);
        Tree tree41 = new Tree();
        addObject(tree41, 12, 7);
        Tree tree42 = new Tree();
        addObject(tree42, 12, 8);
        Tree tree43 = new Tree();
        addObject(tree43, 12, 9);
        Tree tree44 = new Tree();
        addObject(tree44, 12, 10);
        Tree tree45 = new Tree();
        addObject(tree45, 12, 11);
        Tree tree46 = new Tree();
        addObject(tree46, 12, 12);
        Tree tree47 = new Tree();
        addObject(tree47, 12, 13);
        Tree tree48 = new Tree();
        addObject(tree48, 13, 13);
        Tree tree49 = new Tree();
        addObject(tree49, 14, 13);
        Tree tree50 = new Tree();
        addObject(tree50, 15, 13);
        Tree tree51 = new Tree();
        addObject(tree51, 16, 12);
        Tree tree52 = new Tree();
        addObject(tree52, 15, 11);
        tree51.setLocation(15, 12);
        Tree tree53 = new Tree();
        addObject(tree53, 15, 10);
        Tree tree54 = new Tree();
        addObject(tree54, 15, 9);
        Tree tree55 = new Tree();
        addObject(tree55, 15, 8);
        Tree tree56 = new Tree();
        addObject(tree56, 15, 7);
        /*
         * 
         * MyKara mykara2 = new MyKara();
         * addObject(mykara2,13,3);
         * MyKara mykara3 = new MyKara();
         * addObject(mykara3,13,7);
         */
    }
}
