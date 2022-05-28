package com.shanemaglangit.nuatreviewer.ui.welcome


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import com.shanemaglangit.nuatreviewer.databinding.FragmentWelcomeBinding
import com.shanemaglangit.nuatreviewer.util.Subjects

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).supportActionBar?.hide()
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMath.setClickListener(Subjects.MATH)
        binding.buttonScience.setClickListener(Subjects.SCIENCE)
        binding.buttonLanguage.setClickListener(Subjects.LANGUAGE)
        binding.buttonAptitude.setClickListener(Subjects.APTITUDE)

        binding.buttonAbout.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_aboutFragment)
        }
    }

    private fun ImageButton.setClickListener(subject: String) {
        this.setOnClickListener {
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToTopicFragment(subject)
            )
        }
    }
}
