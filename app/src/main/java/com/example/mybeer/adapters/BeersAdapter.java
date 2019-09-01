package com.example.mybeer.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.mybeer.R;
import com.example.mybeer.models.BeerModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.ViewHolder> {


    private List<BeerModel> mBeerModelList;

    private Context mContext;

    public BeersAdapter(List<BeerModel> listCharacter, Context context) {
        this.mBeerModelList = listCharacter;
        this.mContext = context;
    }

    public List<BeerModel> getBeerModelList() {
        return mBeerModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final BeerModel beerModel = mBeerModelList.get(position);
        viewHolder.tvBeerName.setText(beerModel.name);
        viewHolder.tvAbv.setText(beerModel.abv +"%");
        viewHolder.tvDescription.setText(beerModel.description);
        viewHolder.tvTagline.setText(beerModel.tagline);

        final RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_file_download_black_24dp)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(mContext)
                .load(beerModel.pictureUrl)
                .apply(options)
                .into(viewHolder.ivBeerPicture);

    }

    @Override
    public int getItemCount() {
        return mBeerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivBeerPicture)
        ImageView ivBeerPicture;
        
        @BindView(R.id.tvBeerName)
        TextView tvBeerName;
        
        @BindView(R.id.tvAbv)
        TextView tvAbv;
        
        @BindView(R.id.tvTagline)
        TextView tvTagline;
        
        @BindView(R.id.tvDescription)
        TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}

