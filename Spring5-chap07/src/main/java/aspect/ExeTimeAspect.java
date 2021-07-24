package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {
	
	@Pointcut("execution(public * chap07..*(..))")
	private void publicTarget() {
	}
	
	@Around("publicTarget()")//ProceedingJoinPoint : 프록시 대상 객체의 method 호출시 사용.
	public Object measure(ProceedingJoinPoint joinPoint)throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();//proceed를 사용해 method 호출.
			return result;
		}finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s,%s(%s) 실행 시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(),Arrays.toString(joinPoint.getArgs()),
					(finish-start));
		}
	}
}
