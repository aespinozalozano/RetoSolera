package com.ademirespinoza.retosolera.source.remote

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by fernandopretell.
 */
interface WebServiceImages {

    @GET("{image}")
    fun obtenerImagen(@Path("image") image:String): Call<ResponseBody>
}