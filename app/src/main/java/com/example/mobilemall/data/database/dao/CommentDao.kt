package com.example.mobilemall.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobilemall.data.entity.Comment

@Dao
interface CommentDao {
    /*
     * 发布评论
     * */
    @Insert
    fun insert(comment: Comment)

    /*
     *  获取商品评论
     * */
    @Query("select * from comments where item_id=:itemID order by publish_datetime desc")
    fun getCommentByItemId(itemID: String): List<Comment>
}