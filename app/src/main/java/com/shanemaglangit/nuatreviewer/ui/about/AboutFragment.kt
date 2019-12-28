package com.shanemaglangit.nuatreviewer.ui.about


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shanemaglangit.nuatreviewer.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity!!.title = "About the developers"
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
}
