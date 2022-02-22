package com.example.mobilemall.data.database;

import java.lang.System;

/**
 * 数据库操作类
 */
@androidx.room.Database(entities = {com.example.mobilemall.data.entity.Item.class, com.example.mobilemall.data.entity.Account.class, com.example.mobilemall.data.entity.ShoppingCart.class, com.example.mobilemall.data.entity.Favorite.class, com.example.mobilemall.data.entity.Comment.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/mobilemall/data/database/MallDataBase;", "Landroidx/room/RoomDatabase;", "()V", "accountDao", "Lcom/example/mobilemall/data/database/dao/AccountDao;", "commentDao", "Lcom/example/mobilemall/data/database/dao/CommentDao;", "favoriteDao", "Lcom/example/mobilemall/data/database/dao/FavoriteDao;", "itemDao", "Lcom/example/mobilemall/data/database/dao/ItemDao;", "shoppingCartDao", "Lcom/example/mobilemall/data/database/dao/ShoppingCartDao;", "Companion", "app_debug"})
public abstract class MallDataBase extends androidx.room.RoomDatabase {
    public static com.example.mobilemall.data.database.MallDataBase mallDataBase;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.mobilemall.data.database.MallDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mobilemall.data.database.dao.ItemDao itemDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mobilemall.data.database.dao.AccountDao accountDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mobilemall.data.database.dao.CommentDao commentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mobilemall.data.database.dao.ShoppingCartDao shoppingCartDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mobilemall.data.database.dao.FavoriteDao favoriteDao();
    
    public MallDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/mobilemall/data/database/MallDataBase$Companion;", "", "()V", "mallDataBase", "Lcom/example/mobilemall/data/database/MallDataBase;", "getMallDataBase", "()Lcom/example/mobilemall/data/database/MallDataBase;", "setMallDataBase", "(Lcom/example/mobilemall/data/database/MallDataBase;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.mobilemall.data.database.MallDataBase getMallDataBase() {
            return null;
        }
        
        public final void setMallDataBase(@org.jetbrains.annotations.NotNull()
        com.example.mobilemall.data.database.MallDataBase p0) {
        }
        
        private Companion() {
            super();
        }
    }
}