package com.inzhood.androidme.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.inzhood.androidme.R
import com.inzhood.androidme.data.ImageAssets
import kotlinx.android.synthetic.main.fragment_body_part.view.*
import kotlinx.android.synthetic.main.fragment_leg_part.view.*

class LegPartFragment: Fragment() {
    private lateinit var mImageIds: List<Int>
    private var mListIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_leg_part, container, false)
        var mImageIds = ImageAssets.getLegs()
        rootView.leg_part.setImageResource(mImageIds.get(mListIndex))
        return rootView
    }

    companion object {
        fun newInstance() = LegPartFragment()

        private val PARAM = "PARAM"
        fun newInstance(param: Parcelable): LegPartFragment {
            val args: Bundle = Bundle()
            args.putParcelable(PARAM, param)
            val fragment = LegPartFragment()
            fragment.arguments = args
            return fragment
        }
    }
}