package com.shanemaglangit.nuatreviewer.ui.start


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.shanemaglangit.nuatreviewer.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {
    private val arguments: StartFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_description.text = arguments.description

        setupListeners()
    }

    private fun setupListeners() {
        button_return.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_homeFragment)
        }

        button_test.setOnClickListener {
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToQuestionFragment(arguments.title)
            )
        }
    }
}
