package com.example.exercicio2310

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercicio2310.model.Socio


class MainViewModel : ViewModel(){
    val socioAtualizado: MutableLiveData<Socio> = MutableLiveData()

    fun setNovoSocio(socio: Socio) {
        socioAtualizado.postValue(socio)
    }

}