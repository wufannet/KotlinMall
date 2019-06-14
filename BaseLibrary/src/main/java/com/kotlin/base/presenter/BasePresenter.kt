package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 * BasePresenter 组合mView,类型为泛型T
 */
open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}