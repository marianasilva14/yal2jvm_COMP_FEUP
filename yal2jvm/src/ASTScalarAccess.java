

/* Generated By:JJTree: Do not edit this line. ASTScalarAccess.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTScalarAccess extends SimpleNode {
  private String name;
  private String size;
  private boolean isScalar=true;
  public ASTScalarAccess(int id) {
    super(id);
  }

  public ASTScalarAccess(parserGrammar p, int id) {
    super(p, id);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String toString() {
    String test;

    test = super.toString() + " " + name;

    return test;
  }

  public int analyseRhs(SymbolsTable currentTable){
    System.out.println("Analyse the right part of ScalarAccess");

    Symbol symbol = currentTable.returnSymbol(name);

    if(symbol == null)
      return -1;
    else{
      if(symbol.isScalar() && size != null) {
        System.out.println("Can't get size of a scalar variable!");
      }

      if(!symbol.isScalar() && size != null)
        return 1;

      if(symbol.isScalar())
        return 1;
      else
        return 0;

    }
  }

  public int analyseLhs(SymbolsTable currentTable, boolean isScalar){
    System.out.println("Analyse the left part of ScalarAccess");

    Symbol symbol = currentTable.returnSymbol(name);
    this.isScalar = isScalar;
    if(symbol == null){
      currentTable.putOnHashMap(new Symbol("ScalarAccess",name,isScalar));
    }
    else{
      if(isScalar != symbol.isScalar())
        System.out.println("Semantic Error! " + name + " Expected Value " + isScalar + " Value " + symbol.isScalar());
    }

    return 0;
  }

  public String convertToByteCodes(MapVariables mapVariables){
    String line = "";
    if(mapVariables.returnByteCode(name) == -1){
      mapVariables.putOnHashMap(name);
    }
    if(jjtGetParent().getId() == parserGrammarTreeConstants.JJTTERM || jjtGetParent().getId() == parserGrammarTreeConstants.JJTARRAYSIZE || jjtGetParent().jjtGetParent().getId() == parserGrammarTreeConstants.JJTEXPRTEST){
      if(size == null){
        if(mapVariables.returnByteCode(name) >= 4)
          line += "iload " + mapVariables.returnByteCode(name) + "\n";
        else
          line += "iload_" + mapVariables.returnByteCode(name) + "\n";
      }
      else{
        if(mapVariables.returnByteCode(name) >= 4)
          line += "aload " + mapVariables.returnByteCode(name) + "\n";
        else
          line += "aload_" + mapVariables.returnByteCode(name) + "\n";

        line += "arraylength" + "\n";
      }
    }
    else {
      if(isScalar){
        if(mapVariables.returnByteCode(name) >= 4)
          line += "istore " + mapVariables.returnByteCode(name) + "\n\n";
        else
          line += "istore_" + mapVariables.returnByteCode(name) + "\n\n";
      }
      else{
        if(mapVariables.returnByteCode(name) >= 4)
          line += "newarray int" + "\n" + "astore " + mapVariables.returnByteCode(name) + "\n\n";
        else
          line += "newarray int" + "\n" + "astore_" + mapVariables.returnByteCode(name) + "\n\n";
      }
    }
    return line;
  }

  public boolean isScalar(){
    return isScalar;
  }
}
/* JavaCC - OriginalChecksum=4c98cf3cdc1e090826fb33787eabb252 (do not edit this line) */