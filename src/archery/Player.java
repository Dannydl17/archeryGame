package archery;

import java.security.SecureRandom;

public class Player {
    private String name;
    private int id;
    private Integer scoreOfPlayer;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void setScoreOfPlayer(Integer scoreOfPlayer) {
        this.scoreOfPlayer = scoreOfPlayer;
    }
    public Integer getScoreOfPlayer(){
        return this.scoreOfPlayer;
    }

    public int getId() {
        return this.id;
    }

    public Player register(String nameOfPLayer, int id) {
        Player player;
        player = this;
        player.name = nameOfPLayer;
        player.id = id;
        return player;
    }

    public void play(int gameLevel, Integer[][] board) {
        SecureRandom secureRandom = new SecureRandom();
        board[this.id][gameLevel] = secureRandom.nextInt(0, 11);
    }
}
