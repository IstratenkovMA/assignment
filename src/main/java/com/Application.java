package com;

import com.parser.model.Node;
import com.parser.xml.JacksonXmlParser;
import com.search.TreeSearcher;
import java.io.File;
import java.util.List;

public class Application {

  public static void main(String[] args) {
    String filePath = null;
    String searchToken = "";
    for (int i = 0; i < args.length; i++) {
      if ("-f".equals(args[i])) {
        filePath = args[i + 1];
      } else if ("-s".equals(args[i])) {
        searchToken = args[i + 1];
      }
    }

    JacksonXmlParser jacksonXmlParser = new JacksonXmlParser();
    File file = new File(filePath);
    Node tree = jacksonXmlParser.parse(file);
    TreeSearcher searcher = new TreeSearcher();
    List<String> allFilesWithPath = tree.getAllFilesWithPath();
    List<String> result = searcher.search(searchToken, allFilesWithPath);

    //result.stream.peek(System.out::println) works with another console on windows
    for (String s : result) {
      System.out.println(s);
    }
  }
}
