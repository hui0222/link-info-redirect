package kr.co.lir.config.auth;

import kr.co.lir.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity  // spirng Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션 disable
                .and()
                    .authorizeRequests()    // authorizeRequests가 선언되어야 antMachers사용가능, URL별 권한 관리 설정 옵션
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    // 권한관리대상 지정옵션
                    // URL, HTTP 메소드별 관리 가능
                    // "/" 등 지정된 URL은 permitALl() 옵션을 통해 전체 열람 권한을 줌
                    // "/api/v1/**" 주소를 가진 API는 USER권한만 사용가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 설정한 값들 이외 나머지 URL
                    // authenicated()를 추가하여 나머지 URL들은 모두 인증된 사용자들에게만 허용
                    // 인증된 사용자 즉, 로그인한 사용자들을 말함
                    .anyRequest().authenticated()
                .and()
                    .logout()   // 로그아웃 설정
                        .logoutSuccessUrl("/")  // 로그아웃 성공 후 return URL
                .and()
                    .oauth2Login()  // OAuth2 로그인 기능 설정
                        .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                            // 소셜로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
                            // 리소스 서버(소셜서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시 가능
                            .userService(customOAuth2UserService);
    }
}
