package com.uin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author wanglufei
 * @description: 资源服务器的配置
 * 通常为用户，也可以是应用程序，既该资源的拥有者。
 * @date 2022/4/11/7:38 PM
 */
@Configuration
@EnableResourceServer
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {
    /**
     * @param http
     * @author wanglufei
     * @date 2022/4/11 8:00 PM
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // //所有的访问都需要认证访问
        // http.authorizeRequests().anyRequest().authenticated();
        // //唯独user 可以访问 放行我们的资源
        // http.requestMatchers().antMatchers("/user/**");
        http.authorizeRequests().anyRequest().permitAll();


    //     http   // 配置登录页并允许访问
    //             //.formLogin().permitAll()
    //             // 配置Basic登录
    //             //.and().httpBasic()
    //             // 配置登出页面
    //             .logout().logoutUrl("/logout").logoutSuccessUrl("/")
    //             // 配置允许访问的链接
    //             .and().authorizeRequests().antMatchers("/oauth/**", "/login/**", "/logout/**","/api/**").permitAll()
    //             // 其余所有请求全部需要鉴权认证
    //             .anyRequest().authenticated()
    //             // 关闭跨域保护;
    //             .and().csrf().disable();
    //     -----------------------------------
    //             OAuth2.0系列之密码模式实践教程（四）
    //     https://blog.51cto.com/u_15704340/5442346
    }
}
