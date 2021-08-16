package org.bana.entity;

import io.vavr.collection.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.casbin.jcasbin.model.Assertion;
import org.casbin.jcasbin.model.Model;

@Entity
public class JpaRule extends CasbinRule<String> {

  @Id
  private String id;

  public static List<Rule> transformToCasbinRule(Model model) {
    return List.ofAll(model.model.values())
        .flatMap(Map::values)
        .flatMap(JpaRule::rule);
  }

  private static List<JpaRule> rule(Assertion assertion) {
    if (assertion.policy.isEmpty()) {
      return List.empty();
    }
    return List.ofAll(assertion.policy)
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

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public List<String> toPolicy() {
    return null;
  }
}
