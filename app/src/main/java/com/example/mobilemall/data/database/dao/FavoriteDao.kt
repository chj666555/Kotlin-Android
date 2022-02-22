package com.example.mobilemall.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobilemall.data.entity.Favorite

/**
 * 收藏数据库管理
 */
@Dao
interface FavoriteDao {
    /*
     * 新增收藏
     * */
    @Insert
    fun insert( favorite: Favorite)

    /*
     * 查找收藏
     * */
    @Query("select * from favorites  where uid=:uid and item_id=:item_id")
    fun find(uid: String, item_id: String): Favorite?

    /*
     * 取消收藏
     * */
    @Query("delete from favorites where uid=:uid and item_id=:item_id")
    fun delete(uid: String, item_id: String)
}