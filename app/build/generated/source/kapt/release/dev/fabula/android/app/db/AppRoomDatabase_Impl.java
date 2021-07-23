package dev.fabula.android.app.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao;
import dev.fabula.android.bridge.crossing.dao.BridgeCrossingDao_Impl;
import dev.fabula.android.canopy.dao.CanopyDao;
import dev.fabula.android.canopy.dao.CanopyDao_Impl;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao;
import dev.fabula.android.dimensions.fence.dao.DimensionsFenceDao_Impl;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao;
import dev.fabula.android.measurements.create.dao.CreateMeasurementsDao_Impl;
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao;
import dev.fabula.android.measurements.type.dao.MeasurementTypeDao_Impl;
import dev.fabula.android.platform.dao.PlatformDao;
import dev.fabula.android.platform.dao.PlatformDao_Impl;
import dev.fabula.android.railway.dao.RailwayDao;
import dev.fabula.android.railway.dao.RailwayDao_Impl;
import dev.fabula.android.report.dao.ReportDao;
import dev.fabula.android.report.dao.ReportDao_Impl;
import dev.fabula.android.section.dao.RailwaySectionDao;
import dev.fabula.android.section.dao.RailwaySectionDao_Impl;
import dev.fabula.android.station.peregon.dao.StationPeregonDao;
import dev.fabula.android.station.peregon.dao.StationPeregonDao_Impl;
import dev.fabula.android.support.dao.SupportDao;
import dev.fabula.android.support.dao.SupportDao_Impl;
import dev.fabula.android.wire.carrier.dao.CarrierWireDao;
import dev.fabula.android.wire.carrier.dao.CarrierWireDao_Impl;
import dev.fabula.android.wire.contact.dao.ContactWireDao;
import dev.fabula.android.wire.contact.dao.ContactWireDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppRoomDatabase_Impl extends AppRoomDatabase {
  private volatile RailwayDao _railwayDao;

  private volatile RailwaySectionDao _railwaySectionDao;

  private volatile ReportDao _reportDao;

  private volatile StationPeregonDao _stationPeregonDao;

  private volatile SupportDao _supportDao;

  private volatile PlatformDao _platformDao;

  private volatile BridgeCrossingDao _bridgeCrossingDao;

  private volatile CreateMeasurementsDao _createMeasurementsDao;

  private volatile DimensionsFenceDao _dimensionsFenceDao;

  private volatile CanopyDao _canopyDao;

  private volatile ContactWireDao _contactWireDao;

  private volatile CarrierWireDao _carrierWireDao;

  private volatile MeasurementTypeDao _measurementTypeDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `railway` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `railway_section` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `railway_uid` TEXT NOT NULL, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `station_peregon` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `railway_sector_uid` TEXT NOT NULL, `type_of` TEXT NOT NULL, `platform_count` INTEGER NOT NULL, `most_bridge_count` INTEGER NOT NULL, `opora_count` INTEGER NOT NULL, `comment` TEXT, `photo1` TEXT, `photo2` TEXT, `flag_edited` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `support` (`uid` TEXT NOT NULL, `content_type` TEXT NOT NULL, `parent_uid` TEXT NOT NULL, `number` TEXT NOT NULL, `km_way` TEXT, `way_number` TEXT, `picket` TEXT, `carrier_wire` TEXT, `contact_wire` TEXT, `comment` TEXT, `photo1` TEXT, `photo2` TEXT, `flag_created` INTEGER, `flag_edited` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `platform` (`uid` TEXT NOT NULL, `number` TEXT NOT NULL, `station_uid` TEXT NOT NULL, `owner` TEXT NOT NULL, `way_number` TEXT NOT NULL, `km_way` TEXT NOT NULL, `picket` TEXT NOT NULL, `type1` TEXT NOT NULL, `type2` TEXT NOT NULL, `comment` TEXT, `photo1` TEXT, `photo2` TEXT, `type_gabarits_uid` TEXT, `type_platform_uid` TEXT, `flag_edited` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bridge` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `platform_uid` TEXT NOT NULL, `owner` TEXT, `flag_created` INTEGER, `flag_edited` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `measurement` (`uid` TEXT NOT NULL, `gipotinuza` TEXT NOT NULL, `ugol_naklona` TEXT NOT NULL, `vertical_gabarit` TEXT NOT NULL, `horizontal_gabarit` TEXT NOT NULL, `lat` TEXT, `lng` TEXT, `km_way` REAL, `way_number` TEXT, `picket` TEXT, `radius` INTEGER NOT NULL, `vozvishenie` INTEGER NOT NULL, `comment` TEXT, `photo1` TEXT, `photo2` TEXT, `parent_platform_uid` TEXT, `parent_gabarit_naves_uid` TEXT, `parent_gabarit_tor_uid` TEXT, `parent_main_wire_uid` TEXT, `parent_contact_wire_uid` TEXT, `parent_most_perehod_uid` TEXT, `type_measurement_uid` TEXT, `flag_created` INTEGER, `flag_edited` INTEGER, `created_at` INTEGER NOT NULL, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `gabarittor` (`uid` TEXT NOT NULL, `platform_uid` TEXT NOT NULL, `direction` TEXT NOT NULL, `flag_created` INTEGER, `flag_edited` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `canopy` (`uid` TEXT NOT NULL, `platform_uid` TEXT NOT NULL, `north_uid` TEXT, `south_uid` TEXT, `center_uid` TEXT, `flag_created` INTEGER, `flag_edited` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `contact_wire` (`uid` TEXT NOT NULL, `opora_uid` TEXT NOT NULL, `type_height_wire_uid` TEXT NOT NULL, `type_zigzag_wire_uid` TEXT NOT NULL, `flag_created` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `carrier_wire` (`uid` TEXT NOT NULL, `opora_uid` TEXT NOT NULL, `type_height_wire_uid` TEXT NOT NULL, `type_zigzag_wire_uid` TEXT NOT NULL, `flag_created` INTEGER, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `type_measurement` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `norma` REAL NOT NULL, `allowableErrorPlus` REAL NOT NULL, `allowableErrorMinus` REAL NOT NULL, `type_of` TEXT NOT NULL, PRIMARY KEY(`uid`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1dfcf72cd013792e6d7daf671ff4c4c1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `railway`");
        _db.execSQL("DROP TABLE IF EXISTS `railway_section`");
        _db.execSQL("DROP TABLE IF EXISTS `station_peregon`");
        _db.execSQL("DROP TABLE IF EXISTS `support`");
        _db.execSQL("DROP TABLE IF EXISTS `platform`");
        _db.execSQL("DROP TABLE IF EXISTS `bridge`");
        _db.execSQL("DROP TABLE IF EXISTS `measurement`");
        _db.execSQL("DROP TABLE IF EXISTS `gabarittor`");
        _db.execSQL("DROP TABLE IF EXISTS `canopy`");
        _db.execSQL("DROP TABLE IF EXISTS `contact_wire`");
        _db.execSQL("DROP TABLE IF EXISTS `carrier_wire`");
        _db.execSQL("DROP TABLE IF EXISTS `type_measurement`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsRailway = new HashMap<String, TableInfo.Column>(2);
        _columnsRailway.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRailway.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRailway = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRailway = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRailway = new TableInfo("railway", _columnsRailway, _foreignKeysRailway, _indicesRailway);
        final TableInfo _existingRailway = TableInfo.read(_db, "railway");
        if (! _infoRailway.equals(_existingRailway)) {
          return new RoomOpenHelper.ValidationResult(false, "railway(dev.fabula.android.railway.model.Railway).\n"
                  + " Expected:\n" + _infoRailway + "\n"
                  + " Found:\n" + _existingRailway);
        }
        final HashMap<String, TableInfo.Column> _columnsRailwaySection = new HashMap<String, TableInfo.Column>(3);
        _columnsRailwaySection.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRailwaySection.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRailwaySection.put("railway_uid", new TableInfo.Column("railway_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRailwaySection = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRailwaySection = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRailwaySection = new TableInfo("railway_section", _columnsRailwaySection, _foreignKeysRailwaySection, _indicesRailwaySection);
        final TableInfo _existingRailwaySection = TableInfo.read(_db, "railway_section");
        if (! _infoRailwaySection.equals(_existingRailwaySection)) {
          return new RoomOpenHelper.ValidationResult(false, "railway_section(dev.fabula.android.section.model.RailwaySection).\n"
                  + " Expected:\n" + _infoRailwaySection + "\n"
                  + " Found:\n" + _existingRailwaySection);
        }
        final HashMap<String, TableInfo.Column> _columnsStationPeregon = new HashMap<String, TableInfo.Column>(11);
        _columnsStationPeregon.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("railway_sector_uid", new TableInfo.Column("railway_sector_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("type_of", new TableInfo.Column("type_of", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("platform_count", new TableInfo.Column("platform_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("most_bridge_count", new TableInfo.Column("most_bridge_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("opora_count", new TableInfo.Column("opora_count", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("photo1", new TableInfo.Column("photo1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("photo2", new TableInfo.Column("photo2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStationPeregon.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStationPeregon = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStationPeregon = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStationPeregon = new TableInfo("station_peregon", _columnsStationPeregon, _foreignKeysStationPeregon, _indicesStationPeregon);
        final TableInfo _existingStationPeregon = TableInfo.read(_db, "station_peregon");
        if (! _infoStationPeregon.equals(_existingStationPeregon)) {
          return new RoomOpenHelper.ValidationResult(false, "station_peregon(dev.fabula.android.station.peregon.model.StationPeregon).\n"
                  + " Expected:\n" + _infoStationPeregon + "\n"
                  + " Found:\n" + _existingStationPeregon);
        }
        final HashMap<String, TableInfo.Column> _columnsSupport = new HashMap<String, TableInfo.Column>(14);
        _columnsSupport.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("content_type", new TableInfo.Column("content_type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("parent_uid", new TableInfo.Column("parent_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("number", new TableInfo.Column("number", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("km_way", new TableInfo.Column("km_way", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("way_number", new TableInfo.Column("way_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("picket", new TableInfo.Column("picket", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("carrier_wire", new TableInfo.Column("carrier_wire", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("contact_wire", new TableInfo.Column("contact_wire", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("photo1", new TableInfo.Column("photo1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("photo2", new TableInfo.Column("photo2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSupport.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSupport = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSupport = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSupport = new TableInfo("support", _columnsSupport, _foreignKeysSupport, _indicesSupport);
        final TableInfo _existingSupport = TableInfo.read(_db, "support");
        if (! _infoSupport.equals(_existingSupport)) {
          return new RoomOpenHelper.ValidationResult(false, "support(dev.fabula.android.support.model.Support).\n"
                  + " Expected:\n" + _infoSupport + "\n"
                  + " Found:\n" + _existingSupport);
        }
        final HashMap<String, TableInfo.Column> _columnsPlatform = new HashMap<String, TableInfo.Column>(15);
        _columnsPlatform.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("number", new TableInfo.Column("number", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("station_uid", new TableInfo.Column("station_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("owner", new TableInfo.Column("owner", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("way_number", new TableInfo.Column("way_number", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("km_way", new TableInfo.Column("km_way", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("picket", new TableInfo.Column("picket", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("type1", new TableInfo.Column("type1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("type2", new TableInfo.Column("type2", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("photo1", new TableInfo.Column("photo1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("photo2", new TableInfo.Column("photo2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("type_gabarits_uid", new TableInfo.Column("type_gabarits_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("type_platform_uid", new TableInfo.Column("type_platform_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlatform.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlatform = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlatform = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlatform = new TableInfo("platform", _columnsPlatform, _foreignKeysPlatform, _indicesPlatform);
        final TableInfo _existingPlatform = TableInfo.read(_db, "platform");
        if (! _infoPlatform.equals(_existingPlatform)) {
          return new RoomOpenHelper.ValidationResult(false, "platform(dev.fabula.android.platform.model.Platform).\n"
                  + " Expected:\n" + _infoPlatform + "\n"
                  + " Found:\n" + _existingPlatform);
        }
        final HashMap<String, TableInfo.Column> _columnsBridge = new HashMap<String, TableInfo.Column>(6);
        _columnsBridge.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBridge.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBridge.put("platform_uid", new TableInfo.Column("platform_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBridge.put("owner", new TableInfo.Column("owner", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBridge.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBridge.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBridge = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBridge = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBridge = new TableInfo("bridge", _columnsBridge, _foreignKeysBridge, _indicesBridge);
        final TableInfo _existingBridge = TableInfo.read(_db, "bridge");
        if (! _infoBridge.equals(_existingBridge)) {
          return new RoomOpenHelper.ValidationResult(false, "bridge(dev.fabula.android.bridge.crossing.model.BridgeCrossing).\n"
                  + " Expected:\n" + _infoBridge + "\n"
                  + " Found:\n" + _existingBridge);
        }
        final HashMap<String, TableInfo.Column> _columnsMeasurement = new HashMap<String, TableInfo.Column>(25);
        _columnsMeasurement.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("gipotinuza", new TableInfo.Column("gipotinuza", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("ugol_naklona", new TableInfo.Column("ugol_naklona", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("vertical_gabarit", new TableInfo.Column("vertical_gabarit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("horizontal_gabarit", new TableInfo.Column("horizontal_gabarit", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("lat", new TableInfo.Column("lat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("lng", new TableInfo.Column("lng", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("km_way", new TableInfo.Column("km_way", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("way_number", new TableInfo.Column("way_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("picket", new TableInfo.Column("picket", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("radius", new TableInfo.Column("radius", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("vozvishenie", new TableInfo.Column("vozvishenie", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("photo1", new TableInfo.Column("photo1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("photo2", new TableInfo.Column("photo2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("parent_platform_uid", new TableInfo.Column("parent_platform_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("parent_gabarit_naves_uid", new TableInfo.Column("parent_gabarit_naves_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("parent_gabarit_tor_uid", new TableInfo.Column("parent_gabarit_tor_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("parent_main_wire_uid", new TableInfo.Column("parent_main_wire_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("parent_contact_wire_uid", new TableInfo.Column("parent_contact_wire_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("parent_most_perehod_uid", new TableInfo.Column("parent_most_perehod_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("type_measurement_uid", new TableInfo.Column("type_measurement_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeasurement.put("created_at", new TableInfo.Column("created_at", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeasurement = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeasurement = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeasurement = new TableInfo("measurement", _columnsMeasurement, _foreignKeysMeasurement, _indicesMeasurement);
        final TableInfo _existingMeasurement = TableInfo.read(_db, "measurement");
        if (! _infoMeasurement.equals(_existingMeasurement)) {
          return new RoomOpenHelper.ValidationResult(false, "measurement(dev.fabula.android.measurements.model.Measurement).\n"
                  + " Expected:\n" + _infoMeasurement + "\n"
                  + " Found:\n" + _existingMeasurement);
        }
        final HashMap<String, TableInfo.Column> _columnsGabarittor = new HashMap<String, TableInfo.Column>(5);
        _columnsGabarittor.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGabarittor.put("platform_uid", new TableInfo.Column("platform_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGabarittor.put("direction", new TableInfo.Column("direction", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGabarittor.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGabarittor.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGabarittor = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGabarittor = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGabarittor = new TableInfo("gabarittor", _columnsGabarittor, _foreignKeysGabarittor, _indicesGabarittor);
        final TableInfo _existingGabarittor = TableInfo.read(_db, "gabarittor");
        if (! _infoGabarittor.equals(_existingGabarittor)) {
          return new RoomOpenHelper.ValidationResult(false, "gabarittor(dev.fabula.android.dimensions.fence.model.DimensionsFence).\n"
                  + " Expected:\n" + _infoGabarittor + "\n"
                  + " Found:\n" + _existingGabarittor);
        }
        final HashMap<String, TableInfo.Column> _columnsCanopy = new HashMap<String, TableInfo.Column>(7);
        _columnsCanopy.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCanopy.put("platform_uid", new TableInfo.Column("platform_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCanopy.put("north_uid", new TableInfo.Column("north_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCanopy.put("south_uid", new TableInfo.Column("south_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCanopy.put("center_uid", new TableInfo.Column("center_uid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCanopy.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCanopy.put("flag_edited", new TableInfo.Column("flag_edited", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCanopy = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCanopy = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCanopy = new TableInfo("canopy", _columnsCanopy, _foreignKeysCanopy, _indicesCanopy);
        final TableInfo _existingCanopy = TableInfo.read(_db, "canopy");
        if (! _infoCanopy.equals(_existingCanopy)) {
          return new RoomOpenHelper.ValidationResult(false, "canopy(dev.fabula.android.canopy.model.Canopy).\n"
                  + " Expected:\n" + _infoCanopy + "\n"
                  + " Found:\n" + _existingCanopy);
        }
        final HashMap<String, TableInfo.Column> _columnsContactWire = new HashMap<String, TableInfo.Column>(5);
        _columnsContactWire.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContactWire.put("opora_uid", new TableInfo.Column("opora_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContactWire.put("type_height_wire_uid", new TableInfo.Column("type_height_wire_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContactWire.put("type_zigzag_wire_uid", new TableInfo.Column("type_zigzag_wire_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContactWire.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContactWire = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContactWire = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContactWire = new TableInfo("contact_wire", _columnsContactWire, _foreignKeysContactWire, _indicesContactWire);
        final TableInfo _existingContactWire = TableInfo.read(_db, "contact_wire");
        if (! _infoContactWire.equals(_existingContactWire)) {
          return new RoomOpenHelper.ValidationResult(false, "contact_wire(dev.fabula.android.wire.contact.model.ContactWire).\n"
                  + " Expected:\n" + _infoContactWire + "\n"
                  + " Found:\n" + _existingContactWire);
        }
        final HashMap<String, TableInfo.Column> _columnsCarrierWire = new HashMap<String, TableInfo.Column>(5);
        _columnsCarrierWire.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarrierWire.put("opora_uid", new TableInfo.Column("opora_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarrierWire.put("type_height_wire_uid", new TableInfo.Column("type_height_wire_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarrierWire.put("type_zigzag_wire_uid", new TableInfo.Column("type_zigzag_wire_uid", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCarrierWire.put("flag_created", new TableInfo.Column("flag_created", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCarrierWire = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCarrierWire = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCarrierWire = new TableInfo("carrier_wire", _columnsCarrierWire, _foreignKeysCarrierWire, _indicesCarrierWire);
        final TableInfo _existingCarrierWire = TableInfo.read(_db, "carrier_wire");
        if (! _infoCarrierWire.equals(_existingCarrierWire)) {
          return new RoomOpenHelper.ValidationResult(false, "carrier_wire(dev.fabula.android.wire.carrier.model.CarrierWire).\n"
                  + " Expected:\n" + _infoCarrierWire + "\n"
                  + " Found:\n" + _existingCarrierWire);
        }
        final HashMap<String, TableInfo.Column> _columnsTypeMeasurement = new HashMap<String, TableInfo.Column>(6);
        _columnsTypeMeasurement.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeMeasurement.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeMeasurement.put("norma", new TableInfo.Column("norma", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeMeasurement.put("allowableErrorPlus", new TableInfo.Column("allowableErrorPlus", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeMeasurement.put("allowableErrorMinus", new TableInfo.Column("allowableErrorMinus", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTypeMeasurement.put("type_of", new TableInfo.Column("type_of", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTypeMeasurement = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTypeMeasurement = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTypeMeasurement = new TableInfo("type_measurement", _columnsTypeMeasurement, _foreignKeysTypeMeasurement, _indicesTypeMeasurement);
        final TableInfo _existingTypeMeasurement = TableInfo.read(_db, "type_measurement");
        if (! _infoTypeMeasurement.equals(_existingTypeMeasurement)) {
          return new RoomOpenHelper.ValidationResult(false, "type_measurement(dev.fabula.android.measurements.type.model.MeasurementType).\n"
                  + " Expected:\n" + _infoTypeMeasurement + "\n"
                  + " Found:\n" + _existingTypeMeasurement);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "1dfcf72cd013792e6d7daf671ff4c4c1", "c84a55c0415162a0fd8afa723c8816d9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "railway","railway_section","station_peregon","support","platform","bridge","measurement","gabarittor","canopy","contact_wire","carrier_wire","type_measurement");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `railway`");
      _db.execSQL("DELETE FROM `railway_section`");
      _db.execSQL("DELETE FROM `station_peregon`");
      _db.execSQL("DELETE FROM `support`");
      _db.execSQL("DELETE FROM `platform`");
      _db.execSQL("DELETE FROM `bridge`");
      _db.execSQL("DELETE FROM `measurement`");
      _db.execSQL("DELETE FROM `gabarittor`");
      _db.execSQL("DELETE FROM `canopy`");
      _db.execSQL("DELETE FROM `contact_wire`");
      _db.execSQL("DELETE FROM `carrier_wire`");
      _db.execSQL("DELETE FROM `type_measurement`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public RailwayDao railwayDao() {
    if (_railwayDao != null) {
      return _railwayDao;
    } else {
      synchronized(this) {
        if(_railwayDao == null) {
          _railwayDao = new RailwayDao_Impl(this);
        }
        return _railwayDao;
      }
    }
  }

  @Override
  public RailwaySectionDao railwaySectionDao() {
    if (_railwaySectionDao != null) {
      return _railwaySectionDao;
    } else {
      synchronized(this) {
        if(_railwaySectionDao == null) {
          _railwaySectionDao = new RailwaySectionDao_Impl(this);
        }
        return _railwaySectionDao;
      }
    }
  }

  @Override
  public ReportDao reportDao() {
    if (_reportDao != null) {
      return _reportDao;
    } else {
      synchronized(this) {
        if(_reportDao == null) {
          _reportDao = new ReportDao_Impl(this);
        }
        return _reportDao;
      }
    }
  }

  @Override
  public StationPeregonDao stationPeregonDao() {
    if (_stationPeregonDao != null) {
      return _stationPeregonDao;
    } else {
      synchronized(this) {
        if(_stationPeregonDao == null) {
          _stationPeregonDao = new StationPeregonDao_Impl(this);
        }
        return _stationPeregonDao;
      }
    }
  }

  @Override
  public SupportDao supportDao() {
    if (_supportDao != null) {
      return _supportDao;
    } else {
      synchronized(this) {
        if(_supportDao == null) {
          _supportDao = new SupportDao_Impl(this);
        }
        return _supportDao;
      }
    }
  }

  @Override
  public PlatformDao platformDao() {
    if (_platformDao != null) {
      return _platformDao;
    } else {
      synchronized(this) {
        if(_platformDao == null) {
          _platformDao = new PlatformDao_Impl(this);
        }
        return _platformDao;
      }
    }
  }

  @Override
  public BridgeCrossingDao bridgeCrossingDao() {
    if (_bridgeCrossingDao != null) {
      return _bridgeCrossingDao;
    } else {
      synchronized(this) {
        if(_bridgeCrossingDao == null) {
          _bridgeCrossingDao = new BridgeCrossingDao_Impl(this);
        }
        return _bridgeCrossingDao;
      }
    }
  }

  @Override
  public CreateMeasurementsDao createMeasurementDao() {
    if (_createMeasurementsDao != null) {
      return _createMeasurementsDao;
    } else {
      synchronized(this) {
        if(_createMeasurementsDao == null) {
          _createMeasurementsDao = new CreateMeasurementsDao_Impl(this);
        }
        return _createMeasurementsDao;
      }
    }
  }

  @Override
  public DimensionsFenceDao dimensionsFenceDao() {
    if (_dimensionsFenceDao != null) {
      return _dimensionsFenceDao;
    } else {
      synchronized(this) {
        if(_dimensionsFenceDao == null) {
          _dimensionsFenceDao = new DimensionsFenceDao_Impl(this);
        }
        return _dimensionsFenceDao;
      }
    }
  }

  @Override
  public CanopyDao canopyDao() {
    if (_canopyDao != null) {
      return _canopyDao;
    } else {
      synchronized(this) {
        if(_canopyDao == null) {
          _canopyDao = new CanopyDao_Impl(this);
        }
        return _canopyDao;
      }
    }
  }

  @Override
  public ContactWireDao contactWireDao() {
    if (_contactWireDao != null) {
      return _contactWireDao;
    } else {
      synchronized(this) {
        if(_contactWireDao == null) {
          _contactWireDao = new ContactWireDao_Impl(this);
        }
        return _contactWireDao;
      }
    }
  }

  @Override
  public CarrierWireDao carrierWireDao() {
    if (_carrierWireDao != null) {
      return _carrierWireDao;
    } else {
      synchronized(this) {
        if(_carrierWireDao == null) {
          _carrierWireDao = new CarrierWireDao_Impl(this);
        }
        return _carrierWireDao;
      }
    }
  }

  @Override
  public MeasurementTypeDao measurementTypeDao() {
    if (_measurementTypeDao != null) {
      return _measurementTypeDao;
    } else {
      synchronized(this) {
        if(_measurementTypeDao == null) {
          _measurementTypeDao = new MeasurementTypeDao_Impl(this);
        }
        return _measurementTypeDao;
      }
    }
  }
}
