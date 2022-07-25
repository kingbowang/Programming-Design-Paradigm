package utils;

/**
 * Implement Position class to describe the position in the dungeon.
 *
 * @author Pengbo Wang
 */
public class Position {
  public int row;
  public int col;

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
   * Calculate the distance.
   *
   * @param position position
   * @return the distance
   */
  public int getDistance(Position position) {
    return (int) Math.abs((double) ((this.col - position.col) + (this.row - position.row)));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position)) {
      return false;
    }
    Position op = (Position) o;
    return op.row == row && op.col == col;
  }

  @Override
  public int hashCode() {
    return (row * 31 + col) * 31;
  }

}
