package edu.cnm.deepdive.strataphor.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(
    foreignKeys = @ForeignKey(entity = Source.class, parentColumns = "source_id",
        childColumns = "source_id", onDelete = ForeignKey.CASCADE)
)
public class Saying {

  @ColumnInfo(name = "saying_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "source_id", index = true)
  private long sourceId;

  @NonNull
  private String text = "";

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSourceId() {
    return sourceId;
  }

  public void setSourceId(long sourceId) {
    this.sourceId = sourceId;
  }

  @NonNull
  public String getText() {
    return text;
  }

  public void setText(@NonNull String text) {
    this.text = text;
  }

}
