package com.shanemaglangit.nuatreviewer.ui.lesson


import android.os.Build
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.databinding.FragmentLessonBinding
import org.koin.android.ext.android.inject

class LessonFragment : Fragment() {
    private lateinit var binding: FragmentLessonBinding
    private lateinit var lessonViewModel: LessonViewModel
    private val arguments: LessonFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()

    private lateinit var activity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity = requireActivity() as MainActivity
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lesson, container, false)
        lessonViewModel =
            ViewModelProvider(this, LessonViewModelFactory(database, arguments.topicId)).get(
                LessonViewModel::class.java
            )

        setupSupportActionBar()
        setupObservers()
        setupListeners()
        setupDescription()

        binding.lessonViewModel = lessonViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun setupDescription() {
        binding.textDescription.post {
        }
    }

    private fun setupObservers() {
        lessonViewModel.topic.observe(this, Observer {
            if (it != null) {
                if(it.description != null) {
                    val stringSpan = SpannableStringBuilder()

                    it.description.split("<img>").forEachIndexed { index, text ->
                        if (index % 2 == 0) {
                            stringSpan.append("$text\n ")
                        } else {
                            val imageId = resources.getIdentifier("ic_science", "drawable", activity.packageName)
                            val image =
                                if(Build.VERSION.SDK_INT > 23) {
                                    resources.getDrawable(imageId, activity.theme)
                                } else {
                                    resources.getDrawable(imageId)
                                }

                            image.setBounds(0, 0, binding.textDescription.width, binding.textDescription.width / 2)
                            stringSpan.setSpan(ImageSpan(image), stringSpan.length - 1, stringSpan.length, 0)
                        }
                    }

                    binding.textDescription.text = stringSpan
                } else {
                    binding.textDescription.text = "No description found"
                }

                activity.supportActionBar?.title = it.title
            }
        })

    }

    private fun setupListeners() {
        binding.buttonSampleTest.setOnClickListener {
            findNavController().navigate(
                LessonFragmentDirections.actionLessonFragmentToQuestionFragment(
                    lessonViewModel.topic.value!!.topicId
                )
            )
        }

        binding.buttonReturn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupSupportActionBar() {
        activity.supportActionBar?.apply {
            title = "Operations"
            show()
        }
    }
}
