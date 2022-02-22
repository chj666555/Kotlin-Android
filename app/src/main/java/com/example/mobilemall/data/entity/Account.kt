package com.example.mobilemall.data.entity

import androidx.room.Entity

/**
 * 账号
 */
@Entity(tableName = "accounts", primaryKeys = ["mobile", "uid"])
class Account {
    var mobile //手机号
            : String = ""
    var uid //用户唯一标识
            : String= ""
    var password //密码
            : String= ""
}