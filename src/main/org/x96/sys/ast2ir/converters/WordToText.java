package org.x96.sys.ast2ir.converters;

import org.x96.sys.ast2ir.contracts.ToText;
import org.x96.sys.cs.ast.book.passage.pattern.core.Word;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Text;

public class WordToText implements ToText {
    @Override
    public Text convert(Word w) {
        return new Text(w.raw());
    }
}
