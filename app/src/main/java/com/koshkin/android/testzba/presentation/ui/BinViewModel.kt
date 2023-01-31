package com.koshkin.android.testzba.presentation.ui

import android.util.Log
import androidx.lifecycle.*
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.usecases.DeleteBinCardUseCase
import com.koshkin.android.testzba.domain.usecases.GetRemoteBinUseCase
import com.koshkin.android.testzba.domain.usecases.GetSavedBinsUseCase
import com.koshkin.android.testzba.domain.usecases.SaveBinCardUseCase
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr
import kotlinx.coroutines.launch
import com.koshkin.android.testzba.domain.common.Result
import com.koshkin.android.testzba.presentation.mapperspr.BinEntityMapperPr

class BinViewModel(

    private val deleteBinCardUseCase: DeleteBinCardUseCase,
    private val getRemoteBinUseCase: GetRemoteBinUseCase,
    private val getSavedBinsUseCase: GetSavedBinsUseCase,
    private val savedBinsUseCase: SaveBinCardUseCase,
    private val mapper: BinEntityMapperPr
) : ViewModel() {

    private val _dataLoading = MutableLiveData(true)
    val dataLoading: LiveData<Boolean> = _dataLoading

    private var _bin = MutableLiveData<BinEntityPr>()
    var bin:LiveData<BinEntityPr> = _bin

    var binPr:BinEntityPr? = null


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
                    _dataLoading.postValue(false)
                     _bin.postValue(mapper.fromBinCardToBinEntityPr(binResult.data))
                    binPr
         //           Log.i("BVM_binPr", binPr!!.scheme.toString())
//                val savedBins = getSavedBinsUseCase.invoke()
//                savedBins.collect {sBins -> bin.value = mapper.fro}
                }
                is Result.Error -> {
                    _dataLoading.postValue(false)
              //      bin.value = null
                    _error.postValue(binResult.exception.message)
                    Log.i("BVM",binResult.toString())
                }
            }
        }
    }

    fun saveBinPr(bin: BinEntityPr) {
        viewModelScope.launch {
            savedBinsUseCase.invoke(mapper.fromEntityPrToBinCard(bin))
        }
    }

    fun deleteBinPr(bin: BinEntityPr) {
        viewModelScope.launch {
            deleteBinCardUseCase.invoke(mapper.fromEntityPrToBinCard(bin))
        }
    }

    class BinViewModelFactory(

        private val deleteBinCardUseCase: DeleteBinCardUseCase,
        private val getRemoteBinUseCase: GetRemoteBinUseCase,
        private val getSavedBinsUseCase: GetSavedBinsUseCase,
        private val savedBinsUseCase: SaveBinCardUseCase,
        private val mapper: BinEntityMapperPr
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return BinViewModel(
                deleteBinCardUseCase,
                getRemoteBinUseCase,
                getSavedBinsUseCase,
                savedBinsUseCase,
                mapper
            ) as T
        }
    }
}
