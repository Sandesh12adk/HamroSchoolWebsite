package com.project.hamroschool.configure;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        // Permit All Requests inside the Web Application
     /*   http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
*/
        // Deny All Requests inside the Web Application
            /*http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());*/


        http.csrf(x->x.disable())
        .authorizeHttpRequests(x -> {
            x.requestMatchers("/home").permitAll()
                    .requestMatchers("/contact").authenticated()
                    .requestMatchers("/courses").permitAll()
                    .requestMatchers("/login/**").permitAll()
                    .requestMatchers("/about").permitAll()
                    .requestMatchers("/contactform").permitAll()
                    .requestMatchers("/demo").permitAll()
                    .requestMatchers("/holidays/**").permitAll()  // Beause there is anthoer endpoint as /holiday/{kun}
                    .requestMatchers("/assets/**").permitAll()
                    .requestMatchers("/error").permitAll()
                    .requestMatchers("/logout").authenticated()
                    .requestMatchers("/saveMsg").permitAll()
                    .requestMatchers("/messages").hasRole("ADMIN")
                    .requestMatchers("/msg").hasRole("ADMIN")
                    .requestMatchers("/addholidays").hasRole("ADMIN")
                    .requestMatchers("/closeMsg").hasRole("ADMIN")
                    .requestMatchers("removeholiday").hasRole("ADMIN")
                    .requestMatchers("/saveholiday").hasRole("ADMIN")
                    .requestMatchers("/dashboard").authenticated();
        });
      // This is default form, with default behaviour
        // http.formLogin(Customizer.withDefaults());
        http.formLogin(x-> x.loginPage("/login").defaultSuccessUrl("/home")
                .failureUrl("/login?error= false")
                .permitAll());
        http.logout(x->x.logoutSuccessUrl("/login?logout= true").invalidateHttpSession(true).permitAll());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }
    @Bean
    public InMemoryUserDetailsManager users(){
        UserDetails admin= User.withDefaultPasswordEncoder()
                .username("Sandesh")
                .password("123")
                .roles("ADMIN")
                .build();
        UserDetails user1= User.withDefaultPasswordEncoder()
                .username("keshab")
                .password("123")
                .roles("USER")
                .build();
        UserDetails user2= User.withDefaultPasswordEncoder()
                .username("ram")
                .password("123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,admin);
    }
}
