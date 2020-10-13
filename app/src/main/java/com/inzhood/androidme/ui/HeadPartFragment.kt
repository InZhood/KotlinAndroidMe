package com.inzhood.androidme.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.inzhood.androidme.R
import com.inzhood.androidme.data.ImageAssets
import kotlinx.android.synthetic.main.fragment_body_part.view.*
import kotlinx.android.synthetic.main.fragment_head_part.view.*

class HeadPartFragment : Fragment() {
    private var mListIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        var mImageIds = ImageAssets.getHeads()
        val rootView = inflater.inflate(R.layout.fragment_head_part, container, false)
        rootView.head_part.setImageResource(mImageIds.get(mListIndex))

        rootView.head_part.setOnClickListener {
            val currentIndex = mListIndex
            if (currentIndex <mImageIds.size -1 ) {
                mListIndex = currentIndex + 1
            } else {
                mListIndex = 0
            }
            rootView.head_part.setImageResource(mImageIds.get(mListIndex))
        }


        return rootView
    }

    companion object {
        fun newInstance() = HeadPartFragment()

        private val PARAM = "PARAM"
        fun newInstance(param: Parcelable): HeadPartFragment {
            val args: Bundle = Bundle()
            args.putParcelable(PARAM, param)
            val fragment = HeadPartFragment()
            fragment.arguments = args
            return fragment
        }
    }
}