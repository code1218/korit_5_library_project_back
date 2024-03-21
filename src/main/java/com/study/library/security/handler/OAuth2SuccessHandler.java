package com.study.library.security.handler;

import com.study.library.entity.User;
import com.study.library.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Value("${server.deploy-address}")
    private String serverAddress;
    @Value("${server.port}")
    private String port;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String name = authentication.getName();
        User user = userMapper.findUserByOAuth2name(name);

        // OAuth2 로그인을 통해 회원가입이 되어있지 않은 상태
        // OAuth2 동기화
        if(user == null) {
            DefaultOAuth2User oAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
            String providerName = oAuth2User.getAttribute("provider").toString();

            response.sendRedirect("http://" + serverAddress + ":" + port + "/");
            return;
        }

        // OAuth2 로그인을 통해 회원가입을 진행한 기록이 있는 상태
        

    }
}