package com.parser.xml;

import com.parser.model.Node;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class JacksonXmlParserTest {

  @Test
  public void testParseExampleFiles() throws IOException {
    File file = new File("src/test/resources/xml/files-example.xml");
    Node fileTree = new JacksonXmlParser().parse(file);
  }

  @Test
  public void testParseTestFiles() throws IOException {
    File file = new File("src/test/resources/xml/test-files.xml");
    Node fileTree = new JacksonXmlParser().parse(file);
    assert fileTree.getChildren() != null;
    assert !fileTree.getChildren().isEmpty();
  }
}