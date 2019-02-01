package ca.concordia.alexa.asc.config;

import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

import ca.concordia.alexa.asc.speechlet.MySpeechlet;

@Configuration
public class AlexaConfig {
  
  private final MySpeechlet mySpeechlet;
  
  @Autowired
  public AlexaConfig(MySpeechlet mySpeechlet) {
    this.mySpeechlet = mySpeechlet;
  }
  
  @Bean
  public ServletRegistrationBean<SpeechletServlet> registerServlet() {
    SpeechletServlet speechletServlet = new SpeechletServlet();
    speechletServlet.setSpeechlet(mySpeechlet);

    ServletRegistrationBean<SpeechletServlet> servletRegistrationBean = new ServletRegistrationBean<SpeechletServlet>(speechletServlet, "/alexa");
    return servletRegistrationBean;
  }
  
}
