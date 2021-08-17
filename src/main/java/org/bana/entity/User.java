package org.bana.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends UserEntity<String>{
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
  public String id() {
    return id;
  }
}
