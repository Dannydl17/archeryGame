package archery;

import archery.exception.NoSpaceFoundException;
import archery.exception.PlayerFilledException;
import archery.exception.PlayerNotRegisterException;
import archery.exception.PlayerPlaysException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArcheryGameTest {

    @Test
    public void testThatArcheryGameHasFourPlayers(){
        ArcheryGame archeryGame = new ArcheryGame();
        Player[] players = archeryGame.getPlayers();
        assertEquals(4, players.length);
    }

    @Test
    public void testThatWhenPlayerRegisterTheIdIsNotNull(){
        ArcheryGame archeryGame = new ArcheryGame();
        archeryGame.registerPlayer("Tobi");
        Player player = archeryGame.getPlayers()[0];
        assertEquals(player.getId(), 0);
    }

    @Test
    public void testThatWhenPlayerHasRegisterFourTimeAndWantToRegisterAgainThrowException(){
        ArcheryGame game = new ArcheryGame();
        game.registerPlayer("Tobi");
        game.registerPlayer("Delighted");
        game.registerPlayer("Qudus");
        game.registerPlayer("Daniel");
        assertThrows(PlayerFilledException.class, () -> game.registerPlayer("Ope"));
    }

    @Test
    public void testThatAllFourPlayerHasAnIdWhenTheyRegisterTest(){
        ArcheryGame game = new ArcheryGame();
        game.registerPlayer("Tobi");
        game.registerPlayer("Delighted");
        game.registerPlayer("Qudus");
        game.registerPlayer("Daniel");
        Player player = game.getPlayers()[3];
        assertEquals(player.getId(), 3);
    }

    @Test
    public void testThatAnArrayIsCreatedInABoardTest(){
        ArcheryGame game = new ArcheryGame();
        Integer[][] boards = game.getBoard();
        assertEquals(4, boards.length);
        assertEquals(3, boards[0].length);
        assertEquals(3, boards[1].length);
        assertEquals(3, boards[2].length);
        assertEquals(3, boards[3].length);
    }

    @Test
    public void testThatPlayersCanPlayAnArcheryGameIfPlayerHasNotRegisterThrowExceptionTest(){
        ArcheryGame archeryGame = new ArcheryGame();
        Player player = archeryGame.getPlayers()[0];
        assertThrows(PlayerNotRegisterException.class, ()-> archeryGame.play(player));
    }

    @Test
    public void testThatWhenThePlayerPlaysTheBoardScoreOfThePlayerIncreaseTest(){
        ArcheryGame archeryGame = new ArcheryGame();
        archeryGame.registerPlayer("Daniel");
        Player playerOne = archeryGame.getPlayers()[0];
        archeryGame.play(playerOne);
        Integer[][] board = archeryGame.getBoard();
        System.out.println(Arrays.deepToString(board));
        assertNotNull(board[0][0]);
    }
    @Test
    public void testThatWhenPlayerPlayFirstTimeAndDidNotWaitForOthersToPlayThrowException(){
        ArcheryGame archeryGame = new ArcheryGame();
        archeryGame.registerPlayer("Daniel");
        archeryGame.registerPlayer("Tobi");
        archeryGame.registerPlayer("Delight");
        archeryGame.registerPlayer("Qudus");
        Player daniel = archeryGame.getPlayers()[0];
        archeryGame.play(daniel);
        assertThrows(PlayerPlaysException.class, () -> archeryGame.play(daniel));
    }
    @Test
    public void testThatWhenFourPlayersPlayTheGameLevelIncreasesToTheNextLevel(){
        ArcheryGame archeryGame = new ArcheryGame();
        archeryGame.registerPlayer("Daniel");
        archeryGame.registerPlayer("Tobi");
        archeryGame.registerPlayer("Delight");
        archeryGame.registerPlayer("Qudus");
        Player daniel = archeryGame.getPlayers()[0];
        Player tobi = archeryGame.getPlayers()[1];
        Player delight = archeryGame.getPlayers()[2];
        Player qudus = archeryGame.getPlayers()[3];
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
//        System.out.println(Arrays.deepToString(archeryGame.getBoard()));
        assertEquals(2, archeryGame.getLevel());
    }
    @Test
    public void testThatWhenFourPlayerPlaysTheWholeGameLevelWhichIsThreeAndOneWantToPlayAgainThrowsException(){
        ArcheryGame archeryGame = new ArcheryGame();
        archeryGame.registerPlayer("Daniel");
        archeryGame.registerPlayer("Tobi");
        archeryGame.registerPlayer("Delight");
        archeryGame.registerPlayer("Qudus");
        Player daniel = archeryGame.getPlayers()[0];
        Player tobi = archeryGame.getPlayers()[1];
        Player delight = archeryGame.getPlayers()[2];
        Player qudus = archeryGame.getPlayers()[3];
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
        assertEquals(2, archeryGame.getLevel());
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
        assertEquals(3, archeryGame.getLevel());
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
        System.out.println(Arrays.deepToString(archeryGame.getBoard()));
        assertThrows(NoSpaceFoundException.class, ()-> archeryGame.play(tobi));
    } @Test
    public void testThatWhenFourPlayerPlaysTheWholeGameLevelWhichIsThreeWeCanGetTheScoreOfEachPlayer(){
        ArcheryGame archeryGame = new ArcheryGame();
        archeryGame.registerPlayer("Daniel");
        archeryGame.registerPlayer("Tobi");
        archeryGame.registerPlayer("Delight");
        archeryGame.registerPlayer("Qudus");
        Player daniel = archeryGame.getPlayers()[0];
        Player tobi = archeryGame.getPlayers()[1];
        Player delight = archeryGame.getPlayers()[2];
        Player qudus = archeryGame.getPlayers()[3];
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
        assertEquals(2, archeryGame.getLevel());
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
        assertEquals(3, archeryGame.getLevel());
        archeryGame.play(daniel);
        archeryGame.play(tobi);
        archeryGame.play(delight);
        archeryGame.play(qudus);
        assertNotNull(daniel.getScoreOfPlayer());
        assertNotNull(tobi.getScoreOfPlayer());
        assertNotNull(qudus.getScoreOfPlayer());
        assertNotNull(delight.getScoreOfPlayer());
    }




}