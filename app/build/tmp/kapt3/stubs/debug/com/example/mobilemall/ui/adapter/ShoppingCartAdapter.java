package com.example.mobilemall.ui.adapter;

import java.lang.System;

/**
 * 购物车列表适配器
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0017J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/mobilemall/ui/adapter/ShoppingCartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/mobilemall/ui/adapter/holder/ShoppingCartItemHolder;", "Landroid/view/View$OnClickListener;", "fragment", "Lcom/example/mobilemall/ui/fragment/FragmentShoppingCart;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "shoppingCarts", "", "Lcom/example/mobilemall/data/entity/ShoppingCart;", "(Lcom/example/mobilemall/ui/fragment/FragmentShoppingCart;Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
public final class ShoppingCartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.mobilemall.ui.adapter.holder.ShoppingCartItemHolder> implements android.view.View.OnClickListener {
    private final com.example.mobilemall.ui.fragment.FragmentShoppingCart fragment = null;
    private final androidx.recyclerview.widget.RecyclerView recyclerView = null;
    private final java.util.List<com.example.mobilemall.data.entity.ShoppingCart> shoppingCarts = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.mobilemall.ui.adapter.holder.ShoppingCartItemHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.ui.adapter.holder.ShoppingCartItemHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NonConstantResourceId"})
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public ShoppingCartAdapter(@org.jetbrains.annotations.NotNull()
    com.example.mobilemall.ui.fragment.FragmentShoppingCart fragment, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.mobilemall.data.entity.ShoppingCart> shoppingCarts) {
        super();
    }
}