package org.bana.jpa.adapter;

import java.io.Serializable;
import java.util.Collection;
import org.bana.adapter.DataAdapter;
import org.bana.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class JpaAdapter<DATA extends BaseEntity<ID>, ID extends Serializable> implements
    DataAdapter<DATA, ID> {

  private final JpaRepository<DATA, ID> repository;

  public JpaAdapter(JpaRepository<DATA, ID> repository) {
    this.repository = repository;
  }

  public JpaRepository<DATA, ID> getRepository() {
    return repository;
  }

  @Override
  public boolean save(DATA data) {
    repository.save(data);
    return true;
  }

  @Override
  public boolean batchSave(Collection<DATA> datas) {
    repository.saveAll(datas);
    return true;
  }

  @Override
  public DATA select(ID id) {
    return repository.getById(id);
  }

  @Override
  public Collection<DATA> batchSelect(Collection<ID> ids) {
    return repository.findAllById(ids);
  }

  @Override
  public boolean update(DATA data) {
    repository.save(data);
    return true;
  }

  @Override
  public boolean batchUpdate(Collection<DATA> datas) {
    repository.saveAll(datas);
    return true;
  }

  @Override
  public boolean delete(DATA data) {
    repository.delete(data);
    return true;
  }

  @Override
  public boolean delete(ID id) {
    repository.deleteById(id);
    return true;
  }

  @Override
  public boolean batchDelete(Collection<DATA> datas) {
    repository.deleteAllInBatch(datas);
    return true;
  }

  @Override
  public boolean batchDeleteById(Collection<ID> ids) {
    repository.deleteAllByIdInBatch(ids);
    return true;
  }
}
