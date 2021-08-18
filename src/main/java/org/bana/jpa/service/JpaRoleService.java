package org.bana.jpa.service;

import java.io.Serializable;
import org.bana.adapter.DataAdapter;
import org.bana.entity.PermissionEntity;
import org.bana.jpa.entity.Role;
import org.bana.service.PermissionService;
import org.bana.service.RoleService;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JpaRoleService extends RoleService<Role, String> {

  public <E extends PermissionEntity<I>, I extends Serializable> JpaRoleService(
      DataAdapter<Role, String> dataAdapter,
      Enforcer enforcer,
      PermissionService<E, I> permissionService) {
    super(dataAdapter, enforcer, permissionService);
  }

  @Override
  public String fromId(String id) {
    return id;
  }

  @Override
  public String id(String id) {
    return id;
  }
}
