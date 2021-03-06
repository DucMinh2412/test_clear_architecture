package com.example.test_clear_architecture.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Duc Minh
 */

class BindingAdapterUtils {

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(imageView: ImageView, url: String?) {
            if (url.isNullOrEmpty()) {
//                imageView.setImageResource(R.drawable.ic_logo_no_text)
            }
            else{
                Glide.with(imageView.context).load(url).into(imageView)
            }
        }
    }
}