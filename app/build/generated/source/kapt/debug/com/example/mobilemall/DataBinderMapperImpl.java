package com.example.mobilemall;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.mobilemall.databinding.ActivityFirstBindingImpl;
import com.example.mobilemall.databinding.ActivityItemDetailBindingImpl;
import com.example.mobilemall.databinding.ActivityLoginBindingImpl;
import com.example.mobilemall.databinding.ActivityMainBindingImpl;
import com.example.mobilemall.databinding.ActivityRegisterBindingImpl;
import com.example.mobilemall.databinding.CommentItemBindingImpl;
import com.example.mobilemall.databinding.FragmentCartBindingImpl;
import com.example.mobilemall.databinding.FragmentIndexBindingImpl;
import com.example.mobilemall.databinding.FragmentListBindingImpl;
import com.example.mobilemall.databinding.IndexItemBindingImpl;
import com.example.mobilemall.databinding.ItemBindingImpl;
import com.example.mobilemall.databinding.ShoppingcartItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYFIRST = 1;

  private static final int LAYOUT_ACTIVITYITEMDETAIL = 2;

  private static final int LAYOUT_ACTIVITYLOGIN = 3;

  private static final int LAYOUT_ACTIVITYMAIN = 4;

  private static final int LAYOUT_ACTIVITYREGISTER = 5;

  private static final int LAYOUT_COMMENTITEM = 6;

  private static final int LAYOUT_FRAGMENTCART = 7;

  private static final int LAYOUT_FRAGMENTINDEX = 8;

  private static final int LAYOUT_FRAGMENTLIST = 9;

  private static final int LAYOUT_INDEXITEM = 10;

  private static final int LAYOUT_ITEM = 11;

  private static final int LAYOUT_SHOPPINGCARTITEM = 12;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(12);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.activity_first, LAYOUT_ACTIVITYFIRST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.activity_item_detail, LAYOUT_ACTIVITYITEMDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.comment_item, LAYOUT_COMMENTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.fragment_cart, LAYOUT_FRAGMENTCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.fragment_index, LAYOUT_FRAGMENTINDEX);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.fragment_list, LAYOUT_FRAGMENTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.index_item, LAYOUT_INDEXITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.item, LAYOUT_ITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.mobilemall.R.layout.shoppingcart_item, LAYOUT_SHOPPINGCARTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYFIRST: {
          if ("layout/activity_first_0".equals(tag)) {
            return new ActivityFirstBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_first is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYITEMDETAIL: {
          if ("layout/activity_item_detail_0".equals(tag)) {
            return new ActivityItemDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_item_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTER: {
          if ("layout/activity_register_0".equals(tag)) {
            return new ActivityRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
        }
        case  LAYOUT_COMMENTITEM: {
          if ("layout/comment_item_0".equals(tag)) {
            return new CommentItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for comment_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCART: {
          if ("layout/fragment_cart_0".equals(tag)) {
            return new FragmentCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINDEX: {
          if ("layout/fragment_index_0".equals(tag)) {
            return new FragmentIndexBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_index is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLIST: {
          if ("layout/fragment_list_0".equals(tag)) {
            return new FragmentListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_list is invalid. Received: " + tag);
        }
        case  LAYOUT_INDEXITEM: {
          if ("layout/index_item_0".equals(tag)) {
            return new IndexItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for index_item is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEM: {
          if ("layout/item_0".equals(tag)) {
            return new ItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item is invalid. Received: " + tag);
        }
        case  LAYOUT_SHOPPINGCARTITEM: {
          if ("layout/shoppingcart_item_0".equals(tag)) {
            return new ShoppingcartItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for shoppingcart_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(12);

    static {
      sKeys.put("layout/activity_first_0", com.example.mobilemall.R.layout.activity_first);
      sKeys.put("layout/activity_item_detail_0", com.example.mobilemall.R.layout.activity_item_detail);
      sKeys.put("layout/activity_login_0", com.example.mobilemall.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", com.example.mobilemall.R.layout.activity_main);
      sKeys.put("layout/activity_register_0", com.example.mobilemall.R.layout.activity_register);
      sKeys.put("layout/comment_item_0", com.example.mobilemall.R.layout.comment_item);
      sKeys.put("layout/fragment_cart_0", com.example.mobilemall.R.layout.fragment_cart);
      sKeys.put("layout/fragment_index_0", com.example.mobilemall.R.layout.fragment_index);
      sKeys.put("layout/fragment_list_0", com.example.mobilemall.R.layout.fragment_list);
      sKeys.put("layout/index_item_0", com.example.mobilemall.R.layout.index_item);
      sKeys.put("layout/item_0", com.example.mobilemall.R.layout.item);
      sKeys.put("layout/shoppingcart_item_0", com.example.mobilemall.R.layout.shoppingcart_item);
    }
  }
}
