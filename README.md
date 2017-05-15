# tic-tac-toe
A simple game of tic-tac-toe.

I created a game of tic-tac-toe by combining a GridLayout with a RecylerView. Players are simulated by alternating the TextView setter value for each itemView click event. Completion criteria are provided to indicate the end of a game, i.e. itemViews with co-ordinates ``(0,0), (0,1), and (0,2)`` each have the TextView value ``X``, or ``(0,0), (1,1) and (2,2)`` each have the value ``O``, etc.

Player 1 is always X; Player 2 is always O. A local database stores each player's number of wins. Best of three matches wins the set and the game begins anew.

## Attributions

The <a href="https://www.iconfinder.com/icons/190322/game_tac_tic_toe_icon#size=1042">launcher icon</a> was downloaded from IconFinder. It is a product of the author <a href="https://www.iconfinder.com/iconsets/brain-games">Brain Games</a>. The icon was subsequently assembled in <a href="https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html">Roman Nurik's Android Asset Studio.</a>
