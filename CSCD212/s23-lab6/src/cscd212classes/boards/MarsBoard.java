package cscd212classes.boards;
import cscd212enums.DifficultyLevel;
import cscd212classes.lifeform.*;

public class MarsBoard extends GameBoard{

    public MarsBoard(DifficultyLevel difficultyLevel){
        super(difficultyLevel);
    }

    @Override
    public void createLifeForms() {
        this.player = new Human("Hugh Mann", 100);
        this.enemyLifeForms.add(new Martian("Marvin", 120));
        this.enemyLifeForms.add(new Martian("Steve", 50));
        this.enemyLifeForms.add(new Human("Evil Carl", 110));
        this.enemyLifeForms.add(new Human("Carl", 100));
    }
}
