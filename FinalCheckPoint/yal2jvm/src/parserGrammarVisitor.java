/* Generated By:JavaCC: Do not edit this line. parserGrammarVisitor.java Version 6.0_1 */
public interface parserGrammarVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTskipto node, Object data);
  public Object visit(ASTskipto_do_not_consume_last node, Object data);
  public Object visit(ASTprintMessagesError node, Object data);
  public Object visit(ASTModule node, Object data);
  public Object visit(ASTDeclaration node, Object data);
  public Object visit(ASTFunction node, Object data);
  public Object visit(ASTVarlist node, Object data);
  public Object visit(ASTArrayElement node, Object data);
  public Object visit(ASTScalarElement node, Object data);
  public Object visit(ASTStmtlst node, Object data);
  public Object visit(ASTStmt node, Object data);
  public Object visit(ASTAssign node, Object data);
  public Object visit(ASTLhs node, Object data);
  public Object visit(ASTRhs node, Object data);
  public Object visit(ASTArraySize node, Object data);
  public Object visit(ASTTerm node, Object data);
  public Object visit(ASTExprtest node, Object data);
  public Object visit(ASTWhile node, Object data);
  public Object visit(ASTIf node, Object data);
  public Object visit(ASTCallStmt node, Object data);
  public Object visit(ASTCall node, Object data);
  public Object visit(ASTArgumentList node, Object data);
  public Object visit(ASTArgument node, Object data);
  public Object visit(ASTArrayAccess node, Object data);
  public Object visit(ASTScalarAccess node, Object data);
  public Object visit(ASTIndex node, Object data);
  public Object visit(ASTErrorBlock node, Object data);
}
/* JavaCC - OriginalChecksum=7e7ffbc9176f69e3d4b8e5ae2d9c71ee (do not edit this line) */