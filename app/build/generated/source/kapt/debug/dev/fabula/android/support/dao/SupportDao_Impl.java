package dev.fabula.android.support.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.support.model.Support;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SupportDao_Impl implements SupportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Support> __insertionAdapterOfSupport;

  private final EntityInsertionAdapter<Support> __insertionAdapterOfSupport_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagCreated;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagEdited;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWires;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public SupportDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSupport = new EntityInsertionAdapter<Support>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `support` (`uid`,`content_type`,`parent_uid`,`number`,`km_way`,`way_number`,`picket`,`carrier_wire`,`contact_wire`,`comment`,`photo1`,`photo2`,`flag_created`,`flag_edited`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Support value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getContent_type() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContent_type());
        }
        if (value.getParent_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getParent_uid());
        }
        if (value.getNumber() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumber());
        }
        if (value.getKm_way() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getKm_way());
        }
        if (value.getWay_number() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWay_number());
        }
        if (value.getPicket() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPicket());
        }
        if (value.getCarrier_wire() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCarrier_wire());
        }
        if (value.getContact_wire() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getContact_wire());
        }
        if (value.getComment() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPhoto2());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp_1);
        }
      }
    };
    this.__insertionAdapterOfSupport_1 = new EntityInsertionAdapter<Support>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `support` (`uid`,`content_type`,`parent_uid`,`number`,`km_way`,`way_number`,`picket`,`carrier_wire`,`contact_wire`,`comment`,`photo1`,`photo2`,`flag_created`,`flag_edited`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Support value) {
        if (value.getUid() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUid());
        }
        if (value.getContent_type() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getContent_type());
        }
        if (value.getParent_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getParent_uid());
        }
        if (value.getNumber() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNumber());
        }
        if (value.getKm_way() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getKm_way());
        }
        if (value.getWay_number() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWay_number());
        }
        if (value.getPicket() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPicket());
        }
        if (value.getCarrier_wire() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCarrier_wire());
        }
        if (value.getContact_wire() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getContact_wire());
        }
        if (value.getComment() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPhoto2());
        }
        final Integer _tmp;
        _tmp = value.getFlag_created() == null ? null : (value.getFlag_created() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, _tmp);
        }
        final Integer _tmp_1;
        _tmp_1 = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp_1 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, _tmp_1);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM support";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagCreated = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE support SET flag_created = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagEdited = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE support SET flag_edited = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWires = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE support SET contact_wire = ?, carrier_wire = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE support SET number = ?, km_way = ?,way_number = ?,picket = ?,comment = ?,photo1 = ?,photo2 = ?,flag_edited =? WHERE uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Support support) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSupport.insert(support);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final Support support) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSupport_1.insert(support);
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
  public void updateWires(final String uidSupport, final String uidContactWire,
      final String uidCarrierWire) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWires.acquire();
    int _argIndex = 1;
    if (uidContactWire == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidContactWire);
    }
    _argIndex = 2;
    if (uidCarrierWire == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidCarrierWire);
    }
    _argIndex = 3;
    if (uidSupport == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidSupport);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateWires.release(_stmt);
    }
  }

  @Override
  public void update(final String uidSupport, final String number, final String kmWay,
      final String wayNumber, final String picket, final String comment, final String photo1,
      final String photo2, final boolean flag_edited) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (number == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, number);
    }
    _argIndex = 2;
    if (kmWay == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, kmWay);
    }
    _argIndex = 3;
    if (wayNumber == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, wayNumber);
    }
    _argIndex = 4;
    if (picket == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, picket);
    }
    _argIndex = 5;
    if (comment == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, comment);
    }
    _argIndex = 6;
    if (photo1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo1);
    }
    _argIndex = 7;
    if (photo2 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo2);
    }
    _argIndex = 8;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 9;
    if (uidSupport == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidSupport);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdate.release(_stmt);
    }
  }

  @Override
  public Flow<List<Support>> getSupports() {
    final String _sql = "SELECT * FROM support";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"support"}, new Callable<List<Support>>() {
      @Override
      public List<Support> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
          final int _cursorIndexOfParentUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_uid");
          final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
          final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
          final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
          final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
          final int _cursorIndexOfCarrierWire = CursorUtil.getColumnIndexOrThrow(_cursor, "carrier_wire");
          final int _cursorIndexOfContactWire = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_wire");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
          final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
          final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
          final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
          final List<Support> _result = new ArrayList<Support>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Support _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpContent_type;
            _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
            final String _tmpParent_uid;
            _tmpParent_uid = _cursor.getString(_cursorIndexOfParentUid);
            final String _tmpNumber;
            _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
            final String _tmpKm_way;
            _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
            final String _tmpWay_number;
            _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
            final String _tmpPicket;
            _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
            final String _tmpCarrier_wire;
            _tmpCarrier_wire = _cursor.getString(_cursorIndexOfCarrierWire);
            final String _tmpContact_wire;
            _tmpContact_wire = _cursor.getString(_cursorIndexOfContactWire);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            final String _tmpPhoto1;
            _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
            final String _tmpPhoto2;
            _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
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
            _item = new Support(_tmpUid,_tmpContent_type,_tmpParent_uid,_tmpNumber,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpCarrier_wire,_tmpContact_wire,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_created,_tmpFlag_edited);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Support getSupportById(final String uid) {
    final String _sql = "SELECT * FROM support WHERE uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfParentUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfCarrierWire = CursorUtil.getColumnIndexOrThrow(_cursor, "carrier_wire");
      final int _cursorIndexOfContactWire = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_wire");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final Support _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpParent_uid;
        _tmpParent_uid = _cursor.getString(_cursorIndexOfParentUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpCarrier_wire;
        _tmpCarrier_wire = _cursor.getString(_cursorIndexOfCarrierWire);
        final String _tmpContact_wire;
        _tmpContact_wire = _cursor.getString(_cursorIndexOfContactWire);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
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
        _result = new Support(_tmpUid,_tmpContent_type,_tmpParent_uid,_tmpNumber,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpCarrier_wire,_tmpContact_wire,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_created,_tmpFlag_edited);
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
  public List<Support> getSupportCreated(final boolean flag_created) {
    final String _sql = "SELECT * FROM support WHERE flag_created=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_created ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfParentUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfCarrierWire = CursorUtil.getColumnIndexOrThrow(_cursor, "carrier_wire");
      final int _cursorIndexOfContactWire = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_wire");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Support> _result = new ArrayList<Support>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Support _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpParent_uid;
        _tmpParent_uid = _cursor.getString(_cursorIndexOfParentUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpCarrier_wire;
        _tmpCarrier_wire = _cursor.getString(_cursorIndexOfCarrierWire);
        final String _tmpContact_wire;
        _tmpContact_wire = _cursor.getString(_cursorIndexOfContactWire);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
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
        _item = new Support(_tmpUid,_tmpContent_type,_tmpParent_uid,_tmpNumber,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpCarrier_wire,_tmpContact_wire,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Support> getSupportEdited(final boolean flag_edited) {
    final String _sql = "SELECT * FROM support WHERE flag_edited=? and flag_created is null";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfParentUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfCarrierWire = CursorUtil.getColumnIndexOrThrow(_cursor, "carrier_wire");
      final int _cursorIndexOfContactWire = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_wire");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Support> _result = new ArrayList<Support>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Support _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpParent_uid;
        _tmpParent_uid = _cursor.getString(_cursorIndexOfParentUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpCarrier_wire;
        _tmpCarrier_wire = _cursor.getString(_cursorIndexOfCarrierWire);
        final String _tmpContact_wire;
        _tmpContact_wire = _cursor.getString(_cursorIndexOfContactWire);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
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
        _item = new Support(_tmpUid,_tmpContent_type,_tmpParent_uid,_tmpNumber,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpCarrier_wire,_tmpContact_wire,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Support> getListSupportsByIdAndQuery(final String idParent,
      final String filterQuery) {
    final String _sql = "SELECT * FROM support WHERE parent_uid=? and number LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idParent == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idParent);
    }
    _argIndex = 2;
    if (filterQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, filterQuery);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfParentUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfCarrierWire = CursorUtil.getColumnIndexOrThrow(_cursor, "carrier_wire");
      final int _cursorIndexOfContactWire = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_wire");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Support> _result = new ArrayList<Support>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Support _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpParent_uid;
        _tmpParent_uid = _cursor.getString(_cursorIndexOfParentUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpCarrier_wire;
        _tmpCarrier_wire = _cursor.getString(_cursorIndexOfCarrierWire);
        final String _tmpContact_wire;
        _tmpContact_wire = _cursor.getString(_cursorIndexOfContactWire);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
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
        _item = new Support(_tmpUid,_tmpContent_type,_tmpParent_uid,_tmpNumber,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpCarrier_wire,_tmpContact_wire,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Support> getSupportsOfParent(final String uidParent) {
    final String _sql = "SELECT * FROM support WHERE parent_uid=?";
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
      final int _cursorIndexOfContentType = CursorUtil.getColumnIndexOrThrow(_cursor, "content_type");
      final int _cursorIndexOfParentUid = CursorUtil.getColumnIndexOrThrow(_cursor, "parent_uid");
      final int _cursorIndexOfNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "number");
      final int _cursorIndexOfKmWay = CursorUtil.getColumnIndexOrThrow(_cursor, "km_way");
      final int _cursorIndexOfWayNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "way_number");
      final int _cursorIndexOfPicket = CursorUtil.getColumnIndexOrThrow(_cursor, "picket");
      final int _cursorIndexOfCarrierWire = CursorUtil.getColumnIndexOrThrow(_cursor, "carrier_wire");
      final int _cursorIndexOfContactWire = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_wire");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_created");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<Support> _result = new ArrayList<Support>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Support _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpContent_type;
        _tmpContent_type = _cursor.getString(_cursorIndexOfContentType);
        final String _tmpParent_uid;
        _tmpParent_uid = _cursor.getString(_cursorIndexOfParentUid);
        final String _tmpNumber;
        _tmpNumber = _cursor.getString(_cursorIndexOfNumber);
        final String _tmpKm_way;
        _tmpKm_way = _cursor.getString(_cursorIndexOfKmWay);
        final String _tmpWay_number;
        _tmpWay_number = _cursor.getString(_cursorIndexOfWayNumber);
        final String _tmpPicket;
        _tmpPicket = _cursor.getString(_cursorIndexOfPicket);
        final String _tmpCarrier_wire;
        _tmpCarrier_wire = _cursor.getString(_cursorIndexOfCarrierWire);
        final String _tmpContact_wire;
        _tmpContact_wire = _cursor.getString(_cursorIndexOfContactWire);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
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
        _item = new Support(_tmpUid,_tmpContent_type,_tmpParent_uid,_tmpNumber,_tmpKm_way,_tmpWay_number,_tmpPicket,_tmpCarrier_wire,_tmpContact_wire,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_created,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
