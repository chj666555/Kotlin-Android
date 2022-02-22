package com.example.mobilemall.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/mobilemall/ui/activity/ItemDetailActivity;", "Lcom/example/mobilemall/ui/activity/BaseActivity;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "()V", "activityItemDetailBinding", "Lcom/example/mobilemall/databinding/ActivityItemDetailBinding;", "comments", "", "Lcom/example/mobilemall/data/entity/Comment;", "isFavorite", "", "item", "Lcom/example/mobilemall/data/entity/Item;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "add", "", "favorite", "Lcom/example/mobilemall/data/entity/Favorite;", "delete", "username", "", "good_id", "initFavoriteState", "initView", "loadComments", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMenuItemClick", "Landroid/view/MenuItem;", "app_debug"})
public final class ItemDetailActivity extends com.example.mobilemall.ui.activity.BaseActivity implements androidx.appcompat.widget.Toolbar.OnMenuItemClickListener {
    private com.example.mobilemall.databinding.ActivityItemDetailBinding activityItemDetailBinding;
    private com.example.mobilemall.data.entity.Item item;
    private androidx.appcompat.widget.Toolbar toolbar;
    private boolean isFavorite = false;
    private java.util.List<com.example.mobilemall.data.entity.Comment> comments;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void initView() {
    }
    
    /**
     * 初始化收藏状态
     */
    private final void initFavoriteState() {
    }
    
    public final void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void loadComments() {
    }
    
    @java.lang.Override()
    public boolean onMenuItemClick(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    /**
     * 查询商品收藏状态
     */
    private final boolean isFavorite(java.lang.String username, java.lang.String good_id) {
        return false;
    }
    
    /**
     * 收藏
     */
    private final void add(com.example.mobilemall.data.entity.Favorite favorite) {
    }
    
    /**
     * 取消收藏
     */
    private final void delete(java.lang.String username, java.lang.String good_id) {
    }
    
    public ItemDetailActivity() {
        super();
    }
}