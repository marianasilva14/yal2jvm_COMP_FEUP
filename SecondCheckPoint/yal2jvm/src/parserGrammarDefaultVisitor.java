/* Generated By:JavaCC: Do not edit this line. parserGrammarDefaultVisitor.java Version 6.0_1 */
public class parserGrammarDefaultVisitor implements parserGrammarVisitor{
  public Object defaultVisit(SimpleNode node, Object data){
    node.childrenAccept(this, data);
    return data;
  }
  public Object visit(SimpleNode node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTskipto node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTskipto_do_not_consume_last node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTprintMessagesError node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTModule node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTDeclaration node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTFunction node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTVarlist node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArrayElement node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTScalarElement node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTStmtlst node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTStmt node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAssign node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTLhs node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTRhs node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArraySize node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTTerm node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTExprtest node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTWhile node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTIf node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTCallStmt node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTCall node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArgumentList node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArgument node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTArrayAccess node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTScalarAccess node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTIndex node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTErrorBlock node, Object data){
    return defaultVisit(node, data);
  }
}
/* JavaCC - OriginalChecksum=c9cf39d2cb53433f510f3bcc7061aa56 (do not edit this line) */
