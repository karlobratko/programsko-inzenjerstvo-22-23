package hr.kbratko.infrastructure;

import java.util.ArrayList;

public class LimitedArrayList<T> extends ArrayList<T> {

  private final Integer limit;

  public LimitedArrayList(Integer limit) {
    this.limit = limit;
  }

  @Override
  public boolean add(T e) {
    if (this.size() < limit) {
      return super.add(e);
    }
    
    return false;
  }

}
