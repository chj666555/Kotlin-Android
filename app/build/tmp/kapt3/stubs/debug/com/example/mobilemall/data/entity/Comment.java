package com.example.mobilemall.data.entity;

import java.lang.System;

/**
 * 评论
 */
@androidx.room.Entity(tableName = "comments")
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/example/mobilemall/data/entity/Comment;", "", "()V", "comment", "", "item", "Lcom/example/mobilemall/data/entity/Item;", "(Ljava/lang/String;Lcom/example/mobilemall/data/entity/Item;)V", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "item_id", "getItem_id", "setItem_id", "publish_datetime", "", "getPublish_datetime", "()J", "setPublish_datetime", "(J)V", "uid", "getUid", "setUid", "uuid", "getUuid", "setUuid", "app_debug"})
public final class Comment {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private java.lang.String uuid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String item_id = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String comment = "";
    private long publish_datetime = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUuid() {
        return null;
    }
    
    public final void setUuid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    public final void setUid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItem_id() {
        return null;
    }
    
    public final void setItem_id(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getComment() {
        return null;
    }
    
    public final void setComment(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long getPublish_datetime() {
        return 0L;
    }
    
    public final void setPublish_datetime(long p0) {
    }
    
    public Comment() {
        super();
    }
    
    public Comment(@org.jetbrains.annotations.NotNull()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Item item) {
        super();
    }
}