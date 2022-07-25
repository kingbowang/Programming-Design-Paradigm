package battle.weapon;

import battle.Character;

/**
 * Implement Axes class.
 * Axes are great general weapons doing 6-10 points of damage when they hit.
 *
 * @author Pengbo Wang
 */
public class Axes extends Weapon {

  public Axes(String gearsName, String gearsAdjective)
          throws IllegalArgumentException {
    super(gearsName, gearsAdjective, 6, 10);
  }

  @Override
  public boolean satisfyAbility(Character character) {
    return character.getWeapons().size() == 0;
  }
}
