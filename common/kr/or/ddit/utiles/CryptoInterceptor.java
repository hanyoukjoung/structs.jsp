package kr.or.ddit.utiles;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//사용자 정의 인터셉터
// 1.AbstractInterceptor 상속
//2.오버라이딩된 intercept()내 actionInvocation.invoke()
//3.오버라이딩된 intercept()내 actionInvocation.invoke() 취득 반환값이 반드시 return
public class CryptoInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		
		Map<String, String> publicKeyMap = CryptoGenerator.getGeneratePairKey(session);
		request.setAttribute("publicKeyMap", publicKeyMap);
		
		//클라이언트 /join/loginForm.do요청(HttpServletRequest 신규생성 (id=-1))
		//      패키지 특정 및 액션 특정(패키지 네임스페이스="/join"> 액션 ="loginForm")
		//		  액션 class 존재(가정)	= HttpServletRequest 신규생성 (id=-1)
		//        인터셉터 처리 = HttpServletRequest 신규생성 (id=-1)
		//       액션 클래스의 액션 매서드 콜백 /종료 HttpServletRequest(id=-1)
		//       리절트 맴핑 처리 (view)HttpServletRequest 복사본(id=-2)
		//반드시 선언(미선언시 액션 클래스 내 액션 클래스 호출x)
		//해당 액션 매서드의 반환값
		String returnValue=actionInvocation.invoke();//액션 클래스의 액션 매서드 콜백
		
		//해당 액션 매서드의 반환값 반드시 return처리
		// (액션매서드 반환값을 return하지 않으면 result가 무시)
		return returnValue;
	}

}
