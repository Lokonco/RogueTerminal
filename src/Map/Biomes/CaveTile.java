package Map.Biomes;
import GameCharacters.Enemy;
import GameCharacters.EnemyFactory;
import GameCharacters.Player;
import GameLogic.Battle;
import GameLogic.CaveAnimation;

import java.util.Scanner;

public class CaveTile extends Tile {
    private Scanner scanner = new Scanner(System.in);
    private String wizard = """
                                ____\s
                              .'* *.'
                           __/_*_*(_
                          / _______ \\
                         _\\_)/___\\(_/_\s
                        / _((\\- -/))_ \\
                        \\ \\())(-)(()/ /
                         ' \\(((()))/ '
                        / ' \\)).))/ ' \\
                       / _ \\ - | - /_  \\
                      (   ( .;''';. .'  )
                      _\\"__ /    )\\ __"/_
                        \\/  \\   ' /  \\/
                         .'  '...' ' )
                          / /  |  \\ \\
                         / .   .   . \\
                        /   .     .   \\
                       /   /   |   \\   \\
                     .'   /    b    '.  '.
                 _.-'    /     Bb     '-. '-._\s
             _.-'       |      BBb       '-.  '-.\s
            (________mrf\\____.dBBBb.________)____)
            """;

    public CaveTile(){
        super("Cave");
    }

    @Override
    public void onEnter(Player player){

        System.out.println("You stand before a dark cave...");
        System.out.println("Do you want to enter?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");

        String choice = scanner.nextLine();

        if(!choice.equals("1")){
            System.out.println("You decide to stay away from the cave...");
            return; // exit without battle
        }

        System.out.println("You enter the cave...");
        //CaveAnimation.play();
        System.out.println(wizard);


        Enemy boss = EnemyFactory.createBossEnemy();
        boolean won = Battle.startBattle(player, boss);

        if(!won){
            System.out.println("Game Over.");
            System.exit(0);
        }

        // End Game Story
        System.out.println("Your memory returns...");
        System.out.println("You have defeated Erlich...");
        System.out.println("You win!");
        System.exit(0);
    }
}

