package cscd212tests.lab5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import cscd212classes.factories.GameBoardFactory;
import cscd212classes.factories.LifeFormFactory;
import cscd212enums.BoardTheme;
import cscd212enums.DifficultyLevel;
import cscd212enums.LifeFormType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSCD212Lab5Tests {

    @Nested
    class GameBoardFactoryTests {
        @Test
        public void getGameBoardTestBeach() {
            assertTrue(GameBoardFactory.getGameBoard(BoardTheme.BEACH, DifficultyLevel.EASY).getClass()
                    .getSimpleName().equalsIgnoreCase("BeachBoard"));
        }

        @Test
        public void getGameBoardTestMars() {
            assertTrue(GameBoardFactory.getGameBoard(BoardTheme.MARS, DifficultyLevel.EASY).getClass()
                    .getSimpleName().equalsIgnoreCase("MarsBoard"));
        }

        @Test
        public void getGameBoardTestEarth() {
            assertTrue(GameBoardFactory.getGameBoard(BoardTheme.EARTH, DifficultyLevel.EASY).getClass()
                    .getSimpleName().equalsIgnoreCase("EarthBoard"));
        }

        @Test
        public void getGameBoardTestEasy() {
            assertEquals(77, GameBoardFactory.getGameBoard(BoardTheme.EARTH, DifficultyLevel.EASY)
                    .getEnemyLifeForms().get(0).getCurrentLifePoints());
        }

        @Test
        public void getGameBoardTestNormal() {
            assertEquals(110, GameBoardFactory.getGameBoard(BoardTheme.EARTH, DifficultyLevel.NORMAL)
                    .getEnemyLifeForms().get(0).getCurrentLifePoints());
        }

        @Test
        public void getGameBoardTestHard() {
            assertEquals(165, GameBoardFactory.getGameBoard(BoardTheme.EARTH, DifficultyLevel.HARD)
                    .getEnemyLifeForms().get(0).getCurrentLifePoints());
        }

        @Test
        public void getGameBoardTestInsane() {
            assertEquals(220, GameBoardFactory.getGameBoard(BoardTheme.EARTH, DifficultyLevel.INSANE)
                    .getEnemyLifeForms().get(0).getCurrentLifePoints());
        }
    }

    @Nested
    class LifeFormFactoryTests {
        @Test
        public void getLifeFormMartian() {
            assertEquals("Marvin", LifeFormFactory.getLifeForm(LifeFormType.MARTIAN).getName());
        }

        @Test
        public void getLifeFormHuman() {
            assertEquals("Hugh Mann", LifeFormFactory.getLifeForm(LifeFormType.HUMAN).getName());
        }

        @Test
        public void getLifeFormStarBellySneetch() {
            assertEquals("Starry",
                    LifeFormFactory.getLifeForm(LifeFormType.STAR_BELLY_SNEETCH).getName());
        }

        @Test
        public void getLifeFormPlainBellySneetch() {
            assertEquals("Paul", LifeFormFactory.getLifeForm(LifeFormType.PLAIN_BELLY_SNEETCH).getName());
        }

        @Test
        public void getLifeFormMartianLP() {
            assertEquals(120, LifeFormFactory.getLifeForm(LifeFormType.MARTIAN).getCurrentLifePoints());
        }

        @Test
        public void getLifeFormHumanLP() {
            assertEquals(100, LifeFormFactory.getLifeForm(LifeFormType.HUMAN).getCurrentLifePoints());
        }

        @Test
        public void getLifeFormStarBellySneetchLP() {
            assertEquals(85,
                    LifeFormFactory.getLifeForm(LifeFormType.STAR_BELLY_SNEETCH).getCurrentLifePoints());
        }

        @Test
        public void getLifeFormPlainBellySneetchLP() {
            assertEquals(75,
                    LifeFormFactory.getLifeForm(LifeFormType.PLAIN_BELLY_SNEETCH).getCurrentLifePoints());
        }
    }

    @Nested
    class GameBoardTests {
        @ParameterizedTest
        @EnumSource(BoardTheme.class)
        void NullForAdjustForDifficulty(BoardTheme boardTheme) {
            assertThrows(IllegalArgumentException.class, () -> {
                GameBoardFactory.getGameBoard(boardTheme, null);
            });
        }

        @ParameterizedTest
        @EnumSource(BoardTheme.class)
        void NotNullForGetPlayerEASY(BoardTheme boardTheme) {
            assertNotNull(
                    GameBoardFactory.getGameBoard(boardTheme, DifficultyLevel.EASY)
                            .getPlayer());
        }

        @ParameterizedTest
        @EnumSource(BoardTheme.class)
        void NotNullForGetPlayerHARD(BoardTheme boardTheme) {
            assertNotNull(
                    GameBoardFactory.getGameBoard(boardTheme, DifficultyLevel.HARD)
                            .getPlayer());
        }

        @ParameterizedTest
        @EnumSource(BoardTheme.class)
        void NotNullForGetPlayerINSANE(BoardTheme boardTheme) {
            assertNotNull(
                    GameBoardFactory.getGameBoard(boardTheme, DifficultyLevel.INSANE)
                            .getPlayer());
        }

        @ParameterizedTest
        @EnumSource(BoardTheme.class)
        void NotNullForGetPlayerNORMAL(BoardTheme boardTheme) {
            assertNotNull(
                    GameBoardFactory.getGameBoard(boardTheme, DifficultyLevel.NORMAL)
                            .getPlayer());
        }
    }
}
