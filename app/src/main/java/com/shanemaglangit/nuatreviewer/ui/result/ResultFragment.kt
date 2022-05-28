package com.shanemaglangit.nuatreviewer.ui.result


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.databinding.FragmentResultBinding
import com.shanemaglangit.nuatreviewer.databinding.FragmentWelcomeBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val arguments: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).supportActionBar?.hide()
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textScore.text = "${arguments.correctAnswers}"
        binding.textScoreSub.text = "Out of ${arguments.totalQuestions}"

        binding.buttonReturn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
