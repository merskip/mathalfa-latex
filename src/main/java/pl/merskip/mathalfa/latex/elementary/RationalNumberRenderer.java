package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

public class RationalNumberRenderer implements SymbolRenderer<RationalNumber> {
    
    @Override
    public String renderSymbol(RendererRegister register, RationalNumber symbol) {
        String numerator = String.valueOf(symbol.getNumerator());
        String denominator = String.valueOf(symbol.getDenominator());
        
        if (symbol.getDenominator() == 1) {
            return numerator;
        }
        else {
            return String.format("\\cfrac{%s}{%s}", numerator, denominator);
        }
    }
}
