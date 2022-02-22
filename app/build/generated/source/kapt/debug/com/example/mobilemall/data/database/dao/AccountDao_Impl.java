package com.example.mobilemall.data.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.mobilemall.data.entity.Account;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AccountDao_Impl implements AccountDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Account> __insertionAdapterOfAccount;

  public AccountDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAccount = new EntityInsertionAdapter<Account>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `accounts` (`mobile`,`uid`,`password`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Account value) {
        if (value.getMobile() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMobile());
        }
        if (value.getUid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUid());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
      }
    };
  }

  @Override
  public void register(final Account account) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAccount.insert(account);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Account> checkMobile(final String mobile) {
    final String _sql = "select `accounts`.`mobile` AS `mobile`, `accounts`.`uid` AS `uid`, `accounts`.`password` AS `password` from accounts where mobile=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (mobile == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mobile);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "mobile");
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final List<Account> _result = new ArrayList<Account>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Account _item;
        _item = new Account();
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _item.setMobile(_tmpMobile);
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _item.setPassword(_tmpPassword);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Account login(final String mobile, final String passWord) {
    final String _sql = "select `accounts`.`mobile` AS `mobile`, `accounts`.`uid` AS `uid`, `accounts`.`password` AS `password` from accounts where mobile=? and password=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (mobile == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mobile);
    }
    _argIndex = 2;
    if (passWord == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, passWord);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMobile = CursorUtil.getColumnIndexOrThrow(_cursor, "mobile");
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final Account _result;
      if(_cursor.moveToFirst()) {
        _result = new Account();
        final String _tmpMobile;
        _tmpMobile = _cursor.getString(_cursorIndexOfMobile);
        _result.setMobile(_tmpMobile);
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        _result.setUid(_tmpUid);
        final String _tmpPassword;
        _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        _result.setPassword(_tmpPassword);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
