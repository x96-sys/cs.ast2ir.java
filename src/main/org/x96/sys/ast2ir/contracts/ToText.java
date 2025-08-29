package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Text;

public interface ToText {
    Text convert(Word w);
}
