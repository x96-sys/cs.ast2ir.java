package org.x96.sys.ast2ir.converters;

import org.x96.sys.ast2ir.contracts.ToOccurence;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.OneOrMore;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.Quantifier;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrMore;
import org.x96.sys.cs.ast.book.passage.pattern.core.unit.quantifier.ZeroOrOne;
import org.x96.sys.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;

import java.util.Optional;

public class QuantifierToOccurrence implements ToOccurence {
    @Override
    public Optional<Occurrence> convert(Optional<Quantifier> quantifier) {
        if (quantifier.isPresent()) {
            switch (quantifier.get()) {
                case OneOrMore _ -> {
                    return Optional.of(Occurrence.OneOrMore);
                }
                case ZeroOrMore _ -> {
                    return Optional.of(Occurrence.ZeroOrMore);
                }
                case ZeroOrOne _ -> {
                    return Optional.of(Occurrence.ZeroOrOne);
                }
            }
        }
        return Optional.empty();
    }
}
