package org.x96.sys.foundation.ast2ir.contracts;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.Track;

public interface ToTrack {
    public Track convert(Lineage lineage);
}
