package com.team_28.StackOverFlow.jwt.controller;

import com.team_28.StackOverFlow.jwt.dto.SignupDto;
import com.team_28.StackOverFlow.jwt.entity.Member;
import com.team_28.StackOverFlow.jwt.mapper.MemberMapper;
import com.team_28.StackOverFlow.jwt.oauth.PrincipalDetailsService;
import com.team_28.StackOverFlow.jwt.repository.MemberRepository;
import com.team_28.StackOverFlow.jwt.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

import static com.team_28.StackOverFlow.jwt.filter.JwtConstants.*;

@RestController
@RequestMapping("/regi")
@RequiredArgsConstructor
public class RestApiController {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AccountService accountService;
    private final PrincipalDetailsService principalDetailsService;
    private final MemberMapper memberMapper;


    // 추가
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Valid SignupDto signupDto) {
        System.out.println("회원가입 시도");
        Member member = memberMapper.signupDtoToMember(signupDto);
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/signup")
    public ResponseEntity getSignup(){
        System.out.println("회원가입 페이지");
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/signin")
    public ResponseEntity getSignin(){
        System.out.println("로그인 페이지");
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/refresh")
//    public ResponseEntity<Map<String, String>> refresh(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("refresh 컨트롤러 시작");
//        String accessTokenHeader = request.getHeader(ACCESS_TOKEN_HEADER);
//        String refreshTokenHeader = request.getHeader(REFRESH_TOKEN_HEADER);
//        System.out.println(accessTokenHeader+" + "+refreshTokenHeader);
//
//        if (accessTokenHeader == null || !accessTokenHeader.startsWith(TOKEN_HEADER_PREFIX)) {
//            throw new RuntimeException("JWT Token이 존재하지 않습니다.");
//        }
//        String refreshToken = refreshTokenHeader.substring(TOKEN_HEADER_PREFIX.length());
//        Map<String, String> tokens = accountService.refresh(refreshToken);
//        response.setHeader(ACCESS_TOKEN_HEADER, tokens.get(ACCESS_TOKEN_HEADER));
//        if (tokens.get(REFRESH_TOKEN_HEADER) != null) {
//            response.setHeader(REFRESH_TOKEN_HEADER, tokens.get(REFRESH_TOKEN_HEADER));
//        }
//        return ResponseEntity.ok(tokens);
//    }

    @PostMapping("/signout")
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(ACCESS_TOKEN_HEADER);
        String accessToken = authorizationHeader.substring(TOKEN_HEADER_PREFIX.length());
        System.out.println(accessToken);
        return principalDetailsService.logout(accessToken);
    }
    @GetMapping("/signout")
    public ResponseEntity GetLogout(){
        System.out.println("로그아웃 페이지");
        return new ResponseEntity(HttpStatus.OK);
    }



}
