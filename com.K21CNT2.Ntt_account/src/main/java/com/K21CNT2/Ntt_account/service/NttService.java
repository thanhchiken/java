package com.K21CNT2.Ntt_account.service;

import com.K21CNT2.Ntt_account.entity.NttAccount;
import com.K21CNT2.Ntt_account.repository.NttAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NttService {
    @Autowired
    private NttAccountRepository nttAccountRepository;

    public List<NttAccount> getAllAccounts() {
        return nttAccountRepository.findAll();
    }

    public NttAccount getAccountById(Long id) {
        return nttAccountRepository.findById(id).orElse(null);
    }

    public NttAccount save(NttAccount nttAccount) {
        return nttAccountRepository.save(nttAccount);
    }

    public NttAccount update(Long id, NttAccount nttAccount) {
        return nttAccountRepository.findById(id).map(account -> {
            account.setNttUser(nttAccount.getNttUser());
            account.setNttPass(nttAccount.getNttPass());
            account.setNttName(nttAccount.getNttName());
            account.setNttEmail(nttAccount.getNttEmail());
            account.setNttPhone(nttAccount.getNttPhone());
            account.setNttAddress(nttAccount.getNttAddress());
            account.setNttStatus(nttAccount.getNttStatus());
            return nttAccountRepository.save(account);
        }).orElse(null);
    }

    public void delete(Long id) {
        nttAccountRepository.deleteById(id);
    }
}
