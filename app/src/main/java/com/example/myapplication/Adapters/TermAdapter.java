package com.example.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Entity.Term;
import com.example.myapplication.R;
import com.example.myapplication.UI.TermDetails;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    //Grabbing the view from our recycler view layout file
    //Kind of like in the onCreate method
    class TermViewHolder extends RecyclerView.ViewHolder {
        private final TextView termItemView;
        private TermViewHolder(View itemView){
            super(itemView);
            //termListItemID is in the term_list_item
            termItemView = itemView.findViewById(R.id.termListItemID);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Term current = mTerms.get(position);
                    //This is where we set up what happens on click
                    Intent intent = new Intent(context, TermDetails.class);
                    intent.putExtra("id", current.getTermID());
                    intent.putExtra("name", current.getTermTitle());
                    intent.putExtra("startDate", current.getTermStartDate());
                    intent.putExtra("endDate", current.getTermEndDate());
                    context.startActivity(intent);
                }
            });
        }
    }

    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflator;
    public TermAdapter(Context context) {
        mInflator = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where we inflate the layout (Giving a look to our rows)
        View itemView = mInflator.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        //Assigning values to the view we created in the layout file
        //Based on the position of the recycler view
        if (mTerms != null) {
            Term current = mTerms.get(position);
            String name = current.getTermTitle();
            holder.termItemView.setText(name);
        }
        else {
            holder.termItemView.setText("No Term Name");
        }
    }

    public void setTerms(List<Term> terms) {
        mTerms = terms;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTerms != null) {
            return mTerms.size();
        }
        else return 0;
    }
}
