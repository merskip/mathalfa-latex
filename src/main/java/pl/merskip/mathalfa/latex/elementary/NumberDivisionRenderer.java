package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.elementary.NumberDivision;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

public class NumberDivisionRenderer implements SymbolRenderer<NumberDivision> {
    
    @Override
    public String renderSymbol(RendererRegister register, NumberDivision symbol) {
        String numeratorLatex = register.renderSymbol(symbol.getFirstArgument());
        String denominatorLatex = register.renderSymbol(symbol.getSecondArgument());
        return String.format("\\cfrac{%s}{%s}", numeratorLatex, denominatorLatex);
    }
}
