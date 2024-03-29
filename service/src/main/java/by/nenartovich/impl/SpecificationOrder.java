package by.nenartovich.impl;

import by.nenartovich.StatusOrder;
import by.nenartovich.entity.Client;
import by.nenartovich.entity.Manager;
import by.nenartovich.entity.Order;
import by.nenartovich.entity.Order_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecificationOrder {
    public static Specification<Order> getOrderByCreatDateBefore(Date dataCreateBefore) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicatesMain = new ArrayList<>();
            if (dataCreateBefore != null) {
                predicatesMain.add(criteriaBuilder.lessThanOrEqualTo(root.get(Order_.DATE_CREATE), dataCreateBefore));
            }
            return criteriaBuilder.and(predicatesMain.toArray(new Predicate[predicatesMain.size()]));
        };
    }

    public static Specification<Order> getOrderByCreatDateFor(Date dataCreateFor) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicatesMain = new ArrayList<>();
            if (dataCreateFor != null) {
                predicatesMain.add(criteriaBuilder.greaterThan(root.get(Order_.DATE_CREATE), dataCreateFor));
            }
            return criteriaBuilder.and(predicatesMain.toArray(new Predicate[predicatesMain.size()]));
        };
    }

    public static Specification<Order> getOrderByManagerSpec(Manager manager) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicatesMain = new ArrayList<>();
            if (manager != null) {
                predicatesMain.add(criteriaBuilder.equal(root.get(Order_.MANAGER), manager));
            }
            return criteriaBuilder.and(predicatesMain.toArray(new Predicate[predicatesMain.size()]));
        };
    }

    public static Specification<Order> getOrderByClientSpec(Client client) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicatesMain = new ArrayList<>();
            if (client != null) {
                predicatesMain.add(criteriaBuilder.equal(root.get(Order_.CLIENT), client));
            }
            return criteriaBuilder.and(predicatesMain.toArray(new Predicate[predicatesMain.size()]));
        };
    }

    public static Specification<Order> getOrderStatusSpec(StatusOrder statusOrder) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicatesMain = new ArrayList<>();
            if (statusOrder != null) {
                predicatesMain.add(criteriaBuilder.equal(root.get(Order_.STATUS_ORDER), statusOrder));
            }
            return criteriaBuilder.and(predicatesMain.toArray(new Predicate[predicatesMain.size()]));
        };
    }
}
