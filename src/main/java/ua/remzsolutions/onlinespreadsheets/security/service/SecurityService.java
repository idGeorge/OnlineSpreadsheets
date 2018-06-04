package ua.remzsolutions.onlinespreadsheets.security.service;

import org.springframework.security.core.Authentication;

public interface SecurityService {

    Authentication authenticate(String username, String password);

}
