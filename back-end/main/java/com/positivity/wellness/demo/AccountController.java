package com.positivity.wellness.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository repository;

    @RequestMapping(path = "/demo/account", method = RequestMethod.POST)
    @ResponseBody
    public Account saveAccount(@RequestBody Account account) {
        System.out.println(account);
        repository.save(account);
        return account;
    }

    @RequestMapping(path = "/demo/account", method = RequestMethod.GET)
    @ResponseBody
    public Account getAccountByUsername(@RequestParam(name = "user") String userName) {
        return repository.findAccountByUsername(userName);
    }
}
