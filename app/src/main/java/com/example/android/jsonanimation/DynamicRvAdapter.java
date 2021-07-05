package com.example.android.jsonanimation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.jsonanimation.DynamicRvInterface.LoadMore;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class LoadingViewHolder extends RecyclerView.ViewHolder{

    public ProgressBar progressBar;

    public LoadingViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progessBar);
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder{

    public TextView name;

    public ItemViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.burger_name);
    }
}


public class DynamicRvAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int VIEW_TYPE_ITEM =0, VIEW_TYPE_LOADING = 0;
    LoadMore loadMore;
    boolean isLoading;
    Activity activity;
    List<DynamicRvModelClass> items;
    int visibleThreshold = 5;
    int lastVisibleItem, totalItemCount;

    public DynamicRvAdapter(RecyclerView recyclerView, Activity activity, List<DynamicRvModelClass> items) {
        this.activity = activity;
        this.items = items;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(!isLoading && totalItemCount<=(lastVisibleItem+visibleThreshold)){
                    if(loadMore!=null)loadMore.onLoadMore();
                    isLoading = true;
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }

    public  void setLoadMore(LoadMore loadMore){
        this.loadMore = loadMore;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

       if(viewType == VIEW_TYPE_ITEM){
           View view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_item_layout, parent, false);
           return  new LoadingViewHolder(view);
       }
       else if(viewType == VIEW_TYPE_LOADING){
           View view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_progressbar, parent, false);
           return  new LoadingViewHolder(view);
       }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){
            DynamicRvModelClass item = items.get(position);
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.name.setText(items.get(position).getName());
        }
        else if(holder instanceof LoadingViewHolder){
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setLoaded(){
        isLoading = false;
    }
}
