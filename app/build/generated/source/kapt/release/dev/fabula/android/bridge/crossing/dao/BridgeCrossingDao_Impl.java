package dev.fabula.android.bridge.crossing.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.bridge.crossing.model.BridgeCrossing;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BridgeCrossingDao_Impl implements BridgeCrossingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BridgeCrossing> __insertionAdapterOfBridgeCrossing;

  private final EntityInsertionAdapter<BridgeCrossing> __insertionAdapterOfBridgeCrossing_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagCreated;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagEdited;

  public BridgeCrossingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBridgeCrossing = new EntityInsertionAdapter<BridgeCrossing>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `bridge` (`uid`,`name`,`platform_uid`,`owner`,`flag_created`,`flag_edited`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BridgeCrossing value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPlatform_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPlatform_uid());
        }
        if (value.getOwner() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOwner());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
      }
    };
    this.__insertionAdapterOfBridgeCrossing_1 = new EntityInsertionAdapter<BridgeCrossing>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `bridge` (`uid`,`name`,`platform_uid`,`owner`,`flag_created`,`flag_edited`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BridgeCrossing value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getPlatform_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPlatform_uid());
        }
        if (value.getOwner() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOwner());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp_1);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM bridge";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagCreated = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE bridge SET flag_created = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagEdited = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE bridge SET flag_edited = ? WHERE uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final BridgeCrossing bridgeCrossing) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBridgeCrossing.insert(bridgeCrossing);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final BridgeCrossing bridgeCrossing) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBridgeCrossing_1.insert(bridgeCrossing);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public void updateFlagCreated(final String uid, final boolean flag) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFlagCreated.acquire();
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (uid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFlagCreated.release(_stmt);
    }
  }

  @Override
  public void updateFlagEdited(final String uid, final boolean flag) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateFlagEdited.acquire();
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    if (uid == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uid);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateFlagEdited.release(_stmt);
    }
  }

  @Override
  public List<BridgeCrossing> getBridgesCrossing(final String uidParent) {
    final String _sql = "SELECT * FROM bridge WHERE platform_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidParent == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidParent);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<BridgeCrossing> _result = new ArrayList<BridgeCrossing>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BridgeCrossing _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final Boolean _tmpFlag_created;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp == null ? null : _tmp != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        _item = new BridgeCrossing(_tmpUid,_tmpName,_tmpPlatform_uid,_tmpOwner,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getBridgeName(final String uidBridge) {
    final String _sql = "SELECT name FROM bridge WHERE uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidBridge == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidBridge);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getString(0);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BridgeCrossing> getBridgeCreated(final boolean flag_created) {
    final String _sql = "SELECT * FROM bridge WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<BridgeCrossing> _result = new ArrayList<BridgeCrossing>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BridgeCrossing _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final Boolean _tmpFlag_created;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp_1 == null ? null : _tmp_1 != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_2 == null ? null : _tmp_2 != 0;
        _item = new BridgeCrossing(_tmpUid,_tmpName,_tmpPlatform_uid,_tmpOwner,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BridgeCrossing> getBridgeEdited(final boolean flag_edited) {
    final String _sql = "SELECT * FROM bridge WHERE flag_edited=? and flag_created is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "owner");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<BridgeCrossing> _result = new ArrayList<BridgeCrossing>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BridgeCrossing _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpOwner;
        _tmpOwner = _cursor.getString(_cursorIndexOfOwner);
        final Boolean _tmpFlag_created;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagCreated)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagCreated);
        }
        _tmpFlag_created = _tmp_1 == null ? null : _tmp_1 != 0;
        final Boolean _tmpFlag_edited;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_2 == null ? null : _tmp_2 != 0;
        _item = new BridgeCrossing(_tmpUid,_tmpName,_tmpPlatform_uid,_tmpOwner,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
