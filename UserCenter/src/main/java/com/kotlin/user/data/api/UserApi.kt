package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * UserApi ,GitHubService
 * 名字的纠结,包结构的纠结, api还是service
 * data/net/api才对
 * 职责: 网络数据源 DataSource
 */
interface UserApi {
    /*
     @POST("services/auth/register")
     Call<BaseResBean<UserBean>> register(@Body Map params);
     @Body Map
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>
}