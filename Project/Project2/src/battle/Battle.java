package battle;

import battle.ability.Ability;
import battle.gear.AbstractGear;
import battle.weapon.Weapon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Implement Battle class.
 * Set up the process of the battle.
 *
 * @author Pengbo Wang
 */
public class Battle {
  private final Character firstPlayer;
  private final Character secondPlayer;
  private List<AbstractGear> gearBags;
  private List<Weapon> weapons;
  private final List<AbstractGear> allGearBags;
  private final List<Weapon> allWeapons;

  /**
   * The constructor of Battle class.
   *
   * @param playerOne player one
   * @param playerTwo player two
   * @throws IllegalArgumentException if the characters are null
   */
  public Battle(Character playerOne, Character playerTwo) throws IllegalArgumentException {
    if (playerOne == null | playerTwo == null) {
      throw new IllegalArgumentException("Characters can't be null");
    }
    // set the higher charisma is the first player
    if (playerOne.getAbility().getCharisma() > playerTwo.getAbility().getCharisma()) {
      firstPlayer = playerOne;
      secondPlayer = playerTwo;
    } else {
      firstPlayer = playerTwo;
      secondPlayer = playerOne;
    }
    gearBags = new ArrayList<>();
    weapons = new ArrayList<>();
    allGearBags = new ArrayList<>();
    allWeapons = new ArrayList<>();
  }

  /**
   * Add gear to bag.
   *
   * @param gear gear
   */
  public void addBagGear(AbstractGear gear) {
    gearBags.add(gear);
    allGearBags.add(gear);
  }

  /**
   * Add new weapon.
   *
   * @param weapon weapon
   */
  public void addWeapon(Weapon weapon) {
    weapons.add(weapon);
    allWeapons.add(weapon);
  }

  /**
   * Select gears and weapon.
   */
  private void dressPlayer() {
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      int which = rand.nextInt(gearBags.size());
      AbstractGear gear = gearBags.get(which);
      gearBags.remove(which);
      firstPlayer.equip(gear);
    }
    while (true) {
      int idx = rand.nextInt(weapons.size());
      if (weapons.get(idx).satisfyAbility(firstPlayer)) {
        firstPlayer.equipWeapon(weapons.get(idx));
        weapons.remove(idx);
        break;
      }
    }
    for (int i = 0; i < 20; i++) {
      int which = rand.nextInt(gearBags.size());
      AbstractGear gear = gearBags.get(which);
      gearBags.remove(which);
      secondPlayer.equip(gear);
    }
    while (true) {
      int idx = rand.nextInt(weapons.size());
      if (weapons.get(idx).satisfyAbility(secondPlayer)) {
        secondPlayer.equipWeapon(weapons.get(idx));
        weapons.remove(idx);
        break;
      }
    }
  }

  /**
   * Predict the outcome of the battle.
   */
  public void predict() {
    if (gearBags.size() < 40) {
      throw new IllegalArgumentException("Bag Must have 40 gears");
    }
    Scanner scanner = new Scanner(System.in);
    while (true) {
      dressPlayer();
      System.out.printf("Battle Game\n\nplayer1: %s \n%s \n",
              firstPlayer.getName(), firstPlayer.toString());
      System.out.printf("\nplayer2: %s \n%s \n", secondPlayer.getName(), secondPlayer.toString());

      Character player1 = firstPlayer;
      Character player2 = secondPlayer;
      while (true) {
        Ability ability1 = player1.currentAbility();
        Ability ability2 = player2.currentAbility();
        Random random = new Random();
        int strikingPower = ability1.getStrength() + random.nextInt(10) + 1;
        int avoidance = ability2.getDexterity() + random.nextInt(6) + 1;
        System.out.printf("\n" + "%s is ready to attack %s.%n",
                player1.getName(), player2.getName());
        if (strikingPower > avoidance) {
          int damage = ability1.getStrength() + player1.getWeaponAttack()
                  - ability2.getConstitution();
          if (damage > 0) {
            player2.addLossHealth(damage);
            System.out.printf("%s has attacked %d damage.%n", player1.getName(), damage);
          } else {
            System.out.printf("%s has attacked zero damage, "
                            + "because attack %d is not greater than constitution %d.%n",
                    player1.getName(), ability1.getStrength()
                            + player1.getWeaponAttack(), ability2.getConstitution());
          }
        } else {
          System.out.printf("%s miss attack because of opposite's avoidance.%n", player1.getName());
        }

        if (player2.getLossHealth() >= ability2.getHealth()) {
          System.out.printf("%s has won the fight.%n", player1.getName());
          break;
        }
        Character tmp = player1;
        player1 = player2;
        player2 = tmp;
      }
      System.out.println("Nice Battle, Players now send to relax, "
              + "do you want to play again?(yes/no):");
      String command = scanner.nextLine();
      if (!command.equals("yes")) {
        break;
      }
      resetPlayer();
    }
  }

  /**
   * Reset the player.
   */
  public void resetPlayer() {
    gearBags = new ArrayList<>(allGearBags);
    weapons = new ArrayList<>(allWeapons);
    firstPlayer.resetHealth(gearBags, weapons);
    secondPlayer.resetHealth(gearBags, weapons);
  }

}
