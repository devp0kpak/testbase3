package network.dhammakaya.testbase3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import network.dhammakaya.testbase3.Bean.ProductBean;

/**
 * Created by Delux on 3/24/2018.
 */

public class CustomRecyclerViewC2 extends RecyclerView.Adapter<CustomRecyclerViewC2.ViewHolderC2> {

    private ArrayList<ProductBean> mData;
    private Context context;

    public CustomRecyclerViewC2(ArrayList<ProductBean> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderC2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_center2, parent, false);
        return new ViewHolderC2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderC2 holder, int position) {

        holder.product_name.setText(mData.get(position).getName());

        Glide.with(context)
                .load(mData.get(position).getImg_url())
                .into(holder.product_image);

        holder.btn_edit.setTag(R.id.btn_edit, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolderC2 extends RecyclerView.ViewHolder {

        TextView product_name;
        ImageView product_image;
        Button btn_edit;

        public ViewHolderC2(View itemView) {
            super(itemView);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            product_image = (ImageView) itemView.findViewById(R.id.product_image);
            btn_edit = (Button) itemView.findViewById(R.id.btn_edit);

            btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EditActivity.class);
                    intent.putExtra("product_bean", (ProductBean) btn_edit.getTag(R.id.btn_edit));
                    context.startActivity(intent);
                }
            });
        }
    }
}
