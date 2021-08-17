package org.bana.service;

import java.io.Serializable;
import org.bana.adapter.DataAdapter;
import org.bana.entity.PermissionEntity;
import org.bana.entity.Role;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RoleService extends AbstractRoleService<Role, String> {

  public <E extends PermissionEntity<I>, I extends Serializable> RoleService(
      DataAdapter<Role, String> dataAdapter,
      Enforcer enforcer,
      AbstractPermissionService<E, I> permissionService) {
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
