package com.example.mobilemall.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobilemall.data.database.dao.*
import com.example.mobilemall.data.entity.*

/**
 * 数据库操作类
 */
@Database(entities = [Item::class, Account::class, ShoppingCart::class, Favorite::class, Comment::class], version = 1)
abstract class MallDataBase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    abstract fun accountDao(): AccountDao
    abstract fun commentDao(): CommentDao
    abstract fun shoppingCartDao(): ShoppingCartDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        lateinit var mallDataBase //数据库操作对象
                : MallDataBase
    }
}