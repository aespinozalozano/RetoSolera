package com.ademirespinoza.retosolera.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ademirespinoza.retosolera.source.remote.ResponseApi
import com.ademirespinoza.retosolera.repository.PeliculasRepository
import com.ademirespinoza.retosolera.source.local.ResponseEntity

/**
 * Created by fernandopretell.
 */
class PeliculaViewModel(application: Application): AndroidViewModel(application) {

    private var peliculaRepository: PeliculasRepository? = null
    private var list_peliculas: LiveData<ResponseEntity>? = null


    init {

        peliculaRepository = PeliculasRepository(application)
        list_peliculas = peliculaRepository?.listar_peliculas()
    }

    fun listarPeliculasLocal(): LiveData<ResponseEntity>? {

        return list_peliculas
    }

    //ws
    fun getPeliculasRemoto(id: Int): LiveData<ResponseApi> {
        return peliculaRepository?.obtenerPeliculas(id)!!
    }
}