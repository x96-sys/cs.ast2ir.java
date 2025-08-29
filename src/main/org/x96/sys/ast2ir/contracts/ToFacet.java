package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.Pattern;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.Facet;

public interface ToFacet {
    public Facet convert(Pattern pattern);
}
