package com.koshkin.android.testzba

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koshkin.android.testzba.data.api.Bank
import com.koshkin.android.testzba.data.api.Country
import com.koshkin.android.testzba.data.api.Number

class MainActivityViewModel : ViewModel() {
    //  val title = MutableLiveData<String>()
    //  val description = MutableLiveData<String>()
    val number = MutableLiveData<Number>()
    val scheme = MutableLiveData<String>()
    val type = MutableLiveData<String>()
    val brand = MutableLiveData<String>()
    val prepaid = MutableLiveData<Boolean>()
    val country = MutableLiveData<Country>()
    val bank = MutableLiveData<Bank>()
}
