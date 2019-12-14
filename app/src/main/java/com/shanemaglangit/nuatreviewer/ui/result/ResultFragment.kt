package com.shanemaglangit.nuatreviewer.ui.result


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shanemaglangit.nuatreviewer.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments: ResultFragmentArgs by navArgs()

        text_result.text = arguments.correctAnswers.toString()
        text_result_sub.text = "correct answers out of ${arguments.totalQuestions} questions"

        setListeners()
    }

    fun setListeners() {
        button_return.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
