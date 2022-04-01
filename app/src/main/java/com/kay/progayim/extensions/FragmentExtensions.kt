package com.kay.progayim.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(msg: String, length: Int? = Toast.LENGTH_LONG){

    Toast.makeText(requireContext(),msg, length!!).show()
}