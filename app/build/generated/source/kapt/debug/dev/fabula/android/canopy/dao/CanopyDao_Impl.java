package dev.fabula.android.canopy.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.canopy.model.Canopy;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CanopyDao_Impl implements CanopyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Canopy> __insertionAdapterOfCanopy;

  private final EntityInsertionAdapter<Canopy> __insertionAdapterOfCanopy_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagCreated;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagEdited;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCanopyNorth;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCanopyCenter;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCanopySouth;

  public CanopyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCanopy = new EntityInsertionAdapter<Canopy>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `canopy` (`uid`,`platform_uid`,`north_uid`,`south_uid`,`center_uid`,`flag_created`,`flag_edited`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Canopy value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getPlatform_uid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPlatform_uid());
        }
        if (value.getNorth_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNorth_uid());
        }
        if (value.getSouth_uid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSouth_uid());
        }
        if (value.getCenter_uid() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCenter_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
      }
    };
    this.__insertionAdapterOfCanopy_1 = new EntityInsertionAdapter<Canopy>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `canopy` (`uid`,`platform_uid`,`north_uid`,`south_uid`,`center_uid`,`flag_created`,`flag_edited`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Canopy value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getPlatform_uid() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPlatform_uid());
        }
        if (value.getNorth_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNorth_uid());
        }
        if (value.getSouth_uid() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSouth_uid());
        }
        if (value.getCenter_uid() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCenter_uid());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM canopy";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM canopy WHERE uid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagCreated = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE canopy SET flag_created = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagEdited = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE canopy SET flag_edited = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCanopyNorth = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE canopy SET north_uid = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCanopyCenter = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE canopy SET center_uid = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCanopySouth = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE canopy SET south_uid = ? WHERE uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Canopy canopy) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCanopy.insert(canopy);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final Canopy canopy) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCanopy_1.insert(canopy);
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
  public void deleteById(final String uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfDeleteById.release(_stmt);
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
  public void updateFlagEditable(final String uid, final boolean flag) {
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
  public void updateCanopyNorth(final String uidCanopy, final String uidMeasurement) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCanopyNorth.acquire();
    int _argIndex = 1;
    if (uidMeasurement == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidMeasurement);
    }
    _argIndex = 2;
    if (uidCanopy == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidCanopy);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCanopyNorth.release(_stmt);
    }
  }

  @Override
  public void updateCanopyCenter(final String uidCanopy, final String uidMeasurement) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCanopyCenter.acquire();
    int _argIndex = 1;
    if (uidMeasurement == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidMeasurement);
    }
    _argIndex = 2;
    if (uidCanopy == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidCanopy);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCanopyCenter.release(_stmt);
    }
  }

  @Override
  public void updateCanopySouth(final String uidCanopy, final String uidMeasurement) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCanopySouth.acquire();
    int _argIndex = 1;
    if (uidMeasurement == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidMeasurement);
    }
    _argIndex = 2;
    if (uidCanopy == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidCanopy);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCanopySouth.release(_stmt);
    }
  }

  @Override
  public int countIsNotSyncCreated(final boolean flag_created) {
    final String _sql = "SELECT count(uid) FROM canopy WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int countIsNotSyncEdited(final boolean flag_edited) {
    final String _sql = "SELECT count(uid) FROM canopy WHERE flag_edited=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Canopy> getAllCanopies() {
    final String _sql = "SELECT * FROM canopy";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfNorthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "north_uid");
      final int _cursorIndexOfSouthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "south_uid");
      final int _cursorIndexOfCenterUid = CursorUtil.getColumnIndexOrThrow(_cursor, "center_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Canopy> _result = new ArrayList<Canopy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Canopy _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpNorth_uid;
        _tmpNorth_uid = _cursor.getString(_cursorIndexOfNorthUid);
        final String _tmpSouth_uid;
        _tmpSouth_uid = _cursor.getString(_cursorIndexOfSouthUid);
        final String _tmpCenter_uid;
        _tmpCenter_uid = _cursor.getString(_cursorIndexOfCenterUid);
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
        _item = new Canopy(_tmpUid,_tmpPlatform_uid,_tmpNorth_uid,_tmpSouth_uid,_tmpCenter_uid,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Canopy> getCanopiesCreated(final boolean flag_created) {
    final String _sql = "SELECT * FROM canopy WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfNorthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "north_uid");
      final int _cursorIndexOfSouthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "south_uid");
      final int _cursorIndexOfCenterUid = CursorUtil.getColumnIndexOrThrow(_cursor, "center_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Canopy> _result = new ArrayList<Canopy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Canopy _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpNorth_uid;
        _tmpNorth_uid = _cursor.getString(_cursorIndexOfNorthUid);
        final String _tmpSouth_uid;
        _tmpSouth_uid = _cursor.getString(_cursorIndexOfSouthUid);
        final String _tmpCenter_uid;
        _tmpCenter_uid = _cursor.getString(_cursorIndexOfCenterUid);
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
        _item = new Canopy(_tmpUid,_tmpPlatform_uid,_tmpNorth_uid,_tmpSouth_uid,_tmpCenter_uid,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Canopy> getCanopiesEdited(final boolean flag_edited) {
    final String _sql = "SELECT * FROM canopy WHERE flag_edited=? and flag_created is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfNorthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "north_uid");
      final int _cursorIndexOfSouthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "south_uid");
      final int _cursorIndexOfCenterUid = CursorUtil.getColumnIndexOrThrow(_cursor, "center_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Canopy> _result = new ArrayList<Canopy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Canopy _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpNorth_uid;
        _tmpNorth_uid = _cursor.getString(_cursorIndexOfNorthUid);
        final String _tmpSouth_uid;
        _tmpSouth_uid = _cursor.getString(_cursorIndexOfSouthUid);
        final String _tmpCenter_uid;
        _tmpCenter_uid = _cursor.getString(_cursorIndexOfCenterUid);
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
        _item = new Canopy(_tmpUid,_tmpPlatform_uid,_tmpNorth_uid,_tmpSouth_uid,_tmpCenter_uid,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Canopy> getCanopiesOfParent(final String uidParent) {
    final String _sql = "SELECT * FROM canopy WHERE platform_uid=?";
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
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfNorthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "north_uid");
      final int _cursorIndexOfSouthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "south_uid");
      final int _cursorIndexOfCenterUid = CursorUtil.getColumnIndexOrThrow(_cursor, "center_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Canopy> _result = new ArrayList<Canopy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Canopy _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpNorth_uid;
        _tmpNorth_uid = _cursor.getString(_cursorIndexOfNorthUid);
        final String _tmpSouth_uid;
        _tmpSouth_uid = _cursor.getString(_cursorIndexOfSouthUid);
        final String _tmpCenter_uid;
        _tmpCenter_uid = _cursor.getString(_cursorIndexOfCenterUid);
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
        _item = new Canopy(_tmpUid,_tmpPlatform_uid,_tmpNorth_uid,_tmpSouth_uid,_tmpCenter_uid,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Canopy getCanopyOfParent(final String uidParent) {
    final String _sql = "SELECT * FROM canopy WHERE platform_uid=?";
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
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfNorthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "north_uid");
      final int _cursorIndexOfSouthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "south_uid");
      final int _cursorIndexOfCenterUid = CursorUtil.getColumnIndexOrThrow(_cursor, "center_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final Canopy _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpNorth_uid;
        _tmpNorth_uid = _cursor.getString(_cursorIndexOfNorthUid);
        final String _tmpSouth_uid;
        _tmpSouth_uid = _cursor.getString(_cursorIndexOfSouthUid);
        final String _tmpCenter_uid;
        _tmpCenter_uid = _cursor.getString(_cursorIndexOfCenterUid);
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
        _result = new Canopy(_tmpUid,_tmpPlatform_uid,_tmpNorth_uid,_tmpSouth_uid,_tmpCenter_uid,_tmpFlag_created,_tmpFlag_edited);
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
  public boolean isExists(final String uidParent) {
    final String _sql = "SELECT EXISTS(SELECT * FROM canopy WHERE platform_uid=?)";
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
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Canopy getCanopyById(final String uidCanopy) {
    final String _sql = "SELECT * FROM canopy WHERE uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uidCanopy == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uidCanopy);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfPlatformUid = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_uid");
      final int _cursorIndexOfNorthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "north_uid");
      final int _cursorIndexOfSouthUid = CursorUtil.getColumnIndexOrThrow(_cursor, "south_uid");
      final int _cursorIndexOfCenterUid = CursorUtil.getColumnIndexOrThrow(_cursor, "center_uid");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final Canopy _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpPlatform_uid;
        _tmpPlatform_uid = _cursor.getString(_cursorIndexOfPlatformUid);
        final String _tmpNorth_uid;
        _tmpNorth_uid = _cursor.getString(_cursorIndexOfNorthUid);
        final String _tmpSouth_uid;
        _tmpSouth_uid = _cursor.getString(_cursorIndexOfSouthUid);
        final String _tmpCenter_uid;
        _tmpCenter_uid = _cursor.getString(_cursorIndexOfCenterUid);
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
        _result = new Canopy(_tmpUid,_tmpPlatform_uid,_tmpNorth_uid,_tmpSouth_uid,_tmpCenter_uid,_tmpFlag_created,_tmpFlag_edited);
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
