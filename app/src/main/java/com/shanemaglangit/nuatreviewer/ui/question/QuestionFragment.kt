package com.shanemaglangit.nuatreviewer.ui.question


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.databinding.FragmentQuestionBinding
import org.koin.android.ext.android.inject

class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    private lateinit var questionViewModel: QuestionViewModel
    private val arguments: QuestionFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()

    private lateinit var activity: MainActivity
    private var questionNumber = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity = requireActivity() as MainActivity
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        questionViewModel =
            ViewModelProvider(this, QuestionViewModelFactory(database, arguments.topicId)).get(
                QuestionViewModel::class.java
            )

        setupSupportActionBar()
        setupObserver()
        setupListeners()

        binding.questionViewModel = questionViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun setupSupportActionBar() {
        activity.supportActionBar?.apply {
            //            setBackgroundDrawable(
//                ColorDrawable(
//                    if (Build.VERSION.SDK_INT > 23) resources.getColor(
//                        R.color.secondaryColor,
//                        activity.theme
//                    ) else resources.getColor(R.color.secondaryDarkColor)
//                )
//            )
            title = "Question #$questionNumber"
            show()
        }
    }

    private fun setupObserver() {
        questionViewModel.question.observe(this, Observer {
            if (it != null) {
                questionViewModel.loadQuestion()
                questionViewModel.calculateTotalQuestions()
            }
        })

        questionViewModel.currentQuestion.observe(this, Observer {
            if (it != null) {
                val options = questionViewModel.loadOptions().apply { shuffle() }

                binding.buttonA.text = options[0]
                binding.buttonB.text = options[1]
                binding.buttonC.text = options[2]
                binding.buttonD.text = options[3]
            }
        })

        questionViewModel.testDone.observe(this, Observer {
            findNavController()
                .navigate(
                    QuestionFragmentDirections
                        .actionQuestionFragmentToResultFragment(
                            questionViewModel.correctAnswers,
                            questionViewModel.totalQuestions
                        )
                )
        })
    }

    private fun setupListeners() {
        binding.buttonA.setAnswerListener()
        binding.buttonB.setAnswerListener()
        binding.buttonC.setAnswerListener()
        binding.buttonD.setAnswerListener()

        binding.buttonNext.setOnClickListener {
            questionViewModel.loadQuestion()
            resetButtonState()

            questionNumber++
            activity.supportActionBar!!.title = "Question #$questionNumber"
        }
    }

    private fun resetButtonState() {
        val primaryColor: Int

        if (Build.VERSION.SDK_INT > 23) {
            primaryColor = resources.getColor(R.color.primaryColor, activity!!.theme)
        } else {
            primaryColor = resources.getColor(R.color.primaryColor)
        }

        binding.buttonNext.isEnabled = false
        binding.buttonA.setBackgroundColor(primaryColor)
        binding.buttonB.setBackgroundColor(primaryColor)
        binding.buttonC.setBackgroundColor(primaryColor)
        binding.buttonD.setBackgroundColor(primaryColor)
    }

    private fun Button.setAnswerListener() {
        this.setOnClickListener {
            val correctAnswer = questionViewModel.currentQuestion.value!!.answer

            if (correctAnswer == this.text.toString()) {
                this.setBackgroundColor(Color.GREEN)
                questionViewModel.answerCorrect()
            } else {
                this.setBackgroundColor(Color.RED)

                when (correctAnswer) {
                    binding.buttonA.text.toString() -> binding.buttonA.setBackgroundColor(Color.GRAY)
                    binding.buttonB.text.toString() -> binding.buttonB.setBackgroundColor(Color.GRAY)
                    binding.buttonC.text.toString() -> binding.buttonC.setBackgroundColor(Color.GRAY)
                    binding.buttonD.text.toString() -> binding.buttonD.setBackgroundColor(Color.GRAY)
                }
            }

            binding.buttonNext.isEnabled = true
        }
    }
}
