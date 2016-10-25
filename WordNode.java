public class WordNode implements Comparable
{
   private String param;
   private int where;
   public WordNode(String param,int where)
   {
      this.param = param;
      this.where = where;
   }
   public WordNode(WordNode other)
   {
      param = other.getParam();
      where = other.getWhere();
   }
   public int getWhere()
   {
      return where;
   }
   public String getParam()
   {
      return param; 
   }
   public int compareTo(Object other)
   {
      WordNode otherNode = (WordNode)other;
      return where-otherNode.getWhere();
   }
}
