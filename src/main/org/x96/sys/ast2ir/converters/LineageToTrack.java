package org.x96.sys.ast2ir.converters;

import org.x96.sys.ast2ir.contracts.ToTrack;
import org.x96.sys.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.Track;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.terminals.Nucleus;

public class LineageToTrack implements ToTrack {

    @Override
    public Track convert(Lineage lineage) {
        Nucleus[] nuclei = new Nucleus[lineage.cores().length];
        for (int i = 0; i < lineage.cores().length; i++) {
            nuclei[i] = new CoreToNucleus().convert(lineage.cores()[i]);
        }
        return new Track(nuclei);
    }
}
