/*
 * Submitted By: Jordan Trenholm
 * Assignment: 3
 * Date: 2019/03/17
 */

package com.example.android.asn03;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.asn03.Model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final List<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecipeListAdapter(Context context, List<Recipe> recipeList){
        mInflater = LayoutInflater.from(context);
        mRecipeList = recipeList;
        mContext = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, viewGroup, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        Recipe mCurrent = mRecipeList.get(i);
        recipeViewHolder.recipeTitleView.setText(mCurrent.name);
        recipeViewHolder.recipeDescView.setText(mCurrent.description);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        public final TextView recipeTitleView;
        public final TextView recipeDescView;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(@NonNull View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.name);
            recipeDescView = itemView.findViewById(R.id.description);
            mAdapter = adapter;
            itemView.setOnClickListener((MainActivity)adapter.mContext);
        }
    }
}
