package GameLogic;

import GameCharacters.Player;
import Map.Biomes.Tile;
import Map.GameMap;

import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private GameMap gameMap;
    private Player player;

    public Game() {
        scanner = new Scanner(System.in);
        gameMap = new GameMap();
    }

    public void start() {

        // --------- MAIN MENU ---------
        System.out.println("------------------");
        System.out.println("| 1 - Start Game |");
        System.out.println("| 2 - Quit       |");
        System.out.println("------------------");

        int menuChoice = scanner.nextInt();
        scanner.nextLine();

        if (menuChoice == 2) {
            System.out.println("GoodBye");
            System.exit(0);
        }

        System.out.println("You awake in a bush in the forest...");
        System.out.println("All you can remember is your name...");
        System.out.println("And a man named Erlich");

        System.out.println("Enter your name: ");
        player = new Player(scanner.nextLine());

        System.out.println("Welcome, " + player.getName());
        System.out.println("------------------------------");

        gameLoop();
    }

    private void gameLoop() {

        while (player.isAlive()) {

            System.out.println("------------------------");

            System.out.println("     N");
            System.out.println("     |");
            System.out.println("W----+----E");
            System.out.println("     |");
            System.out.println("     S");

            System.out.println("Location: "
                    + gameMap.getCurrentTile()
                    + " (" + gameMap.getX() + "," + gameMap.getY() + ")");

            System.out.println("1- North, 2- East, 3- South, 4- West");
            System.out.println("0- Quit");
            System.out.println();
            System.out.println(player);
            System.out.println();

            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            gameMap.move(input);


            Tile currentTile = gameMap.getCurrentTile();
            currentTile.onEnter(player);
        }

        System.out.println("Game Over");
    }
}