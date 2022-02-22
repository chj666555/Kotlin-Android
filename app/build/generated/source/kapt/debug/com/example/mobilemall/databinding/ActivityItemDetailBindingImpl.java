package com.example.mobilemall.databinding;
import com.example.mobilemall.R;
import com.example.mobilemall.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityItemDetailBindingImpl extends ActivityItemDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.titlebar, 1);
        sViewsWithIds.put(R.id.bottomView, 2);
        sViewsWithIds.put(R.id.btnBack, 3);
        sViewsWithIds.put(R.id.btnAddShoppingCart, 4);
        sViewsWithIds.put(R.id.image, 5);
        sViewsWithIds.put(R.id.price, 6);
        sViewsWithIds.put(R.id.title, 7);
        sViewsWithIds.put(R.id.chkFavorite, 8);
        sViewsWithIds.put(R.id.content, 9);
        sViewsWithIds.put(R.id.etComment, 10);
        sViewsWithIds.put(R.id.btnPublish, 11);
        sViewsWithIds.put(R.id.listView, 12);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityItemDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityItemDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.Button) bindings[4]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[11]
            , (android.widget.CheckBox) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.EditText) bindings[10]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ListView) bindings[12]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}