package com.example.mobilemall.data.database.dao;

import java.lang.System;

/**
 * 购物车数据管理
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/example/mobilemall/data/database/dao/ShoppingCartDao;", "", "addShoppingCart", "", "shoppingCart", "Lcom/example/mobilemall/data/entity/ShoppingCart;", "delete", "uid", "", "item_uuid", "findItem", "getShoppingCarts", "", "update", "app_debug"})
public abstract interface ShoppingCartDao {
    
    /**
     * 购物车新增商品
     */
    @androidx.room.Insert()
    public abstract void addShoppingCart(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.ShoppingCart shoppingCart);
    
    /**
     * 获取我的购物车列表
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from shopping_carts where uid=:uid order by add_datetime desc")
    public abstract java.util.List<com.example.mobilemall.data.entity.ShoppingCart> getShoppingCarts(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    /**
     * 查询商品是否加过购物车
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from shopping_carts where uid=:uid and item_uuid=:item_uuid")
    public abstract com.example.mobilemall.data.entity.ShoppingCart findItem(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String item_uuid);
    
    /**
     * 删除购物车记录
     */
    @androidx.room.Query(value = "delete from shopping_carts where uid=:uid")
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String uid);
    
    /**
     * 删除购物车商品
     */
    @androidx.room.Query(value = "delete from shopping_carts where uid=:uid and item_uuid=:item_uuid")
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String uid, @org.jetbrains.annotations.NotNull()
    java.lang.String item_uuid);
    
    /**
     * 更新购物车记录
     */
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.ShoppingCart shoppingCart);
}