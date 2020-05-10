package com.nutchanok.colorlistguideapp.services

import com.nutchanok.colorlistguideapp.models.ListColor
import com.nutchanok.colorlistguideapp.models.ListColorResponse
import com.nutchanok.colorlistguideapp.views.MainView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainPresenter(private val view: MainView) {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun getListColor() {
        retrofit.create<MainService>(MainService::class.java)
            .getListColor()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ListColorResponse> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(listColorResponse: ListColorResponse) {
                  view.setUserColor(listColorResponse)
                    var d = listColorResponse
                }

                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })
    }


}
