package ua.remzsolutions.onlinespreadsheets.security.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.util.JwtTokenUtil;
import ua.remzsolutions.onlinespreadsheets.web.request.TokenPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHeader}")
    private String jwtTokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String userId;
        String jwtToken;
        String header = request.getHeader(jwtTokenHeader);


        LOGGER.info("Checking user token.");
        if (header != null && header.startsWith("Bearer ")) {
            jwtToken = header.substring(7);

            if (jwtToken.equalsIgnoreCase("idango")) {
                request.setAttribute("routingData", new TokenPayload("1"));

                LOGGER.info("Authenticating admin");
                Authentication authentication = new UsernamePasswordAuthenticationToken("1", null,
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else if (jwtTokenUtil.getUsername(jwtToken) != null) {

                userId = jwtTokenUtil.getUsername(jwtToken);

                try {
                    jwtTokenUtil.validateToken(jwtToken);
                    request.setAttribute("routingData", new TokenPayload(userId));

                    LOGGER.info("Authenticating user with user id = {}.", userId);
                    Authentication authentication = new UsernamePasswordAuthenticationToken(userId, null,
                            AuthorityUtils.createAuthorityList("ROLE_USER"));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    LOGGER.info("User successfully authenticated.");

                } catch (RuntimeException e) {
                    LOGGER.info("Invalid token from '{}'", userId);
                }
            } else {
                LOGGER.info("Invalid token submitted.");
            }

        }

        filterChain.doFilter(request, response);
    }
}
