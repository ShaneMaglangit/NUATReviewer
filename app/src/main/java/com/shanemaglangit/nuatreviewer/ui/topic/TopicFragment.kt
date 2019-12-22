package com.shanemaglangit.nuatreviewer.ui.topic


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.databinding.FragmentTopicBinding
import com.shanemaglangit.nuatreviewer.util.TopicAdapter
import com.shanemaglangit.nuatreviewer.util.TopicListener
import org.koin.android.ext.android.inject

class TopicFragment : Fragment() {
    private lateinit var binding: FragmentTopicBinding
    private lateinit var topicViewModel: TopicViewModel
    private val arguments: TopicFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()
    private lateinit var topicAdapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_topic, container, false)
        topicViewModel =
            ViewModelProvider(this, TopicViewModelFactory(database, arguments.subject)).get(
                TopicViewModel::class.java
            )

        setupSupportActionBar()
        setupObserver()

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        topicAdapter = TopicAdapter(TopicListener {
            findNavController().navigate(TopicFragmentDirections.actionTopicFragmentToLessonFragment(it))
        })

        binding.recyclerTopics.layoutManager = layoutManager
        binding.recyclerTopics.adapter = topicAdapter
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun setupObserver() {
        topicViewModel.topics.observe(this, Observer {
            if (it != null) topicAdapter.submitList(it)
        })
    }

    private fun setupSupportActionBar() {
        val activity = requireActivity() as MainActivity
        activity.setSupportActionBarColor(Color.TRANSPARENT)
        activity.supportActionBar!!.apply {
            title = arguments.subject
            show()
        }
    }
}