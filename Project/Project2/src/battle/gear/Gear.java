package battle.gear;

/**
 * This is a gear interface.
 *
 * @author Pengbo Wang
 */
public interface Gear extends Comparable<Gear> {

  /**
   * Returns the name of the gear.
   *
   * @return name
   */
  String getName();

  /**
   * Returns the adjective of the gear.
   *
   * @return adjective
   */
  String getAdjective();

}
