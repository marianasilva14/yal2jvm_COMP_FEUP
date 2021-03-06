/* Generated By:JJTree: Do not edit this line. ASTRhs.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTRhs extends SimpleNode {
  private String name;

    public ASTRhs(int id) {
      super(id);
    }

    public ASTRhs(parserGrammar p, int id) {
      super(p, id);
    }

    public String getName() {
  	  return name;
    }

    public void setName(String name) {
  	  this.name = name;
    }

    public String toString() {
  	  String test = super.toString();

  	  if(name != null)
  		  test += " " + name;

  	  return test;
    }

    @Override
    public int analyse(SymbolsTable currentTable){
      return analyseContent(currentTable);
    }

    @Override
    public int analyseContent(SymbolsTable currentTable){
  		System.out.println("Analyse the children of Rhs");
      int b=0;
      for(int i=0; i < jjtGetNumChildren();i++){
        if(jjtGetChild(i).analyse(currentTable)==-1)
          b=-1;
      }

      return b;
    }

  	public int analyseRhs(SymbolsTable currentTable){
  		System.out.println("Analyse the right part of Rhs");
  		return jjtGetChild(0).analyseRhs(currentTable);
  	}

    public String convertToByteCodes(MapVariables mapVariables){
      String line = "";
      for(int i = 0; i < jjtGetNumChildren(); i++){
        line += jjtGetChild(i).convertToByteCodes(mapVariables);
      }
      if(name != null) {
        if(name.equals("*"))
          line += "imul" + "\n";
        else if(name.equals("+"))
          line += "iadd" + "\n";
        else if(name.equals("<<"))
          line += "ishl" + "\n";
        else if(name.equals(">>"))
          line += "ishr" + "\n";
        else if(name.equals("|"))
          line += "ior" + "\n";
        else if(name.equals("/"))
          line += "idiv" + "\n";
        else if(name.equals("-"))
          line += "isub" + "\n";
        else if(name.equals("&"))
          line += "iand" + "\n";
      }

      return line;
    }

}
/* JavaCC - OriginalChecksum=5aeb10aa2652dec5bc5a437a06189648 (do not edit this line) */
