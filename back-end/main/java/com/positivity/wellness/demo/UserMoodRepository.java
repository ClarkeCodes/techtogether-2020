package com.positivity.wellness.demo;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserMoodRepository extends CrudRepository<UserMood, Long> {
    List<UserMood> findAllByUserId(String userId);
}
