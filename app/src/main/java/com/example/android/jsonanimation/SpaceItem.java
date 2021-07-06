package com.example.android.jsonanimation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

//    Creating Space between Items in Drawer Recycler View
public class SpaceItem extends DrawerItem<SpaceItem.ViewHolder>{

    private int spaceDp;

    public SpaceItem(int spaceDp){
        this.spaceDp = spaceDp;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {
        Context c = parent.getContext();
        View view  = new View(c);
        int height = (int) (c.getResources().getDisplayMetrics().density*spaceDp);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                height
        ));

        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {

    }

//    His function is named Selectable
    @Override
    public boolean isSelected() {
        return false;
    }

    public class ViewHolder extends DrawerAdapter.ViewHolder{

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }


}
