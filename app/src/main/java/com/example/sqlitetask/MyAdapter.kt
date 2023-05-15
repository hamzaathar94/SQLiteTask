package com.example.sqlitetask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(context: Context,val mydata:ArrayList<MyData>):RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    //create new class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mydata[position]

        // sets the image to the imageview from our itemHolder class
        //   holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.NAME
        holder.textView1.text = ItemsViewModel.PHONE.toString()
        holder.textView2.text = ItemsViewModel.EMAIL


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mydata.size
    }


    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //  val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.txtname)
        val textView1: TextView = itemView.findViewById(R.id.txtphone)
        val textView2: TextView = itemView.findViewById(R.id.txtemail)
    }

}