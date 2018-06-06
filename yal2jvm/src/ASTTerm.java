/* Generated By:JJTree: Do not edit this line. ASTTerm.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTTerm extends SimpleNode {
  private String name;
	private String nameInteger;

  public ASTTerm(int id) {
    super(id);
  }

  public ASTTerm(parserGrammar p, int id) {
    super(p, id);
  }

  public String getName() {
	  return name;
  }

  public String getNameInteger() {
	  return nameInteger;
  }

  public void setName(String name) {
	  this.name = name;
  }

  public void setNameInteger(String name) {
	  this.nameInteger = name;
  }

  public String toString() {
	  String test = super.toString();

	if(name != null)
	  test+= " " + name;

	if(nameInteger != null)
	  test+= " " + nameInteger;

	  return test;
  }

  @Override
  public int analyse(SymbolsTable currentTable){
		return analyseContent(currentTable);
  }

  @Override
  public int analyseContent(SymbolsTable currentTable){
		System.out.println("Analyse the children of Term");
    int b=0;
    for(int i=0; i < jjtGetNumChildren();i++){
      if(jjtGetChild(i).analyse(currentTable)==-1)
        b=-1;
    }

    return b;
  }

	public int analyseRhs(SymbolsTable currentTable){
		System.out.println("Analyse the right part of Term");

    int b=0;
		if(nameInteger == null){
			for(int i=0; i < jjtGetNumChildren();i++){
	      b= jjtGetChild(i).analyseRhs(currentTable);
	    }
		}
		else{
			return 1;
		}
		return b;

	}

  public String convertToByteCodes(MapVariables mapVariables){
    String line = "";
    if(name == null && nameInteger == null) {
      for(int i = 0; i < jjtGetNumChildren(); i++){
        line += jjtGetChild(i).convertToByteCodes(mapVariables);
      }
    }
    else if (nameInteger != null) {

      if(name != null && name.equals("-")){
          line +="bipush " + name + nameInteger + "\n";
      }
      else{
        if(Integer.parseInt(nameInteger)<=5)
          line +="iconst_" + nameInteger + "\n";
        else
          line +="bipush " + nameInteger + "\n";
      }
    }
    else if (name != null) {
      line += "iconst_" + name + "\n";
    }

    return line;
  }



}
/* JavaCC - OriginalChecksum=6e0a45afda7272769448323ecc8eb0e4 (do not edit this line) */
