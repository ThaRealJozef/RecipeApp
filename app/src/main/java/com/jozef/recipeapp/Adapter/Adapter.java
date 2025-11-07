package com.jozef.recipeapp.Adapter;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.jozef.recipeapp.R;
import com.jozef.recipeapp.RecipeActivity;
import com.jozef.recipeapp.RoomDB.User;

import java.util.List;

public class Adapter extends  RecyclerView.Adapter<com.jozef.recipeapp.Adapter.Adapter.myviewHolder>{

//    List<ResModel> data;
//    Context context;

    List<User> data;
    Context context;
    int list_design;
//    ArrayList<String> data = new ArrayList<>();
//
//    public Adapter(ArrayList<String> data) {
//        this.data = data;
//    }

    public Adapter(List<User> data , Context context) {

        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_design ,parent,false);
         return new myviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {

        final User temp = data.get(position);

        holder.txt1.setText(data.get(position).getTittle());
        Glide.with(holder.txt1.getContext()).load(data.get(position).getImg()).into(holder.img);

        holder.img2.setOnClickListener(v -> {

            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("img", temp.getImg());
            intent.putExtra("tittle", temp.getTittle());
            intent.putExtra("des", temp.getDes());
            intent.putExtra("ing", temp.getIng()); // Ingredients
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);


        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    static class myviewHolder extends RecyclerView.ViewHolder{
        ImageView img , img2;
        TextView txt1;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            img2 = itemView.findViewById(R.id.card_btn);
            txt1 = itemView.findViewById(R.id.txt1);
        }
    }



}
