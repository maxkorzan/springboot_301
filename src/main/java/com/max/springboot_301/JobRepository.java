package com.max.springboot_301;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
