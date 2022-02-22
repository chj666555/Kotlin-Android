package com.example.mobilemall.data.entity

import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.mobilemall.data.database.convert.ItemConvert

/**
 * 购物车记录
 */
@Entity(tableName = "shopping_carts", primaryKeys = ["uid", "item_uuid"])
@TypeConverters(ItemConvert::class)
class ShoppingCart {
    /**
     * 用户唯一标识
     */
    var uid: String= ""

    /**
     * 商品id
     */
    var item_uuid: String= ""

    /**
     * 商品
     */
    var item: Item=Item()

    /**
     * 数量
     */
    var quantity = 0

    /**
     * 商品添加购物车的时间
     */
    var add_datetime: Long = 0

    /**
     * 商品在购物车中的选择状态
     */
    var selected:Boolean = false
}