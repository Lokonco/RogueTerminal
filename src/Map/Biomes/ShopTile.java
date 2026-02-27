/*
package Map.Biomes;
import GameCharacters.Player;
import java.util.Scanner;

public class ShopTile extends Tile {
    private Scanner scanner = new Scanner(System.in);

    public ShopTile(){
        super("Shop");
    }

    @Override
    public void onEnter(Player player){

        System.out.println("You discover a traveling merchant.");
        System.out.println("\"Welcome, traveler...\"");

        boolean shopping = true;

        while(shopping){

            System.out.println("----------------------");
            System.out.println("Gold: " + player.getGold());
            System.out.println("1 - Buy Potion (25 gold)");
            System.out.println("2 - Upgrade Weapon (+5 dmg) (100 gold)");
            System.out.println("3 - Leave");
            System.out.println("----------------------");

            String choice = scanner.nextLine();

            switch(choice){

                case "1":
                    if(player.getGold() >= 25){
                        player.addGold(-25);
                        player.addPotion(1);
                        System.out.println("Potion purchased.");
                    } else {
                        System.out.println("Not enough gold.");
                    }
                    break;

                case "2":
                    if(player.getGold() >= 100){
                        player.addGold(-100);
                        player.upgradeWeapon(5);
                        System.out.println("Your weapon has been upgraded.");
                    } else {
                        System.out.println("Not enough gold.");
                    }
                    break;

                case "3":
                    shopping = false;
                    System.out.println("You leave the merchant.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
*/
//Add to player class
// public void addPotion(int amount){
//    potions += amount;}

//   public void upgradeWeapon(int amount){
//      setAttackDamage(getAttackDamage() + amount);
//}

//Add to character class
//protected void setAttackDamage(int attackDamage){
    //this.attackDamage = attackDamage;
//}