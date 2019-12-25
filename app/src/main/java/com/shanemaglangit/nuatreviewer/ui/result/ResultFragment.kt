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
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {
    private val arguments: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_score.text = "${arguments.correctAnswers}"
        text_score_sub.text = "Out of ${arguments.totalQuestions}"

        button_return.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
