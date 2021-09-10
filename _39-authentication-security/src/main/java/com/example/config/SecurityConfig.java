package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

//author: 悟空非空也（B站/知乎/公众号）
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    /**@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置密码编码器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        // 内存身份认证，模拟测试用户
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder =
                auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder);

        builder.withUser("wukong").password(bCryptPasswordEncoder.encode("wukong")).roles("common");
        builder.withUser("admin").password(bCryptPasswordEncoder.encode("admin")).roles("vip");
    }**/

    /**@Autowired
    private DataSource dataSource;

    //重写 configure方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置密码编码器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        //使用jdbc进行身份认证
        String userSQL ="select username,password,valid from t_customer " +
                "where username = ?";
        String authoritySQL="select c.username,a.authority from t_customer c,t_authority a,"+
                "t_customer_authority ca where ca.customer_id=c.id " +
                "and ca.authority_id=a.id and c.username =?";
        auth.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .dataSource(dataSource)
                .usersByUsernameQuery(userSQL)
                .authoritiesByUsernameQuery(authoritySQL);

    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String str = bCryptPasswordEncoder.encode("wukong");
        System.out.println("str = " + str);
        System.out.println(bCryptPasswordEncoder.matches("wukong", str));
    }**/

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //设置密码编码器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        //使用 UserDetailsService 进行身份认证时，对明文密码进行加密
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }

}