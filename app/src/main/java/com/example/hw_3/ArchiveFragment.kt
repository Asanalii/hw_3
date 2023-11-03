package com.example.hw_3

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.hw_3.base.BaseFragment
import com.example.hw_3.databinding.FragmentArchiveBinding
import com.example.hw_3.decoration.HeaderDecoration
import com.example.hw_3.decoration.OffsetDecoration


class ArchiveFragment: BaseFragment<FragmentArchiveBinding>(FragmentArchiveBinding::inflate ) {
    private val args: ArchiveFragmentArgs by navArgs()


    override fun onBindView() {
        super.onBindView()

        val jobs = getTransformedList()
        val job_adapter = JobListAdapter(jobs)

        with(binding) {
            listView.adapter = job_adapter
            listView.addItemDecoration(OffsetDecoration(start = 16, top = 2, end = 16, bottom = 2))
            listView.addItemDecoration(HeaderDecoration())

            listView.layoutManager = LinearLayoutManager(requireContext())

            listView.swipeToLike {
                job_adapter.notifyItemChanged(it)
                Toast.makeText(requireContext(), jobs[it].name + " was liked ", Toast.LENGTH_SHORT)
                    .show()
            }

            LinearSnapHelper().attachToRecyclerView(listView)

//            listView.setOnClickListener {
//                findNavController()
//            }
//            listView.setOnClickListener{
//                findNavController().navigate(
//                    ArchiveFragmentDirections.actionArchiveFragmentToJobInfoFragment()
//                )
//            }
        }

    }



    private fun getTransformedList():List<JobListDTO> {
        val jobList = JobListMaker.createJobList()
        val list: MutableList<JobListDTO> = mutableListOf()

        jobList.forEachIndexed{index, item ->


            if (item.specification == null){
            list.add(JobListDTO(JobListType.JOB_VIEW,"", item.name, item.tools, item.paymentPlatform, item.salaryRange))
            } else {
                list.add(JobListDTO(JobListType.JOB_SPECIFICATION_VIEW, item.specification))
            }

        }

        list.add(JobListDTO(JobListType.SPACING_VIEW))

        return list
    }




}