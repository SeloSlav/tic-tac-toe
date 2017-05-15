package com.martinerlic.tic_tac_toe.activity;

import android.content.Intent;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mnxe on 5/15/2017.
 */

public class MainActivity extends AppCompatActivity implements GridRecyclerAdapter.ItemClickListener {


    public GridRecyclerAdapter adapter;
    public TextView playerHint;
    public Player player1;
    public Player player2;
    public RecyclerView recyclerView;
    public List<Integer> xPositions = new ArrayList<>();
    public List<Integer> oPositions = new ArrayList<>();


    /* Dummy cell position data */
    String[] data = {"", "", "", "", "", "", "", "", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set layout */
        setContentView(R.layout.main_activity);

        /* Create players */
        player1 = new Player("X", true, 0, false); // textValue, turn?, score, previousWinner?
        player2 = new Player("O", false, 0, false);

        /* Initialize RecyclerView */
        initRecyclerView(data);

        /* Set initial game conditions */
        initGameConditions(player1, player2);

        /* Start the game, check for completion conditions, etc. */
        Toast.makeText(getApplicationContext(), "Let's Play!", Toast.LENGTH_SHORT).show();
    }


    public void initRecyclerView(String[] data) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numColumns));
        adapter = new GridRecyclerAdapter(this, adapter, data, numColumns, player1, player2, xPositions, oPositions);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    private void initGameConditions(Player player1, Player player2) {
        player1.setTurn(true); // Give initial turn to Player 1
        player2.setTurn(false); // Double-check that Player 2 does not have the inital turn
        playerHint = (TextView) findViewById(R.id.playerHint);
        playerHint.setText(R.string.player_1_turn); // Initialize player turn hint

        // Toast.makeText(getApplicationContext(), "Player 1 is " + player1.getTextValue(), Toast.LENGTH_SHORT).show(); // Some introductory text
        // Toast.makeText(getApplicationContext(), "Player 2 is " + player2.getTextValue(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(View itemView, int position) {
        Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();

        /* Set the value of the cell depending on which player has a turn */
        if (player1.isTurn()) {
            itemView.setOnClickListener(v -> {
                playerHint.setText(R.string.player_1_turn);
            });
        } else if (player2.isTurn()) {
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
                initRecyclerView(data);
                adapter.notifyDataSetChanged();
                initGameConditions(player1, player2);
                break;
            /* GitHub repository */
            case R.id.info:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/santafebound/tic-tac-toe/blob/master/README.md"));
                startActivity(browserIntent);
                break;
        }
        return true;
    }


}
