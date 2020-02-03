# YouCantRunAwayJon (In progress)
![screenshot](https://raw.githubusercontent.com/killvung/YouCantRunAwayJon/master/Screenshot%202020-02-02%20at%206.32.34%20PM.png)
An interesting Android application based on a [programming interview question](https://ianna1009.gitbooks.io/leectcode/Cracking%20Coding%20Interview/Chapter8.%20Recursion%20and%20Dynamic%20Programming/82_robot_in_a_grid.html). Given a robot "J" started at the position (0,0) in the grid, its goal is to move down the bottom right of the grid, while avoiding another robot "Q".

### Brief Todo: 
- Set the game to Win if "J" reaches to the bottom right of the grid 
- Resolve a bug where "J" can walk to next row from the edge of the grid
- Resolve a bug where the game crashed after "J" walked beyond the boundary
- Set the game to Lost if both "Q" and "J" runs to each other
- "Q" can move toward "J"
