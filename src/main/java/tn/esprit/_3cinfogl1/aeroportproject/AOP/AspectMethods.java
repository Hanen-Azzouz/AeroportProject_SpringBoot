package tn.esprit._3cinfogl1.aeroportproject.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectMethods {


    @Before("execution(* tn.esprit._3cinfogl1.aeroportproject.RestControllers.*.ajouter*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getDeclaringTypeName();
        String nomMethod=joinPoint.getSignature().getName();
        log.info(name+"In method " + nomMethod);
    }
    //.getDeclaringTypeName()=>pour avoir le nom du package
    //.getName()=>pour avoir le nom de méthode



    @After("execution(* tn.esprit._3cinfogl1.aeroportproject.RestControllers.*.ajouter*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getDeclaringTypeName();
        String nomMethod=joinPoint.getSignature().getName();
        log.info(name+"Out method " + nomMethod);
    }



}
