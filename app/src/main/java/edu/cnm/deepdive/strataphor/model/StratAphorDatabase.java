package edu.cnm.deepdive.strataphor.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.strataphor.R;
import edu.cnm.deepdive.strataphor.StratAphorApplication;
import edu.cnm.deepdive.strataphor.model.dao.SayingDao;
import edu.cnm.deepdive.strataphor.model.dao.SourceDao;
import edu.cnm.deepdive.strataphor.model.entity.Saying;
import edu.cnm.deepdive.strataphor.model.entity.Source;
import edu.cnm.deepdive.strataphor.service.RandomSaying;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Database(
    entities = {Source.class, Saying.class},
    version = 1,
    exportSchema = true
)
public abstract class StratAphorDatabase extends RoomDatabase {

  private static final String DATABASE_NAME = "strataphor_db";

  public static StratAphorDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract SourceDao getSourceDao();

  public abstract SayingDao getSayingDao();

  private static class InstanceHolder {

    private static final StratAphorDatabase INSTANCE =
        Room.databaseBuilder(StratAphorApplication.getInstance().getApplicationContext(),
            StratAphorDatabase.class, DATABASE_NAME)
            .build();

  }

}
