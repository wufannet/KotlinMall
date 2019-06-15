package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import javax.inject.Inject

/**
 * BaseMvpActivity 组合mPresenter,类型为泛型T, BaseView是接口,无法组合mPresenter
 * MPV类结构,  activity/v与p一一对应,通过泛型基类,继承,组合实现, 省去了子类组合P,V,直接通过泛型配置基类mView,mPresenter
 * 自己的代码没有把组合责任上交给父类,因为考虑到可能一个activity持有多个presenter.不过可以父类组合一个,其他的通过子类自己组合.
 */
open class BaseMvpActivity<T:BasePresenter<*>> : BaseActivity(),BaseView {
    @Inject
    lateinit var mPresenter:T

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}