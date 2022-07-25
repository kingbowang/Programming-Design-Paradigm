import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battle {
  private final Character firstPlayer;
  private final Character secondPlayer;
  private final List<AbstractGear> gearBags;
  private final List<Weapon> weapons;

  public Battle(Character playerOne, Character playerTwo) throws IllegalArgumentException {
    if (playerOne == null | playerTwo == null) {
      throw new IllegalArgumentException("Characters can't be null");
    }
    // set the max charisma is the first player
    if(playerOne.currentAbility().getCharisma() > playerTwo.currentAbility().getCharisma()) {
      firstPlayer = playerOne;
      secondPlayer = playerTwo;
    }else{
      firstPlayer = playerTwo;
      secondPlayer = playerOne;
    }
    gearBags = new ArrayList<>();
    weapons = new ArrayList<>();
  }

  /**
   * add gear to bag
   * @param gear
   */
  public void addBagGear(AbstractGear gear) {
    gearBags.add(gear);
  }

  /**
   * add new weapon
   * @param weapon
   */
  public void addWeapon(Weapon weapon){
    weapons.add(weapon);
  }

  /**
   * select gears and weapon
   */
  private void dressPlayer() {
    Random rand = new Random();
    for(int i = 0 ; i < 20; i ++){
      int which = rand.nextInt(gearBags.size());
      AbstractGear gear = gearBags.get(which);
      gearBags.remove(which);
      firstPlayer.equip(gear);
    }
    while (true) {
      int idx = rand.nextInt(weapons.size());
      if(weapons.get(idx).satisfyAbility(firstPlayer)) {
        firstPlayer.equipWeapon(weapons.get(idx));
        weapons.remove(idx);
        break;
      }
    }
    for(int i = 0 ; i < 20; i ++){
      int which = rand.nextInt(gearBags.size());
      AbstractGear gear = gearBags.get(which);
      gearBags.remove(which);
      secondPlayer.equip(gear);
    }
    while (true) {
      int idx = rand.nextInt(weapons.size());
      if(weapons.get(idx).satisfyAbility(secondPlayer)) {
        secondPlayer.equipWeapon(weapons.get(idx));
        weapons.remove(idx);
        break;
      }
    }
  }

  public void predict() {
    if(gearBags.size() < 40){
      throw new IllegalArgumentException("Bag Must have 40 gears");
    }
    dressPlayer();
    System.out.printf("player1: %s \n %s \n", firstPlayer.getName(), firstPlayer.toString());
    System.out.printf("player2: %s \n %s \n", secondPlayer.getName(), secondPlayer.toString());

    Character player1 = firstPlayer;
    Character player2 = secondPlayer;
    while (true) {
      Ability ability1 = player1.currentAbility();
      Ability ability2 = player2.currentAbility();
      Random random = new Random();
      int strikingPower = ability1.getStrength() + random.nextInt(10) + 1;
      int avoidance = ability2.getDexterity() + random.nextInt(6) + 1;
      System.out.printf("%s ready to attach %s.%n", player1.getName(), player2.getName());
      if(strikingPower > avoidance){
        int damage = ability1.getStrength() + player1.getWeaponAttack() - ability2.getConstitution();
        if(damage > 0){
          player2.addLossHealth(damage);
          System.out.printf("%s has attack %d damage.%n", player1.getName(), damage);
        }else{
          System.out.printf("%s has attack zero damage, because attack %d less than constitution %d.%n",
              player1.getName(), ability1.getStrength() + player1.getWeaponAttack(), ability2.getConstitution());
        }
      }else{
        System.out.printf("%s miss attach because of opposite's avoidance.%n", player1.getName());
      }

      if (player2.getLossHealth() >= ability2.getHealth()) {
        System.out.printf("%s has won the fight.%n", player1.getName());
        break;
      }
      Character tmp = player1;
      player1 = player2;
      player2 = tmp;
    }
  }

  public void resetPlayer(){
    firstPlayer.resetHealth(gearBags, weapons);
    secondPlayer.resetHealth(gearBags, weapons);
  }

}
