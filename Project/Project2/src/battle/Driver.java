package battle;

import battle.ability.Ability;
import battle.gear.AbstractGear;
import battle.gear.BeltGear;
import battle.gear.BeltType;
import battle.gear.FootGear;
import battle.gear.HeadGear;
import battle.gear.PotionGear;
import battle.weapon.Axes;
import battle.weapon.Broadsword;
import battle.weapon.Flail;
import battle.weapon.Katana;
import battle.weapon.TwoHandedSword;
import battle.weapon.Weapon;

/**
 * Implement Driver class.
 * Running project 2 - Battle.
 *
 * @author Pengbo Wang
 */
public class Driver {

  /**
   * The constructor of the Driver class.
   *
   * @param args args
   */
  public static void main(String[] args) {
    Character playerOne = new Character("Abdul");
    Character playerTwo = new Character("Vic");
    Battle fight = new Battle(playerOne, playerTwo);
    // Head gears
    Ability ability = new Ability(0, 3, 0, 0);
    AbstractGear head = new HeadGear("Helm", "Flight", ability);
    ability = new Ability(0, 4, 0, 0);
    AbstractGear headTwo = new HeadGear("Mask", "Rock", ability);
    ability = new Ability(0, 5, 0, 0);
    AbstractGear headThree = new HeadGear("Headband", "Flame", ability);
    ability = new Ability(0, -4, 0, 0);
    AbstractGear headFour = new HeadGear("Hat", "Devil", ability);
    ability = new Ability(0, 6, 0, 0);
    AbstractGear headFive = new HeadGear("Balaclava", "Speed", ability);
    fight.addBagGear(head);
    fight.addBagGear(headTwo);
    fight.addBagGear(headThree);
    fight.addBagGear(headFour);
    fight.addBagGear(headFive);

    // Foot gears
    ability = new Ability(0, 0, 2, 0);
    AbstractGear foot = new FootGear("Boots", "Electricity", ability);
    ability = new Ability(0, 0, 3, 0);
    AbstractGear footTwo = new FootGear("Slipper", "Fire", ability);
    ability = new Ability(0, 0, 3, 0);
    AbstractGear footThree = new FootGear("Slides", "Water", ability);
    ability = new Ability(0, 0, -3, 0);
    AbstractGear footFour = new FootGear("Shoes", "Doom", ability);
    ability = new Ability(0, 0, 4, 0);
    AbstractGear footFive = new FootGear("Sneakers", "Ruin", ability);
    fight.addBagGear(foot);
    fight.addBagGear(footTwo);
    fight.addBagGear(footThree);
    fight.addBagGear(footFour);
    fight.addBagGear(footFive);

    // Potion gears
    ability = new Ability(2, 0, 2, 0);
    AbstractGear potion1 = new PotionGear("Water", "Power", ability);
    ability = new Ability(2, 2, 1, 1);
    AbstractGear potion2 = new PotionGear("Water", "Flame", ability);
    ability = new Ability(5, 8, 0, 3);
    AbstractGear potion3 = new PotionGear("Water", "King", ability);
    ability = new Ability(2, 1, 3, 1);
    AbstractGear potion4 = new PotionGear("Water", "Healing", ability);
    ability = new Ability(-1, 0, -2, 0);
    AbstractGear potion5 = new PotionGear("Water", "Escape", ability);
    ability = new Ability(-3, -5, 0, -3);
    AbstractGear potion6 = new PotionGear("Water", "Devil", ability);
    ability = new Ability(4, 0, 2, 2);
    AbstractGear potion7 = new PotionGear("Water", "Justice", ability);
    ability = new Ability(2, 0, 1, 0);
    AbstractGear potion8 = new PotionGear("Water", "Telepathy", ability);
    ability = new Ability(3, 3, 1, 3);
    AbstractGear potion9 = new PotionGear("Water", "Strength", ability);
    ability = new Ability(6, 0, 1, 2);
    AbstractGear potion10 = new PotionGear("Water", "Kill", ability);
    ability = new Ability(-2, -2, 0, -2);
    AbstractGear potion11 = new PotionGear("Potion", "Doom", ability);
    ability = new Ability(3, 5, 0, 0);
    AbstractGear potion12 = new PotionGear("Potion", "Holy", ability);
    ability = new Ability(5, 0, 0, 2);
    AbstractGear potion13 = new PotionGear("Potion", "Ruin", ability);
    ability = new Ability(3, 10, 0, 3);
    AbstractGear potion14 = new PotionGear("Potion", "Telepathy", ability);
    ability = new Ability(2, 0, 0, 2);
    AbstractGear potion15 = new PotionGear("Potion", "Strength", ability);
    ability = new Ability(-6, 0, -4, 0);
    AbstractGear potion16 = new PotionGear("Potion", "Punishment", ability);
    ability = new Ability(3, 0, 3, 6);
    AbstractGear potion17 = new PotionGear("Potion", "Flame", ability);
    ability = new Ability(9, 0, 1, 3);
    AbstractGear potion18 = new PotionGear("Potion", "Explosion", ability);
    ability = new Ability(-3, 0, -2, -1);
    AbstractGear potion19 = new PotionGear("Potion", "Fake", ability);
    ability = new Ability(3, 3, 1, 0);
    AbstractGear potion20 = new PotionGear("Potion", "Healing", ability);
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

    // Belt gears
    ability = new Ability(0, 9, 8, 0);
    AbstractGear beltGear1 = new BeltGear("Belt", "Heft", ability, BeltType.LARGE);
    ability = new Ability(10, 0, 5, 0);
    AbstractGear beltGear2 = new BeltGear("Belt", "King", ability, BeltType.LARGE);
    ability = new Ability(0, 8, 0, 10);
    AbstractGear beltGear19 = new BeltGear("Belt", "Explosion", ability, BeltType.LARGE);
    ability = new Ability(0, 3, 0, 8);
    AbstractGear beltGear3 = new BeltGear("Belt", "Flight", ability, BeltType.MEDIUM);
    ability = new Ability(5, 0, 5, 0);
    AbstractGear beltGear18 = new BeltGear("Belt", "Strength", ability, BeltType.MEDIUM);
    ability = new Ability(0, 6, 5, 0);
    AbstractGear beltGear5 = new BeltGear("Belt", "Speed", ability, BeltType.MEDIUM);
    ability = new Ability(-2, 0, -2, 0);
    AbstractGear beltGear4 = new BeltGear("Belt", "Fake", ability, BeltType.SMALL);
    ability = new Ability(0, 2, 0, 2);
    AbstractGear beltGear6 = new BeltGear("Belt", "Water", ability, BeltType.SMALL);
    ability = new Ability(-2, 0, -1, 0);
    AbstractGear beltGear7 = new BeltGear("Belt", "Drunkenness", ability, BeltType.SMALL);
    ability = new Ability(0, 3, 1, 0);
    AbstractGear beltGear8 = new BeltGear("Belt", "Sight", ability, BeltType.SMALL);
    ability = new Ability(2, 0, 0, 3);
    AbstractGear beltGear9 = new BeltGear("Belt", "Healing", ability, BeltType.SMALL);
    ability = new Ability(4, 1, 0, 0);
    AbstractGear beltGear10 = new BeltGear("Belt", "Justice", ability, BeltType.SMALL);
    ability = new Ability(0, 0, 2, 2);
    AbstractGear beltGear11 = new BeltGear("Belt", "Magic", ability, BeltType.SMALL);
    ability = new Ability(5, 0, 3, 0);
    AbstractGear beltGear12 = new BeltGear("Belt", "Flame", ability, BeltType.SMALL);
    ability = new Ability(0, 3, 3, 0);
    AbstractGear beltGear13 = new BeltGear("Belt", "Burning", ability, BeltType.SMALL);
    ability = new Ability(-3, 0, -4, 0);
    AbstractGear beltGear14 = new BeltGear("Belt", "Escape", ability, BeltType.SMALL);
    ability = new Ability(2, 0, 3, 0);
    AbstractGear beltGear15 = new BeltGear("Belt", "Kill", ability, BeltType.SMALL);
    ability = new Ability(-2, 0, -3, 0);
    AbstractGear beltGear16 = new BeltGear("Belt", "Devil", ability, BeltType.SMALL);
    ability = new Ability(-2, -3, 0, 0);
    AbstractGear beltGear17 = new BeltGear("Belt", "Doom", ability, BeltType.SMALL);
    ability = new Ability(0, 3, 0, 2);
    AbstractGear beltGear20 = new BeltGear("Belt", "Ice", ability, BeltType.SMALL);
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

    Weapon weapon1 = new Katana("Katana", "Ice");
    fight.addWeapon(weapon1);
    Weapon weapon2 = new Broadsword("Broadsword", "Water");
    fight.addWeapon(weapon2);
    Weapon weapon3 = new TwoHandedSword("Two-handed sword", "Poison");
    fight.addWeapon(weapon3);
    Weapon weapon4 = new Axes("Axe", "Flame");
    fight.addWeapon(weapon4);
    Weapon weapon5 = new Flail("Flail", "Sleep");
    fight.addWeapon(weapon5);
    Weapon weapon6 = new Axes("Axe", "Light");
    fight.addWeapon(weapon6);

    // predict the battle
    fight.predict();
  }
}
