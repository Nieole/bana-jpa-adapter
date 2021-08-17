package org.bana.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission extends PermissionEntity<String> {

  @Id
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String id() {
    return id;
  }
}
