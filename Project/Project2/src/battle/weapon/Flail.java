package battle.weapon;

import battle.Character;
import battle.ability.Ability;
import java.util.Random;

/**
 * Implement Flail class.
 * Flails are also great general weapons, but they can only be effectively wielded by players
 * with a dexterity greater than 14. They do 8-12 points of damage when they hit. If the player
 * does not have the dexterity to wield a flail, the flail only does half damage.
 *
 * @author Pengbo Wang
 */
public class Flail extends Weapon {
  // save hold character
  private Character character;

  public Flail(String gearsName, String gearsAdjective)
          throws IllegalArgumentException {
    super(gearsName, gearsAdjective, 8, 12);
  }

  @Override
  public boolean satisfyAbility(Character character) {
    if (character.getWeapons().size() == 0) {
      this.character = character;
      return true;
    }
    return false;
  }

  @Override
  public int getAttack() {
    Ability ability = character.currentAbility();
    Random random = new Random();
    int ratio = ability.getDexterity() < 14 ? 2 : 1;
    return (minAttack + random.nextInt(maxAttack - minAttack + 1)) / ratio;
  }
}
