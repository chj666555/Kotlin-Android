package com.example.mobilemall.ui.fragment

import android.app.Fragment
import com.example.mobilemall.ui.activity.BaseActivity

open class BaseFragment : Fragment() {
    val parentActivity: BaseActivity
        get() = activity as BaseActivity
}