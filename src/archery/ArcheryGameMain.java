package archery;

import java.util.Scanner;

import static java.lang.System.in;

public class ArcheryGameMain {

    static Scanner keyboardInput = new Scanner(in);
    private static ArcheryGame archeryGame = new ArcheryGame();
    public static void main(String[] args) {
      goToMain();
//        System.out.println(archeryGame);
    }

    private static void goToMain() {
        System.out.println("Hello, Friends welcome to Archery Game");
        for (int numberOfPlayer = 1; numberOfPlayer <=4; numberOfPlayer++) {
            System.out.println("Enter your name:   ");
            String name = keyboardInput.nextLine();
            archeryGame.registerPlayer(name);
        }

    }

}
