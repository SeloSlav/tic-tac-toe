package com.martinerlic.tic_tac_toe.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.martinerlic.tic_tac_toe.R;
import com.martinerlic.tic_tac_toe.adapter.GridRecyclerAdapter;
import com.martinerlic.tic_tac_toe.model.Player;

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

        initPlayers();
    }


    private void initPlayers() {
        Player player1 = new Player("X", true, 0, false); // textValue, turn?, score, previousWinner?
        Player player2 = new Player("O", false, 0, false);

        Toast.makeText(getApplicationContext(), "Player 1 is " + player1.getTextValue(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Player 2 is " + player2.getTextValue(), Toast.LENGTH_LONG).show();
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


}
