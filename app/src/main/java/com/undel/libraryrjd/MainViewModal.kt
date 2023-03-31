package com.undel.libraryrjd

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.undel.libraryrjd.data.models.documents
import com.undel.libraryrjd.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModal @Inject constructor(private val repository: ApiRepository):ViewModel() {

    private val _allDocuments = MutableLiveData<List<documents>>()
    val allDocument: LiveData<List<documents>>
        get() = _allDocuments
    fun getAllDoc(){
        viewModelScope.launch(){
            repository.getAllDocument().let {
                if (it.isSuccessful){
                    _allDocuments.postValue(it.body())
                }
                else{
                    Log.d("checkData", "Ошибка: ${it.errorBody()}")
                }
            }

        }
    }
}