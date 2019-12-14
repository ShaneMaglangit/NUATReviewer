package com.shanemaglangit.nuatreviewer.ui.result


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var resultViewModel: ResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val arguments: ResultFragmentArgs by navArgs()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        resultViewModel = ViewModelProvider(
            this,
            ResultViewModelFactory(arguments.totalQuestions, arguments.correctAnswers)
        ).get(ResultViewModel::class.java)

        binding.resultViewModel = resultViewModel
        binding.lifecycleOwner = this

        return binding.root
    }


}
