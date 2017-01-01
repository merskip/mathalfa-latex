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
            return formatNumber(numerator);
        }
        else if (numerator.signum() == -1
                && denominator.signum() >= 0) {
            return String.format("-\\tfrac{%s}{%s}",
                    formatNumber(numerator.abs()), formatNumber(denominator));
        }
        else {
            return String.format("\\tfrac{%s}{%s}",
                    formatNumber(numerator), formatNumber(denominator));
        }
    }
    
    private String formatNumber(BigInteger number) {
        return formatNumber(number, 3);
    }
    
    private String formatNumber(BigInteger number, int partSize) {
        String absNumber = number.abs().toString();
        
        StringBuilder numberBuilder = new StringBuilder();
        numberBuilder.append(number.signum() < 0 ? "-" : "");

        int firstPartSize = absNumber.length() % partSize;
        if (firstPartSize == 0) firstPartSize = partSize;
        numberBuilder.append(absNumber.substring(0, firstPartSize));
        
        for (int i = firstPartSize; i < absNumber.length(); i += partSize) {
            numberBuilder.append("~");
            numberBuilder.append(absNumber.substring(i, i+partSize));
        }

        return numberBuilder.toString();
    }
}
