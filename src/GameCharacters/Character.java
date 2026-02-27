package GameCharacters;

public abstract class Character{
    protected String name;
    protected int Health;
    protected int AttackDamage;

    public Character(String name, int Health, int AttackDamage){
        this.name = name;
        this.Health = Health;
        this.AttackDamage = AttackDamage;
    }

    //-------Methods for the character class-------//
    public void takeDamage(int damage){
        Health -= damage;
    }

    public boolean isAlive(){
        return (Health > 0);
    }
    //----------------------------------------------//

    //-------Getters----------//
    public String getName(){
        return name;
    }

    public int getHealth(){
        return Health;
    }

    public int getAttackDamage(){
        return AttackDamage;
    }
    //-------------------------//

    @Override
    public String toString(){
        return "Name: " + name + " Health: " + Health + " AtkDamage " + AttackDamage;
    }
}
