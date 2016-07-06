package com.bakigoal;

import com.bakigoal.model.Settings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by ilmir on 06.07.16.
 */
public class Application {
  public static void main(String[] args) throws IOException {
    ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
    MyMarshallerUnmarshaller marshaller = context.getBean(MyMarshallerUnmarshaller.class);

    String fileName = "oxm/settings.xml";
    Settings settings = new Settings();
    marshaller.saveSettings(settings, fileName);

    Settings loadSettings = marshaller.loadSettings(fileName);
    System.out.println("Loaded: " + loadSettings);
  }
}
