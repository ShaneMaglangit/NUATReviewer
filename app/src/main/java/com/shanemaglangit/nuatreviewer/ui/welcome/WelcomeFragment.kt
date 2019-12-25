package com.shanemaglangit.nuatreviewer.ui.welcome


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.util.Subjects
import kotlinx.android.synthetic.main.fragment_welcome.*
import org.koin.android.ext.android.inject

class WelcomeFragment : Fragment() {
    private val database: TopicDatabaseDao by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = requireActivity() as MainActivity
        activity.setSupportActionBarColor(Color.TRANSPARENT)
        activity.supportActionBar?.hide()

        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_math.setClickListener(Subjects.MATH)
        button_science.setClickListener(Subjects.SCIENCE)
        button_language.setClickListener(Subjects.LANGUAGE)
        button_aptitude.setClickListener(Subjects.APTITUDE)
    }

    private fun ImageButton.setClickListener(subject: String) {
        this.setOnClickListener {
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToTopicFragment(subject)
            )
        }
    }
}
