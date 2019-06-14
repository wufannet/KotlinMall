package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){
    this.subscribeOn(Schedulers.io()) //订阅在io线程
        .observeOn(AndroidSchedulers.mainThread()) //观察在主线程
        .subscribe(subscriber)
}