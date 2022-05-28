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
import timber.log.Timber

class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    private lateinit var questionViewModel: QuestionViewModel
    private val arguments: QuestionFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()

    private lateinit var activity: MainActivity
    private var questionNumber = 1

    private var secondaryColor = 0
    private var darkColor = 0

    private lateinit var optionButtons: List<Button>

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
        optionButtons = listOf(binding.buttonA, binding.buttonB, binding.buttonC, binding.buttonD)

        initColors()
        setupSupportActionBar()
        setupObserver()
        setupListeners()

        binding.questionViewModel = questionViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun initColors() {
        if (Build.VERSION.SDK_INT > 23) {
            secondaryColor = resources.getColor(R.color.secondaryColor, activity.theme)
            darkColor = resources.getColor(R.color.darkColor, activity.theme)
        } else {
            secondaryColor = resources.getColor(R.color.secondaryColor)
            darkColor = resources.getColor(R.color.darkColor)
        }
    }

    private fun setupSupportActionBar() {
        activity.supportActionBar?.apply {
            title = "Question #$questionNumber"
            show()
        }
    }

    private fun setupObserver() {
        questionViewModel.question.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                questionViewModel.calculateTotalQuestions()
                questionViewModel.loadQuestion()
            }
        })

        questionViewModel.currentQuestion.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                val options = questionViewModel.loadOptions().apply { shuffle() }

                optionButtons.forEachIndexed { index, button ->
                    button.text = options[index]
                }
            }
        })

        questionViewModel.testDone.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController()
                    .navigate(
                        QuestionFragmentDirections
                            .actionQuestionFragmentToResultFragment(
                                questionViewModel.correctAnswers,
                                questionViewModel.totalQuestions
                            )
                    )
                questionViewModel.testDoneCompleted()
            }
        })
    }

    private fun setupListeners() {
        optionButtons.forEach { it.setAnswerListener() }

        binding.buttonNext.setOnClickListener {
            val noMoreQuestion = questionViewModel.loadQuestion()
            binding.buttonNext.visibility = View.GONE

            if (!noMoreQuestion) {
                questionNumber++
                toggleStyle()
                optionButtons.forEach { it.isClickable = true }
                activity.supportActionBar!!.title = "Question #$questionNumber"
            } else {
                optionButtons.forEach { it.visibility = View.GONE }
            }
        }
    }

    private fun toggleStyle() {
        optionButtons.forEach {
            it.setBackgroundColor(darkColor)
            it.setTextColor(Color.WHITE)
        }
    }

    private fun Button.setAnswerListener() {
        this.setOnClickListener {
            val correctAnswer = questionViewModel.currentQuestion.value!!.answer

            if (correctAnswer == this.text.toString()) {
                this.setBackgroundColor(secondaryColor)
                this.setTextColor(darkColor)
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

            optionButtons.forEach { it.isClickable = false }
            binding.buttonNext.visibility = View.VISIBLE
        }
    }
}
