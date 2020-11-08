package com.positivity.wellness.demo;

import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class UserMoodSpecifications {
    public static Specification<UserMood> isInDateRange(String userId, Date from, Date to) {
        // make time for from
        from.setHours(0);
        from.setMinutes(0);
        from.setSeconds(1);

        to.setHours(23);
        to.setMinutes(59);
        to.setSeconds(59);

        return (root, query, cb) ->
                cb.and(
                        cb.equal(root.get("userId"), userId),
                        cb.greaterThanOrEqualTo(root.get("when"), from),
                        cb.lessThanOrEqualTo(root.get("when"), to));
    }
}
