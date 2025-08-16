package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Term;

public interface ToTerm {
    public Term convert(Unit unit);
}
