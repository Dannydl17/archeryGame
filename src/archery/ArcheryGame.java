package archery;

import archery.exception.NoSpaceFoundException;
import archery.exception.PlayerFilledException;
import archery.exception.PlayerNotRegisterException;
import archery.exception.PlayerPlaysException;

import java.util.Arrays;

public class ArcheryGame {
   private final Player[] players = new Player[4];
   private Board board = new Board();
   private int numberOfPlayer = 0;
   private int gameLevel = 0;

    @Override
    public String toString() {
        return "ArcheryGame{" +
                "players=" + Arrays.toString(players) +
                ", board=" + board +
                ", numberOfPlayer=" + numberOfPlayer +
                ", gameLevel=" + gameLevel +
                '}';
    }

    public void registerPlayer(String nameOfPLayer) {
        Player player = getUnregisteredPlayer();
        player = new Player();
        player = player.register(nameOfPLayer, numberOfPlayer);
        players[numberOfPlayer] = player;
        numberOfPlayer++;
    }
    private Player getUnregisteredPlayer() {
        for (Player player:this.players) {
            if (player == null) return player;
        }
        throw new PlayerFilledException("Player already filled...");
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Integer[][] getBoard() {
        return this.board.getBoard();
    }

    public void play(Player player) {
        if (this.gameLevel >= 3) throw new NoSpaceFoundException("Game level is over");
        if (player == null) throw new PlayerNotRegisterException("Player has not register");
        if (this.getBoard()[player.getId()][gameLevel] != null) throw new PlayerPlaysException("Player already play wait for next level");
        player.play(gameLevel, this.board.getBoard());
        if (player.getId() == 3) gameLevel++;
        if (gameLevel == 3 && player.getId() == 3){
            calculateScore();
        }
    }

    private void calculateScore() {
        for (Player player : this.players){
            player.setScoreOfPlayer(setSumUpPlayerScore(player.getId()));
        }
    }

    private Integer setSumUpPlayerScore(int id) {
        Integer[] playerBoard = getBoard()[id];
        return Arrays.stream(playerBoard)
                .mapToInt(x -> x)
                .sum();
    }

    public int getLevel() {
        return gameLevel + 1;
    }
}
