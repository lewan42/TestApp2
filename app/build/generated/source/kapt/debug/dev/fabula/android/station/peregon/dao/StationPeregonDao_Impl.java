package dev.fabula.android.station.peregon.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.station.peregon.model.StationPeregon;
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
public final class StationPeregonDao_Impl implements StationPeregonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StationPeregon> __insertionAdapterOfStationPeregon;

  private final EntityInsertionAdapter<StationPeregon> __insertionAdapterOfStationPeregon_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateFlagEdited;

  private final SharedSQLiteStatement __preparedStmtOfUpdate;

  public StationPeregonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStationPeregon = new EntityInsertionAdapter<StationPeregon>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `station_peregon` (`uid`,`name`,`railway_sector_uid`,`type_of`,`platform_count`,`most_bridge_count`,`opora_count`,`comment`,`photo1`,`photo2`,`flag_edited`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StationPeregon value) {
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
        if (value.getRailway_sector_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRailway_sector_uid());
        }
        if (value.getType_of() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType_of());
        }
        stmt.bindLong(5, value.getPlatform_count());
        stmt.bindLong(6, value.getMost_bridge_count());
        stmt.bindLong(7, value.getOpora_count());
        if (value.getComment() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPhoto2());
        }
        final Integer _tmp;
        _tmp = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp);
        }
      }
    };
    this.__insertionAdapterOfStationPeregon_1 = new EntityInsertionAdapter<StationPeregon>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `station_peregon` (`uid`,`name`,`railway_sector_uid`,`type_of`,`platform_count`,`most_bridge_count`,`opora_count`,`comment`,`photo1`,`photo2`,`flag_edited`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StationPeregon value) {
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
        if (value.getRailway_sector_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRailway_sector_uid());
        }
        if (value.getType_of() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getType_of());
        }
        stmt.bindLong(5, value.getPlatform_count());
        stmt.bindLong(6, value.getMost_bridge_count());
        stmt.bindLong(7, value.getOpora_count());
        if (value.getComment() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getComment());
        }
        if (value.getPhoto1() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPhoto1());
        }
        if (value.getPhoto2() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPhoto2());
        }
        final Integer _tmp;
        _tmp = value.getFlag_edited() == null ? null : (value.getFlag_edited() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM station_peregon";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM station_peregon WHERE uid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateFlagEdited = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE station_peregon SET flag_edited = ? WHERE uid =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE station_peregon SET comment = ?, photo1 = ?, photo2 = ?, flag_edited=?  WHERE uid =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final StationPeregon stationPeregon) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStationPeregon.insert(stationPeregon);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final StationPeregon stationPeregon) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStationPeregon_1.insert(stationPeregon);
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
  public void update(final String uidStation, final String comment, final String photo1,
      final String photo2, final boolean flag_edited) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdate.acquire();
    int _argIndex = 1;
    if (comment == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, comment);
    }
    _argIndex = 2;
    if (photo1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo1);
    }
    _argIndex = 3;
    if (photo2 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, photo2);
    }
    _argIndex = 4;
    final int _tmp;
    _tmp = flag_edited ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 5;
    if (uidStation == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, uidStation);
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
  public Flow<List<StationPeregon>> getStationPeregons() {
    final String _sql = "SELECT * FROM station_peregon";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"station_peregon"}, new Callable<List<StationPeregon>>() {
      @Override
      public List<StationPeregon> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRailwaySectorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_sector_uid");
          final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
          final int _cursorIndexOfPlatformCount = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_count");
          final int _cursorIndexOfMostBridgeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "most_bridge_count");
          final int _cursorIndexOfOporaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_count");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
          final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
          final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
          final List<StationPeregon> _result = new ArrayList<StationPeregon>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final StationPeregon _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpRailway_sector_uid;
            _tmpRailway_sector_uid = _cursor.getString(_cursorIndexOfRailwaySectorUid);
            final String _tmpType_of;
            _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
            final int _tmpPlatform_count;
            _tmpPlatform_count = _cursor.getInt(_cursorIndexOfPlatformCount);
            final int _tmpMost_bridge_count;
            _tmpMost_bridge_count = _cursor.getInt(_cursorIndexOfMostBridgeCount);
            final int _tmpOpora_count;
            _tmpOpora_count = _cursor.getInt(_cursorIndexOfOporaCount);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            final String _tmpPhoto1;
            _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
            final String _tmpPhoto2;
            _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
            final Boolean _tmpFlag_edited;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
            }
            _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
            _item = new StationPeregon(_tmpUid,_tmpName,_tmpRailway_sector_uid,_tmpType_of,_tmpPlatform_count,_tmpMost_bridge_count,_tmpOpora_count,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_edited);
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
  public List<StationPeregon> getEditedStations(final boolean flag) {
    final String _sql = "SELECT * FROM station_peregon WHERE flag_edited=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp;
    _tmp = flag ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRailwaySectorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_sector_uid");
      final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
      final int _cursorIndexOfPlatformCount = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_count");
      final int _cursorIndexOfMostBridgeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "most_bridge_count");
      final int _cursorIndexOfOporaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_count");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<StationPeregon> _result = new ArrayList<StationPeregon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StationPeregon _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpRailway_sector_uid;
        _tmpRailway_sector_uid = _cursor.getString(_cursorIndexOfRailwaySectorUid);
        final String _tmpType_of;
        _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
        final int _tmpPlatform_count;
        _tmpPlatform_count = _cursor.getInt(_cursorIndexOfPlatformCount);
        final int _tmpMost_bridge_count;
        _tmpMost_bridge_count = _cursor.getInt(_cursorIndexOfMostBridgeCount);
        final int _tmpOpora_count;
        _tmpOpora_count = _cursor.getInt(_cursorIndexOfOporaCount);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final Boolean _tmpFlag_edited;
        final Integer _tmp_1;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp_1 == null ? null : _tmp_1 != 0;
        _item = new StationPeregon(_tmpUid,_tmpName,_tmpRailway_sector_uid,_tmpType_of,_tmpPlatform_count,_tmpMost_bridge_count,_tmpOpora_count,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public StationPeregon getStationPeregonsById(final String id) {
    final String _sql = "SELECT * FROM station_peregon WHERE uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRailwaySectorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_sector_uid");
      final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
      final int _cursorIndexOfPlatformCount = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_count");
      final int _cursorIndexOfMostBridgeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "most_bridge_count");
      final int _cursorIndexOfOporaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_count");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final StationPeregon _result;
      if(_cursor.moveToFirst()) {
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpRailway_sector_uid;
        _tmpRailway_sector_uid = _cursor.getString(_cursorIndexOfRailwaySectorUid);
        final String _tmpType_of;
        _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
        final int _tmpPlatform_count;
        _tmpPlatform_count = _cursor.getInt(_cursorIndexOfPlatformCount);
        final int _tmpMost_bridge_count;
        _tmpMost_bridge_count = _cursor.getInt(_cursorIndexOfMostBridgeCount);
        final int _tmpOpora_count;
        _tmpOpora_count = _cursor.getInt(_cursorIndexOfOporaCount);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _result = new StationPeregon(_tmpUid,_tmpName,_tmpRailway_sector_uid,_tmpType_of,_tmpPlatform_count,_tmpMost_bridge_count,_tmpOpora_count,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_edited);
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
  public List<StationPeregon> getStationPeregonsByIdAndQuery(final String idRailwaySection,
      final String query) {
    final String _sql = "SELECT * FROM station_peregon WHERE railway_sector_uid=? and name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idRailwaySection == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idRailwaySection);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRailwaySectorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_sector_uid");
      final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
      final int _cursorIndexOfPlatformCount = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_count");
      final int _cursorIndexOfMostBridgeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "most_bridge_count");
      final int _cursorIndexOfOporaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_count");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<StationPeregon> _result = new ArrayList<StationPeregon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StationPeregon _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpRailway_sector_uid;
        _tmpRailway_sector_uid = _cursor.getString(_cursorIndexOfRailwaySectorUid);
        final String _tmpType_of;
        _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
        final int _tmpPlatform_count;
        _tmpPlatform_count = _cursor.getInt(_cursorIndexOfPlatformCount);
        final int _tmpMost_bridge_count;
        _tmpMost_bridge_count = _cursor.getInt(_cursorIndexOfMostBridgeCount);
        final int _tmpOpora_count;
        _tmpOpora_count = _cursor.getInt(_cursorIndexOfOporaCount);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _item = new StationPeregon(_tmpUid,_tmpName,_tmpRailway_sector_uid,_tmpType_of,_tmpPlatform_count,_tmpMost_bridge_count,_tmpOpora_count,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<StationPeregon> getListStationOrPeregonByIdAndType(final String idRailwaySection,
      final String type) {
    final String _sql = "SELECT * FROM station_peregon WHERE railway_sector_uid=? and type_of=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idRailwaySection == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idRailwaySection);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRailwaySectorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_sector_uid");
      final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
      final int _cursorIndexOfPlatformCount = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_count");
      final int _cursorIndexOfMostBridgeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "most_bridge_count");
      final int _cursorIndexOfOporaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_count");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<StationPeregon> _result = new ArrayList<StationPeregon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StationPeregon _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpRailway_sector_uid;
        _tmpRailway_sector_uid = _cursor.getString(_cursorIndexOfRailwaySectorUid);
        final String _tmpType_of;
        _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
        final int _tmpPlatform_count;
        _tmpPlatform_count = _cursor.getInt(_cursorIndexOfPlatformCount);
        final int _tmpMost_bridge_count;
        _tmpMost_bridge_count = _cursor.getInt(_cursorIndexOfMostBridgeCount);
        final int _tmpOpora_count;
        _tmpOpora_count = _cursor.getInt(_cursorIndexOfOporaCount);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _item = new StationPeregon(_tmpUid,_tmpName,_tmpRailway_sector_uid,_tmpType_of,_tmpPlatform_count,_tmpMost_bridge_count,_tmpOpora_count,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<StationPeregon> getListStationOrPeregonByIdAndTypeAndQuery(
      final String idRailwaySection, final String type, final String query) {
    final String _sql = "SELECT * FROM station_peregon WHERE railway_sector_uid=? and type_of=? and name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (idRailwaySection == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idRailwaySection);
    }
    _argIndex = 2;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRailwaySectorUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_sector_uid");
      final int _cursorIndexOfTypeOf = CursorUtil.getColumnIndexOrThrow(_cursor, "type_of");
      final int _cursorIndexOfPlatformCount = CursorUtil.getColumnIndexOrThrow(_cursor, "platform_count");
      final int _cursorIndexOfMostBridgeCount = CursorUtil.getColumnIndexOrThrow(_cursor, "most_bridge_count");
      final int _cursorIndexOfOporaCount = CursorUtil.getColumnIndexOrThrow(_cursor, "opora_count");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfPhoto1 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo1");
      final int _cursorIndexOfPhoto2 = CursorUtil.getColumnIndexOrThrow(_cursor, "photo2");
      final int _cursorIndexOfFlagEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "flag_edited");
      final List<StationPeregon> _result = new ArrayList<StationPeregon>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final StationPeregon _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpRailway_sector_uid;
        _tmpRailway_sector_uid = _cursor.getString(_cursorIndexOfRailwaySectorUid);
        final String _tmpType_of;
        _tmpType_of = _cursor.getString(_cursorIndexOfTypeOf);
        final int _tmpPlatform_count;
        _tmpPlatform_count = _cursor.getInt(_cursorIndexOfPlatformCount);
        final int _tmpMost_bridge_count;
        _tmpMost_bridge_count = _cursor.getInt(_cursorIndexOfMostBridgeCount);
        final int _tmpOpora_count;
        _tmpOpora_count = _cursor.getInt(_cursorIndexOfOporaCount);
        final String _tmpComment;
        _tmpComment = _cursor.getString(_cursorIndexOfComment);
        final String _tmpPhoto1;
        _tmpPhoto1 = _cursor.getString(_cursorIndexOfPhoto1);
        final String _tmpPhoto2;
        _tmpPhoto2 = _cursor.getString(_cursorIndexOfPhoto2);
        final Boolean _tmpFlag_edited;
        final Integer _tmp;
        if (_cursor.isNull(_cursorIndexOfFlagEdited)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(_cursorIndexOfFlagEdited);
        }
        _tmpFlag_edited = _tmp == null ? null : _tmp != 0;
        _item = new StationPeregon(_tmpUid,_tmpName,_tmpRailway_sector_uid,_tmpType_of,_tmpPlatform_count,_tmpMost_bridge_count,_tmpOpora_count,_tmpComment,_tmpPhoto1,_tmpPhoto2,_tmpFlag_edited);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
