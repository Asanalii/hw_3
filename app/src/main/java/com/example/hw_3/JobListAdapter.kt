package com.example.hw_3


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_3.base.BaseJobTypeViewHolder
import com.example.hw_3.databinding.ItemJobSpecificationBinding
import com.example.hw_3.databinding.ItemSpacingBinding
import com.example.hw_3.databinding.ItemTypeBinding
//import com.example.hw_3.databinding.ItemRegionBinding

class JobListAdapter(
//    private val items: List<JobListDTO>): RecyclerView.Adapter<BaseJobTypeViewHolder<*>>(ContinentDiffUtils()) {
    private val items: List<JobListDTO>): ListAdapter<JobListDTO,BaseJobTypeViewHolder<*>>(ContinentDiffUtils()) {

    class ContinentDiffUtils: DiffUtil.ItemCallback<JobListDTO>() {
        override fun areItemsTheSame(oldItem: JobListDTO, newItem: JobListDTO): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: JobListDTO, newItem: JobListDTO): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseJobTypeViewHolder<*> {
//        Log.d("Adapter", "Creating ViewHolder for viewType: $viewType")

        return when(viewType) {
            JobListType.JOB_SPECIFICATION_VIEW.ordinal -> HeaderViewHolder(
                ItemJobSpecificationBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            JobListType.JOB_VIEW.ordinal -> JobViewHolder(
                ItemTypeBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> SpacingViewHolder(
                ItemSpacingBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),16
            )
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseJobTypeViewHolder<*>, position: Int) {

        val item = items[position]

        if (item.viewType == JobListType.JOB_VIEW) {
            holder.bindView(item)
        } else if (item.viewType == JobListType.JOB_SPECIFICATION_VIEW) {
            (holder as? HeaderViewHolder)?.bindView(item)
        }

        if(item.viewType==JobListType.SPACING_VIEW){
            (holder as? SpacingViewHolder)?.bindView(item)
        }

        holder.itemView.setOnClickListener{
            val item = items[position]
            if(item.viewType == JobListType.JOB_VIEW){
                val bundle = Bundle().apply {
                    putString("name",item.name)
                    putString("salary",item.salaryRange)
                }
                it.findNavController().navigate(R.id.action_archiveFragment_to_jobInfoFragment,bundle)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType.ordinal
    }

    class JobViewHolder(override val binding: ItemTypeBinding):
        BaseJobTypeViewHolder<ItemTypeBinding>(binding){

        override fun bindView(item:JobListDTO){
            binding.nameJob.text = item.name
            binding.toolsJob.text = item.tools
            binding.paymentPlatformJob.text = item.paymentPlatform
            binding.salaryRangeJob.text = item.salaryRange
        }
    }

//    class JobSpecificationViewHolder(override val binding: ItemJobSpecificationBinding):
//        BaseJobTypeViewHolder<ItemJobSpecificationBinding>(binding){
//
//        override fun bindView(item:JobListDTO){
//            binding.root.text = item.specification
//        }
//    }


    class HeaderViewHolder(override val binding:ItemJobSpecificationBinding):
        BaseJobTypeViewHolder<ItemJobSpecificationBinding>(binding){

        override fun bindView(item:JobListDTO){
            binding.root.text = item.specification
        }
    }


}


enum class JobListType {
    JOB_SPECIFICATION_VIEW, JOB_VIEW, SPACING_VIEW
}

data class JobListDTO(
    val viewType: JobListType,
    val specification: String? = null,
    val name: String? = null,
    val tools: String? = null,
    val paymentPlatform: String? = null,
    val salaryRange: String? = null
)