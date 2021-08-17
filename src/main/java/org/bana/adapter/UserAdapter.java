package org.bana.adapter;

import org.bana.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserAdapter extends JpaAdapter<User, String> {

  public UserAdapter(JpaRepository<User, String> repository) {
    super(repository);
  }
}
