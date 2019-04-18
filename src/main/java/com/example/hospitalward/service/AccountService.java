package com.example.hospitalward.service;

        import com.example.hospitalward.model.Account;
        import com.example.hospitalward.model.Patient;
        import com.example.hospitalward.util.Page;
        import com.github.pagehelper.PageInfo;

public interface AccountService {
    PageInfo selectList(Patient patient, Page page) throws  Exception;

    Integer create(Account account) throws  Exception;

    Integer edit(Account account) throws  Exception;
}
