package org.bana.jpa.adapter;

import org.bana.jpa.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public class PermissionAdapter extends JpaAdapter<Permission, String> {

  public PermissionAdapter(JpaRepository<Permission, String> repository) {
    super(repository);
  }
}
