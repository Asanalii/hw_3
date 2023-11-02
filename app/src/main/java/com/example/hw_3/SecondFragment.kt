package com.example.hw_3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.hw_3.base.BaseFragment
import com.example.hw_3.databinding.FragmentArchiveBinding
import com.example.hw_3.decoration.HeaderDecoration
import com.example.hw_3.decoration.OffsetDecoration


class SecondFragment: BaseFragment<FragmentArchiveBinding>(FragmentArchiveBinding::inflate ) {
    private val args: SecondFragmentArgs by navArgs()


    override fun onBindView() {
        super.onBindView()

        val jobs = getTransformedList()
        val job_adapter = JobListAdapter(jobs)

        with(binding){
            listView.adapter = job_adapter
            listView.addItemDecoration(OffsetDecoration(start = 16,top=2,end=16,bottom=2))
            listView.addItemDecoration(HeaderDecoration())

            listView.layoutManager = LinearLayoutManager(requireContext())

            listView.swipeToLike {
                job_adapter.notifyItemRemoved(it)
                Toast.makeText(requireContext(), jobs[it].name, Toast.LENGTH_SHORT).show()
//                countries.
            }

            LinearSnapHelper().attachToRecyclerView(listView)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        binding
//    }



//        continentView.adapter = continentAdapter
//        continentView.addItemDecoration(OffsetDecoration(start = 4,top=16,end=4,bottom=8))
//        continentView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)

//            LinearSnapHelper().attachToRecyclerView(continentView)

    }


    private fun getTransformedList():List<JobListDTO> {
        val jobList = JobListMaker.createJobList()
        val list: MutableList<JobListDTO> = mutableListOf()

//        countryList.forEachIndexed{index, name, tools,paymentPlatform, salaryRange  ->
        jobList.forEachIndexed{index, item ->

//            val previousItem = if (index > 0) jobList[index - 1] else null
//
//            if (previousItem?.specification?.lowercase() != item.specification?.lowercase()) {
//                list.add(JobListDTO(JobListType.JOB_SPECIFICATION_VIEW, item.specification))
//            }

            if (item.specification == null){
            list.add(JobListDTO(JobListType.JOB_VIEW,"", item.name, item.tools, item.paymentPlatform, item.salaryRange))
            } else {
                list.add(JobListDTO(JobListType.JOB_SPECIFICATION_VIEW, item.specification))
            }


//            if(previousItem?.specification?.lowercase() != item.specification?.lowercase()){
//                list.add(JobListDTO(JobListType.JOB_SPECIFICATION_VIEW,item.specification.toString()))
//                list.add(JobListDTO(JobListType.JOB_VIEW, item.name, item.tools, item.paymentPlatform, item.salaryRange))  // add this line
//            }
//            else list.add(JobListDTO(JobListType.JOB_VIEW,item.name,item.tools,item.paymentPlatform,item.salaryRange))
//             list.add(JobListDTO(JobListType.JOB_VIEW,item.name,item.tools,item.paymentPlatform,item.salaryRange))
        }

        list.add(JobListDTO(JobListType.SPACING_VIEW))

        return list
    }




}