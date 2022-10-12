package com.qinshuihe1.common.infrastructure.security.config;

import com.google.common.base.Predicates;
import com.qinshuihe1.common.utils.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AuthurizationConfig extends WebSecurityConfigurerAdapter {
/*
    best
 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/admin/login","/v2/api-docs/**","/swagger-ui.html","/webjars/**","/swagger-ui.html/**","/swagger-resources/**").anonymous().anyRequest().authenticated();
    }
/*
声明加密方式
 */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }
/*
认证管理器
 */
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("webApi").apiInfo(webApiInfo()).select().paths(Predicates.not(PathSelectors.regex("/error*"))).build().globalOperationParameters(getParameterList());
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder().title("漆水河API中心").description("spring boot 从零开始").version("1.0").build();
    }

    private List<Parameter> getParameterList(){
        ParameterBuilder clientIdTickt = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        clientIdTickt.name(CommonConstant.TOKEN_STR).description("请求令牌").modelRef(new ModelRef("String")).parameterType("header").required(false).build();
        parameters.add(clientIdTickt.build());
        return parameters;
    }
}
