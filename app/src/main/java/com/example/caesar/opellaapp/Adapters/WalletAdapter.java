package com.example.caesar.opellaapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.caesar.opellaapp.R;
import com.example.caesar.opellaapp.WalletPay.CreditCardPaystack;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.WalletViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private Listener listener;
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Drawable> mImageUrls = new ArrayList<>();
    private Context mContext;

    public WalletAdapter(Context context, ArrayList<String> names, ArrayList<Drawable> imageUrls) {
        mNames = names;
        mImageUrls = imageUrls;
        mContext = context;
    }
    public static interface Listener {
        void onClick(int position);
    }

    @Override
    public WalletViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new WalletViewHolder(view);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
    @Override
    public void onBindViewHolder(WalletViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageDrawable(mImageUrls.get(position));
//        Glide.with(mContext)
//                .asBitmap()
//                .load(mImageUrls.get(position))
//                .into(holder.image);
//        Picasso.get().load(mImageUrls.get(position)).into(holder.image);


        holder.name.setText(mNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: clicked on an image: " + mNames.get(position));
                Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
                if (listener != null){
                    listener.onClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class WalletViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;

        public WalletViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);
        }
    }
}
