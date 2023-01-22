package hr.kbratko.domain;

import java.util.Objects;

public class BaseModel<K extends Comparable<K>> {

  protected K id;

  public BaseModel() {
  }

  public BaseModel(K id) {
    this.id = id;
  }

  public K getId() {
    return id;
  }

  public void setId(K id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BaseModel<?> baseModel = (BaseModel<?>) o;

    return Objects.equals(id, baseModel.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
