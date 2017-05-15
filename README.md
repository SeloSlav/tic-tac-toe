# tic-tac-toe
A simple game of tic-tac-toe.

I created a simple game of tic-tac-toe by combining a GridLayout with a RecylerView. "Players" are simulated by alternating the TextView setter value for each itemView click event. Completion criteria are provided to indicate the end of a game, i.e. itemViews with co-ordinates ``(0,0), (0,1), and (0,2)`` each have the TextView value ``X``, or ``(0,0), (1,1) and (2,2)`` each have the value ``O``, etc.

Player 1 is always X; Player 2 is always O. A local database stores each player's number of wins. Best of three matches wins the set and the game begins anew.
