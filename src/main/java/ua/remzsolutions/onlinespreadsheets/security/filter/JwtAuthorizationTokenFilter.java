package ua.remzsolutions.onlinespreadsheets.security.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import ua.remzsolutions.onlinespreadsheets.security.service.SecurityService;
import ua.remzsolutions.onlinespreadsheets.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationTokenFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Autowired
    private SecurityService securityService;

    public JwtAuthorizationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String username;
        String jwtToken;
        String header = request.getHeader(jwtTokenHeader);

        LOGGER.info("Checking user token.");
        if (header != null && header.startsWith("Bearer ")) {
            jwtToken = header.substring(7);

            if (jwtTokenUtil.isValid(jwtToken) && jwtTokenUtil.hasClaim("username", jwtToken) ) {
                username = jwtTokenUtil.getUsername(jwtToken);
                securityService.authenticate(username, null);
            } else {
                LOGGER.info("Invalid token from submitted from {}.", request.getRemoteAddr());
                return;
            }
        } else {
            LOGGER.info("No token submitted from {}.", request.getRemoteAddr());
        }

        filterChain.doFilter(request, response);
    }
}
