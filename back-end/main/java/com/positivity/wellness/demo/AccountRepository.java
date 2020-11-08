package com.positivity.wellness.demo;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByUsername(String userName);
}
