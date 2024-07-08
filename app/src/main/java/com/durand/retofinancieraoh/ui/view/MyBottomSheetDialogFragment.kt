package com.durand.retofinancieraoh.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.durand.retofinancieraoh.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetDialogFragment: BottomSheetDialogFragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate your bottom sheet layout here
        val view = inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        val textView = view.findViewById<TextView>(R.id.textView)
        return view
    }
}