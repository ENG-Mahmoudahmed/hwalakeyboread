package com.example.hwalasdk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<ContactDTO> mDataset;
    protected ItemListener mListener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContactAdapter(ArrayList<ContactDTO> myDataset, ItemListener itemListener) {
        mDataset = myDataset;
        mListener=itemListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final ContactDTO name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position).getNumber());
        holder.txtFooter.setText(mDataset.get(position).getDisplayName());
        holder.item=name;
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface ItemListener {
        void onItemClick(ContactDTO item);
    }
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and you provide
    //access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        private ContactDTO item;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }



    }
}