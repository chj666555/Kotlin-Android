package com.example.mobilemall.data.database.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/mobilemall/data/database/dao/AccountDao;", "", "checkMobile", "", "Lcom/example/mobilemall/data/entity/Account;", "mobile", "", "login", "passWord", "register", "", "account", "app_debug"})
public abstract interface AccountDao {
    
    /**
     * 检查手机号是否可用
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from accounts where mobile=:mobile")
    public abstract java.util.List<com.example.mobilemall.data.entity.Account> checkMobile(@org.jetbrains.annotations.NotNull()
    java.lang.String mobile);
    
    /**
     * 注册
     */
    @androidx.room.Insert()
    public abstract void register(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.data.entity.Account account);
    
    /**
     * 登录验证
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select * from accounts where mobile=:mobile and password=:passWord")
    public abstract com.example.mobilemall.data.entity.Account login(@org.jetbrains.annotations.NotNull()
    java.lang.String mobile, @org.jetbrains.annotations.NotNull()
    java.lang.String passWord);
}