package com.parser.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.parser.model.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lombok.SneakyThrows;

public class JacksonXmlParser {

  private static final XmlMapper xmlMapper = new XmlMapper();

  @SneakyThrows
  public Node parse(File file) {
    String xml = inputStreamToString(new FileInputStream(file));
    return xmlMapper.readValue(xml, Node.class);
  }

  public String inputStreamToString(InputStream is) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    while ((line = br.readLine()) != null) {
      sb.append(line);
    }
    br.close();
    return sb.toString();
  }
}
