package by.nenartovich.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ADMIN", "MANAGER", "CLIENT")
                .antMatchers("/", "/manager/**").hasAnyAuthority("MANAGER")
                .antMatchers("/", "/client/**").hasAnyAuthority("CLIENT", "MANAGER")
                .antMatchers("/", "/rest-catalog/**").hasAnyAuthority("CLIENT", "MANAGER")
                .antMatchers("/sms-rest").permitAll()
                .antMatchers("/index").permitAll()
                .and()
                .formLogin().permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login");

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
