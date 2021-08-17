package org.bana.service;

import java.io.Serializable;
import org.bana.adapter.DataAdapter;
import org.bana.entity.RoleEntity;
import org.bana.entity.User;
import org.casbin.jcasbin.main.Enforcer;

public class JpaUserService extends UserService<User,String>{

  public <R extends RoleEntity<RI>, RI extends Serializable> JpaUserService(
      DataAdapter<User, String> dataAdapter,
      Enforcer enforcer, RoleService<R, RI> roleService) {
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
