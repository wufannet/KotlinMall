package com.kotlin.user.injection.moudle

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * 类似工厂类的静态工厂方法
 * 或者抽象类提供工厂方法,根据配置返回不同的实现类
 * 两种纬度的注入
 * 1.构造函数
 * 2.接口,其他库类,使用Module,工厂方法提供
 */
@Module
class UserModule {

    @Provides
    fun providesUserSevice(service: UserServiceImpl):UserService{
        return service
    }
}