package com.shanemaglangit.nuatreviewer.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.databinding.FragmentHomeBinding
import com.shanemaglangit.nuatreviewer.util.TopicAdapter
import com.shanemaglangit.nuatreviewer.util.TopicListener

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var topicAdapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel =
            ViewModelProvider(this, HomeViewModelFactory()).get(HomeViewModel::class.java)

        activity!!.title = ""
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this

        setupObservers()
        setupRecyclerTopics()

        return binding.root
    }

    private fun setupObservers() {
        homeViewModel.topicItem.observe(viewLifecycleOwner, Observer {
            topicAdapter.addHeaderAndSubmitList(it)
        })

        homeViewModel.selectedTopic.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToStartFragment(it.title!!, it.description!!))
                homeViewModel.topicOpened()
            }
        })
    }

    private fun setupRecyclerTopics() {
        topicAdapter = TopicAdapter( TopicListener {
            homeViewModel.openTopic(it)
        })

        binding.recyclerTopics.apply {
            adapter = topicAdapter
            layoutManager = GridLayoutManager(activity, 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int) = when (position) {
                        0 -> 2
                        else -> 1
                    }
                }
            }
        }
    }
}
