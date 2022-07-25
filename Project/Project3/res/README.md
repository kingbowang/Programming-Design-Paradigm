## Project 3 - Dungeon Model

### 1. About

After a player enters the game, he will walk along the tunnel from the starting position to the ending position. During this process, the player can collect the treasures in the journey. The number of caves in the dungeon is determined by rows and columns, the number of tunnels is determined by interconnectivity, and the number of treasures is determined by the number of caves and the probability of treasure appearing.

### 2. List Of Features

- To make it easier to create a dungeon model, I chose to number each cave, treasure, and tunnel, starting from 1.
- When using the Kruskal algorithm for dungeon creation, I used a private method, which ensures that the dungeon creation is not visible to the outside.

### 3. How To Run

Click [here](https://www.jetbrains.com/help/idea/compiling-applications.html) to see how to run the JAR file. And my JAR file has arguments, using the link above you can run it to see the example of my run which was hardcoded.

### 4. How to Use the Program

This dungeon model needs to enter five parameters, which need to be entered when running the command java DungeonDriver, otherwise, it will cause a program error. The order of these five parameters is the number of rows in the dungeon model, the number of columns in the game, whether it is a wrapping dungeon, the interconnectivity of the dungeon, and the probability (decimal form) of occurrence of treasure.

### 5. Description of Example

Run 1 -- a non-wrapping dungeon.txt
1. Print the parameters of this dungeon, including rows, columns, etc.
2. Print the dungeon. Because it is a console program, I choose to number the caves. Caves are numbered in rows starting from 1.
3. Print the start and end positions of the dungeon.
4. Output the treasure that the current game player can obtain, the treasure that the player has picked up, the direction in which the player can move, and the player's current position.
5. Request user input and update the status based on user input.
6. The game is over.

Run 2 -- a wrapping dungeon and take treasure.txt
1. Print the parameters of this dungeon, including rows, columns, etc.
2. Print the dungeon. Because it is a console program, I choose to number the caves. Caves are numbered in rows starting from 1.
3. Print the start and end positions of the dungeon.
4. Output the treasure that the current game player can obtain, the treasure that the player has picked up, the direction in which the player can move, and the player's current position.
5. Request user input and update the status based on user input.
6. The game is over.

Run 3 -- player starting at the start and reaching the end.txt
1. Print the parameters of this dungeon, including rows, columns, etc.
2. Print the dungeon. Because it is a console program, I choose to number the caves. Caves are numbered in rows starting from 1.
3. Print the start and end positions of the dungeon.
4. Output the treasure that the current game player can obtain, the treasure that the player has picked up, the direction in which the player can move, and the player's current position.
5. Request user input and update the status based on user input.
6. The game is over.

Run 4 -- player visiting every location.txt
1. Print the parameters of this dungeon, including rows, columns, etc.
2. Print the dungeon. Because it is a console program, I choose to number the caves. Caves are numbered in rows starting from 1.
3. Print the start and end positions of the dungeon.
4. Output the treasure that the current game player can obtain, the treasure that the player has picked up, the direction in which the player can move, and the player's current position.
5. Request user input and update the status based on user input.
6. The game is over.

### 6. Design/Model Changes

The original version has been modified in detail. The class and interface have not changed, some methods have been added, and some useless parameters have been deleted.

### 7. Assumptions

- The treasure collected by the players will be held until the end of the game, and the value of each treasure is different.
- After the game starts, players are allowed to choose not to pick up treasure when they can pick up treasure.

### 8. Limitations

When the user inputs, if the input command is not available in the current situation. For example, when the current cave does not have a tunnel to the north, the user inputs the player's command to go north, the program will not reject this command and place the player on the corresponding location.

### 9. Citations

Wikimedia Foundation. (2021, April 25). Kruskal's algorithm. Wikipedia. Retrieved November 1, 2021, from https://en.wikipedia.org/wiki/Kruskal's_algorithm. 
