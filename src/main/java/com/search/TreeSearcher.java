package com.search;

import java.util.List;
import java.util.stream.Collectors;

public class TreeSearcher implements Searcher {

  @Override
  public List<String> search(String searchToken, List<String> files) {
    return files
        .stream()
        .filter(file -> isFileApplicable(searchToken, file))
        .collect(Collectors.toList());
  }

  @Override
  public boolean isFileApplicable(String searchToken, String file) {
    if (searchToken == null || searchToken.isEmpty()) {
      return true;
    }
    if (file.endsWith(searchToken)) {
      return true;
    }
    return file.matches(searchToken);
  }
}
