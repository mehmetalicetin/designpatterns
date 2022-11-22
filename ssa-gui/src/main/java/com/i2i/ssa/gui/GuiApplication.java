package com.i2i.ssa.gui;

import com.sun.faces.config.ConfigureListener;
import javax.faces.webapp.FacesServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuiApplication {

  public static void main(String[] args) {
    SpringApplication.run(GuiApplication.class, args);
  }

  @Bean
  public ServletRegistrationBean<?> facesServletRegistration() {
    ServletRegistrationBean<?> registration = new ServletRegistrationBean<>(new FacesServlet(),
        "*.xhtml");
    registration.setLoadOnStartup(1);
    return registration;
  }

  @Bean
  public ServletContextInitializer servletContextInitializer() {
    return servletContext -> {
      servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration",
          Boolean.TRUE.toString());
      servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
      servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
      servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
      servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
      servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");
    };
  }

  @Bean
  public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
    return new ServletListenerRegistrationBean<>(new ConfigureListener());
  }

}
