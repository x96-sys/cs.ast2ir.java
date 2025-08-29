package org.x96.sys.ast2ir.contracts;

import org.x96.sys.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.Track;

public interface ToTrack {
    public Track convert(Lineage lineage);
}
