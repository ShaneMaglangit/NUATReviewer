package com.shanemaglangit.nuatreviewer.ui.start


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.databinding.FragmentStartBinding

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private lateinit var startViewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        startViewModel =
            ViewModelProvider(this, StartViewModelFactory()).get(StartViewModel::class.java)

        binding.startViewModel = startViewModel
        binding.lifecycleOwner = this

        startViewModel.toHome.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(R.id.action_startFragment_to_homeFragment)
                startViewModel.navigateToHomeCompleted()
            }
        })

        startViewModel.toQuestion.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(R.id.action_startFragment_to_questionFragment)
                startViewModel.navigatetoQuestionCompleted()
            }
        })

        return binding.root
    }
}
