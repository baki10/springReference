package com.bakigoal;

import com.bakigoal.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ilmir on 05.07.16.
 */
@Component
public class MyMarshallerUnmarshaller {

  @Autowired
  private Marshaller marshaller;

  @Autowired
  private Unmarshaller unmarshaller;

  public void saveSettings(Settings settings, String fileName) throws IOException {
    try (FileOutputStream os = new FileOutputStream(fileName)) {
      this.marshaller.marshal(settings, new StreamResult(os));
    }
  }

  public Settings loadSettings(String fileName) throws IOException {
    Settings settings;
    try (FileInputStream is = new FileInputStream(fileName)) {
      settings = (Settings) this.unmarshaller.unmarshal(new StreamSource(is));
    }
    return settings;
  }

}
