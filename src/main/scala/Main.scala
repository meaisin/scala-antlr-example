import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.*

import java.io.FileInputStream
import java.io.InputStream

@main def main(args: String*): Unit = {
  val inputStream: InputStream = args.length match
    case 0 => System.in
    case 1 =>
      new FileInputStream(args.head)
    case _ => throw new Exception
  val antlrInputStream: ANTLRInputStream = new ANTLRInputStream(inputStream)
  val lexer: ExprLexer = new ExprLexer(antlrInputStream)
  val tokenStream: CommonTokenStream = new CommonTokenStream(lexer)
  val parser: ExprParser = new ExprParser(tokenStream)
  val tree = parser.prog
  System.out.println(s"${tree.toStringTree(parser)}")
}
