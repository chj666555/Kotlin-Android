package com.example.mobilemall.data.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\tH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/mobilemall/data/database/dao/ItemDao;", "", "addItem", "", "items", "Lcom/example/mobilemall/data/entity/Item;", "deleteAll", "find", "uuid", "", "findAll", "", "keywords", "app_debug"})
public abstract interface ItemDao {
    
    @androidx.room.Insert()
    public abstract void addItem(@org.jetbrains.annotations.Nullable()
    com.example.mobilemall.data.entity.Item items);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from items order by add_datetime desc")
    public abstract java.util.List<com.example.mobilemall.data.entity.Item> findAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from items where uuid=:uuid")
    public abstract com.example.mobilemall.data.entity.Item find(@org.jetbrains.annotations.NotNull()
    java.lang.String uuid);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from items where title like \'%\'|| :keywords|| \'%\' or content like \'%\'|| :keywords|| \'%\'")
    public abstract java.util.List<com.example.mobilemall.data.entity.Item> findAll(@org.jetbrains.annotations.NotNull()
    java.lang.String keywords);
    
    @androidx.room.Query(value = "delete from items")
    public abstract void deleteAll();
}