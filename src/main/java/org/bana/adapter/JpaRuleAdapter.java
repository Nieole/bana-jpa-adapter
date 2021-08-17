package org.bana.adapter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.bana.entity.JpaRule;
import org.bana.repository.JpaRuleRepository;
import org.casbin.jcasbin.model.Assertion;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

public class JpaRuleAdapter implements Adapter<JpaRule> {

  private final JpaRuleRepository jpaRuleRepository;
  private volatile boolean isFiltered = true;

  public JpaRuleAdapter(JpaRuleRepository jpaRuleRepository) {
    this.jpaRuleRepository = jpaRuleRepository;
  }

  @Override
  public boolean isFiltered() {
    return isFiltered;
  }

  @Override
  @Transactional
  public void addPolicy(String sec, String ptype, List<String> rule) {
    JpaRule jpaRule = new JpaRule();
    jpaRule.setPtype(ptype);
    if (StringUtils.hasText(rule.get(0))) {
      jpaRule.setV0(rule.get(0));
    }
    if (rule.size() > 1 && StringUtils.hasText(rule.get(1))) {
      jpaRule.setV1(rule.get(1));
    }
    if (rule.size() > 2 && StringUtils.hasText(rule.get(2))) {
      jpaRule.setV2(rule.get(2));
    }
    if (rule.size() > 3 && StringUtils.hasText(rule.get(3))) {
      jpaRule.setV3(rule.get(3));
    }
    if (rule.size() > 4 && StringUtils.hasText(rule.get(4))) {
      jpaRule.setV4(rule.get(4));
    }
    if (rule.size() > 5 && StringUtils.hasText(rule.get(5))) {
      jpaRule.setV5(rule.get(5));
    }
    if (rule.size() > 6 && StringUtils.hasText(rule.get(6))) {
      jpaRule.setV6(rule.get(6));
    }
    if (rule.size() > 7 && StringUtils.hasText(rule.get(7))) {
      jpaRule.setV7(rule.get(7));
    }
    jpaRuleRepository.save(jpaRule);
  }

  @Override
  public List<JpaRule> loadAllRule() {
    return jpaRuleRepository.findAll();
  }

  @Override
  public void deleteAll() {
    jpaRuleRepository.deleteAll();
  }

  @Override
  public void saveAll(List<JpaRule> rules) {
    jpaRuleRepository.saveAll(rules);
  }

  @Override
  @Transactional
  public void removeFilteredPolicy(String sec, String ptype, int fieldIndex,
      String... fieldValues) {
    if (fieldValues.length == 0) {
      return;
    }
    jpaRuleRepository.findOne((root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();
      predicates.add(criteriaBuilder.equal(root.get("ptype"), ptype));
      int count = fieldIndex;
      for (String fieldValue : fieldValues) {
        predicates.add(criteriaBuilder.equal(root.get("v" + count), fieldValue));
        count++;
      }
      return query.where(predicates.toArray(new Predicate[0])).getRestriction();
    }).ifPresent(jpaRuleRepository::delete);
  }

  @Override
  public void setIsFiltered(Boolean isFiltered ) {
    this.isFiltered = isFiltered;
  }

  @Override
  public io.vavr.collection.List<JpaRule> transform(Assertion assertion) {
    if (assertion.policy.isEmpty()) {
      return io.vavr.collection.List.empty();
    }
    return io.vavr.collection.List.ofAll(assertion.policy)
        .map(p -> {
          JpaRule rule = new JpaRule();
          rule.setPtype(assertion.key);
          rule.setV0(p.get(0));
          if (p.size() >= 2) {
            rule.setV1(p.get(1));
          }
          if (p.size() >= 3) {
            rule.setV2(p.get(2));
          }
          if (p.size() >= 4) {
            rule.setV3(p.get(3));
          }
          if (p.size() >= 5) {
            rule.setV4(p.get(4));
          }
          if (p.size() >= 6) {
            rule.setV5(p.get(5));
          }
          if (p.size() >= 7) {
            rule.setV6(p.get(6));
          }
          if (p.size() >= 8) {
            rule.setV7(p.get(7));
          }
          return rule;
        });
  }
}
