package SamwaMoney.TimeTableArtist.configuration;

import SamwaMoney.TimeTableArtist.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    
    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 헤더에서 token 가져오기
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("authorization: {}", authorization);

        // token이 null이 아닌지, Bearer 로 시작하는지 확인
        if(authorization == null || !authorization.startsWith("Bearer ")) {
            log.error("올바르지 않은 authorization입니다!");
            filterChain.doFilter(request, response);
            return;
        }

        // token에서 Bearer 떼어내서 token만 남기기
        String token = authorization.split(" ")[1]; // authorization의 두 번째 단어

        // token이 expire되었는지 확인
        if(JwtUtil.isExpired(token, secretKey)) {
            log.error("토큰이 만료되었습니다!");
            filterChain.doFilter(request, response);
            return;
        }

        // token에서 userName 꺼내기
        String userName = JwtUtil.getUserName(token, secretKey);
        log.info("userName:{}", userName);

        // 권한 부여하기
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userName, null, List.of(new SimpleGrantedAuthority("USER")));
        // Detail 넣기
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
