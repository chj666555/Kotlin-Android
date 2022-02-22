package com.example.mobilemall

import android.app.Application
import androidx.room.Room
import com.example.mobilemall.data.database.MallDataBase
//全局入口
class MallApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        mallApplication = this
        //初始化数据库
        MallDataBase.mallDataBase = Room.databaseBuilder(this, MallDataBase::class.java, "malldb").build()
    }

    companion object {
        lateinit var mallApplication: MallApplication
    }
}