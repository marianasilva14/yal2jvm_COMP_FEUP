import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

/* Generated By:JJTree: Do not edit this line. ASTErrorBlock.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTErrorBlock extends SimpleNode {
  public ASTErrorBlock(int id) {
    super(id);
  }

  public ASTErrorBlock(parserGrammar p, int id) {
    super(p, id);
  }

  @Override
  public int analyseContent(SymbolsTable currentTable){
    SymbolsTable symbolsTable = new SymbolsTable(currentTable);
    int b=0;

    for(int i=0; i < jjtGetNumChildren();i++){
      if(jjtGetChild(i).analyse(symbolsTable)==-1)
        b=-1;
    }

    return b;
  }

}
/* JavaCC - OriginalChecksum=028e30976a38d0ecf00d0d9ff7b0dcd9 (do not edit this line) */
