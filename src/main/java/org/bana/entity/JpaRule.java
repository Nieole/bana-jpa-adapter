package org.bana.entity;

import io.vavr.collection.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JpaRule extends CasbinRule<String> {

  @Id
  @Column(length = 40)
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public List<String> toPolicy() {
    return super.toPolicy();
  }
}
