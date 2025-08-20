package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToFacet;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Casing;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Lineage;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.Pattern;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.Facet;

public class PatternToFacet implements ToFacet {
    @Override
    public Facet convert(Pattern pattern) {
        switch (pattern) {
            case Casing casing -> {
                return new CasingToMesh().convert(casing);
            }
            case Lineage lineage -> {
                return new LineageToTrack().convert(lineage);
            }
        }
    }
}
