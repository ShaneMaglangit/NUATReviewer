package com.shanemaglangit.nuatreviewer.ui.lesson


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
    ): View {
        activity = requireActivity() as MainActivity
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lesson, container, false)
        lessonViewModel =
            ViewModelProvider(this, LessonViewModelFactory(database, arguments.topicId)).get(
                LessonViewModel::class.java
            )

        setupSupportActionBar()
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

    private fun setupListeners() {
        binding.buttonSampleTest.setOnClickListener {
            findNavController().navigate(
                LessonFragmentDirections.actionLessonFragmentToQuestionFragment(arguments.topicId)
            )
        }

        binding.buttonReturn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonNew.setOnClickListener {
            findNavController().navigate(
                LessonFragmentDirections.actionLessonFragmentToAddQuestionFragment(arguments.topicId)
            )
        }
    }

    private fun setupSupportActionBar() {
        activity.supportActionBar?.apply {
            title = ""
            show()
        }
    }
}
