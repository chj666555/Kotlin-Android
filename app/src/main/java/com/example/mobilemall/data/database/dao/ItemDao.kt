package com.example.mobilemall.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobilemall.data.entity.Item

@Dao
interface ItemDao {
    //新增商品
    @Insert
    fun addItem(items: Item?)

    //查询所有商品，按时间倒序排列
    @Query("select * from items order by add_datetime desc")
    fun findAll(): List<Item>

    //查询指定商品
    @Query("select * from items where uuid=:uuid")
    fun find(uuid: String): Item

    //根据关键词查询商品，按时间倒序排列
    @Query("select * from items where title like '%'|| :keywords|| '%' or content like '%'|| :keywords|| '%'")
    fun findAll(keywords: String): List<Item>

    //删除所有商品
    @Query("delete from items")
    fun deleteAll()
}