//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.util.ArrayList;
public class TrieMap implements TrieMapInterface{
  TrieMapNode root;
  
  public TrieMap(){
    root = new TrieMapNode();
  }
  
  //Indirectly recursive method to meet definition of interface
  public void put(String key, String value){
    key = key + " ";
    if(root.getChildren().get(key.charAt(0)) == null) {
      root.getChildren().put(key.charAt(0), new TrieMapNode());
    }
    String curKey = key.substring(1);
    put(root.getChildren().get(key.charAt(0)),curKey,value);
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public void put(TrieMapNode current, String curKey, String value){
    if(curKey.equals(" ")) {
      current.setValue(value);
    }
    else {
      if(current.getChildren().get(curKey.charAt(0)) == null) {
        current.getChildren().put(curKey.charAt(0), new TrieMapNode());
      }
      String newKey = curKey.substring(1);
      put(current.getChildren().get(curKey.charAt(0)),newKey,value);
    }
  }
  
  //Indirectly recursive method to meet definition of interface
  public String get(String key){
    String value = null;
    key = key + " ";
    if(!(root.getChildren().get(key.charAt(0)) == null)) {
      String curKey = key.substring(1);
      value = get(root.getChildren().get(key.charAt(0)),curKey);
    }
    return value;
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public String get(TrieMapNode current, String curKey){
    String value = null;
    if(curKey.equals(" ")) {
      value = current.getValue();
    }
    else {
      if(!(current.getChildren().get(curKey.charAt(0)) == null)) {
        String newKey = curKey.substring(1);
        value = get(current.getChildren().get(curKey.charAt(0)),newKey);
      }
    }
    return value;
  }
  
  //Indirectly recursive method to meet definition of interface
  public boolean containsKey(String key){
    boolean containsKey = false;
    key = key + " ";
    if(!(root.getChildren().get(key.charAt(0)) == null)) {
      String curKey = key.substring(1);
      containsKey = containsKey(root.getChildren().get(key.charAt(0)),curKey);
    }
    return containsKey;
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public boolean containsKey(TrieMapNode current, String curKey){
    boolean containsKey = false;
    if(curKey.equals(" ")) {
      if (current.getValue() != null) {
        containsKey = true;
      }
    }
    else {
      if(!(current.getChildren().get(curKey.charAt(0)) == null)) {
        String newKey = curKey.substring(1);
        containsKey = containsKey(current.getChildren().get(curKey.charAt(0)),newKey);
      }
    }
    return containsKey;
  }
  
  //Indirectly recursive method to meet definition of interface
  public ArrayList<String> getKeysForPrefix(String prefix){
    TrieMapNode prefixNode = null;
    ArrayList<String> keys = new ArrayList<>();
    prefix = prefix + " ";
    if(!(root.getChildren().get(prefix.charAt(0)) == null)) {
      String curKey = prefix.substring(1);
      prefixNode = findNode(root.getChildren().get(prefix.charAt(0)),curKey);
      if(prefixNode != null) {
        if(prefixNode.getValue()!=null) {
          keys.add(prefixNode.getValue());
        }
        ArrayList<TrieMapNode> list = new ArrayList<TrieMapNode>(prefixNode.getChildren().values());
        for(int i = 0; i<prefixNode.getChildren().size(); i++) {
          keys = getSubtreeKeys(list.get(i),keys);
        }
      }
    }
    return keys;
  }
  
  //Recursive helper function to find node that matches a prefix
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public TrieMapNode findNode(TrieMapNode current, String curKey){
    TrieMapNode prefixNode = null;
    if(curKey.equals(" ")) {
      prefixNode = current;
    }
    else {
      if(!(current.getChildren().get(curKey.charAt(0)) == null)) {
        String newKey = curKey.substring(1);
        prefixNode = findNode(current.getChildren().get(curKey.charAt(0)),newKey);
      }
    }
    return prefixNode;
  }
  
  //Recursive helper function to get all keys in a node's subtree
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public ArrayList<String> getSubtreeKeys(TrieMapNode current, ArrayList<String> keys){
    ArrayList<TrieMapNode> list = new ArrayList<TrieMapNode>(current.getChildren().values());
    if(current.getValue() != null) {
      keys.add(current.getValue());
    }
    for(int i = 0; i<current.getChildren().size(); i++) {
      getSubtreeKeys(list.get(i),keys);
    }
    return keys;
  }
  
  //Indirectly recursive method to meet definition of interface
  public void print(){
    ArrayList<TrieMapNode> list = new ArrayList<TrieMapNode>(root.getChildren().values());
    for(int i = 0; i<root.getChildren().size(); i++) {
      print(list.get(i));
    }
  }
  
  //Recursive method to print values in tree
  public void print(TrieMapNode current){
    ArrayList<TrieMapNode> list = new ArrayList<TrieMapNode>(current.getChildren().values());
    if(current.getValue() != null) {
      System.out.println(current.getValue());
    }
    for(int i = 0; i<current.getChildren().size(); i++) {
      print(list.get(i));
    }
  }
  
  public static void main(String[] args){
    //You can add some code in here to test out your TrieMap initially
    //The TrieMapTester includes a more detailed test
    TrieMap map = new TrieMap();
    map.put("hello","hello");
    map.put("happy","happy");
    map.put("ouch","ouch");
    map.put("roar","roar");
    map.put("xd","xd");

    map.print();
  }
}