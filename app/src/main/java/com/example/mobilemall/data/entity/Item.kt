package com.example.mobilemall.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
class Item {
    //ID
    @PrimaryKey
    var uuid: String = ""

    //标题
    var title: String= ""

    //详情
    var content: String= ""

    //价格
    var price = 0f

    //图片名
    var picture: String=""

    //添加时间
    var add_datetime: Long = 0
}