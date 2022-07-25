import project.Food;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Food.
 */
public class FoodTest {

  @Test
  public void testFoodEggs() {
    Food food = Food.EGGS;
    Assert.assertEquals(food, Food.EGGS);
    Assert.assertNotEquals(food, Food.FRUITS);
  }

  @Test
  public void testFoodLeaves() {
    Food food = Food.LEAVES;
    Assert.assertNotEquals(food, Food.EGGS);
    Assert.assertNotEquals(food, Food.FRUITS);
    Assert.assertNotEquals(food, Food.INSECTS);
    Assert.assertNotEquals(food, Food.NUTS);
    Assert.assertNotEquals(food, Food.SEEDS);
    Assert.assertNotEquals(food, Food.TREE_SAP);
    Assert.assertEquals(food, Food.LEAVES);
  }
}