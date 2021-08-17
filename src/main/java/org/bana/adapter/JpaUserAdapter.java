package org.bana.adapter;

import org.bana.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class JpaUserAdapter extends JpaAdapter<User,String> {
  public JpaUserAdapter(JpaRepository<User, String> repository) {
    super(repository);
  }
}
