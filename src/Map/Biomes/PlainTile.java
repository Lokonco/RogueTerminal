package Map.Biomes;

import GameCharacters.Player;

public class PlainTile extends Tile {

    public PlainTile(){
        super("Plain");
    }

    @Override
    public void onEnter(Player player){
        System.out.println("The plains are quiet...");
    }
}
