package com.example.mobilemall.data.database.convert

import androidx.room.TypeConverter
import com.example.mobilemall.data.entity.Item
import com.google.gson.Gson

/**
 * 将商品实体通过JSON形式存到数据库
 */
object  ItemConvert {
    @JvmStatic
    @TypeConverter
    fun fromString(value: String): Item {
        return Gson().fromJson(value, Item::class.java)
    }

    @JvmStatic
    @TypeConverter
    fun fromArrayList(item: Item): String {
        val gson = Gson()
        return gson.toJson(item)
    }
}