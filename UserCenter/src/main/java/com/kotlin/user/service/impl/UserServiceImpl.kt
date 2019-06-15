package com.kotlin.user.service.impl

import com.kotlin.base.rx.BaseException
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import rx.Observable

class UserServiceImpl :UserService{
    override fun  register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        val repository = UserRepository()

        return repository.register(mobile,pwd,verifyCode)
            .flatMap{
                // flatMap操作符     文档api,有时看实现更容易看懂
                //将Observable发出的项转换为Observable,然后将这些Observable压平成一个Observable
                //这里应该用map的?  不行,error情况下不行  BaseResp<String> -> boolean or http  error
                if(it.status!=0){ //业务状态码,错误,//TODO http错误
                     Observable.error(BaseException(it.status,it.message))
                }else{
                    Observable.just(true)
                }
            }
    }
}