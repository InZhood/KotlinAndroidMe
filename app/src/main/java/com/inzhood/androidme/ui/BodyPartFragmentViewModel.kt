package com.inzhood.androidme.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inzhood.androidme.data.ImageAssets

class BodyPartFragmentViewModel: ViewModel() {

    var imageIndex: MutableLiveData<Int>
    var mImageIds: List<Int>
    fun getListIndex(): Int{
        return  imageIndex.value!!
    }
    fun setListIndex(index: Int) {

        imageIndex.value = index
    }

    fun getImageIds(): List<Int> {
        return mImageIds
    }


    init {
        imageIndex = MutableLiveData(0)
        mImageIds = ImageAssets.getBodies()
    }
}