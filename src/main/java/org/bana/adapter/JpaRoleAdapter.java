package org.bana.adapter;

import java.util.Collection;
import org.bana.entity.Role;
import org.bana.repository.RoleRepository;

public class JpaRoleAdapter implements DataAdapter<Role,String>{
  private final RoleRepository repository;

  public JpaRoleAdapter(RoleRepository repository) {
    this.repository = repository;
  }

  @Override
  public boolean save(Role role) {
    repository.save(role);
    return true;
  }

  @Override
  public boolean batchSave(Collection<Role> roles) {
    repository.saveAll(roles);
    return true;
  }

  @Override
  public Role select(String id) {
    return repository.getById(id);
  }

  @Override
  public Collection<Role> batchSelect(Collection<String> ids) {
    return repository.findAllById(ids);
  }

  @Override
  public boolean update(Role role) {
    repository.save(role);
    return true;
  }

  @Override
  public boolean batchUpdate(Collection<Role> roles) {
    repository.saveAll(roles);
    return true;
  }

  @Override
  public boolean delete(Role role) {
    repository.delete(role);
    return true;
  }

  @Override
  public boolean delete(String id) {
    repository.deleteById(id);
    return true;
  }

  @Override
  public boolean batchDelete(Collection<Role> roles) {
    repository.deleteAllInBatch(roles);
    return true;
  }

  @Override
  public boolean batchDeleteById(Collection<String> ids) {
    repository.deleteAllByIdInBatch(ids);
    return true;
  }
}
