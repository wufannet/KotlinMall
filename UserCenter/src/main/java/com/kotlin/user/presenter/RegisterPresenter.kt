package com.kotlin.user.presenter

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.user.presenter.view.RegisterView
import com.kotlin.user.service.impl.UserServiceImpl
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * 1.业务逻辑,调用服务类/M(单层或者多层区分网络和数据库)类
 */
class RegisterPresenter:BasePresenter<RegisterView>() {

    fun register(mobile:String,verifyCode:String,pwd:String){

        /*
        观察者模式通过泛型基类来定义子类传递的数据类型,call<T>,callback<T>,onNext(T)
        1.Observable<Boolean>
        2.Subscriber<Boolean>
        3.onNext(t: Boolean)
         */

        val userService = UserServiceImpl()
        userService.register(mobile,verifyCode,pwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseSubscriber<Boolean>(){
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t)
                }
            })

    }
}