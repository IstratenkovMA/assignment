package com.search;

import java.util.List;

public interface Searcher {

  List<String> search(String searchToken, List<String> files);

  boolean isFileApplicable(String searchToken, String file);
}
