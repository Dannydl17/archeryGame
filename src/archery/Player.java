package archery;

import java.security.SecureRandom;

public class Player {
    private String name;
    private int id;
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
