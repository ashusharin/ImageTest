package com.shusharin.testcaseimage.ui.detailScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.shusharin.testcaseimage.R
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "img"

class DetailFragment : Fragment() {

    private var img: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            img = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgHolder = activity?.findViewById<ImageView>(R.id.image_holder)
        Picasso.get().load(img).error(R.drawable.ic_launcher_foreground).into(imgHolder)
    }
}