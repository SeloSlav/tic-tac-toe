package com.martinerlic.tic_tac_toe.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.martinerlic.tic_tac_toe.R;
import com.martinerlic.tic_tac_toe.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.ViewHolder> {


    private String[] mData;
    private int mColumns;
    private Player mPlayer1;
    private Player mPlayer2;
    private Context mContext;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private List<Integer> mXPositions;
    private List<Integer> mOPositions;


    /* Initialize constructor */
    public GridRecyclerAdapter(Context context, String[] data, int numColumns, Player player1, Player player2, List<Integer> xPositions, List<Integer> oPositions) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mColumns = numColumns;
        this.mPlayer1 = player1;
        this.mPlayer2 = player2;
        this.mContext = context;
        this.mXPositions = xPositions;
        this.mOPositions = oPositions;
    }


    /* Inflate cell layout */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);

        /* Set minimum height of each cell by the number of rows in the grid */
        int height = parent.getMeasuredHeight() / mColumns;
        itemView.setMinimumHeight(height);

        return new ViewHolder(itemView);
    }


    /* Bind data to TextView */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        String cell = mData[position];
        viewHolder.cellTextView.setText(cell);

        viewHolder.itemView.setOnClickListener(v -> {
            checkTurn(viewHolder, position);
            checkCompletionConditions(mXPositions, mOPositions, position);
        });
    }


    /* Check the current player turn */
    private void checkTurn(final ViewHolder viewHolder, int position) {
        if (!(viewHolder.cellTextView.getText().toString().isEmpty())) {
            Toast.makeText(mContext, "You cannot select this cell!", Toast.LENGTH_SHORT).show();
        } else {
            if (mPlayer1.isTurn()) {
                /* Set cell to "X" */
                viewHolder.cellTextView.setText(mPlayer1.getTextValue());

                /* Set clicked */
                viewHolder.cellTextView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
                mXPositions.add(position);
                // mOPositions.add(-1);
                Toast.makeText(mContext, mXPositions.toString(), Toast.LENGTH_SHORT).show();

                /* Prepare next turn */
                mPlayer1.setTurn(false);
                mPlayer2.setTurn(true);
            } else {
                /* Set cell to "O" */
                viewHolder.cellTextView.setText(mPlayer2.getTextValue());

                /* Set clicked */
                viewHolder.cellTextView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
                mOPositions.add(position);
                // mXPositions.add(-1);
                Toast.makeText(mContext, mOPositions.toString(), Toast.LENGTH_SHORT).show();

                /* Prepare next turn */
                mPlayer1.setTurn(true);
                mPlayer2.setTurn(false);
            }
        }
    }


    private void checkCompletionConditions(List<Integer> mXPositions, List<Integer> mOPositions, int position) {
        /*Map<Integer, Integer> map = createMapFromLists(mXPositions, mOPositions);
        Toast.makeText(mContext, map.toString(), Toast.LENGTH_SHORT).show();*/

        /* Legend
        * 0: top-left
        * 1: top-center
        * 2: top-right
        * 3: middle-left
        * 4: middle-center
        * 5: middle-right
        * 6: bottom-left
        * 7: bottom-center
        * 8: bottom-right
        */

        /* Wins
        * Condition 1: 0, 1, 2
        * Condition 2: 0, 4, 7
        * Condition 3: 2, 6, 8
        * Condition 4: 6, 7, 8
        * Condition 5: 0, 4, 8
        */

        // TODO: This is a little too brute-force for my liking. I'll have to look up some kind of tic-tac-toe win condition algorithm
        Integer[] condition1 = {0, 1, 2};
        for (Integer item : condition1) {
            if (mXPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_1_wins, Toast.LENGTH_SHORT).show();
            } else if (mOPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_2_wins, Toast.LENGTH_SHORT).show();
            }
        }

        Integer[] condition2 = {0, 4, 7};
        for (Integer item : condition2) {
            if (mXPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_1_wins, Toast.LENGTH_SHORT).show();
            } else if (mOPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_2_wins, Toast.LENGTH_SHORT).show();
            }
        }

        Integer[] condition3 = {2, 6, 8};
        for (Integer item : condition3) {
            if (mXPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_1_wins, Toast.LENGTH_SHORT).show();
            } else if (mOPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_2_wins, Toast.LENGTH_SHORT).show();
            }
        }

        Integer[] condition4 = {6, 7, 8};
        for (Integer item : condition4) {
            if (mXPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_1_wins, Toast.LENGTH_SHORT).show();
            } else if (mOPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_2_wins, Toast.LENGTH_SHORT).show();
            }
        }

        Integer[] condition5 = {0, 4, 8};
        for (Integer item : condition5) {
            if (mXPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_1_wins, Toast.LENGTH_SHORT).show();
            } else if (mOPositions.contains(item)) {
                Toast.makeText(mContext, R.string.player_2_wins, Toast.LENGTH_SHORT).show();
            }
        }

    }


    /*private Map<Integer, Integer> createMapFromLists(List<Integer> mXPositions, List<Integer> mOPositions) {
        if (mXPositions.size() != mOPositions.size())
            throw new IllegalArgumentException("Cannot combine lists with dissimilar sizes!");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < mXPositions.size(); i++) {
            map.put(mXPositions.get(i), mOPositions.get(i));
        }
        return map;
    }*/


    /* Item count */
    @Override
    public int getItemCount() {
        return mData.length;
    }


    /* Store cell views */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cellTextView;

        ViewHolder(View itemView) {
            super(itemView);
            cellTextView = (TextView) itemView.findViewById(R.id.textView);
        }


        @Override
        public void onClick(View itemView) {
            if (mClickListener != null) mClickListener.onItemClick(itemView, getAdapterPosition());
        }
    }


    /* Get data at click position */
    public String getItem(int id) {
        return mData[id];
    }


    /* Capture click position */
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    /* Implement method to respond to click events in MainActivity */
    public interface ItemClickListener {
        void onItemClick(View itemView, int position);
    }


}