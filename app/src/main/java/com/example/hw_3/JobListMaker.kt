package com.example.hw_3

object JobListMaker {

    fun createJobList(): MutableList<JobListDTO> {
        val list = mutableListOf<JobListDTO>()

        //designer
        list.add(JobListDTO(viewType = JobListType.JOB_SPECIFICATION_VIEW, specification = "Designers"))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Junior UX Designer",
            tools = "Canva",
            paymentPlatform = "Paystack",
            salaryRange = "$40-60k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Middle UX Designer",
            tools = "Canva",
            paymentPlatform = "Paystack",
            salaryRange = "$60-80k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Middle UX Designer",
            tools = "Canva",
            paymentPlatform = "Paystack",
            salaryRange = "$60-80k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Middle UX Designer",
            tools = "Canva",
            paymentPlatform = "Paystack",
            salaryRange = "$60-80k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Middle UX Designer",
            tools = "Canva",
            paymentPlatform = "Paystack",
            salaryRange = "$60-80k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Middle UX Designer",
            tools = "Canva",
            paymentPlatform = "Paystack",
            salaryRange = "$60-80k/yearly"
        ))
        //android
        list.add(JobListDTO(viewType = JobListType.JOB_SPECIFICATION_VIEW, specification = "Android Developers"))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Junior Android Developer",
            tools = "Android Studio",
            paymentPlatform = "Paystack",
            salaryRange = "$50-70k/yearly"
        ))

        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Senior Android Developer",
            tools = "Android Studio",
            paymentPlatform = "Paystack",
            salaryRange = "$80-100k/yearly"
        ))

        // iOS
        list.add(JobListDTO(viewType = JobListType.JOB_SPECIFICATION_VIEW, specification = "iOS Developers"))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Junior iOS Developer",
            tools = "Xcode",
            paymentPlatform = "Paystack",
            salaryRange = "$50-70k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Senior iOS Developer",
            tools = "Swift",
            paymentPlatform = "Paystack",
            salaryRange = "$70-90k/yearly"
        ))

        // Frontend
        list.add(JobListDTO(viewType = JobListType.JOB_SPECIFICATION_VIEW, specification = "Frontend developers"))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Junior Frontend Developer",
            tools = "React",
            paymentPlatform = "Paystack",
            salaryRange = "$50-70k/yearly"
        ))
        list.add(JobListDTO(
            viewType = JobListType.JOB_VIEW,
            name = "Senior Frontend Developer",
            tools = "React",
            paymentPlatform = "Stripe",
            salaryRange = "$70-90k/yearly"
        ))

        return list
    }
}
