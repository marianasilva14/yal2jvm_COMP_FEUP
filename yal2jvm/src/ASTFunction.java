/* Generated By:JJTree: Do not edit this line. ASTFunction.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

public
class ASTFunction extends SimpleNode {
  private String name;

public ASTFunction(int id) {
  super(id);
}

public ASTFunction(parserGrammar p, int id) {
  super(p, id);
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public String toString() {
  String test;

  test = super.toString() + " " + name;

  return test;
}

@Override
public int analyse(SymbolsTable currentTable){
  boolean isScalar = jjtGetChild(0).isScalar();
  if(currentTable.returnSymbol(name)!=null){
    System.out.println("Function already exists!");
    return -1;
  }
  if(isScalar)
    currentTable.putOnHashMap(new Symbol("Function",name,true));
  else
    currentTable.putOnHashMap(new Symbol("Function",name,false));

  return 0;
}

@Override
public int analyseContent(SymbolsTable currentTable){
  System.out.println("Analyse children of Function");
  int b=0;
  SymbolsTable symbolsTable = new SymbolsTable(currentTable);

  for(int i=0; i < jjtGetNumChildren();i++){
    if(jjtGetChild(i).analyseContent(symbolsTable)==-1)
      b=-1;
  }

  return b;
}

public String convertToByteCodes(MapVariables data){
  String line = "";
  MapVariables mapVariables = new MapVariables(data);
  String returnType = "V";
  String returnArg = "";
  ArrayList<String> typeOfArgs = new ArrayList<String>();
  if(name.equals("main")){
    line += ".method public static main([Ljava/lang/String;)V" + "\n";
  }
  else{
   
    for(int i = 0; i < jjtGetNumChildren(); i++){
        if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTVARLIST) {
          for(int j = 0; j < jjtGetChild(i).jjtGetNumChildren(); j++){
            if(jjtGetChild(i).jjtGetChild(j).getId() == parserGrammarTreeConstants.JJTARRAYELEMENT)
              typeOfArgs.add("[I");
            else if(jjtGetChild(i).jjtGetChild(j).getId() == parserGrammarTreeConstants.JJTSCALARELEMENT)
              typeOfArgs.add("I");
          }
        }
        else if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTARRAYELEMENT) {
          returnType = "[I";
          returnArg = jjtGetChild(i).getName();
        }
        else if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTSCALARELEMENT) {
          returnType = "I";
          returnArg = jjtGetChild(i).getName();
        }
    }

    String function = ".method public static " + name + "(";
    for(int k = 0; k < typeOfArgs.size(); k++){
      function += typeOfArgs.get(k);
    }
    function += ")" + returnType;

    line += function + "\n";

  }

  String aux="";

  for(int i = 0; i < jjtGetNumChildren(); i++){
    aux += jjtGetChild(i).convertToByteCodes(mapVariables);
  }

  String[] splitstr = aux.split("\n");
  for(int j=0; j < splitstr.length - 1;j++){
    if((splitstr[j].contains("iload") || splitstr[j].contains("iconst")) && splitstr[j+1].contains("istore")){
      String[] split2 = splitstr[j+1].split("_");
      for(int k=0; k < splitstr.length; k++){
        if(splitstr[k].contains("astore_"+split2[1])) {
          mapVariables.putOnHashMap("temp");
          String temp = "iconst_0\n";
          temp += "istore_" + mapVariables.returnByteCode("temp") + "\n";
          temp += "loop" + mapVariables.loopCounter + ":\n";
          temp += "iload_" + mapVariables.returnByteCode("temp") + "\n";
          temp += "aload_" + split2[1] + "\n"; 
          temp += "arraylength\n";
          temp += "if_icmpge loop" + mapVariables.loopCounter + "_end\n";
          temp += "aload_" + split2[1] + "\n";
          temp += "iload_" + mapVariables.returnByteCode("temp") + "\n";
          temp += splitstr[j] + "\n";
          temp += "iastore\n";
          temp += "iinc " + mapVariables.returnByteCode("temp") + " 1\n";
          temp += "goto loop" + mapVariables.loopCounter + "\n";
          temp += "loop" + mapVariables.loopCounter + "_end:\n";
          mapVariables.loopCounter++;
          splitstr[j+1] = "";
          splitstr[j] = temp;

        }
      }
    }
  }
  aux="";
  for(int j=0; j < splitstr.length;j++){
    aux+=splitstr[j]+"\n";
  }
  int max = typeOfArgs.size();
  int stack=0;
  int argNumber = 0;
  int lastIndex = 0;
  String findStr = "I";
  String[] maxAux = aux.split("\n");
  String newAux="";

  for(int i=0; i < maxAux.length; i++){
    if(maxAux[i].contains("istore")){
      String[] var = maxAux[i].split("_");
      if(var.length == 1){
        var = maxAux[i].split(" ");
      }
      if(mapVariables.returnByteCode(returnArg) == Integer.parseInt(var[1])){
        if(mapVariables.returnByteCode(returnArg)>=4)
          newAux = "iconst_0\nistore " + mapVariables.returnByteCode(returnArg) + "\n";
        else
          newAux = "iconst_0\nistore_" + mapVariables.returnByteCode(returnArg) + "\n";
        aux = newAux + aux;
        break;
      }
    }
  }

  for(int i=0; i < maxAux.length; i++){

    if(maxAux[i].contains("invokestatic")){
      String[] value = maxAux[i].split("\\(");
      String[] temp = value[1].split("\\)");

      argNumber = 0;
      lastIndex = 0;
      findStr = "I";

      while(lastIndex != -1){

          lastIndex = temp[0].indexOf(findStr,lastIndex);

          if(lastIndex != -1){
              argNumber ++;
              lastIndex += findStr.length();
          }

      }

      lastIndex = 0;
      findStr = "String";

      while(lastIndex != -1){

        lastIndex = temp[0].indexOf(findStr,lastIndex);

        if(lastIndex != -1){
            argNumber ++;
            lastIndex += findStr.length();
        }

      }

      stack-=argNumber;
    if(!maxAux[i].contains("V")){
      stack++;
    }
    }
    else if(maxAux[i].contains("iastore")){
      stack-=3;
    }
    else if(maxAux[i].contains("if_") || maxAux[i].contains("astore")){
      stack-=2;
    }
    else if(maxAux[i].contains("iinc") ||  maxAux[i].contains("arraylength") || maxAux[i].equals("") || maxAux[i].contains("loop") || maxAux[i].contains(".limit"))
      continue;
    else if(maxAux[i].contains("istore") || maxAux[i].contains("iadd") || maxAux[i].contains("imul") || maxAux[i].contains("isub") || maxAux[i].contains("idiv") || maxAux[i].contains("iand") || maxAux[i].contains("ior") || maxAux[i].contains("ishl") || maxAux[i].contains("ishr") || maxAux[i].contains("iaload") || maxAux[i].contains("ireturn") || maxAux[i].contains("areturn")){
      stack-=1;
    }
    else
      stack++;

    if(stack > max){
      max=stack;
    }

  }

  if(name.equals("main") && mapVariables.counter==0)
    line += ".limit locals 1" + "\n";
  else
    line +=".limit locals " + mapVariables.counter + "\n";
  line +=".limit stack " + max + "\n";

  line+=aux;

  if(returnType.equals("V"))
    line += "return" + "\n";
  else{ 
    String[] split = aux.split("\n");
    boolean isScalar = true;
    for(int i = 0; i < split.length; i++) {
      if(split[i].contains(Integer.toString(mapVariables.returnByteCode(returnArg))) && split[i].contains("astore")) {
        isScalar = false;
      } 
    }
    if(isScalar) {
      if(mapVariables.returnByteCode(returnArg)>=4)
        line += "iload " + mapVariables.returnByteCode(returnArg) + "\n";
      else
        line += "iload_" + mapVariables.returnByteCode(returnArg) + "\n";
      line += "ireturn" + "\n";
    }
    else {
      if(mapVariables.returnByteCode(returnArg)>=4)
      line += "aload " + mapVariables.returnByteCode(returnArg) + "\n";
    else
      line += "aload_" + mapVariables.returnByteCode(returnArg) + "\n";
    line += "areturn" + "\n";
    }
  }
    line += ".end method" + "\n";
    line += "\n";

    return line;

}

public ArrayList<String> getFunction() {

  String returnType = "V";
  String name = this.name;
  for(int i = 0; i < jjtGetNumChildren(); i++){
      if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTARRAYELEMENT) {
        returnType = "[I";
      }
      else if(jjtGetChild(i).getId() == parserGrammarTreeConstants.JJTSCALARELEMENT) {
        returnType = "I";
      }
  }
  ArrayList<String> returns = new ArrayList<String>();

  returns.add(name);
  returns.add(returnType);

  return returns;
}


}
/* JavaCC - OriginalChecksum=abac2313f4a585dbc8038a0f08c4989e (do not edit this line) */
