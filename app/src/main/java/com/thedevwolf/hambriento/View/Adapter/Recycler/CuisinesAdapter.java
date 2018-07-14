package com.thedevwolf.hambriento.View.Adapter.Recycler;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Callback.CuisineListener;
import com.thedevwolf.hambriento.Model.CuisinesModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.databinding.RecycleCuisineBinding;

public class CuisinesAdapter extends RecyclerView.Adapter<CuisinesAdapter.ViewHolder> {
    private CuisinesModel cuisinesModel;
    private CuisineListener cuisineListener;

    public CuisinesAdapter(CuisinesModel cuisinesModel, CuisineListener cuisineListener) {
        this.cuisinesModel = cuisinesModel;
        this.cuisineListener = cuisineListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_cuisine,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CuisinesModel.CuisinesData cuisinesData=cuisinesModel.getCuisines().get(position);
        Picasso.get().load(R.drawable.restaurant).into(holder.cuisineBinding.ivCuisineImage);
        holder.cuisineBinding.tvCuisineName.setText(cuisinesData.getCuisine().getCuisine_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuisineListener.onCuisineClickListener(cuisinesData.getCuisine().getCuisine_id(),cuisinesData.getCuisine().getCuisine_name());
            }
        });

    }

    @Override
    public int getItemCount() {
        return cuisinesModel.getCuisines().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecycleCuisineBinding cuisineBinding;
        public ViewHolder(View itemView) {
            super(itemView);
            cuisineBinding= DataBindingUtil.bind(itemView);
            assert cuisineBinding!=null;
            cuisineBinding.notifyChange();
        }
    }
}
