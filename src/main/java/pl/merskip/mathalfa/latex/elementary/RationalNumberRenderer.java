package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.elementary.RationalNumber;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

import java.math.BigInteger;

public class RationalNumberRenderer implements SymbolRenderer<RationalNumber> {
    
    @Override
    public String renderSymbol(RendererRegister register, RationalNumber symbol) {
        BigInteger numerator = symbol.getNumerator();
        BigInteger denominator = symbol.getDenominator();
        
        if (symbol.isInteger()) {
            return numerator.toString();
        }
        else if (numerator.signum() == -1
                && denominator.signum() >= 0) {
            return String.format("-\\cfrac{%s}{%s}", numerator.abs(), denominator);
        }
        else {
            return String.format("\\cfrac{%s}{%s}", numerator, denominator);
        }
    }
}
