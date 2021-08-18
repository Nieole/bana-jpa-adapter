package org.bana.jpa.adapter;

import org.bana.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class UserAdapter extends JpaAdapter<User, String> {

  public UserAdapter(JpaRepository<User, String> repository) {
    super(repository);
  }
}
