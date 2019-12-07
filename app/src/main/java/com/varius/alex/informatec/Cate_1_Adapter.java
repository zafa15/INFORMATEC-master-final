package com.varius.alex.informatec;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Cate_1_Adapter extends RecyclerView.Adapter<Cate_1_Adapter.ProductViewHolder> {

    private Context mCtx;
    private List<CategoriaProduct> productList;

    public Cate_1_Adapter(Context mCtx, List<CategoriaProduct> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public Cate_1_Adapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cate_1_list, null);
        return new Cate_1_Adapter.ProductViewHolder(view);
    }
    @Override
    public void onBindViewHolder(Cate_1_Adapter.ProductViewHolder holder, int position) {
        CategoriaProduct product = productList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getimg_url())
                .into(holder.imageView);

        holder.Text_nombre.setText(product.getName());
        holder.Text_Description.setText(product.getdescription());
        holder.Text_price.setText(String.valueOf(product.getprice()));
        holder.Text_stock.setText(String.valueOf(product.getstock()));

        Glide.with(mCtx)
                .load(product.getimg_url())
                .into(holder.imageView);
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView Text_nombre, Text_Description, Text_price, Text_stock;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            Text_nombre = itemView.findViewById(R.id.Text_nombre);
            Text_Description = itemView.findViewById(R.id.Text_Description);
            Text_price = itemView.findViewById(R.id.Text_price);
            Text_stock = itemView.findViewById(R.id.Text_stock);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
