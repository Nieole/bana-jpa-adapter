package org.bana.jpa.adapter;

import org.bana.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public class RoleAdapter extends JpaAdapter<Role, String> {

  public RoleAdapter(JpaRepository<Role, String> repository) {
    super(repository);
  }
}
