package pl.otez.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class AuthentificationConfiguration extends WebSecurityConfigurerAdapter {
    private final CurrentUserService currentUserService;
    private final PasswordEncoder passwordEncoder;
    private final SessionFilter sessionFilter;


    @Lazy
    public AuthentificationConfiguration(CurrentUserService aCurrentUserService, PasswordEncoder aPasswordEncoder, SessionFilter aSessionFilter) {
        currentUserService = aCurrentUserService;
        passwordEncoder = aPasswordEncoder;
        sessionFilter = aSessionFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(currentUserService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http
                .cors()
                .and()
                .csrf()
                .disable();

        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        ((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                authException.getMessage()))
                ).and();

        http.authorizeHttpRequests()
                .antMatchers("/", "/api/client/login", "/api/**", "/**", "/api/employee/login")
                .permitAll()
                .anyRequest()
                .authenticated();

//        http.authorizeHttpRequests()
//                .antMatchers("/api/client/login", "/api/**", "/**").hasAuthority("USER");
//
//        http.authorizeHttpRequests()
//                .antMatchers("/api/employee/login").hasRole("ADMIN");

        http
                .addFilterBefore(sessionFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
