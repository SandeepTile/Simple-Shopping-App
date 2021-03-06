package com.example.sandy.simple_shopping_app.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.sandy.simple_shopping_app.Adapters.CategoryAdapter
import com.example.sandy.simple_shopping_app.Adapters.CategoryRecyclerAdapter
import com.example.sandy.simple_shopping_app.Model.Category
import com.example.sandy.simple_shopping_app.R
import com.example.sandy.simple_shopping_app.Services.DataService
import com.example.sandy.simple_shopping_app.Utilites.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var adapter:CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter= CategoryRecyclerAdapter(this,DataService.categories){category ->

            val productIntent=Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)
        }

        categoryListView.adapter=adapter

        val layoutManager=LinearLayoutManager(this)
        categoryListView.layoutManager=layoutManager
        categoryListView.setHasFixedSize(true)

    }
}
