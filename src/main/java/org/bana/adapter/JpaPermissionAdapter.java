package org.bana.adapter;

import org.bana.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public class JpaPermissionAdapter extends JpaAdapter<Permission,String> {
  public JpaPermissionAdapter(JpaRepository<Permission, String> repository) {
    super(repository);
  }
}
