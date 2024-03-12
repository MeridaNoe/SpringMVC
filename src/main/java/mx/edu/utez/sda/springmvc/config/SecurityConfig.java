package mx.edu.utez.sda.springmvc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
            UserDetails children = User.withUsername("ninio")
                .password(passwordEncoder().encode("1234"))
                .roles("NINIO")
                .build();
        UserDetails adulto = User.withUsername("adulto")
                .password(passwordEncoder().encode("1234"))
                .roles("ADULTO")
                .build();

        return new InMemoryUserDetailsManager(children, adulto);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> {
            requests.requestMatchers("/", "/index").permitAll();
            requests.anyRequest().authenticated();
        });
        httpSecurity.formLogin((login) -> {
            login.loginPage("/login").permitAll();
        });
        httpSecurity.logout((logout) -> {
            logout.permitAll();
        });
        return httpSecurity.build();
    }
}
