package com.rim.qrcodegenerator.auth;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ApplicationUserDaoImpl implements ApplicationUserDao{


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName) {
        return Optional.empty();
    }
}
