package com.kotlin.user.ui.activity

import android.os.Bundle
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.R
import com.kotlin.user.presenter.RegisterPresenter
import com.kotlin.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        mRegisterBtn.setOnClickListener{
            mPresenter.register(mMobileEt.text.toString(),mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
            //D/OkHttp: <-- HTTP FAILED: java.net.SocketTimeoutException: failed to connect to /10.28.14.168 (port 8080) from /192.168.1.192 (port 39144) after 10000ms
        }

    }

    override fun onRegisterResult(result: Boolean) {
       toast("注册成功")
    }
}