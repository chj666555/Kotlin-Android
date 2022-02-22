package com.example.mobilemall.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobilemall.data.entity.Account

@Dao
interface AccountDao {
    /**
     * 检查手机号是否可用
     */
    @Query("select * from accounts where mobile=:mobile")
    fun checkMobile(mobile: String): List<Account>

    /**
     * 注册
     */
    @Insert
    fun register(account: Account)

    /**
     * 登录验证
     */
    @Query("select * from accounts where mobile=:mobile and password=:passWord")
    fun login(mobile: String, passWord: String): Account?
}