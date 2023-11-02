package com.example.hw_3.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.hw_3.JobListDTO

abstract class BaseViewHolder<VB: ViewBinding,T>(protected open val binding: VB):
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

abstract class BaseJobTypeViewHolder<VB: ViewBinding>(override val binding: VB):
    BaseViewHolder<VB, JobListDTO>(binding)


