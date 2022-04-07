package me.guillaume.chuck_facts.adapters.web.security;

import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import me.guillaume.chuck_facts.infrastructure.persistence.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsersRepository usersService;

/*    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // Users temp = usersService.findByEmailAndPassword("flopp@flopp.flopp", "nuclearFLOPP");
        auth.inMemoryAuthentication()
                .withUser("guillaume").password(passwordEncoder().encode("guillaume")).roles("ADMIN");
    }*/

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login-form")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/admin", true)
                .failureUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Users myUser = this.usersService.findByName(username);
            return new MyUserDetails(myUser);
        };
    }

    private static class MyUserDetails extends Users implements UserDetails {
        public MyUserDetails(Users myUser){
            super(myUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
        }

        @Override
        public String getUsername() {
            return this.getName();
        }

        @Override
        public String getPassword() {
            return "$2y$10$xUWGCnmZmn.qPEVcMUP1q.IsW4MCaD1ODFnIl49lvf44nCOCu8vK.";
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
