package com.kotlin.user.injection.component

import com.kotlin.user.injection.moudle.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * 属性和注入构造函数,注入Module的连接
 */


@Component(modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)

}