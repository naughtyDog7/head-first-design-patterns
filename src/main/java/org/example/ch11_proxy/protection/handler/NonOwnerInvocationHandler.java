package org.example.ch11_proxy.protection.handler;

import lombok.RequiredArgsConstructor;
import org.example.ch11_proxy.protection.person.PersonBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class NonOwnerInvocationHandler implements InvocationHandler {
    private final PersonBean person;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        String methodName = method.getName();
        try {
            if (methodName.startsWith("get")) {
                return method.invoke(person, args);
            } else if (methodName.equals("setHotOrNotRating")) {
                return method.invoke(person, args);
            } else if (methodName.startsWith("set")) {
                throw new IllegalAccessException("You can't set another person's information");
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();

        }
        return null;
    }
}
