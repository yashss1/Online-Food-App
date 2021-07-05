package com.example.android.jsonanimation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRvViewHolder> {

    private ArrayList<StaticRvModel> items;
    int row_index = -1;

    public StaticRvAdapter(ArrayList<StaticRvModel> items) {
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public StaticRvViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //Binding the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item, parent, false);
        StaticRvViewHolder staticRvViewHolder = new StaticRvViewHolder(view);
        return staticRvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StaticRvViewHolder holder, int position) {
        StaticRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        // For selected item (if item selected)
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if(row_index==position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected);
        }
        else{
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // TO hold our views
    public static class StaticRvViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRvViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.pizza_image);
            textView = itemView.findViewById(R.id.pizza_text);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }


}
