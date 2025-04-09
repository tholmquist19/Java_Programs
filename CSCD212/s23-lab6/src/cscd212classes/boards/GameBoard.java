package cscd212classes.boards;
import cscd212classes.lifeform.LifeForm;
import java.util.ArrayList;
import cscd212enums.DifficultyLevel;

public abstract class GameBoard {
    protected final ArrayList<LifeForm> enemyLifeForms;
    protected LifeForm player;

    public GameBoard(DifficultyLevel difficultyLevel){
        this.enemyLifeForms= new ArrayList<>();
        this.createLifeForms();
        this.adjustForDifficulty(difficultyLevel);
        this.enemyLifeForms.trimToSize();
    }
    public LifeForm getPlayer(){
        return this.player;
    }
    public ArrayList<LifeForm> getEnemyLifeForms(){
        return this.enemyLifeForms;
    }
    public abstract void createLifeForms();
    protected void adjustForDifficulty(final DifficultyLevel difficultyLevel){
        for(int i=0; i<enemyLifeForms.size(); i++){
            double x = enemyLifeForms.get(i).getCurrentLifePoints();
            x*=difficultyLevel.getModifier();
            int y = (int) x;
            enemyLifeForms.get(i).setCurrentLifePoints(y);
        }
    }
}
