package com.example.photoeditor.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.photoeditor.R

@BindingAdapter("loadPlaceHolderImage")
fun loadPlaceHolderImage(view: ImageView, path: String?) {
    if (path.isNullOrBlank()) {
        view.setImageResource(R.drawable.ic_place_holder)
        return
    }
    Glide.with(view)
        .clear(view)
    Glide.with(view)
        .load(path)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .override(100, 100)
        .placeholder(R.drawable.ic_place_holder)
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                view.setImageDrawable(resource)
                return false
            }

        })
        .into(view)
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, path: String?) {
    if (path.isNullOrBlank()) {
        view.setImageResource(R.drawable.ic_place_holder)
        return
    }
    Glide.with(view)
        .clear(view)
    Glide.with(view)
        .load(path)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//        .override(100, 100)
        .placeholder(R.drawable.ic_place_holder)
        .addListener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                view.setImageDrawable(resource)
                return false
            }

        })
        .into(view)
}