package GameLogic;

import GameCharacters.Enemy;
import GameCharacters.Player;
import java.util.Scanner;


public class Battle {
    public static boolean startBattle(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);

        String art = """
                      ,____
                      |---.\\
              ___     |    `
             / .-\\  ./=)
            |  |"|_/\\/|
            ;  |-;| /_|
           / \\_| |/ \\ |
          /      \\/\\( |
          |   /  |` ) |
          /   \\ _/    |
         /--._/  \\    |
         `/|)    |    /
           /     |   |
         .'      |   |
        /         \\  |
       (_.-.__.__./  /
""";

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println(player.toString());
            System.out.println(enemy.toString());
            System.out.println("Press 1 - Attack");
            System.out.println("Press 2 - Potions");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                enemy.takeDamage(player.getAttackDamage());
                System.out.println("You attacked and did " + player.getAttackDamage() + " damage");

                if (enemy.isAlive()) {
                    player.takeDamage(enemy.getAttackDamage());
                    System.out.println(enemy.getName() + " attacked and did " + enemy.getAttackDamage() + " damage");
                }

            } else if (choice.equals("2")) {
                player.usePotion();
            }
        }

        if (player.isAlive()) {
            System.out.println("You defeated " + enemy.getName());
            player.addGold(enemy.getGoldReward());
            System.out.println("You earned " + enemy.getGoldReward());
            return true; // return True since the player won the Fight

        } else {
            System.out.println("You Died....");
            System.out.println(art);
            return false;
        }

    }
}