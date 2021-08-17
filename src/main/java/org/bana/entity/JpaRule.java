package org.bana.entity;

import io.vavr.collection.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class JpaRule extends CasbinRule<String> {

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
  public List<String> toPolicy() {
    return super.toPolicy();
  }
}
