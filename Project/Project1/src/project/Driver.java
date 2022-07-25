package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Driver Class.
 *
 * @author Pengbo Wang
 * @date 2021-09-30
 */
public class Driver {
  // Species drill, guereza, howler, mangabey, saki, spider, squirrel, and tamarin

  /**
   * Main method to driver the system.
   *
   * @param args args
   */
  public static void main(String[] args) {

    // The Sanctuary should start with room for n animals in isolation and m troops of monkeys.
    // While these are defined when the Sanctuary is constructed, the Sanctuary would like the
    // flexibility of expanding should the needs and funds allow.
    Isolation isolation = new Isolation(10);
    List<Enclosure> enclosures = new ArrayList<>();
    Enclosure e1 = new Enclosure("drill", 100);
    Enclosure e2 = new Enclosure("guereza", 100);
    Enclosure e3 = new Enclosure("howler", 100);
    enclosures.add(e1);
    enclosures.add(e2);
    enclosures.add(e3);

    Sanctuary sanctuary = new Sanctuary(isolation, enclosures);

    Monkey m1 = new Monkey("drill");
    Monkey m2 = new Monkey("guereza");
    Monkey m3 = new Monkey("howler");
    Monkey m4 = new Monkey("drill");
    sanctuary.addMonkey(m1);
    sanctuary.addMonkey(m2);
    sanctuary.addMonkey(m3);
    sanctuary.addMonkey(m4);

    m1.setAttention("Kevin", "male", 21, 12, 6, Food.EGGS);
    sanctuary.removeMonkey(m1);
    sanctuary.addMonkey(m1);

    m2.setAttention("Corinna", "female", 15, 14, 4, Food.FRUITS);
    sanctuary.removeMonkey(m2);
    sanctuary.addMonkey(m2);

    m3.setAttention("Peter", "male", 9, 6, 1, Food.TREE_SAP);
    sanctuary.removeMonkey(m3);
    sanctuary.addMonkey(m3);

    //Report the species that are currently being housed in alphabetical order. The list should
    //include where in the sanctuary each species is (both in enclosures and in isolation).
    Map<String, Set<String>> monkeyHouses = new HashMap<>();
    for (Monkey m : sanctuary.getIsolation().getMonkeys()) {
      monkeyHouses.put(m.getSpecies(), new HashSet<>());
      monkeyHouses.get(m.getSpecies()).add("Isolation");
    }
    for (Enclosure enclosure : enclosures) {
      for (Monkey m : enclosure.getMonkeys()) {
        if (!monkeyHouses.containsKey(m.getSpecies())) {
          monkeyHouses.put(m.getSpecies(), new HashSet<>());
        }
        monkeyHouses.get(m.getSpecies()).add("Enclosure");
      }
    }
    List<String> specie = new ArrayList<>(monkeyHouses.keySet());
    specie.sort(String::compareTo);
    for (String sp : specie) {
      System.out.println("----------------");
      System.out.println("Species: " + sp);
      System.out.println("housed in " + String.join(" and ", monkeyHouses.get(sp)));
      System.out.println("----------------");
    }

    //Look up where a particular species is currently housed. If none of a particular species is
    //currently being housed, it should report this fact.
    System.out.println("#########################");
    String species = "guereza";
    System.out.println("test species exist: " + species);
    boolean exist = false;
    for (Monkey m : isolation.getMonkeys()) {
      if (m.getSpecies().equals(species)) {
        exist = true;
        break;
      }
    }
    for (Enclosure enclosure : enclosures) {
      if (enclosure.getMonkeys().size() > 0 && enclosure.getSpecies().equals(species)) {
        exist = true;
        break;
      }
    }
    System.out.println(species + " exist " + exist);

    System.out.println("#########################");


    //Produce a sign for a given enclosure that lists each individual monkey that is currently
    //housed there. For each individual monkey, the sign should include their name, sex, and
    //favorite food.
    for (Enclosure enclosure : enclosures) {
      System.out.println("Enclosure: ");
      for (Monkey m : enclosure.getMonkeys()) {
        System.out.println(String.format("name: %s  sex: %s  favorite food:%s",
                m.getName(), m.getSex(), m.getFood().toString()));
        System.out.println("----------------");
      }
    }
    System.out.println("#########################");

    //Produce an alphabetical list (by name) of all of the monkeys housed in the Sanctuary. This
    //information should include where each monkey can be found.
    monkeyHouses = new HashMap<>();
    for (Monkey m : sanctuary.getIsolation().getMonkeys()) {
      String name = "Undefine";
      monkeyHouses.put(name, new HashSet<>());
      monkeyHouses.get(name).add("Isolation");
    }
    for (Enclosure enclosure : enclosures) {
      for (Monkey m : enclosure.getMonkeys()) {
        if (!monkeyHouses.containsKey(m.getSpecies())) {
          monkeyHouses.put(m.getSpecies(), new HashSet<>());
        }
        monkeyHouses.get(m.getSpecies()).add("Enclosure");
      }
    }
    specie = new ArrayList<>(monkeyHouses.keySet());
    specie.sort(String::compareTo);
    for (String sp : specie) {
      System.out.println("----------------");
      System.out.println("Species: " + sp);
      System.out.println("housed in " + String.join(",", monkeyHouses.get(sp)));
      System.out.println("----------------");
    }


    //Produce a shopping list of the favorite foods of the inhabitants of the Sanctuary. For each
    //food listed, the quantity needed should also be listed. Large monkeys should receive 500 gr
    //of their favorite food while medium and small monkeys require 250 gr and 100 gr respectively.
    System.out.println("#########################");
    Map<String, Integer> foodSize = new HashMap<>();
    for (Enclosure enclosure : enclosures) {
      for (Monkey m : enclosure.getMonkeys()) {
        String food = m.getFood().toString();
        if (m.getSize() < 10) {
          foodSize.put(food, foodSize.getOrDefault(food, 0) + 100);
        } else if (m.getSize() < 20) {
          foodSize.put(food, foodSize.getOrDefault(food, 0) + 250);
        } else {
          foodSize.put(food, foodSize.getOrDefault(food, 0) + 500);
        }
      }
    }

    for (String food : foodSize.keySet()) {
      System.out.println("Food: " + food + "    " + "Need food size: " + foodSize.get(food));
    }

  }
}
