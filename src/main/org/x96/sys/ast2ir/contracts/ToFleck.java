package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.core.Axis;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Fleck;

public interface ToFleck {
    public Fleck convert(Axis axis);
}
