package battle.weapon;

import battle.Character;

/**
 * Implement Broadsword class.
 * Broadswords are a good medium weapon that can do 6-10 points of damage when they hit.
 *
 * @author Pengbo Wang
 */
public class Broadsword extends Weapon {

  public Broadsword(String gearsName, String gearsAdjective)
          throws IllegalArgumentException {
    super(gearsName, gearsAdjective, 6, 10);
  }

  @Override
  public boolean satisfyAbility(Character character) {
    return character.getWeapons().size() == 0;
  }
}