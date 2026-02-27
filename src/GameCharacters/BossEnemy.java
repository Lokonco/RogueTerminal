package GameCharacters;

public class BossEnemy extends Enemy{

    public BossEnemy(String name, int Health, int AttackDamage, int goldReward){
        super(name, Health, AttackDamage, goldReward);
    }

    @Override
    public void takeDamage(int damage){
        int reducedDamage = damage / 2;
        super.takeDamage((reducedDamage));
        System.out.println("The boss resisted some damage");
    }
}