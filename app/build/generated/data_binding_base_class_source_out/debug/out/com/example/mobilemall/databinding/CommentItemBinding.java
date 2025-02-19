// Generated by data binding compiler. Do not edit!
package com.example.mobilemall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.mobilemall.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class CommentItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView txtContent;

  @NonNull
  public final TextView txtDateTime;

  @NonNull
  public final TextView txtUID;

  protected CommentItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView txtContent, TextView txtDateTime, TextView txtUID) {
    super(_bindingComponent, _root, _localFieldCount);
    this.txtContent = txtContent;
    this.txtDateTime = txtDateTime;
    this.txtUID = txtUID;
  }

  @NonNull
  public static CommentItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.comment_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static CommentItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<CommentItemBinding>inflateInternal(inflater, R.layout.comment_item, root, attachToRoot, component);
  }

  @NonNull
  public static CommentItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.comment_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static CommentItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<CommentItemBinding>inflateInternal(inflater, R.layout.comment_item, null, false, component);
  }

  public static CommentItemBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static CommentItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (CommentItemBinding)bind(component, view, R.layout.comment_item);
  }
}
