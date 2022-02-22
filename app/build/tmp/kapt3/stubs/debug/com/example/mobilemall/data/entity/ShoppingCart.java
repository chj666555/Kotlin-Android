package com.example.mobilemall.data.entity;

import java.lang.System;

/**
 * 购物车记录
 */
@androidx.room.TypeConverters(value = {com.example.mobilemall.data.database.convert.ItemConvert.class})
@androidx.room.Entity(tableName = "shopping_carts", primaryKeys = {"uid", "item_uuid"})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014\u00a8\u0006$"}, d2 = {"Lcom/example/mobilemall/data/entity/ShoppingCart;", "", "()V", "add_datetime", "", "getAdd_datetime", "()J", "setAdd_datetime", "(J)V", "item", "Lcom/example/mobilemall/data/entity/Item;", "getItem", "()Lcom/example/mobilemall/data/entity/Item;", "setItem", "(Lcom/example/mobilemall/data/entity/Item;)V", "item_uuid", "", "getItem_uuid", "()Ljava/lang/String;", "setItem_uuid", "(Ljava/lang/String;)V", "quantity", "", "getQuantity", "()I", "setQuantity", "(I)V", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "uid", "getUid", "setUid", "app_debug"})
public final class ShoppingCart {
    
    /**
     * 用户唯一标识
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uid = "";
    
    /**
     * 商品id
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String item_uuid = "";
    
    /**
     * 商品
     */
    @org.jetbrains.annotations.NotNull()
    private com.example.mobilemall.data.entity.Item item;
    
    /**
     * 数量
     */
    private int quantity = 0;
    
    /**
     * 商品添加购物车的时间
     */
    private long add_datetime = 0L;
    
    /**
     * 商品在购物车中的选择状态
     */
    private boolean selected = false;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUid() {
        return null;
    }
    
    public final void setUid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItem_uuid() {
        return null;
    }
    
    public final void setItem_uuid(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.mobilemall.data.entity.Item getItem() {
        return null;
    }
    
    public final void setItem(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Item p0) {
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final void setQuantity(int p0) {
    }
    
    public final long getAdd_datetime() {
        return 0L;
    }
    
    public final void setAdd_datetime(long p0) {
    }
    
    public final boolean getSelected() {
        return false;
    }
    
    public final void setSelected(boolean p0) {
    }
    
    public ShoppingCart() {
        super();
    }
}