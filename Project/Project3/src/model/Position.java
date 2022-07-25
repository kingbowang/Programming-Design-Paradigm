package model;

/**
 * Implement a Position class.
 * Describe position by row and column.
 *
 * @author Pengbo Wang
 */
public class Position {
  public int col;
  public int row;

  /**
   * The constructor of the Position class.
   *
   * @param row rows in the dungeon
   * @param col columns in the dungeon
   * @throws IllegalArgumentException if the row is negative
   * @throws IllegalArgumentException if the column is negative
   */
  public Position(int row, int col) throws IllegalArgumentException {
    if (row < 0) {
      throw new IllegalArgumentException("Negative row is not supported.");
    }
    if (col < 0) {
      throw new IllegalArgumentException("Negative column is not supported.");
    }
    this.row = row;
    this.col = col;
  }

  /**
   * Construct a method to calculate the distance between two positions.
   *
   * @param position the position of the cave or tunnel
   * @return the distance between two positions
   */
  public int getDistance(Position position) {
    return (int) Math.abs((double) ((this.col - position.col) + (this.row - position.row)));
  }

}
