package com.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TreeSearcherTest {

  ArrayList<String> files;

  @Before
  public void setUp() throws Exception {
    files = new ArrayList<>();
    files.add("/file-776194140.xml");
    files.add("/dir-880176375/file-1073842118.java");
    files.add("/dir-880176375/dir-2145307015/file-1498940214.xhtml");
  }

  @After
  public void tearDown() throws Exception {
    files.clear();
  }

  @Test
  public void testEmptySearchTokenSearch() {
    TreeSearcher treeSearcher = new TreeSearcher();

    List<String> searchedFiles = treeSearcher.search("", files);
    assertTrue(files.containsAll(searchedFiles));
    assertTrue(searchedFiles.containsAll(files));
  }

  @Test
  public void testFileNameSearchTokenSearch() {
    TreeSearcher treeSearcher = new TreeSearcher();

    List<String> searchedFiles = treeSearcher.search("file-1073842118.java", files);
    assertEquals(1, searchedFiles.size());
    assertTrue(searchedFiles.contains("/dir-880176375/file-1073842118.java"));
  }

  @Test
  public void testRegexpSearchTokenSearch() {
    TreeSearcher treeSearcher = new TreeSearcher();

    List<String> searchedFiles = treeSearcher.search(".*?[a-z]{4}-\\d+\\.[a-z]+", files);
    assertTrue(files.containsAll(searchedFiles));
    assertTrue(searchedFiles.containsAll(files));
  }
}