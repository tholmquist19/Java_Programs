package cscd212classes.factories;
import cscd212classes.boards.GameBoard;
import cscd212enums.*;
import cscd212classes.boards.*;

public class GameBoardFactory {
    public GameBoardFactory(){}

    public static GameBoard getGameBoard(BoardTheme levelTheme, DifficultyLevel difficultyLevel){
        if(levelTheme==null||difficultyLevel==null)
            throw new IllegalArgumentException("Bad params in getGameBoard");
        if(levelTheme==BoardTheme.MARS)
            return new MarsBoard(difficultyLevel);
        if(levelTheme==BoardTheme.BEACH)
            return new BeachBoard(difficultyLevel);
        return new EarthBoard(difficultyLevel);
    }
}
