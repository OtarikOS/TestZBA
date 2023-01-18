package com.koshkin.android.testzba.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.usecases.DeleteBinCardUseCase
import com.koshkin.android.testzba.domain.usecases.GetRemoteBinUseCase
import com.koshkin.android.testzba.domain.usecases.GetSavedBinsUseCase
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr
import kotlinx.coroutines.launch
import com.koshkin.android.testzba.domain.common.Result

class BinViewModel(

    private val deleteBinCardUseCase: DeleteBinCardUseCase,
    private val getRemoteBinUseCase: GetRemoteBinUseCase,
    private val getSavedBinsUseCase: GetSavedBinsUseCase,
    private val savedBinsUseCase: GetSavedBinsUseCase
) : ViewModel() {

    private val _dataLoading = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _bin = MutableLiveData<BinEntityPr>()
    val bin = _bin

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private var _remoteBin: BinCard? = null

    fun getBinV(id: Int) {
        viewModelScope.launch {
            _dataLoading.postValue(true)
            when (val binResult = getRemoteBinUseCase.invoke(id)) {
                is Result.Success -> {
                    _remoteBin = null
                    _remoteBin = binResult.data

//                val savedBins = getSavedBinsUseCase.invoke()
//                savedBins.collect {sBins -> bin.value = mapper.fro}
                }
                is Result.Error -> {
                    _dataLoading.postValue(false)
                    bin.value = null
                    _error.postValue(binResult.exception.message)
                }

            }
        }

    }

}
