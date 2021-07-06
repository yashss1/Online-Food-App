package com.example.android.jsonanimation;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.jsonanimation.DynamicRvInterface.LoadMore;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashBoardFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;

    List<DynamicRvModelClass> items = new ArrayList();
    DynamicRvAdapter dynamicRvAdapter;

    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashboard_fragment, container, false);

        final ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.pizza_image3, "Pizza"));
        item.add(new StaticRvModel(R.drawable.pizza_image3, "Pizza"));
        item.add(new StaticRvModel(R.drawable.pizza_image3, "Pizza"));
        item.add(new StaticRvModel(R.drawable.pizza_image3, "Pizza"));
        item.add(new StaticRvModel(R.drawable.pizza_image3, "Pizza"));
        item.add(new StaticRvModel(R.drawable.pizza_image3, "Pizza"));

        // Setting up the first RecyclerView 1
        recyclerView = root.findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false)));
        // That above (LinearLayoutManager.HORIZONTAL) sets the layout to Horizontal
        recyclerView.setAdapter(staticRvAdapter);

        // Setting up the second RecyclerView 2
        items.add(new DynamicRvModelClass("Burger1"));
        items.add(new DynamicRvModelClass("Burger2"));
        items.add(new DynamicRvModelClass("Burger3"));
        items.add(new DynamicRvModelClass("Burger4"));
        items.add(new DynamicRvModelClass("Burger5"));
        items.add(new DynamicRvModelClass("Burger6"));
        items.add(new DynamicRvModelClass("Burger7"));
        items.add(new DynamicRvModelClass("Burger8"));
        items.add(new DynamicRvModelClass("Burger9"));
        items.add(new DynamicRvModelClass("Burger10"));
        items.add(new DynamicRvModelClass("Burger11"));
        items.add(new DynamicRvModelClass("Burger12"));
        items.add(new DynamicRvModelClass("Burger13"));
        items.add(new DynamicRvModelClass("Burger14"));
        items.add(new DynamicRvModelClass("Burger15"));
        items.add(new DynamicRvModelClass("Burger16"));
        items.add(new DynamicRvModelClass("Burger17"));

        RecyclerView drv = root.findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        dynamicRvAdapter = new DynamicRvAdapter(drv, getActivity(), items);
        drv.setAdapter(dynamicRvAdapter);

        dynamicRvAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if(items.size()<=10){
                    item.add(null);
                    dynamicRvAdapter.notifyItemInserted(items.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRvAdapter.notifyItemRemoved(items.size());

                            // Inserting more Dummy Data using for loop
                            int index = items.size();
                            int end = index+10;
                            for(int i = index; i<end;i++){
                                String name = UUID.randomUUID().toString();
                                DynamicRvModelClass item = new DynamicRvModelClass(name);
                                items.add(item);
                            }
                            dynamicRvAdapter.notifyDataSetChanged();
                            dynamicRvAdapter.setLoaded();
                        }
                    }, 4000); // As we want delay of 4sec in recycler View
                }
                else{
                    Toast.makeText(getActivity(), "Data Completed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }
}
