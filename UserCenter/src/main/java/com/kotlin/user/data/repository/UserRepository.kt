package com.kotlin.user.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * 可以持有多种数据源,目前是网络数据源
 */
class UserRepository @Inject constructor(){


    fun register(mobile:String,pwd:String,verifyCode:String): Observable<BaseResp<String >>{
        //RegisterReq map body就够了,改个参数要改一串调用方法,api的不用改了 v,p,m 3个类都要改
        // 多一个类,没省代码, 复杂度不够的情况,有点鸡肋
         return RetrofitFactory.instance.create(UserApi::class.java)
             .register(RegisterReq(mobile,pwd,verifyCode))
    }
}