## Project 4 - Text-Based Adventure Game

### 1. About

After a player enters the dungeon, he will walk along the tunnel from the starting cave to the end cave. During this process, the player can collect treasure and arrows along the way. The player has three arrows at the beginning. The number of caves in the dungeon is determined by row and col, the number of tunnels is determined by interconnectivity, and the number of treasures and arrows is determined by the number of caves and the probability of treasure appearing together. Otyughs will randomly appear in caves in the dungeon. Users can use arrows to attack Otyughs. If the player enters the cave of Otyughs, the player will be eaten by Otyughs. The user can control the player's actions by entering different commands. The M (move) command allows the player to move on the map, the P (pick) command allows the player to pick up the treasure or arrow in the cave, and the S (shoot) command allows the player to shoot arrows at the cave at the specified distance and direction.

### 2. List Of Features

- To make it easier to create a dungeon model, I chose to number each cave, treasure, and tunnel, starting from one.
- When using the Kruskal algorithm for dungeon creation, I used a private method, which ensures that the dungeon creation is not visible to the outside.
- When processing user input, if the user inputs an illegal instruction, the program will throw an exception and exit.
- The game only needs one controller object from the beginning to the end, so when creating the controller object, I used the singleton mode.
- I overloaded the equals method and hashcode method in the Position class to make the two Position objects with equal row and col equal.

### 3. How To Run

Click [here](https://www.jetbrains.com/help/idea/compiling-applications.html) to see how to run the JAR file. And my JAR file has no arguments, using the link above you can run it to see the example of my run which was hardcoded.

### 4. How to Use the Program

This game consists of six parameters. The parameters of the game can be modified in the dungeonImpl class. The parameters must meet the requirements, otherwise, it will cause a program error. The six parameters are the number of rows in the game, the number of columns in the game, whether wrapping, the interconnectivity of the map, the probability of occurrence of Treasure (input in decimal form), and the number of Otyughs.

### 5. Description of Example

Run 1 -- the player picking up arrows.txt
1. The program will output the arrow and quantity that can be picked up in cave.
2. Waiting for user input.
3. Player picks up arrow, and the picked arrow disappears from cave.

Run 2 -- the player being eaten by a Otyugh.txt
1. The program prompts the user that there is Otyugh in the cave around the user.
2. Player enters the cave where Otyugh exists.
3. Player was eaten by Otyugh.
4. The game is over.

Run 3 -- the player killing a Otyugh and picking up treasure.txt
1. The program will output the current direction that can be moved and the treasure that can be picked up.
2. The program prompts the user that there is Otyugh in the cave around the user.
3. User enters the distance and direction of arrow.
4. The program outputs the information that Otyugh was hit.
5. The user enters the cave where the killed Otyugh exists without being attacked, and the program does not prompt that there is Otyugh around.
6. Player successfully reached the end position.
7. The game is over.

Run 4 -- escape from Otyughs.txt
1. The program prompts the user that there is Otyugh in the cave around the user.
2. User enters the distance and direction of arrow.
3. The program outputs the information that Otyugh was hit. Only one time.
4. The user enters the cave where the injured Otyugh exists without being attacked, but the program prompts that there is Otyugh around.
5. Player successfully reached the end position.
6. The game is over.

### 6. Design/Model Changes

The original version has been modified in detail. Add Position class and Direction class, some methods have been added, and some useless parameters have been deleted.

### 7. Assumptions

- The treasure collected by the players will be held until the end of the game, and the value of each treasure is different.
- After the game starts, players are allowed to choose not to pick up treasure when they can pick up treasure.
- I regard arrows as a kind of treasure. When the probability of treasure is 20%, it means that treasure and arrow account for 20% of the total caves.

### 8. Limitations

In this dungeon game I created, the tunnel is only a channel connecting the cave, and a cave can only have a tunnel with the cave that the distance is one in the south, east, north, and west direction around it. The tunnel cannot exist alone.

### 9. Citations

Wikimedia Foundation. (2021, April 25). Kruskal's algorithm. Wikipedia. Retrieved November 1, 2021, from https://en.wikipedia.org/wiki/Kruskal's_algorithm. 
