package com.shanemaglangit.nuatreviewer.ui.lesson


import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shanemaglangit.nuatreviewer.MainActivity
import com.shanemaglangit.nuatreviewer.R
import kotlinx.android.synthetic.main.fragment_lesson.*

class LessonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setupSupportActionBar()

        return inflater.inflate(R.layout.fragment_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_return.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setupSupportActionBar() {
        val activity = requireActivity() as MainActivity
        activity.supportActionBar?.apply {
            setBackgroundDrawable(
                ColorDrawable(
                    if (Build.VERSION.SDK_INT > 23) resources.getColor(
                        R.color.secondaryColor,
                        activity.theme
                    ) else resources.getColor(R.color.secondaryDarkColor)
                )
            )
            title = "Operations"
            show()
        }
    }
}
