package com.shanemaglangit.nuatreviewer.ui.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.databinding.FragmentAddTopicBinding
import org.koin.android.ext.android.inject

class AddTopicFragment : Fragment() {
    private lateinit var binding: FragmentAddTopicBinding
    private lateinit var viewModel: AddTopicViewModel
    private val arguments: AddTopicFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTopicBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            AddTopicViewModelFactory(database, arguments.subject)
        )[AddTopicViewModel::class.java]

        setupUI()
        setupSupportActionbar()
        setupListeners()

        binding.addTopicViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun setupUI() {
        (binding.textCategory as MaterialAutoCompleteTextView).setSimpleItems(arguments.categories)
    }

    private fun setupListeners() {
        binding.buttonSubmit.setOnClickListener {
            viewModel.saveTopic()
            findNavController().navigateUp()
        }
    }

    private fun setupSupportActionbar() {
        (requireActivity() as MainActivity).supportActionBar?.apply {
            title = "Add New Topic"
            show()
        }
    }

}