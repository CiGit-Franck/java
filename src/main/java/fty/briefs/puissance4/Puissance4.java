package fty.briefs.puissance4;

/**
 * 
 *
 * @author Franck THERY
 */
public class Puissance4 {

    public final static int ROWS = 6;
    public final static int COLUMS = 7;
    Game game;

    /**
     * Init app for the game
     */
    public Puissance4() {
        game = new Game(ROWS, COLUMS);
    }
    
    /**
     * Start a game
     */
    public void play(){
        do {
            game.play();
        } while (Screen.again());
        System.exit(0);        
    }
}
