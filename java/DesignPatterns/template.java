/* The template pattern simply defines a set of guidelines for subclasses
 * to follow. For example both Football and Cricket need to initilize, start
 * and end their games. To this end they can both benifit by folliwng a Game
 * template and simply overwriting the behavior. */

//-------------------------------------------------
// Main class
//-------------------------------------------------
public class template{
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

//-------------------------------------------------
// Class that is used as a template for other games
//-------------------------------------------------
abstract class Game{
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    public final void play(){
        //Initialize game
        initialize();
        //Start game
        startPlay();
        //End game
        endPlay();
    }
}

//-------------------------------------------------
// Concrete instance of Cricket
//-------------------------------------------------
class Cricket extends Game{

    @Override void endPlay(){
        System.out.println("Cricket Game Finished!");
    }

    @Override void initialize(){
        System.out.println("Cricket Game Initilized! Start playing.");
    }

    @Override void startPlay(){
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

//-------------------------------------------------
// Concrete instance of Football
//-------------------------------------------------
class Football extends Game{

    @Override void endPlay(){
        System.out.println("Football Game Finished!");
    }

    @Override void initialize(){
        System.out.println("Football Game Initilized! Start playing.");
    }

    @Override void startPlay(){
        System.out.println("Football Game Started. Enjoy the game!");
    }
}

