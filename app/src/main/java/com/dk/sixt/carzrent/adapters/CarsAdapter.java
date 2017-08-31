package com.dk.sixt.carzrent.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.sixt.carzrent.R;
import com.dk.sixt.carzrent.models.Cars;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dk on 30/8/17.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private Context mContext;
    private List<Cars> carsList;

    public CarsAdapter(Context mContext, List<Cars> carsList) {
        this.mContext = mContext;
        this.carsList = carsList;
    }

    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_row_layout, parent, false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarsViewHolder holder, int position) {
        Cars carData = carsList.get(position);
        Picasso.with(mContext)
                .load(carData.getCarImageUrl())
                .placeholder(R.mipmap.car_default)
                .resize(95, 95)
                .centerInside()
                .into(holder.carImageView);
        holder.carNameTV.setText(carData.getName());
        holder.carMakeTV.setText(carData.getMake());
        holder.carModelTV.setText(carData.getModelName());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {
        public ImageView carImageView;
        public TextView carNameTV;
        public TextView carMakeTV;
        public TextView carModelTV;

        public CarsViewHolder(View itemView) {
            super(itemView);
            carImageView = (ImageView) itemView.findViewById(R.id.car_image_view);
            carNameTV = (TextView) itemView.findViewById(R.id.car_name_tv);
            carMakeTV = (TextView) itemView.findViewById(R.id.car_make_tv);
            carModelTV = (TextView) itemView.findViewById(R.id.car_model_tv);
        }
    }
}
