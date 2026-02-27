package GameCharacters;
import java.util.Random;

public class EnemyFactory {
    private static Random random = new Random();

    public static Enemy createRandomEnemy(){
        int r = random.nextInt(4);

        return switch (r) {
            case 0 -> new Enemy("Goblin", 20, 5, 10);
            case 1 -> new Enemy("Feral Child", 20, 5, 10);
            case 2 -> new Enemy("A Hobo", 5, 1, 0);
            default -> new Enemy("Wizard", 20, 5, 10);
        };
    }

    public static Enemy createBossEnemy(){
        return new BossEnemy("Erlich the Boss", 100, 25, 1000);
    }
}
