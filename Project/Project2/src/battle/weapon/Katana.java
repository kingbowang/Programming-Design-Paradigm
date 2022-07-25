package battle.weapon;

import battle.Character;

/**
 * Implement Katana class.
 * Katanas are lightweight curved swords that come in pairs.
 * They can do a base of 4-6 points of damage when they hit.
 * They are so light that a player can carry two of them (which attack separately).
 *
 * @author Pengbo Wang
 */
public class Katana extends Weapon {

  public Katana(String gearsName, String gearsAdjective) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, 4, 6);
  }

  @Override
  public boolean satisfyAbility(Character character) {
    return character.getWeapons().size() == 0 || (
            character.getWeapons().size() == 1 && character.getWeapons().get(0) instanceof Katana
      );
  }
}
