package com.shusharin.testcaseimage.ui.mainscreen.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.testcaseimage.R
import com.shusharin.testcaseimage.databinding.ImageCardviewBinding
import com.squareup.picasso.Picasso

class RVAdapter: RecyclerView.Adapter<ImageViewHolder>(){

    var onImageItemClickListener : ((String) ->Unit)? = null

    var imageList = listOf<String>()
        set(value) {
            val callback = DiffCallback(imageList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageCardviewBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ImageViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val binding = holder.binding
        val img = imageList[position]
        Picasso.get().load(img).resize(250, 250).error(R.drawable.ic_launcher_foreground).into(binding.imgVh)
        holder.itemView.setOnClickListener{
            onImageItemClickListener?.invoke(img)

        }
    }


    override fun getItemCount(): Int {
        return imageList.size
    }
}