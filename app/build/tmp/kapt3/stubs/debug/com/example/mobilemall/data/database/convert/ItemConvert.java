package com.example.mobilemall.data.database.convert;

import java.lang.System;

/**
 * 将商品实体通过JSON形式存到数据库
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/mobilemall/data/database/convert/ItemConvert;", "", "()V", "fromArrayList", "", "item", "Lcom/example/mobilemall/data/entity/Item;", "fromString", "value", "app_debug"})
public final class ItemConvert {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mobilemall.data.database.convert.ItemConvert INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public static final com.example.mobilemall.data.entity.Item fromString(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverter()
    public static final java.lang.String fromArrayList(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Item item) {
        return null;
    }
    
    private ItemConvert() {
        super();
    }
}