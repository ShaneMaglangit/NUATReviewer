package com.shanemaglangit.nuatreviewer.ui.topic


import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.databinding.FragmentTopicBinding
import com.shanemaglangit.nuatreviewer.util.Subjects
import com.shanemaglangit.nuatreviewer.util.TopicAdapter
import com.shanemaglangit.nuatreviewer.util.TopicListener
import org.koin.android.ext.android.inject

class TopicFragment : Fragment() {
    private lateinit var binding: FragmentTopicBinding
    private lateinit var topicViewModel: TopicViewModel
    private lateinit var topicAdapter: TopicAdapter
    private val arguments: TopicFragmentArgs by navArgs()
    private val database: TopicDatabaseDao by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_topic, container, false)
        topicViewModel =
            ViewModelProvider(this, TopicViewModelFactory(database, arguments.subject)).get(
                TopicViewModel::class.java
            )

        setupUI()
        setupSupportActionBar()
        setupObservers()

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        topicAdapter = TopicAdapter(TopicListener {
            findNavController().navigate(
                TopicFragmentDirections.actionTopicFragmentToLessonFragment(
                    it
                )
            )
        })

        binding.recyclerTopics.layoutManager = layoutManager
        binding.recyclerTopics.adapter = topicAdapter
        binding.lifecycleOwner = this

        return binding.root
    }

    private fun setupObservers() {
        topicViewModel.topics.observe(this, Observer {
            if (it != null) topicAdapter.submitList(it)
        })

        topicViewModel.categories.observe(this, Observer {
            if (it != null) {
                topicViewModel.loadTopics()
                it.forEach { category ->
                    val buttonCategory = Button(context).apply {
                        text = category
                        stateListAnimator = null
                        typeface = Typeface.create(
                            ResourcesCompat.getFont(context, R.font.montserrat),
                            Typeface.NORMAL
                        )
                        setBackgroundColor(Color.WHITE)
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        ).apply { marginStart = 40 }
                        setOnClickListener {
                            binding.linearMath.children.forEach { child ->
                                if (child is Button) {
                                    child.typeface = Typeface.create(
                                        ResourcesCompat.getFont(
                                            context,
                                            R.font.montserrat
                                        ), Typeface.NORMAL
                                    )
                                    child.background = ColorDrawable(Color.WHITE)
                                }
                            }
                            toggleSelectedCategory(this)
                            topicViewModel.loadTopics(category)
                        }
                    }

                    binding.linearMath.addView(buttonCategory)
                }

                toggleSelectedCategory(binding.linearMath.getChildAt(0) as Button)
            }
        })
    }

    private fun toggleSelectedCategory(view: Button) {
        view.typeface =
            Typeface.create(ResourcesCompat.getFont(context!!, R.font.montserrat), Typeface.BOLD)
        view.background =
            resources.getDrawable(R.drawable.selected_category_background, activity!!.theme)
    }

    private fun setupUI() {
        binding.imageHeader.setImageResource(
            when (arguments.subject) {
                Subjects.MATH -> R.drawable.ic_math_header
                Subjects.SCIENCE -> R.drawable.ic_science_header
                Subjects.LANGUAGE -> R.drawable.ic_language_header
                Subjects.APTITUDE -> R.drawable.ic_aptitude_header
                else -> R.drawable.ic_math_header
            }
        )
    }

    private fun setupSupportActionBar() {
        val activity = requireActivity() as MainActivity
        activity.supportActionBar!!.apply {
            title = ""
            show()
        }

        activity.setSupportActionBarColor(
            if (Build.VERSION.SDK_INT > 23) resources.getColor(R.color.darkColor, activity.theme)
            else resources.getColor(R.color.darkColor)
        )
    }
}