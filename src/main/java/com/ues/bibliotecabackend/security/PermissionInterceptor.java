package com.ues.bibliotecabackend.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      HasPermission hasPermission = handlerMethod.getMethodAnnotation(HasPermission.class);

      if (hasPermission != null) {
        String permisoRequerido = hasPermission.value();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
          UserDetails userDetails = (UserDetails) principal;
          List<String> permisos = userDetails.getAuthorities().stream()
              .map(grantedAuthority -> grantedAuthority.getAuthority())
              .collect(Collectors.toList());

          if (permisos.contains(permisoRequerido)) {
            return true;
          }
        }

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return false;
      }
    }

    return true;
  }
}