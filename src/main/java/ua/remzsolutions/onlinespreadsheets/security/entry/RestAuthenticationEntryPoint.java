package ua.remzsolutions.onlinespreadsheets.security.entry;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.remzsolutions.onlinespreadsheets.web.exception.ExceptionRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {


    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException, ServletException {

        LOGGER.info(e);

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getOutputStream().println(objectMapper.writeValueAsString(new ExceptionRepresentation(e)));
    }
}