package cscd212classes.boards;
import cscd212classes.lifeform.*;
import cscd212enums.DifficultyLevel;

public class EarthBoard extends GameBoard{

    public EarthBoard(DifficultyLevel difficultyLevel) {
        super(difficultyLevel);
    }
    @Override
    public void createLifeForms() {
        this.player = new Martian("Marvin", 120);
        this.enemyLifeForms.add(new Human("Dave", 110));
        this.enemyLifeForms.add(new Human("Hugh Mann", 100));
    }
}
