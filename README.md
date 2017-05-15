# Qwic Tac Toe
A quick offline game of tic-tac-toe that can be played in twos.

I created a game of tic-tac-toe by combining a GridLayout with a RecylerView. Players are simulated by alternating the TextView setter value for each itemView click event. Completion criteria are provided to indicate the end of a game, i.e. itemViews with co-ordinates ``(0,0), (0,1), and (0,2)`` each have the TextView value ``X``, or ``(0,0), (1,1) and (2,2)`` each have the value ``O``, etc.

Player 1 is always X; Player 2 is always O. When a player wins a match, that player gets the first turn in the subsequent round.

## Attributions

The <a href="https://www.iconfinder.com/icons/190322/game_tac_tic_toe_icon#size=1042">launcher icon</a> was downloaded from IconFinder. It is a product of the author <a href="https://www.iconfinder.com/iconsets/brain-games">Brain Games</a>. The icon was subsequently assembled in <a href="https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html">Roman Nurik's Android Asset Studio.</a>
