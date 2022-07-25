# Project 2 - Battle
 
This project is a program that predicts a battle game between two players.

## 1. About

The program creates a battle game which the users can specify the two players to attack.
Before the game start, you must add at least 5 items of headgear, 5 items of footwear, 15 belts, and 15 potions
to the battle, and add enough weapons.  After added, by called predict method, the game will start automatically.
When one player is defeated, the game is over. And you can choose to play a battle game again if you want.
I implemented a battle package which included ability package, gear package and weapon package.

```java
package battle
package battle.ability
package battle.gear
package battle.weapon
```

## 2. List Of Features

### 2.1 The features of the Gear classes:
All the gear classes implement almost the same things except for a comparator method.

#### 2.1.1 Gear class
```java
  /**
   * Returns the name of the gear.
   * @return name
   */
  String getName();

  /**
   * Returns the adjective of the gear.
   * @return adjective
   */
  String getAdjective();

  /**
     * get ability
     * @return ability
     */
  Ability getAbility();
```

### 2.2 The features of the Character class
Characters after successful creation can return their:
Base attack power.
Base defense power.
Name.
Adjective.
Equip gears.
Modified attack power due to equip gear.
Modified defense power due to equip gear.
ToString that describes the gear that is equipped and the base attack and defense with the modified attack and defense.

```java
  /**
   * Returns the name of the character.
   * @return name
   */
  String getName();

  /**
  * get current ability with all equal gears
  * @return
  */
  Ability currentAbility();

  /**
     * Equips the character with weapon
     * @param o weapon
     */
   boolean equipWeapon(Weapon o)

  /**
   * Equips the character with a gear.
   * @param o Gear object
   */
  void equip(Gear o); 
```

## 3. How To Run
Click [here](https://www.jetbrains.com/help/idea/compiling-applications.html) to see how to run JAR file.
My JAR file has no arguments, using the link above you can run it to see the example of my run which was hard coded.

## 4. How to Use the Program
Using the functionality of any specific class follow the format of "object name of specific class", "name of method()", e.g"playerOne.toString()", playerOne being a Character object.
Looking at the ExampleRun1.txt files you can see how to create objets for specific classes. It can be run in multiple ways.

## 5. Description of Example Runs
Run 1 -- Filename: ExampleRun1.txt:
1. Create the battle object and two characters.
2. Add gears to the bags and add weapons.
3. Prints information about the predicted fight.

Run 2 -- Filename: ExampleRun2.txt:
1. Create the battle object and two characters.
2. Add gears to the bags and add weapons.
3. Prints information about the predicted fight.

## 6. Design/Model Changes
There is no change, the original is the same as the revised.

## 7. Assumptions
The character can have negative ability with different gears.

## 8. Limitations
The battle game starts should after gears added to bag.
If the striking power of the first character is always less than the avoidance of the second character, and the sum of the second character strength and weapons is lower than the first character constitution, then the battle will never stop. It is a tied game.