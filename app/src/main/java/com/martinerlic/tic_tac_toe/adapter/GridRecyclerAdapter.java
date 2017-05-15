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
    private Context mContext;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    /* Initialize constructor */
    public GridRecyclerAdapter(Context context, String[] data, int numColumns, Player player1, Player player2) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mColumns = numColumns;
        this.mPlayer1 = player1;
        this.mPlayer2 = player2;
        this.mContext = context;
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
        holder.cellTextView.setText(cell);
    }


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
            itemView.setOnClickListener(this);
            itemView.setOnClickListener(v -> {
                if (!(cellTextView.getText().toString().isEmpty() || cellTextView.getText().toString().equals("."))) {
                    Toast.makeText(mContext, "You cannot select this cell!", Toast.LENGTH_SHORT).show();
                } else {
                    if (mPlayer1.isTurn()) {
                        cellTextView.setText(mPlayer1.getTextValue());

                    /* Prepare next turn */
                        mPlayer1.setTurn(false);
                        mPlayer2.setTurn(true);
                    } else {
                        cellTextView.setText(mPlayer2.getTextValue());

                    /* Prepare next turn */
                        mPlayer2.setTurn(false);
                        mPlayer1.setTurn(true);
                    }
                }
            });
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