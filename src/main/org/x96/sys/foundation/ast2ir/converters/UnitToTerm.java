package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToTerm;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Unit;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Term;

public class UnitToTerm implements ToTerm {
    @Override
    public Term convert(Unit unit) {
        return new Term(
                unit.bang().isPresent(),
                new GlyphToIdentity().convert(unit.glyph()),
                new QuantifierToOccurrence().convert(unit.quantifier()));
    }
}
