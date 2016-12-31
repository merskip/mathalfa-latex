package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.elementary.NumberAddition;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

public class NumberAdditionRenderer extends OperatorRenderer
        implements SymbolRenderer<NumberAddition> {
    
    public NumberAdditionRenderer() {
        super("+");
    }
    
    @Override
    public String renderSymbol(RendererRegister register, NumberAddition symbol) {
        return renderOperator(register, symbol, symbol.getFirstArgument(), symbol.getSecondArgument());
    }
}
