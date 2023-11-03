package com.example.hw_3

import android.os.Bundle
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.hw_3.base.BaseFragment
import com.example.hw_3.databinding.FragmentArchiveBinding
import com.example.hw_3.databinding.FragmentJobInfoBinding
import com.example.hw_3.decoration.HeaderDecoration
import com.example.hw_3.decoration.OffsetDecoration


class JobInfoFragment: BaseFragment<FragmentJobInfoBinding>(FragmentJobInfoBinding::inflate ) {
    private val args: JobInfoFragmentArgs by navArgs()


    override fun onBindView() {
        super.onBindView()
        binding.jobName.text = args.name
        binding.jobSalary.text = args.salary

//        val job_adapter = JobListAdapter(jobs)

        binding.arrowBack.setOnClickListener{
            findNavController().navigate(
                JobInfoFragmentDirections.actionJobInfoFragmentToArchiveFragment("")
            )
        }

        binding.textView.text = HtmlCompat.fromHtml(getString(R.string.bulleted_list), HtmlCompat.FROM_HTML_MODE_COMPACT)

    }


}