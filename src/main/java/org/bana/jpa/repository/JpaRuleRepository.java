package org.bana.jpa.repository;

import org.bana.jpa.entity.JpaRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRuleRepository extends JpaRepository<JpaRule, String>,
    JpaSpecificationExecutor<JpaRule> {

}
