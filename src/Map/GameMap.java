package Map;
import Map.Biomes.CaveTile;
import Map.Biomes.ForestTile;
import Map.Biomes.PlainTile;
import Map.Biomes.Tile;

public class GameMap {

    private Tile[][] gameMap = {
            { new ForestTile(), new PlainTile(), new ForestTile(), new ForestTile(), new ForestTile(), new CaveTile() },
            { new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile() },
            { new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile() },
            { new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile() },
            { new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile() },
            { new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile(), new ForestTile() }
    };

    private int x = 0;
    private int y = 0;

    public void move(String direction){
        switch (direction) {
            case "1" -> y = (y - 1 + gameMap.length) % gameMap.length;
            case "2" -> x = (x + 1) % gameMap[0].length;
            case "3" -> y = (y + 1) % gameMap.length;
            case "4" -> x = (x - 1 + gameMap[0].length) % gameMap[0].length;
        }
    }

    public Tile getCurrentTile(){
        return gameMap[y][x];
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
}
