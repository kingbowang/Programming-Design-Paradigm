import java.util.ArrayList;
import java.util.List;

import project.Food;
import project.Enclosure;
import project.Isolation;
import project.Monkey;
import project.Sanctuary;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for Sanctuary. Verifying that Sanctuary state is properly managed, and all Sanctuary
 * actions are properly validated.
 */
public class SanctuaryTest {

  @Test
  public void testSanctuaryMonkey() {
    Isolation isolation = new Isolation(10);
    List<Enclosure> enclosures = new ArrayList<>();
    Enclosure e1 = new Enclosure("drill", 100);
    Enclosure e2 = new Enclosure("guereza", 100);
    Enclosure e3 = new Enclosure("howler", 100);
    enclosures.add(e1);
    enclosures.add(e2);

    Sanctuary sanctuary = new Sanctuary(isolation, enclosures);

    Monkey m1 = new Monkey("drill");
    Monkey m2 = new Monkey("guereza");
    Monkey m3 = new Monkey("howler");
    Monkey m4 = new Monkey("drill");
    sanctuary.addMonkey(m1);
    sanctuary.addMonkey(m2);
    sanctuary.addMonkey(m3);
    sanctuary.addMonkey(m4);

    m1.setAttention("Allan", "male", 10, 10, 5, Food.EGGS);
    sanctuary.removeMonkey(m1);
    sanctuary.addMonkey(m1);

    m2.setAttention("James", "female", 10, 10, 5, Food.FRUITS);
    sanctuary.removeMonkey(m2);
    sanctuary.addMonkey(m2);

    Assert.assertEquals(sanctuary.getIsolation(), isolation);
    Assert.assertEquals(sanctuary.getEnclosures().size(), 2);

    Assert.assertTrue(sanctuary.addEnclosure(e3));
  }
}