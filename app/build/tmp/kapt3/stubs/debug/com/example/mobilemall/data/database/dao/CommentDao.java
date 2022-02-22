package com.example.mobilemall.data.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/mobilemall/data/database/dao/CommentDao;", "", "getCommentByItemId", "", "Lcom/example/mobilemall/data/entity/Comment;", "itemID", "", "insert", "", "comment", "app_debug"})
public abstract interface CommentDao {
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Comment comment);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from comments where item_id=:itemID order by publish_datetime desc")
    public abstract java.util.List<com.example.mobilemall.data.entity.Comment> getCommentByItemId(@org.jetbrains.annotations.NotNull()
    java.lang.String itemID);
}