package edu.cnm.deepdive.strataphor.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import edu.cnm.deepdive.strataphor.model.entity.Source;
import java.util.List;

@Dao
public interface SourceDao {

  @Insert
  long insert(Source source);

  @Insert
  List<Long> insert(Source... sources);

  @Insert
  List<Long> insert(List<Source> sources);

  @Query("SELECT * FROM Source ORDER BY name ASC")
  List<Source> findAll();

  @Query("SELECT * FROM Source WHERE source_id = :sourceId")
  Source findFirstById(long sourceId);

  @Update
  int update(Source... sources);

  @Update
  int update(List<Source> sources);

  @Delete
  int delete(Source... sources);

  @Delete
  int delete(List<Source> sources);

}
