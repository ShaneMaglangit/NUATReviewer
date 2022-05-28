package com.shanemaglangit.nuatreviewer.ui.question

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.databinding.FragmentAddQuestionBinding
import com.shanemaglangit.nuatreviewer.databinding.FragmentAddTopicBinding
import com.shanemaglangit.nuatreviewer.ui.topic.AddTopicViewModel
import com.shanemaglangit.nuatreviewer.ui.topic.AddTopicViewModelFactory
import org.koin.android.ext.android.inject

class AddQuestionFragment : Fragment() {
    private lateinit var binding: FragmentAddQuestionBinding
    private lateinit var viewModel: AddQuestionViewModel
    private val arguments: AddQuestionFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddQuestionBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            AddQuestionViewModelFactory(database, arguments.topicId)
        )[AddQuestionViewModel::class.java]

        setupSupportActionbar()
        setupListeners()

        binding.addQuestionViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun setupListeners() {
        binding.buttonSubmit.setOnClickListener {
            viewModel.saveQuestion()
            findNavController().navigateUp()
        }
    }

    private fun setupSupportActionbar() {
        (requireActivity() as MainActivity).supportActionBar?.apply {
            title = "Add New Question"
            show()
        }
    }
}