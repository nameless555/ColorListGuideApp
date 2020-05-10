package com.nutchanok.colorlistguideapp.services

import com.nutchanok.colorlistguideapp.models.ListColorResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MainService {


    @GET("unknows")
    fun getListColor(
    ): Observable<ListColorResponse>


}