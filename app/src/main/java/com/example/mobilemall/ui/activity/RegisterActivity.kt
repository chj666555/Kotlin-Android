package com.example.mobilemall.ui.activity

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Account
import com.example.mobilemall.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : BaseActivity(), View.OnClickListener {
    private var activityRegisterBinding: ActivityRegisterBinding? = null
    private var second = 60 //验证码倒计时
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        initBackgroundVideo()
    }

    /**
     * 初始化背景视频
     */
    private fun initBackgroundVideo() {
        activityRegisterBinding!!.video.setVideoURI(Uri.parse("android.resource://$packageName/raw/login_background"))
        activityRegisterBinding!!.video.setOnPreparedListener { mp: MediaPlayer ->
            mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
            mp.start()
            mp.isLooping = true //循环
        }
        activityRegisterBinding!!.video.start()
    }

    private val runnable: Runnable = object : Runnable {
        @SuppressLint("SetTextI18n")
        override fun run() {
            second--
            if (second < 0) {
                second = 60
                activityRegisterBinding!!.btnGetCode.text = "获取验证码"
                return
            }
            activityRegisterBinding!!.btnGetCode.text = second.toString() + "秒"
            handler.postDelayed(this, 1000) //更新验证码按钮文字
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnGetCode -> {

                //获取验证码
                if (second != 60) {
                    //还不可以获取验证码
                    return
                }
                second = 60
                handler.postDelayed(runnable, 1000) //更新验证码按钮文字
            }
            R.id.btnBack -> {

                //返回
                finish()
            }
            R.id.btnReg -> {
                //注册按钮事件
                //获取注册信息
                val username = activityRegisterBinding!!.etUserName.text.toString()
                val password = activityRegisterBinding!!.etPassword.text.toString()
                val code = activityRegisterBinding!!.etCode.text.toString()
                //检查内容合法性
                if (username.isEmpty() || password.isEmpty() || code.isEmpty()) {
                    toast("请将注册信息填写完整")
                    return
                }
                if (code.length != 6) {
                    toast("验证码输入有误")
                    return
                }
                Thread(Runnable {
                    if (MallDataBase.mallDataBase.accountDao().checkMobile(username).isNotEmpty()) {
                        toast("该手机号已被注册，请换一个")
                    } else {
                        val account = Account()
                        account.password = password
                        account.mobile = username
                        account.uid = UUID.randomUUID().toString().replace("-".toRegex(), "")
                        //新增用户
                        MallDataBase.mallDataBase.accountDao().register(account)
                        toast("注册成功")
                        finish()
                    }

                }).start()
            }
        }
    }
}