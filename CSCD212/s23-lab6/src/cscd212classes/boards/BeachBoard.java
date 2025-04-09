package cscd212classes.boards;
import cscd212enums.*;
import cscd212classes.lifeform.*;


public class BeachBoard extends GameBoard{

    public BeachBoard(DifficultyLevel difficultyLevel){
        super(difficultyLevel);
    }
    @Override
    public void createLifeForms() {
        this.player = new StarBellySneetch("Starry", 85);
        this.enemyLifeForms.add(new PlainBellySneetch("Paul", 75));
        this.enemyLifeForms.add(new PlainBellySneetch("Pete", 80));
        this.enemyLifeForms.add(new Human("Dave", 110));
    }
}
