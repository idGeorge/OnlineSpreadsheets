package ua.remzsolutions.onlinespreadsheets.security;

import ua.remzsolutions.onlinespreadsheets.security.entry.RestAuthenticationEntryPoint;
import ua.remzsolutions.onlinespreadsheets.security.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "ua.remzsolutions.onlinespreadsheets.security.*")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationEntryPoint getAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter getAuthenticationTokenFilter() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Disabling csrf
                .csrf().disable()

                // unauthorized access handler
                .exceptionHandling().authenticationEntryPoint(getAuthenticationEntryPoint()).and()

                // session policy
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();

        // Jwt authentication filter
        httpSecurity.addFilterBefore(getAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
