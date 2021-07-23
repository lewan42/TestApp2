package dev.fabula.android.section.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import dev.fabula.android.section.model.RailwaySection;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RailwaySectionDao_Impl implements RailwaySectionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RailwaySection> __insertionAdapterOfRailwaySection;

  private final EntityInsertionAdapter<RailwaySection> __insertionAdapterOfRailwaySection_1;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public RailwaySectionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRailwaySection = new EntityInsertionAdapter<RailwaySection>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `railway_section` (`uid`,`name`,`railway_uid`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RailwaySection value) {
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
        if (value.getRailway_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRailway_uid());
        }
      }
    };
    this.__insertionAdapterOfRailwaySection_1 = new EntityInsertionAdapter<RailwaySection>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `railway_section` (`uid`,`name`,`railway_uid`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RailwaySection value) {
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
        if (value.getRailway_uid() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRailway_uid());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM railway_section";
        return _query;
      }
    };
  }

  @Override
  public void insert(final RailwaySection railwaySection) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRailwaySection.insert(railwaySection);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWithReplace(final RailwaySection railwaySection) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRailwaySection_1.insert(railwaySection);
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
  public List<RailwaySection> getRailwaySections(final String uid_railway) {
    final String _sql = "SELECT * FROM railway_section WHERE railway_uid=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uid_railway == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uid_railway);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfRailwayUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_uid");
      final List<RailwaySection> _result = new ArrayList<RailwaySection>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final RailwaySection _item;
        final String _tmpUid;
        _tmpUid = _cursor.getString(_cursorIndexOfUid);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpRailway_uid;
        _tmpRailway_uid = _cursor.getString(_cursorIndexOfRailwayUid);
        _item = new RailwaySection(_tmpUid,_tmpName,_tmpRailway_uid);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<RailwaySection>> getRailwaySections() {
    final String _sql = "SELECT * FROM railway_section";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"railway_section"}, new Callable<List<RailwaySection>>() {
      @Override
      public List<RailwaySection> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRailwayUid = CursorUtil.getColumnIndexOrThrow(_cursor, "railway_uid");
          final List<RailwaySection> _result = new ArrayList<RailwaySection>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RailwaySection _item;
            final String _tmpUid;
            _tmpUid = _cursor.getString(_cursorIndexOfUid);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpRailway_uid;
            _tmpRailway_uid = _cursor.getString(_cursorIndexOfRailwayUid);
            _item = new RailwaySection(_tmpUid,_tmpName,_tmpRailway_uid);
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
}
