package com.kotlin.base.data.net

import com.kotlin.base.common.BaseConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 工厂方法类,单例入口
 */
class RetrofitFactory private constructor(){
    companion object{
        //伴生对象,实现单例,工厂方法 lazy是线程安全的
        //没用m开头定义字段,thread java类也没有,activity有
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit:Retrofit
    private val interceptor:Interceptor

    init {
        /* header统一添加(token,utf-8格式), 通用拦截器
          方法参数覆盖注解实现封装
          @Headers("Content-Type:application/json")
          @Headers("Content-Type:application/x-www-form-urlencoded")
          @POST 情况都带了Content-Type,@GET没有带,重复添加,怎么让业务类能重载拦截器设置?  父类子类可以,统一拦截器就没法搞了,可以没对应注解再覆盖!!
          这种情况怎么办?
         */
        //it 默认,应该默认为chain
        interceptor = Interceptor{
           chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("charset","utf-8")
                .build()
           chain.proceed(request) //lambda不需要return,最后的表达式就是返回值
        }


        retrofit = Retrofit.Builder()
            .baseUrl(BaseConstant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()


    }

    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(initLogInterceptor())
            .connectTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .build()
    }

    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * GitHubService service = retrofit.create(GitHubService.class);
     * 这里是少调用一次private retrofit 相当于代理, 方法签名一样,可以使用kotlin的委托,不需要自己写
     */
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }

}