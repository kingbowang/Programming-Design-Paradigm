package battle.weapon;

import battle.Character;
import battle.ability.Ability;
import java.util.Random;

/**
 * Implement Two-handed swords.
 * Two-handed swords are a heavy sword that can only be effectively wielded by players with
 * strength greater than 14, but they can do 8-12 points of damage when they hit.
 * If the player does not have the strength to wield a two-handed sword,
 * the sword only does half damage.
 *
 * @author Pengbo Wang
 */
public class TwoHandedSword extends Weapon {
  // save hold character
  private Character character;

  public TwoHandedSword(String gearsName, String gearsAdjective)
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
    int ratio = ability.getStrength() < 14 ? 2 : 1;
    return (minAttack + random.nextInt(maxAttack - minAttack + 1)) / ratio;
  }
}
