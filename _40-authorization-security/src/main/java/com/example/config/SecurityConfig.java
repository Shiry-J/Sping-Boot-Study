package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

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

    // 使用jdbc 技术访问数据库
    @Autowired
    private DataSource dataSource;


    /**
     * 持久化Token存储
     * @return
     */
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jr=new JdbcTokenRepositoryImpl();
        jr.setDataSource(dataSource);
        return jr;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //设置密码编码器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
        //使用 UserDetailsService 进行身份认证时，对明文密码进行加密
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义用户授权管理
        http.authorizeRequests()
                // 所有人都可以访问
                .antMatchers("/").permitAll()
                // 需要对static文件夹下静态资源（图片和样式）进行统一放行
                .antMatchers("/login/**").permitAll()
                .antMatchers("/detail/visitor/**").permitAll()
                // 访问如下请求需要 角色（权限）是 common 或者 vip
                .antMatchers("/detail/common/**").hasRole("common")
                .antMatchers("/detail/vip/**").hasRole("vip")
                // 任何请求访问都需要先进行身份认证
                .anyRequest().authenticated();

        //登录自定义
        http.authorizeRequests().and()
                .formLogin()
                .loginPage("/userLogin").permitAll()
                .loginProcessingUrl("/userLogin")
                .usernameParameter("name")
                .passwordParameter("pwd")
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");

        //退出自定义
        http
                // 开启退出功能
                .logout()
                // 访问 /logout 执行退出功能
                .logoutUrl("/logout")
                // 退出成功，访问首页  /
                .logoutSuccessUrl("/");

        //记住我功能
        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .tokenValiditySeconds(60*60*24*7)
                .tokenRepository(this.tokenRepository());

    }




}