/*
 * Submitted By: Jordan Trenholm
 * Assignment: 3
 * Date: 2019/03/17
 */

package com.example.android.asn03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.asn03.Model.Recipe;

import java.util.LinkedList;

import static com.example.android.asn03.DataProvider.getRecipes;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinkedList<Recipe> mRecipeList;
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;

    public static final String EXTRA_MESSAGE = "com.example.android.asn03.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecipeList = getRecipes();

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new RecipeListAdapter(this, mRecipeList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        int mPosition =  mRecyclerView.getChildAdapterPosition(view);
        Recipe recipe = mRecipeList.get(mPosition);
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(EXTRA_MESSAGE, recipe);
        startActivity(intent);
    }
}
