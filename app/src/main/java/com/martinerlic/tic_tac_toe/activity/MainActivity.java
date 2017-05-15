package com.martinerlic.tic_tac_toe.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.martinerlic.tic_tac_toe.R;
import com.martinerlic.tic_tac_toe.adapter.GridRecyclerAdapter;

/**
 * Created by mnxe on 5/15/2017.
 */

public class MainActivity extends AppCompatActivity implements GridRecyclerAdapter.ItemClickListener {


    GridRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Set layout */
        setContentView(R.layout.main_activity);

        /* Dummy cell position data */
        String[] data = {".", ".", ".", ".", ".", ".", ".", ".", "."};

        /* Initialize RecyclerView */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numColumns));
        adapter = new GridRecyclerAdapter(this, data, numColumns);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        Player player1 = new Player().invoke();
        Player player2 = new Player().invoke();

        /* Give initial turn to Player 1 */
        player1.getPlayer1().setTurn(true);

        gameLoop(player1, player2);
    }


    private void gameLoop(Player player1, Player player2) {
        Toast.makeText(getApplicationContext(), "Player 1 is " + player1.getPlayer1().getTextValue(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Player 2 is " + player2.getPlayer2().getTextValue(), Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onStop() {
        super.onStop();
    }


    private class Player {
        private com.martinerlic.tic_tac_toe.model.Player player1;
        private com.martinerlic.tic_tac_toe.model.Player player2;

        com.martinerlic.tic_tac_toe.model.Player getPlayer1() {
            return player1;
        }

        com.martinerlic.tic_tac_toe.model.Player getPlayer2() {
            return player2;
        }

        Player invoke() {
            player1 = new com.martinerlic.tic_tac_toe.model.Player("X", true, 0, false);
            player2 = new com.martinerlic.tic_tac_toe.model.Player("O", false, 0, false);

            return this;
        }
    }
}
