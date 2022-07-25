package project;

import java.util.Objects;

/**
 * Monkey class.
 */
public final class Monkey {
  // monkey's attributes
  private String name;
  private final String species;
  private String sex;
  private int size;
  private int weight;
  private int age;
  private Food food;

  //if is a new monkey
  private boolean isnew;

  /**
   * Monkey construct.
   *
   * @param species species
   */
  public Monkey(String species) {
    this.species = species;
    isnew = true;
  }

  /**
   * Set monkey attention.
   *
   * @param name   name
   * @param sex    sex
   * @param size   size
   * @param weight weight
   * @param age    age
   * @param food   food
   */
  public void setAttention(String name, String sex, int size, int weight, int age, Food food) {
    isnew = false;
    this.name = name;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.food = food;
  }

  /**
   * Getter.
   *
   * @return isnew
   */
  public boolean getAttention() {
    return !isnew;
  }

  /**
   * Getter.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Getter.
   *
   * @return species
   */
  public String getSpecies() {
    return species;
  }

  /**
   * Getter.
   *
   * @return sex
   */
  public String getSex() {
    return sex;
  }

  /**
   * Getter.
   *
   * @return size
   */
  public int getSize() {
    return size;
  }

  /**
   * Getter.
   *
   * @return weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Getter.
   *
   * @return age
   */
  public int getAge() {
    return age;
  }

  /**
   * Getter.
   *
   * @return food
   */
  public Food getFood() {
    return food;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Monkey monkey = (Monkey) o;
    return getSize() == monkey.getSize()
            && getWeight() == monkey.getWeight()
            && getAge() == monkey.getAge()
            && isnew == monkey.isnew
            && getName().equals(monkey.getName())
            && getSpecies().equals(monkey.getSpecies())
            && Objects.equals(getSex(), monkey.getSex())
            && getFood() == monkey.getFood();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getSpecies(), getSex(),
            getSize(), getWeight(), getAge(), getFood(), isnew);
  }
}
