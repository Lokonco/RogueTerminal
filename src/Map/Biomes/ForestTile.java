package Map.Biomes;
import GameCharacters.Enemy;
import GameCharacters.EnemyFactory;
import GameCharacters.Player;
import GameLogic.Battle;
import java.util.Random;

public class ForestTile extends Tile {
    private Random random = new Random();

    public ForestTile(){
        super("Forest");
    }

    @Override
    public void onEnter(Player player){

        if(random.nextInt(100) < 30){

            System.out.println("A wild enemy appears!");

            Enemy enemy = EnemyFactory.createRandomEnemy();
            boolean won = Battle.startBattle(player, enemy);

            if(!won){
                System.out.println("Game Over.");
                System.exit(0);
            }
        }
    }
}