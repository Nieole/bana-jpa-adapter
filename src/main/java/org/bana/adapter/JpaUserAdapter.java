package org.bana.adapter;

import java.util.Collection;
import org.bana.entity.User;
import org.bana.repository.UserRepository;

public class JpaUserAdapter implements DataAdapter<User,String> {
  private final UserRepository userRepository;

  public JpaUserAdapter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean save(User user) {
    userRepository.save(user);
    return true;
  }

  @Override
  public boolean batchSave(Collection<User> collection) {
    userRepository.saveAll(collection);
    return true;
  }

  @Override
  public User select(String id) {
    return userRepository.getById(id);
  }

  @Override
  public Collection<User> batchSelect(Collection<String> ids) {
    return userRepository.findAllById(ids);
  }

  @Override
  public boolean update(User user) {
    userRepository.save(user);
    return true;
  }

  @Override
  public boolean batchUpdate(Collection<User> users) {
    userRepository.saveAll(users);
    return true;
  }

  @Override
  public boolean delete(User user) {
    userRepository.delete(user);
    return true;
  }

  @Override
  public boolean delete(String id) {
    userRepository.deleteById(id);
    return true;
  }

  @Override
  public boolean batchDelete(Collection<User> users) {
    userRepository.deleteAllInBatch(users);
    return true;
  }

  @Override
  public boolean batchDeleteById(Collection<String> ids) {
    userRepository.deleteAllByIdInBatch(ids);
    return true;
  }
}
