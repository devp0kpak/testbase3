package network.dhammakaya.testbase3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import network.dhammakaya.testbase3.Bean.ProductBean;

/**
 * Created by Delux on 3/24/2018.
 */

public class CustomRecyclerViewC1 extends RecyclerView.Adapter<CustomRecyclerViewC1.ViewHolderC1> {

    private ArrayList<ProductBean> mData;
    private Context context;

    public CustomRecyclerViewC1(ArrayList<ProductBean> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderC1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_center1, parent, false);
        return new ViewHolderC1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderC1 holder, int position) {
        holder.product_name.setText(mData.get(position).getName());
        holder.product_detail.setText( mData.get(position).getDetail());
        holder.product_price.setText(mData.get(position).getPrice() + " ฿");

        Glide.with(context)
                .load(mData.get(position).getImg_url())
                .into(holder.product_image);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolderC1 extends RecyclerView.ViewHolder {

        TextView product_name;
        TextView product_detail;
        TextView product_price;
        ImageView product_image;

        public ViewHolderC1(View itemView) {
            super(itemView);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            product_detail = (TextView) itemView.findViewById(R.id.product_detail);
            product_price = (TextView) itemView.findViewById(R.id.product_price);
            product_image = (ImageView) itemView.findViewById(R.id.product_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProductBean data = mData.get(getAdapterPosition());
                    Toast.makeText(context, data.getName(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
