package org.bana.jpa.service;

import java.io.Serializable;
import org.bana.adapter.DataAdapter;
import org.bana.entity.RoleEntity;
import org.bana.jpa.entity.User;
import org.bana.service.RoleService;
import org.bana.service.UserService;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JpaUserService extends UserService<User, String> {

  public <R extends RoleEntity<RI>, RI extends Serializable> JpaUserService(
      DataAdapter<User, String> dataAdapter, Enforcer enforcer,
      RoleService<R, RI> roleService) {
    super(dataAdapter, enforcer, roleService);
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
