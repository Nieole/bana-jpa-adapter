package org.bana.adapter;

import org.bana.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public class JpaRoleAdapter extends JpaAdapter<Role, String> {

  public JpaRoleAdapter(JpaRepository<Role, String> repository) {
    super(repository);
  }
}
