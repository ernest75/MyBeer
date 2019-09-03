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
        viewHolder.mTvBeerName.setText(beerModel.name);
        viewHolder.mTvAbv.setText(beerModel.abv +"%");
        viewHolder.mTvDescription.setText(beerModel.description);
        viewHolder.mTvTagline.setText(beerModel.tagline);

        final RequestOptions options = new RequestOptions()
                .centerCrop()
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_file_download_black_24dp)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(mContext)
                .load(beerModel.pictureUrl)
                .apply(options)
                .into(viewHolder.mIvBeerPicture);

    }

    @Override
    public int getItemCount() {
        return mBeerModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivBeerPicture)
        ImageView mIvBeerPicture;
        
        @BindView(R.id.tvBeerName)
        TextView mTvBeerName;
        
        @BindView(R.id.tvAbv)
        TextView mTvAbv;
        
        @BindView(R.id.tvTagline)
        TextView mTvTagline;
        
        @BindView(R.id.tvDescription)
        TextView mTvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }
}

