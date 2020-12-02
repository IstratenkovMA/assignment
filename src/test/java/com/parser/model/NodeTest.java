package com.parser.model;

import com.parser.xml.JacksonXmlParser;
import java.io.File;
import junit.framework.TestCase;

public class NodeTest extends TestCase {

  public void testGetAllFilesWithPath() {
    File file = new File("src/test/resources/xml/test-files.xml");
    Node fileTree = new JacksonXmlParser().parse(file);
    assertFalse(fileTree.getAllFilesWithPath().isEmpty());
  }
}