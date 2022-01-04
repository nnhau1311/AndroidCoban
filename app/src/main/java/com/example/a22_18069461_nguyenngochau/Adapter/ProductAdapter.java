package com.example.a22_18069461_nguyenngochau.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a22_18069461_nguyenngochau.Activity.CreateProductActivity;
import com.example.a22_18069461_nguyenngochau.Modal.Product;
import com.example.a22_18069461_nguyenngochau.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    Context context;
    ArrayList<Product> arrayList;

    public ProductAdapter(Context context, ArrayList<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ProductAdapter.ViewHolder holder, int position) {
        Product product = arrayList.get(position);
        holder.tvType.setText(product.getType());
        holder.tvPrice.setText(String.valueOf(product.getPrice()));
        holder.tvContent.setText(product.getContent());
        holder.tvSl.setText(product.getQuantity());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton btnCong,btnTru;
        private TextView tvType,tvContent,tvPrice,tvSl;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tvType);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvSl = itemView.findViewById(R.id.tvSlItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CreateProductActivity.class);
                    context.startActivity(intent);
                    
                }
            });
        }
    }
}
