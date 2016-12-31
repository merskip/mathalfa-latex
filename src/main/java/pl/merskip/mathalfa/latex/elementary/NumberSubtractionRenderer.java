package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.elementary.NumberSubtraction;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

public class NumberSubtractionRenderer extends OperatorRenderer
        implements SymbolRenderer<NumberSubtraction> {
    
    protected NumberSubtractionRenderer() {
        super("-");
    }
    
    @Override
    public String renderSymbol(RendererRegister register, NumberSubtraction symbol) {
        return renderOperator(register, symbol, symbol.getFirstArgument(), symbol.getSecondArgument());
    }
}
