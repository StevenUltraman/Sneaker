package com.irozon.sneakersample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.irozon.sneaker.Sneaker

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btShowWarning).setOnClickListener {
            Sneaker.with(this)
                .setTitle("Warning!!")
                .setCornerRadius(5, 5)
                .setMessage("This is the warning message")
                .sneakWarning()
        }
    }
}