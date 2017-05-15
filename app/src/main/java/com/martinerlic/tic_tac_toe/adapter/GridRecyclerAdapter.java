package com.martinerlic.tic_tac_toe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.martinerlic.tic_tac_toe.R;
import com.martinerlic.tic_tac_toe.model.Player;

public class GridRecyclerAdapter extends RecyclerView.Adapter<GridRecyclerAdapter.ViewHolder> {


    private String[] mData = new String[0];
    private int mColumns;
    private Player mPlayer1;
    private Player mPlayer2;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    /* Initialize constructor */
    public GridRecyclerAdapter(Context context, String[] data, int numColumns, Player player1, Player player2) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mColumns = numColumns;
        this.mPlayer1 = player1;
        this.mPlayer2 = player2;
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        String cell = mData[position];
        holder.myTextView.setText(cell);
    }


    /* Item count */
    @Override
    public int getItemCount() {
        return mData.length;
    }


    /* Store cell views */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.textView);
            /*itemView.setOnClickListener(this);*/

            /* Set the value of the cell depending on which player has a turn */
            if (mPlayer1.isTurn()) {
                itemView.setOnClickListener(v -> {
                    myTextView.setText(mPlayer1.getTextValue());
                });
            } else {
                itemView.setOnClickListener(v -> {
                    myTextView.setText(mPlayer2.getTextValue());
                });
            }
        }

        @Override
        public void onClick(View view) {
            /*if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());*/

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
        void onItemClick(View view, int position);
    }


}