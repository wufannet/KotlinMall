package com.kotlin.base.common

/*
    基础常量
    放在base中, base和当前项目耦合,并不是通用的可以直接拷贝的,没法打成库包通用.还是代码层的复用,要修改常量. 不同项目除了ui/业务包,别的好像都通用了.
 */
class BaseConstant{
    companion object {
        //七牛服务地址
        const val IMAGE_SERVER_ADDRESS = "http://osea2fxp7.bkt.clouddn.com/"
        //本地服务器地址
        const val SERVER_ADDRESS = "http://10.28.14.168:8080"
        //SP表名
        const val TABLE_PREFS = "Kotlin_mall"
        //Token Key
        const val KEY_SP_TOKEN = "token"
    }
}
