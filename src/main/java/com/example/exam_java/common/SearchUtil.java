package com.example.exam_java.common;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class SearchUtil {
    private SearchUtil() {
        // Hide the default constructor
    }


    public static <T> Specification<T> like(String fieldName, String value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.like(cb.lower(root.get(fieldName)), "%" + value.trim().toLowerCase() + "%");
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> likeUpperCase(String fieldName, String value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.like(root.get(fieldName), "%" + value.trim().toUpperCase() + "%");
            }
            return cb.conjunction();
        };
    }
//
//    public static <R, F> Specification<R> in(String fieldName, List<F> filterList) {
//        return (root, query, cb) -> {
//            if (filterList != null && !filterList.isEmpty()) {
//                if (filterList.size() > 1) {
//                    In<F> inClause = cb.in(root.get(fieldName));
//                    filterList.forEach(inClause::value);
//                    return inClause;
//                } else {
//                    return cb.equal(root.<Comparable>get(fieldName), filterList.get(0));
//                }
//            }
//            return cb.conjunction();
//        };
//    }
//

    public static <R, F> Specification<R> notIn(String fieldName, List<F> filterList) {
        return (root, query, cb) -> {
            if (filterList != null && !filterList.isEmpty()) {
                if (filterList.size() > 1) {
                    return cb.not(root.get(fieldName).in(filterList));
                } else {
                    return cb.notEqual(root.get(fieldName), filterList.get(0));
                }
            }
            return cb.conjunction();
        };


    }
//    public static <T, V> Specification<T> dt(String fieldName) {
//        return (root, query, cb) -> {
//            SingularAttribute<? super T, ?> singularAttribute = root.getModel().getSingularAttribute(fieldName);
//            query.groupBy(root.get(singularAttribute));
//            return cb.conjunction();
//        };
//    }
    public static <T> Specification<T> eq(String fieldName, Object value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.equal(root.<Comparable>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }
    public static <T> Specification<T> notEq(String fieldName, Object value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.notEqual(root.<Comparable>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> gt(String fieldName, Comparable value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.greaterThan(root.<Comparable>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> ge(String fieldName, Comparable value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.greaterThanOrEqualTo(root.<Comparable>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> lt(String fieldName, Comparable value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.lessThan(root.<Comparable>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> le(String fieldName, Comparable value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.lessThanOrEqualTo(root.<Comparable>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> bw(String fieldName, Comparable valueFirst, Comparable valueSecond) {
        return (root, query, cb) -> {
            if (valueFirst != null || valueSecond != null) {
                return cb.between(root.<Comparable>get(fieldName), valueFirst, valueSecond);
            }
            return cb.conjunction();
        };
    }

    public static <T> Specification<T> bf(String fieldName, Timestamp value) {
        return (root, query, cb) -> {
            if (value != null) {
                return cb.lessThan(root.<Timestamp>get(fieldName), value);
            }
            return cb.conjunction();
        };
    }

//    public static <T> Specification<T> or(Map<String, String> mapPredicate) {
//        return (root, query, cb) -> {
//            List<Predicate> predicates = new ArrayList<>();
//            for (Map.Entry<String, String> entry : mapPredicate.entrySet()) {
//                if (entry.getValue() != null) {
//                    predicates.add(cb.equal(root.<Comparable>get(entry.getKey()), entry.getValue()));
//                }
//            }
//            return cb.or(predicates.toArray(new Predicate[0]));
//        };
//    }
//
}
