package com.integranova.spring.expensereportdemo.security;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String APPUSER_ROLE = "AppUser";
    private static final String ADMINUSER_ROLE = "AdminUser";
    private static final String OPERATORUSER_ROLE = "OperatorUser";

    TokenAuthenticationProvider provider;

    public SecurityConfig(final TokenAuthenticationProvider provider) {
        super();
        this.provider = requireNonNull(provider);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }

    @Override
    public void configure(final WebSecurity web) {
        web.ignoring().requestMatchers(getPublicUrls());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling()
        .defaultAuthenticationEntryPointFor(forbiddenEntryPoint(), getProtectedUrls())
        .and()
        .authenticationProvider(provider)
        .addFilterBefore(restAuthenticationFilter(), AnonymousAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers("/api/AppUserApi/**").hasAnyAuthority(APPUSER_ROLE, ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/EmployeeApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ExpenseLineApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ExpenseReportApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/PaymentTypeApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ProjectApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ExpenseTypeApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ExpenseCurrencyApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/AssignmentApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/TeamApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ERLTemplateApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ERTemplateApi/**").hasAnyAuthority(ADMINUSER_ROLE, OPERATORUSER_ROLE)
        .antMatchers("/api/ExchangeHistoryApi/**").hasAnyAuthority(ADMINUSER_ROLE)
        .antMatchers("/api/SystemParamApi/**").hasAnyAuthority(ADMINUSER_ROLE)
        .antMatchers("api/GlobalServices/**").hasAnyAuthority(ADMINUSER_ROLE)
        .and()
        .cors()
        .and()
        .csrf().disable()
        .formLogin().disable()
        .httpBasic().disable()
        .logout().disable();
        // @formatter:on
    }

    @Bean
    public TokenAuthenticationFilter restAuthenticationFilter() throws Exception {
        final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(getProtectedUrls());
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        return filter;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        final AuthenticationSuccessHandler successHandler = new AuthenticationSuccessHandler();
        successHandler.setRedirectStrategy(new NoRedirectStrategy());
        return successHandler;
    }

    @Bean
    public SimpleUrlAuthenticationSuccessHandler successHandler() {
        final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setRedirectStrategy(new NoRedirectStrategy());
        return successHandler;
    }

    @Bean
    public FilterRegistrationBean<TokenAuthenticationFilter> disableAutoRegistration(
            final TokenAuthenticationFilter filter) {
        final FilterRegistrationBean<TokenAuthenticationFilter> registration = new FilterRegistrationBean<>(filter);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(FORBIDDEN);
    }

    private RequestMatcher getPublicUrls() {
        List<RequestMatcher> publicUrls = new ArrayList<>();
        publicUrls.add(new AntPathRequestMatcher("/Token"));
        publicUrls.add(new AntPathRequestMatcher("/api/Account/AnonymousUserInfo"));
        publicUrls.addAll(getPublicUrls4UserFunctions());
        publicUrls.addAll(getPublicUrls4GlobalServices());
        publicUrls.addAll(getPublicUrls4AppUser());
        publicUrls.addAll(getPublicUrls4Employee());
        publicUrls.addAll(getPublicUrls4ExpenseLine());
        publicUrls.addAll(getPublicUrls4ExpenseReport());
        publicUrls.addAll(getPublicUrls4PaymentType());
        publicUrls.addAll(getPublicUrls4Project());
        publicUrls.addAll(getPublicUrls4ExpenseType());
        publicUrls.addAll(getPublicUrls4ExpenseCurrency());
        publicUrls.addAll(getPublicUrls4Assignment());
        publicUrls.addAll(getPublicUrls4Team());
        publicUrls.addAll(getPublicUrls4ERLTemplate());
        publicUrls.addAll(getPublicUrls4ERTemplate());
        publicUrls.addAll(getPublicUrls4ExchangeHistory());
        publicUrls.addAll(getPublicUrls4SystemParam());
        return new OrRequestMatcher(publicUrls);
    }

    private List<RequestMatcher> getPublicUrls4UserFunctions() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/UserFunctions/**"));
        return urls;
    }

    private List<RequestMatcher> getPublicUrls4GlobalServices() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4AppUser() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4Employee() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ExpenseLine() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ExpenseReport() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4PaymentType() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4Project() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ExpenseType() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ExpenseCurrency() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4Assignment() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4Team() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ERLTemplate() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ERTemplate() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4ExchangeHistory() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getPublicUrls4SystemParam() {
        return new ArrayList<>();
    }

    private RequestMatcher getProtectedUrls() {
        List<RequestMatcher> protectedUrls = new ArrayList<>();
        protectedUrls.add(new AntPathRequestMatcher("/api/Account/UserInfo"));
        protectedUrls.add(new AntPathRequestMatcher("/api/Account/Logout"));
        protectedUrls.addAll(getProtectedUrls4UserFunctions());
        protectedUrls.addAll(getProtectedUrls4GlobalServices());
        protectedUrls.addAll(getProtectedUrls4AppUser());
        protectedUrls.addAll(getProtectedUrls4Employee());
        protectedUrls.addAll(getProtectedUrls4ExpenseLine());
        protectedUrls.addAll(getProtectedUrls4ExpenseReport());
        protectedUrls.addAll(getProtectedUrls4PaymentType());
        protectedUrls.addAll(getProtectedUrls4Project());
        protectedUrls.addAll(getProtectedUrls4ExpenseType());
        protectedUrls.addAll(getProtectedUrls4ExpenseCurrency());
        protectedUrls.addAll(getProtectedUrls4Assignment());
        protectedUrls.addAll(getProtectedUrls4Team());
        protectedUrls.addAll(getProtectedUrls4ERLTemplate());
        protectedUrls.addAll(getProtectedUrls4ERTemplate());
        protectedUrls.addAll(getProtectedUrls4ExchangeHistory());
        protectedUrls.addAll(getProtectedUrls4SystemParam());
        return new OrRequestMatcher(protectedUrls);
    }

    private List<RequestMatcher> getProtectedUrls4UserFunctions() {
        return new ArrayList<>();
    }

    private List<RequestMatcher> getProtectedUrls4GlobalServices() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/GlobalServices/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4AppUser() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/AppUserApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4Employee() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/EmployeeApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ExpenseLine() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ExpenseLineApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ExpenseReport() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ExpenseReportApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4PaymentType() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/PaymentTypeApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4Project() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ProjectApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ExpenseType() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ExpenseTypeApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ExpenseCurrency() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ExpenseCurrencyApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4Assignment() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/AssignmentApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4Team() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/TeamApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ERLTemplate() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ERLTemplateApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ERTemplate() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ERTemplateApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4ExchangeHistory() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/ExchangeHistoryApi/**"));
        return urls;
    }

    private List<RequestMatcher> getProtectedUrls4SystemParam() {
        List<RequestMatcher> urls = new ArrayList<>();
        urls.add(new AntPathRequestMatcher("/api/SystemParamApi/**"));
        return urls;
    }
}
