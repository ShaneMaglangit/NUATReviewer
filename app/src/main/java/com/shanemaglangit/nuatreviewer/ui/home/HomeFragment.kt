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

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var alarmAdapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeViewModel =
            ViewModelProvider(this, HomeViewModelFactory()).get(HomeViewModel::class.java)
        alarmAdapter = TopicAdapter()

        binding.recyclerTopics.layoutManager = GridLayoutManager(activity, 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int) = when (position) {
                    0 -> 2
                    else -> 1
                }
            }
        }

        binding.recyclerTopics.adapter = alarmAdapter
        binding.homeViewModel = homeViewModel
        binding.lifecycleOwner = this

        activity!!.title = ""

        homeViewModel.topicItem.observe(viewLifecycleOwner, Observer {
            alarmAdapter.addHeaderAndSubmitList(it)
        })

        homeViewModel.toStart.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.action_homeFragment_to_startFragment)
                homeViewModel.navigateToStartCompleted()
            }
        })

        return binding.root
    }
}
