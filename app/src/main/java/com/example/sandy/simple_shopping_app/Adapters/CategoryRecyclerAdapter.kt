package com.example.sandy.simple_shopping_app.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sandy.simple_shopping_app.Model.Category
import com.example.sandy.simple_shopping_app.R
import kotlinx.android.synthetic.main.category_indiview.view.*

class CategoryRecyclerAdapter(val context:Context,val categories:List<Category>,
                              val itemClick :(Category) -> Unit):RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view=LayoutInflater.from(context).inflate(R.layout.category_indiview,parent,false)
        return Holder(view,itemClick)

    }

    override fun getItemCount(): Int {

        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bindCategory(categories[position],context)

    }

    inner class Holder(itemView: View?,val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView){

        val categoryImage=itemView!!.findViewById<ImageView>(R.id.categoryImage)
        val categoryName=itemView!!.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category:Category,context: Context){

            val resorceID=context.resources.getIdentifier(category.image,"drawable",context.packageName)

            categoryImage.setImageResource(resorceID)
            categoryName.text=category.title
            itemView.setOnClickListener { itemClick(category) }
        }



    }
}