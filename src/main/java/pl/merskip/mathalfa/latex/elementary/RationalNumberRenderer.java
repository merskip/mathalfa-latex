package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

import static java.lang.Math.abs;

public class RationalNumberRenderer implements SymbolRenderer<RationalNumber> {
    
    @Override
    public String renderSymbol(RendererRegister register, RationalNumber symbol) {
        String sign = symbol.getNumerator() < 0 ? "-" : "";
        String numerator = String.valueOf(abs(symbol.getNumerator()));
        String denominator = String.valueOf(symbol.getDenominator());
        
        if (symbol.getDenominator() == 1) {
            return sign + numerator;
        }
        else {
            return String.format("%s\\cfrac{%s}{%s}", sign, numerator, denominator);
        }
    }
}
