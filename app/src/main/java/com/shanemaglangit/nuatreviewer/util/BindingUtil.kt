package com.shanemaglangit.nuatreviewer.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("resultSub")
fun setResultSub(view: TextView, value: Int) {
    view.text = "correct answers out of $value questions"
}