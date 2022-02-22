package com.example.mobilemall.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0012\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/mobilemall/ui/activity/MainActivity;", "Lcom/example/mobilemall/ui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "()V", "activityMainBinding", "Lcom/example/mobilemall/databinding/ActivityMainBinding;", "currentIndex", "", "fragmentList", "Lcom/example/mobilemall/ui/fragment/FragmentList;", "loadItemList", "", "keyWords", "", "loadList", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "showCart", "showIndex", "showSearch", "switchFragment", "fragment", "Landroid/app/Fragment;", "app_debug"})
public final class MainActivity extends com.example.mobilemall.ui.activity.BaseActivity implements android.view.View.OnClickListener, androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
    private com.example.mobilemall.databinding.ActivityMainBinding activityMainBinding;
    private int currentIndex = 0;
    private com.example.mobilemall.ui.fragment.FragmentList fragmentList;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"NonConstantResourceId"})
    @java.lang.Override()
    public boolean onMenuItemClick(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void loadItemList(java.lang.String keyWords) {
    }
    
    /**
     * 显示首页
     */
    private final void showIndex() {
    }
    
    /**
     * 显示商品列表页面
     */
    private final void loadList(java.lang.String keyWords) {
    }
    
    /**
     * 显示购物车
     */
    private final void showCart() {
    }
    
    private final void switchFragment(android.app.Fragment fragment) {
    }
    
    private final void showSearch() {
    }
    
    @android.annotation.SuppressLint(value = {"NonConstantResourceId"})
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public MainActivity() {
        super();
    }
}