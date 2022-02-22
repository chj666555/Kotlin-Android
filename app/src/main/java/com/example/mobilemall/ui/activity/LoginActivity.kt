package com.example.mobilemall.ui.activity

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.mobilemall.R
import com.example.mobilemall.data.database.MallDataBase
import com.example.mobilemall.data.entity.Account
import com.example.mobilemall.databinding.ActivityLoginBinding
import com.example.mobilemall.util.Constant
import com.google.gson.Gson

/**
 * 登录页面
 */
class LoginActivity : BaseActivity() {
    private var activityLoginBinding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val account = geAccount()
        if (account != null) {
            //已经保存过密码,直接登录
            Constant.account = account
            finish()
            startActivity(Intent(this, MainActivity::class.java))
            return
        }
        initBackgroundVideo()
    }

    /**
     * 初始化背景视频
     */
    private fun initBackgroundVideo() {
        activityLoginBinding!!.video.setVideoURI(Uri.parse("android.resource://$packageName/raw/login_background"))
        activityLoginBinding!!.video.setOnPreparedListener { mp: MediaPlayer ->
            mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
            mp.start()
            mp.isLooping = true //循环
        }
        activityLoginBinding!!.video.start()
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.btnReg -> {

                //注册
                startActivity(Intent(this, RegisterActivity::class.java))
            }
            R.id.btnLogin -> {

                //登录
                val username = activityLoginBinding!!.etUserName.text.toString()
                val password = activityLoginBinding!!.etPassword.text.toString()
                Thread(Runnable {
                    val account = MallDataBase.mallDataBase.accountDao().login(username, password)
                    if (account == null) {
                        toast("用户名或密码错误")
                    } else {
                        Constant.account = account
                        if (activityLoginBinding!!.chkPwd.isChecked) {
                            //记住密码
                            keepLogin(account)
                        }
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }).start()
            }
        }
    }

    //记住密码
    private fun keepLogin(account: Account) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences.edit().putString("user_info", Gson().toJson(account)).apply()
    }

    //获取保存的用户信息,用于登录
    private fun geAccount(): Account? {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val user_info_json = sharedPreferences.getString("user_info", null)
        return if (user_info_json == null) {
            null
        } else {
            Gson().fromJson(user_info_json, Account::class.java)
        }
    }
}