package com.example.mobilemall.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mobilemall.data.entity.ShoppingCart

/**
 * 购物车数据管理
 */
@Dao
interface ShoppingCartDao {
    /**
     * 购物车新增商品
     */
    @Insert
    fun addShoppingCart(shoppingCart: ShoppingCart)

    /**
     * 获取我的购物车列表
     */
    @Query("select * from shopping_carts where uid=:uid order by add_datetime desc")
    fun getShoppingCarts(uid: String): List<ShoppingCart>

    /**
     * 查询商品是否加过购物车
     */
    @Query("select * from shopping_carts where uid=:uid and item_uuid=:item_uuid")
    fun findItem(uid: String, item_uuid: String): ShoppingCart?

    /**
     * 删除购物车记录
     */
    @Query("delete from shopping_carts where uid=:uid")
    fun delete(uid: String)

    /**
     * 删除购物车商品
     */
    @Query("delete from shopping_carts where uid=:uid and item_uuid=:item_uuid")
    fun delete(uid: String, item_uuid: String)

    /**
     * 更新购物车记录
     */
    @Update
    fun update(shoppingCart: ShoppingCart)
}