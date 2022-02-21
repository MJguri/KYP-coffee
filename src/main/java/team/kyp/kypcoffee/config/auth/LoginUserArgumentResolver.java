package team.kyp.kypcoffee.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import team.kyp.kypcoffee.config.auth.SessionUser;
import team.kyp.kypcoffee.config.auth.LoginUser;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;
    /* supportsParameter() * isLoginUserAnnotation: 파라미터에 @LoginUser 붙어 있는지
    * * isUserClass : 파라미터 클래스 타입이 SessionUser.class인지 */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        return isLoginUserAnnotation && isUserClass; }
    /* resolveArgument() * 세션에서 객체를 가져오기 */

    @Override
    public Object resolveArgument     (MethodParameter parameter, ModelAndViewContainer mavContatiner,
                                       NativeWebRequest ebRequest, WebDataBinderFactory binderFactory)
            throws Exception {
        return httpSession.getAttribute("user"); } }
