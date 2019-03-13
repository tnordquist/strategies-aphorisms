package edu.cnm.deepdive.strataphor.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(indices = @Index(value = "name", unique = true))
public class Source {

  @ColumnInfo(name = "source_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name = "";

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

}
