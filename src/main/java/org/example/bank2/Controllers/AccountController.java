package org.example.bank2.Controllers;

import org.example.bank2.DTO.NomineeRequest;
import org.example.bank2.entites.Account;
import org.example.bank2.entites.User;
import org.example.bank2.services.AccountService;
import org.example.bank2.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
    @RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService,UserService userService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
         accountService.createAccount(account);
        User user=userService.getUserById(account.getUser());
        List<String>accountList=user.getAccounts();
        accountList.add(account.getId());
        userService.saveUser(user);
        return account;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/addNominee")
    public Account addNominee(@RequestBody NomineeRequest nomineeRequest) {

        System.out.println(nomineeRequest.getNomineeId());
        System.out.println(nomineeRequest.getUserId());

        Account account=accountService.getAccountById(nomineeRequest.getUserId());
        Account nominee=accountService.getAccountById(nomineeRequest.getNomineeId());

        Set<String> accountNominees=account.getNominees();

        accountNominees.add(nominee.getId());

        Account account1=accountService.updateAccount(account.getId(),account);


        return account1;
    }



}
