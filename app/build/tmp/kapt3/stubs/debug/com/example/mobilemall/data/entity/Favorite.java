package com.example.mobilemall.data.entity;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.example.mobilemall.data.database.convert.ItemConvert.class})
@androidx.room.Entity(tableName = "favorites", primaryKeys = {"uid", "item_id"})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/example/mobilemall/data/entity/Favorite;", "", "()V", "item", "Lcom/example/mobilemall/data/entity/Item;", "getItem", "()Lcom/example/mobilemall/data/entity/Item;", "setItem", "(Lcom/example/mobilemall/data/entity/Item;)V", "item_id", "", "getItem_id", "()Ljava/lang/String;", "setItem_id", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "uid", "getUid", "setUid", "app_debug"})
public final class Favorite {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uid = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String item_id = "";
    @org.jetbrains.annotations.NotNull()
    private com.example.mobilemall.data.entity.Item item;
    private long time = 0L;
    
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
    public final com.example.mobilemall.data.entity.Item getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Item p0) {
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
    
    public Favorite() {
        super();
    }
}