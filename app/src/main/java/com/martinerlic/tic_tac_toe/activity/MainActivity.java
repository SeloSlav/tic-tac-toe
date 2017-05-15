package com.martinerlic.tic_tac_toe.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.martinerlic.tic_tac_toe.R;
import com.martinerlic.tic_tac_toe.adapter.GridRecyclerAdapter;
import com.martinerlic.tic_tac_toe.model.Player;

/**
 * Created by mnxe on 5/15/2017.
 */

public class MainActivity extends AppCompatActivity implements GridRecyclerAdapter.ItemClickListener {


    GridRecyclerAdapter adapter;
    TextView playerHint;
    public Player player1;
    public Player player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set layout */
        setContentView(R.layout.main_activity);

        /* Dummy cell position data */
        String[] data = {".", ".", ".", ".", ".", ".", ".", ".", "."};

        /* Create players */
        player1 = new Player("X", true, 0, false); // textValue, turn?, score, previousWinner?
        player2 = new Player("O", false, 0, false);

        /* Initialize RecyclerView */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numColumns));
        adapter = new GridRecyclerAdapter(this, data, numColumns, player1, player2);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        /* Set initial game conditions */
        initGameConditions(player1, player2);

        /* Start the game, check for completion conditions, etc. */
        Toast.makeText(getApplicationContext(), "Let's Play!", Toast.LENGTH_SHORT).show();
        gameLoop(player1, player2);
    }


    private void initGameConditions(Player player1, Player player2) {
        player1.setTurn(true); // Give initial turn to Player 1
        player2.setTurn(false); // Double-check that Player 2 does not have the inital turn
        playerHint = (TextView) findViewById(R.id.playerHint);

        // Toast.makeText(getApplicationContext(), "Player 1 is " + player1.getTextValue(), Toast.LENGTH_SHORT).show(); // Some introductory text
        // Toast.makeText(getApplicationContext(), "Player 2 is " + player2.getTextValue(), Toast.LENGTH_SHORT).show();
    }


    private void gameLoop(Player player1, Player player2) {
        if (player1.isTurn()) {
            playerHint.setText(R.string.player_1_turn); // Indicate that it is Player 1's turn
        } else {
            playerHint.setText(R.string.player_2_turn);
        }
    }


    @Override
    public void onItemClick(View itemView, int position) {
        Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();

        /* Set the value of the cell depending on which player has a turn */
        if (player1.isTurn()) {
            itemView.setOnClickListener(v -> {
                playerHint.setText(R.string.player_1_turn);
            });
        } else {
            itemView.setOnClickListener(v -> {
                playerHint.setText(R.string.player_2_turn);
            });
        }
    }


    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /* Reset the game */
            case R.id.reset:
                initGameConditions(player1, player2);
                break;
        }
        return true;
    }


}
