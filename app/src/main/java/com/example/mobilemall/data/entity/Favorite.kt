package com.example.mobilemall.data.entity

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.mobilemall.data.database.convert.ItemConvert

@Entity(tableName = "favorites", primaryKeys = ["uid", "item_id"])
@TypeConverters(ItemConvert::class)
class Favorite {
    //用户唯一标识
    var uid: String = ""

    //收藏的商品ID
    var item_id: String = ""

    //商品
    var item: Item=Item()

    //收藏时间
    var time: Long = 0
}