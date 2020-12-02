package com.parser.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Node implements Tree {

  @Getter
  private ArrayList<String> files = new ArrayList<>();

  @Setter
  @Getter
  private String name;

  @Setter
  @Getter
  private List<Node> children;

  @JacksonXmlProperty(isAttribute = true, localName = "is-file")
  private Boolean isFile;

  @Override
  public List<String> getAllFilesWithPath() {
    files = new ArrayList<>();
    depthFirstSearch(this, new LinkedList<String>());
    return files;
  }

  private void depthFirstSearch(Node node, LinkedList<String> path) {
    path.addLast(node.name);
    if (node.isFile) {
      files.add(String.join("/", path));
    } else if (node.getChildren() != null) {
      for (Node child : node.getChildren()) {
        depthFirstSearch(child, path);
      }
    }
    path.removeLast();
  }
}