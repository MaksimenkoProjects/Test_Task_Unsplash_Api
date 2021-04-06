package com.example.testtaskunsplashapi.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskunsplashapi.BR
import com.example.testtaskunsplashapi.models.UnsplashPhoto

class UnsplashPhotoAdapter(
        @LayoutRes val layputId: Int,
        var listLinkPhoto: List<UnsplashPhoto>,
        val viewModel: MainViewModel
) : RecyclerView.Adapter<UnsplashPhotoAdapter.UnsplashPhotoViewHolder>() {

    override fun onViewAttachedToWindow(holder: UnsplashPhotoViewHolder) {
        holder.itemView.setOnClickListener {
            viewModel.openPhoto(listLinkPhoto.get(holder.adapterPosition).full)
        }
    }

    override fun onViewDetachedFromWindow(holder: UnsplashPhotoViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnsplashPhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return UnsplashPhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UnsplashPhotoViewHolder, position: Int) {
        holder.bind(listLinkPhoto.get(position).thumb)
    }

    override fun getItemCount(): Int = listLinkPhoto.size

    override fun getItemViewType(position: Int) = layputId

    class UnsplashPhotoViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: String) {
            binding.setVariable(BR.photo, photo)
        }
    }
}