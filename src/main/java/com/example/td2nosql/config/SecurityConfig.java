package com.example.td2nosql.config;
import com.example.td2nosql.filter.JwtFilter;
import com.example.td2nosql.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public PasswordEncoder getPassword() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        http.csrf().disable();
        web.ignoring().antMatchers("/**").antMatchers("/example/endpoint");

//        http.authorizeRequests()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .successHandler(new CustomAuthenticationSuccessHandler())
//                .and()
//                .logout().logoutRequestMatcher(new
//                AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

//        http.csrf().disable().authorizeRequests().antMatchers("/authenticate", "api/users/")
//                .permitAll().anyRequest().authenticated()
//                .and().exceptionHandling().and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
    }
}
