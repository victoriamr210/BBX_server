package com.bbx.shop.assigment.auth;

import com.bbx.shop.assigment.auth.token.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${jwt.get.token.uri}")
    private String authenticationPath;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UnAuthorizedResponseAuthenticationEntryPoint unAuthorizedResponseAuthenticationEntryPoint;

//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;


    @Bean
    public JwtRequestFilter authenticationJwtTokenFilter() {
        return new JwtRequestFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .cors().disable()
//            .csrf().disable()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .authorizeRequests()
//            .antMatchers("/authenticate").permitAll()
//            .antMatchers("/api/**").permitAll();
        http
                .cors().and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unAuthorizedResponseAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
//                .anyRequest().authenticated();
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/api/**").permitAll();
//
        http
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);


        http
                .headers()
                .frameOptions().sameOrigin()  //H2 Console Needs this setting
                .cacheControl();
    }


//    @Override
//    public void configure(final WebSecurity web) {
//        web
//                .ignoring()
//                .antMatchers(
//                        HttpMethod.POST,
//                        authenticationPath
//                )
//                .antMatchers(HttpMethod.OPTIONS, "/**")
//                .and()
//                .ignoring()
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/" //Other Stuff You want to Ignore
//                )
//                .and()
//                .ignoring()
//                .antMatchers("/h2-console/**/**");
//
//    }
}
