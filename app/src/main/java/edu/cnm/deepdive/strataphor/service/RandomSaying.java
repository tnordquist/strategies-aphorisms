package edu.cnm.deepdive.strataphor.service;

import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.strataphor.model.StratAphorDatabase;
import edu.cnm.deepdive.strataphor.model.entity.Saying;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSaying {

  private Random rng;
  private List<Saying> sayings;

  private RandomSaying() {
    rng = new Random();
    sayings = new ArrayList<>();
    new BaseFluentAsyncTask<Void, Void, Void, Void>()
        .setPerformer((ignore) -> {
          sayings.addAll(StratAphorDatabase.getInstance().getSayingDao().findAll());
          return null;
        })
        .execute();
  }

  public static RandomSaying getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public Saying getRandomSaying() {
    return sayings.get(rng.nextInt(sayings.size()));
  }

  private static class InstanceHolder {

    private static final RandomSaying INSTANCE = new RandomSaying();

  }

}
