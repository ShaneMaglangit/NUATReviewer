package com.shanemaglangit.nuatreviewer.ui.question


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    private lateinit var questionViewModel : QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val arguments: QuestionFragmentArgs by navArgs()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        questionViewModel = ViewModelProvider(this, QuestionViewModelFactory(arguments.title)).get(QuestionViewModel::class.java)

        binding.questionViewModel = questionViewModel
        binding.lifecycleOwner = this

        setupListeners()
        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        questionViewModel.currentQuestion.observe(this, Observer {
            binding.buttonConfirmation.visibility = View.VISIBLE
            binding.buttonNext.visibility = View.GONE
            binding.radioGroupAnswer.children.forEach {
                if(it is RadioButton) {
                    it.isEnabled = true
                    it.isChecked = false

                    if(Build.VERSION.SDK_INT >= 23) {
                        it.buttonTintList = resources.getColorStateList(R.color.default_button_color_state, activity!!.theme)
                        it.setTextColor(resources.getColor(R.color.secondaryTextColor, activity!!.theme))
                    } else {
                        it.buttonTintList = resources.getColorStateList(R.color.default_button_color_state)
                        it.setTextColor(resources.getColor(R.color.secondaryTextColor))
                    }
                }
            }
        })

        questionViewModel.answerIsCorrect.observe(this, Observer {
            if(it != null) {
                val selectedRadioButton = when(binding.radioGroupAnswer.checkedRadioButtonId) {
                    R.id.radio_answer_top_left -> binding.radioAnswerTopLeft
                    R.id.radio_answer_top_right -> binding.radioAnswerTopRight
                    R.id.radio_answer_bottom_left -> binding.radioAnswerBottomLeft
                    R.id.radio_answer_bottom_right -> binding.radioAnswerBottomRight
                    else -> null
                } as RadioButton

                val colorState = when(it) {
                    true -> {
                        if(Build.VERSION.SDK_INT >= 23) {
                            resources.getColorStateList(R.color.correct_button_color_state, activity!!.theme)
                        } else {
                            resources.getColorStateList(R.color.correct_button_color_state)
                        }
                    }
                    false -> {
                        if(Build.VERSION.SDK_INT >= 23) {
                            resources.getColorStateList(R.color.incorrect_button_color_state, activity!!.theme)
                        } else {
                            resources.getColorStateList(R.color.incorrect_button_color_state)
                        }
                    }
                    else -> null
                }

                selectedRadioButton.buttonTintList = colorState
                selectedRadioButton.setTextColor(colorState)
                binding.buttonConfirmation.visibility = View.GONE
                binding.buttonNext.visibility = View.VISIBLE
                binding.radioGroupAnswer.children.forEach { it.isEnabled = false }

                questionViewModel.answerSubmittedSuccessfully()
            }
        })

        questionViewModel.isEnd.observe(this, Observer {
            if(it) {
                findNavController().navigate(
                    QuestionFragmentDirections.actionQuestionFragmentToResultFragment()
                )

                questionViewModel.testEnded()
            }
        })
    }

    private fun setupListeners() {
        binding.buttonConfirmation.setOnClickListener {
            val answer = when(binding.radioGroupAnswer.checkedRadioButtonId) {
                R.id.radio_answer_top_left -> binding.radioAnswerTopLeft.text.toString()
                R.id.radio_answer_top_right -> binding.radioAnswerTopRight.text.toString()
                R.id.radio_answer_bottom_left -> binding.radioAnswerBottomLeft.text.toString()
                R.id.radio_answer_bottom_right -> binding.radioAnswerBottomRight.text.toString()
                else -> null
            }

            if(answer != null) {
                questionViewModel.submitAnswer(answer)
            } else {
                Snackbar.make(binding.root, "Please choose your answer", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
