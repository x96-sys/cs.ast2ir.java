package org.x96.sys.foundation.ast2ir.converters;

import org.x96.sys.foundation.ast2ir.contracts.ToSwitch;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.core.Choices;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.occurrence.Occurrence;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Nucleus;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.characterization.facet.terminals.Switch;

import java.util.Optional;

public class ChoicesToSwitch implements ToSwitch {
    @Override
    public Switch convert(Choices choices) {
        Optional<Occurrence> occurrence =
                new QuantifierToOccurrence().convert(choices.quantifier());
        Nucleus[] nuclei = new Nucleus[choices.cores().length];
        for (int i = 0; i < choices.cores().length; i++) {
            nuclei[i] = new CoreToNucleus().convert(choices.cores()[i]);
        }
        return new Switch(nuclei, occurrence);
    }
}
