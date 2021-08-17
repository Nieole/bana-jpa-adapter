package org.bana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Permission extends PermissionEntity<String> {

  @Id
  @Column(length = 40)
  @GenericGenerator(name = "xid",strategy = "org.bana.entity.IdGenerator")
  @GeneratedValue(generator = "xid",strategy = GenerationType.SEQUENCE)
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
