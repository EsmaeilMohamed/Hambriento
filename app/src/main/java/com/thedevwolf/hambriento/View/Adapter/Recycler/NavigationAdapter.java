package com.thedevwolf.hambriento.View.Adapter.Recycler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thedevwolf.hambriento.Callback.NavigationItemListener;
import com.thedevwolf.hambriento.Model.NavigationMenuModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.databinding.RecycleNavBinding;

import java.util.List;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    private List<NavigationMenuModel> menuModelList;
    private NavigationItemListener navigationItemListener;
    Context context;

    public NavigationAdapter(List<NavigationMenuModel> menuModelList, NavigationItemListener navigationItemListener, Context context) {
        this.menuModelList = menuModelList;
        this.navigationItemListener = navigationItemListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_nav,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        NavigationMenuModel menuModel=menuModelList.get(position);
        holder.navBinding.ivMenuPic.setImageDrawable(context.getResources().getDrawable(menuModel.getImageId()));
        holder.navBinding.tvMenuTitle.setText(menuModel.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleMenuItemClick(holder.getAdapterPosition());
            }
        });

    }

    private void handleMenuItemClick(int position) {
        switch (position){
            case 0:
                navigationItemListener.onHomeClick();
                break;
            case 1:
                navigationItemListener.onFavoriteClick();
                break;
            case 2:
                navigationItemListener.onLogoutClick();
                break;
             default:
                 break;
        }

    }

    @Override
    public int getItemCount() {
        return menuModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RecycleNavBinding navBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            navBinding = DataBindingUtil.bind(itemView);
            assert navBinding != null;
            navBinding.notifyChange();
        }
    }
}
