import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.Tree
import org.antlr.v4.runtime.tree.Trees

fun main(args: Array<String>) {
    val filename = args[0]
    val chars = CharStreams.fromFileName(filename)
    val lexer = WGSLLexer(chars)
    val tokens = CommonTokenStream(lexer)
    val parser = WGSLParser(tokens)
    val tree = parser.translation_unit()
    println(tree.format(parser))
}

private fun Tree.format(parser: Parser, indent: Int = 0): String = buildString {
    val tree = this@format
    val prefix = "  ".repeat(indent)
    append(prefix)
    append(Trees.getNodeText(tree, parser))
    if (tree.childCount != 0) {
        append(" (\n")
        for (i in 0 until tree.childCount) {
            append(tree.getChild(i).format(parser, indent + 1))
            append("\n")
        }
        append(prefix).append(")")
    }
}
