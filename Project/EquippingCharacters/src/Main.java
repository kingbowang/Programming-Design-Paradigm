import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Character playerOne = new Character("Abdul");
        Character playerTwo = new Character("Vic");
        Battle fight = new Battle(playerOne,playerTwo);
        // Head gears
        Ability ability = new Ability(0,3,0,0);
        AbstractGear head = new HeadGear("Helm", "Flight", ability);
        ability = new Ability(0,4,0,0);
        AbstractGear headTwo = new HeadGear("Mask", "rock", ability);
        ability = new Ability(0,5,0,0);
        AbstractGear headThree = new HeadGear("Headband", "Flame", ability);
        ability = new Ability(0,-3,0,0);
        AbstractGear headFour = new HeadGear("Cap", "Healing", ability);
        ability = new Ability(0,-5,0,0);
        AbstractGear headFive = new HeadGear("Balaclava", "Speed", ability);
        fight.addBagGear(head);
        fight.addBagGear(headTwo);
        fight.addBagGear(headThree);
        fight.addBagGear(headFour);
        fight.addBagGear(headFive);

        // Foot gears
        ability = new Ability(0,0,2,0);
        AbstractGear foot = new FootGear("Boots", "Electricity", ability);
        ability = new Ability(0,0,3,0);
        AbstractGear footTwo = new FootGear("slipper", "fire", ability);
        ability = new Ability(0,0,3,0);
        AbstractGear footThree = new FootGear("slides", "water", ability);
        ability = new Ability(0,0,-3,0);
        AbstractGear footFour = new FootGear("Shoes", "Magic", ability);
        ability = new Ability(0,0,-1,0);
        AbstractGear footFive = new FootGear("Sneaker", "Ruin", ability);
        fight.addBagGear(foot);
        fight.addBagGear(footTwo);
        fight.addBagGear(footThree);
        fight.addBagGear(footFour);
        fight.addBagGear(footFive);

        // potion gears
        ability = new Ability(2,0,2,0);
        AbstractGear potion1 = new PotionGear("Ring", "Shock", ability);
        ability = new Ability(3,2,1,0);
        AbstractGear potion2 = new PotionGear("Signet", "Speed", ability);
        ability = new Ability(0,10,0,0);
        AbstractGear potion3 = new PotionGear("Glove", "Speed", ability);
        ability = new Ability(0,0,1,0);
        AbstractGear potion4 = new PotionGear("BrassKnuckles", "Healing", ability);
        ability = new Ability(0,0,-2,0);
        AbstractGear potion5 = new PotionGear("Gauntlet", "Flame", ability);
        ability = new Ability(0,-5,0,0);
        AbstractGear potion6 = new PotionGear("Watch", "Escape", ability);
        ability = new Ability(0,0,0,2);
        AbstractGear potion7 = new PotionGear("Bracelet", "Ruin", ability);
        ability = new Ability(5,0,1,0);
        AbstractGear potion8 = new PotionGear("Nail knife", "Telepathy", ability);
        ability = new Ability(0,3,0,0);
        AbstractGear potion9 = new PotionGear("mitten ", "Strength", ability);
        ability = new Ability(0,0,-1,0);
        AbstractGear potion10 = new PotionGear("bangle", "Ice", ability);
        ability = new Ability(0,-2,0,0);
        AbstractGear potion11 = new PotionGear("Fit Band ", "Wind", ability);
        ability = new Ability(0,5,0,0);
        AbstractGear potion12 = new PotionGear("Knuckle Duster", "Explosion", ability);
        ability = new Ability(5,0,0,0);
        AbstractGear potion13 = new PotionGear("Bracelet", "Ruin", ability);
        ability = new Ability(0,20,0,0);
        AbstractGear potion14 = new PotionGear("Nail knife", "Telepathy", ability);
        ability = new Ability(0,0,0,2);
        AbstractGear potion15 = new PotionGear("mitten ", "Strength", ability);
        ability = new Ability(0,0,1,0);
        AbstractGear potion16 = new PotionGear("bangle", "Ice", ability);
        ability = new Ability(0,0,3,0);
        AbstractGear potion17 = new PotionGear("Fit Band ", "Wind", ability);
        ability = new Ability(0,0,1,0);
        AbstractGear potion18 = new PotionGear("Knuckle Duster", "Explosion", ability);
        ability = new Ability(0,0,2,0);
        AbstractGear potion19 = new PotionGear("Potion Band ", "Wind", ability);
        ability = new Ability(0,0,3,0);
        AbstractGear potion20 = new PotionGear("Potion Duster", "Explosion", ability);
        fight.addBagGear(potion1);
        fight.addBagGear(potion2);
        fight.addBagGear(potion3);
        fight.addBagGear(potion4);
        fight.addBagGear(potion5);
        fight.addBagGear(potion6);
        fight.addBagGear(potion7);
        fight.addBagGear(potion8);
        fight.addBagGear(potion9);
        fight.addBagGear(potion10);
        fight.addBagGear(potion11);
        fight.addBagGear(potion12);
        fight.addBagGear(potion13);
        fight.addBagGear(potion14);
        fight.addBagGear(potion15);
        fight.addBagGear(potion16);
        fight.addBagGear(potion17);
        fight.addBagGear(potion18);
        fight.addBagGear(potion19);
        fight.addBagGear(potion20);

        // belt gears
        ability = new Ability(2,0,2,0);
        AbstractGear beltGear1 = new BeltGear("Amulet", "Heft", ability, BeltType.SMALL);
        ability = new Ability(10,0,1,0);
        AbstractGear beltGear2 = new BeltGear("Necklace", "Invincibility", ability, BeltType.LARGE);
        ability = new Ability(2,3,0,0);
        AbstractGear beltGear3 = new BeltGear("Scarab", "Flight", ability, BeltType.MEDIUM);
        ability = new Ability(-2,0,-2,0);
        AbstractGear beltGear4 = new BeltGear("Collar", "Electricity", ability, BeltType.SMALL);
        ability = new Ability(2,0,3,0);
        AbstractGear beltGear5 = new BeltGear("Brooch", "Speed", ability, BeltType.SMALL);
        ability = new Ability(2,0,2,0);
        AbstractGear beltGear6 = new BeltGear("Ribbon", "Swimming", ability, BeltType.SMALL);
        ability = new Ability(2,0,1,0);
        AbstractGear beltGear7 = new BeltGear("BowTie", "Drunkenness", ability, BeltType.SMALL);
        ability = new Ability(2,0,1,0);
        AbstractGear beltGear8 = new BeltGear("Chain", "Sight", ability, BeltType.SMALL);
        ability = new Ability(2,0,1,0);
        AbstractGear beltGear9 = new BeltGear("Pendant", "Healing", ability, BeltType.SMALL);
        ability = new Ability(10,0,1,0);
        AbstractGear beltGear10 = new BeltGear("chain", "Sleep", ability, BeltType.SMALL);
        ability = new Ability(2,0,2,0);
        AbstractGear beltGear11 = new BeltGear("Amulet", "Magic", ability, BeltType.SMALL);
        ability = new Ability(10,0,3,0);
        AbstractGear beltGear12 = new BeltGear("Necklace", "Flame", ability, BeltType.SMALL);
        ability = new Ability(2,0,3,0);
        AbstractGear beltGear13 = new BeltGear("chain", "Burning", ability, BeltType.SMALL);
        ability = new Ability(5,0,3,0);
        AbstractGear beltGear14 = new BeltGear("Scarab", "Escape", ability, BeltType.SMALL);
        ability = new Ability(2,0,3,0);
        AbstractGear beltGear15 = new BeltGear("Collar", "Ruin", ability, BeltType.SMALL);
        ability = new Ability(2,0,3,0);
        AbstractGear beltGear16 = new BeltGear("Brooch", "Telepathy", ability, BeltType.SMALL);
        ability = new Ability(2,0,3,0);
        AbstractGear beltGear17 = new BeltGear("Ribbon", "Teleportation", ability, BeltType.SMALL);
        ability = new Ability(2,0,5,0);
        AbstractGear beltGear18 = new BeltGear("BowTie", "Strength", ability, BeltType.MEDIUM);
        ability = new Ability(0,5,5,0);
        AbstractGear beltGear19 = new BeltGear("Chain", "Explosion", ability, BeltType.LARGE);
        ability = new Ability(0,5,1,0);
        AbstractGear beltGear20 = new BeltGear("Pendant", "Ice", ability, BeltType.SMALL);
        fight.addBagGear(beltGear1);
        fight.addBagGear(beltGear2);
        fight.addBagGear(beltGear3);
        fight.addBagGear(beltGear4);
        fight.addBagGear(beltGear5);
        fight.addBagGear(beltGear6);
        fight.addBagGear(beltGear7);
        fight.addBagGear(beltGear8);
        fight.addBagGear(beltGear9);
        fight.addBagGear(beltGear10);
        fight.addBagGear(beltGear11);
        fight.addBagGear(beltGear12);
        fight.addBagGear(beltGear13);
        fight.addBagGear(beltGear14);
        fight.addBagGear(beltGear15);
        fight.addBagGear(beltGear16);
        fight.addBagGear(beltGear17);
        fight.addBagGear(beltGear18);
        fight.addBagGear(beltGear19);
        fight.addBagGear(beltGear20);

        Weapon weapon1 = new Katana("katana kill", "kill forever");
        fight.addWeapon(weapon1);
        Weapon weapon2 = new Broadsword("Broadswords kill", "kill forever");
        fight.addWeapon(weapon2);
        Weapon weapon3 = new TwohandedSword("Two-handed swords", "kill enemy");
        fight.addWeapon(weapon3);
        Weapon weapon4 = new Axes("Axes kill", "kill forever");
        fight.addWeapon(weapon4);
        Weapon weapon5 = new Flail("Flails kill", "kill forever");
        fight.addWeapon(weapon5);
        Weapon weapon6 = new Axes("Axes kill2", "kill");
        fight.addWeapon(weapon6);

        // predict the battle
        Scanner scanner = new Scanner(System.in);
        while (true) {
            fight.predict();
            fight.resetPlayer();
            System.out.println("Nice Battle, Players now send to relax, do you want to play again?(yes/no):");
            String command = scanner.nextLine();
            if(!command.equals("yes")){
                break;
            }
        }
    }
}
