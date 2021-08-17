package org.bana.entity;

import io.vavr.collection.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JpaRule extends CasbinRule<String> {

  @Id
  private String id;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public List<String> toPolicy() {
    return null;
  }
}
