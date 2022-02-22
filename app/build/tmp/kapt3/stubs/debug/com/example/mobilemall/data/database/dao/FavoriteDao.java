package com.example.mobilemall.data.database.dao;

import java.lang.System;

/**
 * 收藏数据库管理
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/mobilemall/data/database/dao/FavoriteDao;", "", "delete", "", "uid", "", "item_id", "find", "Lcom/example/mobilemall/data/entity/Favorite;", "insert", "favorite", "app_debug"})
public abstract interface FavoriteDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Favorite favorite);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from favorites  where uid=:uid and item_id=:item_id")
    public abstract com.example.mobilemall.data.entity.Favorite find(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String item_id);
    
    @androidx.room.Query(value = "delete from favorites where uid=:uid and item_id=:item_id")
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String item_id);
}