package com.K21CNT2.Ntt_account.controller;

import com.K21CNT2.Ntt_account.entity.NttAccount;
import com.K21CNT2.Ntt_account.service.NttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Accounts")
public class NttAccountController {
    @Autowired
    private NttService nttService;

    @GetMapping
    public String Accounts(Model model) {
        model.addAttribute("accounts", nttService.getAllAccounts());
        return "NttAccount-list";
    }

    @GetMapping("/add")
    public String addAccount(Model model) {
        model.addAttribute("account", new NttAccount());
        return "NttAccount-add";
    }

    @PostMapping("/add")
    public String saveAccount(@ModelAttribute("account") NttAccount nttAccount) {
        nttService.save(nttAccount);
        return "redirect:/Accounts";
    }

    @GetMapping("/edit/{id}")
    public String editAccount(@PathVariable(value = "id") Long id, Model model) {
        NttAccount nttAccount = nttService.getAccountById(id);
        model.addAttribute("account", nttAccount);
        return "NttAccount-edit"; // Sửa "NttAccounts-edit" thành "NttAccount-edit"
    }

    @PostMapping("/update/{id}")
    public String updateAccount(@PathVariable(value = "id") Long id, @ModelAttribute("account") NttAccount nttAccount) {
        nttService.update(id, nttAccount);
        return "redirect:/Accounts";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable(value = "id") Long id) {
        nttService.delete(id);
        return "redirect:/Accounts";
    }
}
