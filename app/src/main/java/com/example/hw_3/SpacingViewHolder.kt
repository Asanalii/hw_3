package com.example.hw_3

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import com.example.hw_3.base.BaseJobTypeViewHolder
import com.example.hw_3.databinding.ItemSpacingBinding
import com.example.hw_3.decoration.dp

class SpacingViewHolder(override val binding: ItemSpacingBinding, private val height: Int):
    BaseJobTypeViewHolder<ItemSpacingBinding>(binding) {
    override fun bindView(item: JobListDTO) {
        binding.root.setHeight(height.dp)
    }
}

fun View.setHeight(height:Int){
    val layoutParams = this.layoutParams as ViewGroup.LayoutParams
    layoutParams.height = height
    this.layoutParams = layoutParams
}