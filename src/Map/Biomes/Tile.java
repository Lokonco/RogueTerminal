package Map.Biomes;
import GameCharacters.Player;

public abstract class Tile {
    protected String name;

    public Tile(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void onEnter(Player player);

    @Override
    public String toString(){
        return name;
    }
}