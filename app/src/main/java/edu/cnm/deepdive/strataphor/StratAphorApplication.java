package edu.cnm.deepdive.strataphor;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class StratAphorApplication extends Application {

  private static StratAphorApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.
  }

  public static StratAphorApplication getInstance() {
    return instance;
  }

}
