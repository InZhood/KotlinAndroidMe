package com.inzhood.androidme.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.inzhood.androidme.R
import com.inzhood.androidme.data.ImageAssets
import kotlinx.android.synthetic.main.fragment_body_part.view.*
import kotlinx.android.synthetic.main.fragment_head_part.view.*
import kotlinx.android.synthetic.main.fragment_leg_part.view.*

class BodyPartFragment: Fragment() {

    // moved to ViewModel
    // private lateinit var mImageIds: List<Int>
    // private var mListIndex = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_body_part, container, false)
        val model = ViewModelProvider(this) [BodyPartFragmentViewModel::class.java]
        // this works var mImageIds = ImageAssets.getBodies()
       // don't need it, covered in observe rootView.body_part.setImageResource(model.mImageIds.get(model.getListIndex()))
        rootView.body_part.setOnClickListener {
            val currentIndex = model.getListIndex()
            if (currentIndex < model.mImageIds.size -1 ) {
                model.setListIndex(currentIndex + 1)
            } else {
                model.setListIndex(0)
            }
            // being replaced by observe rootView.body_part.setImageResource(model.mImageIds.get(model.getListIndex()))
        }
        model.imageIndex.observe(viewLifecycleOwner, Observer {
            index -> rootView.body_part.setImageResource(model.mImageIds.get(index))
        })
        return rootView
    }

    companion object {
        fun newInstance() = BodyPartFragment()

        private val PARAM = "PARAM"
        fun newInstance(param: Parcelable): BodyPartFragment {
            val args: Bundle = Bundle()
            args.putParcelable(PARAM, param)
            val fragment = BodyPartFragment()
            fragment.arguments = args
            return fragment
        }
    }
}