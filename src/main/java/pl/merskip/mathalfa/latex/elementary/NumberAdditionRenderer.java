package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.NumberAddition;
import pl.merskip.mathalfa.base.elementary.NumberMultiplication;
import pl.merskip.mathalfa.base.elementary.NumberSubtraction;
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
    
    @Override
    protected boolean firstArgumentNeedsParentheses(Symbol firstArgument) {
        //noinspection SimplifiableIfStatement
        if (firstArgument instanceof NumberAddition
                || firstArgument instanceof NumberSubtraction
                || firstArgument instanceof NumberMultiplication) {
            return false;
        }
        else {
            return super.firstArgumentNeedsParentheses(firstArgument);
        }
    }
    
    @Override
    protected boolean secondArgumentNeedsParentheses(Symbol secondArgument) {
        //noinspection SimplifiableIfStatement
        if (secondArgument instanceof NumberMultiplication) {
            return false;
        }
        else {
            return super.firstArgumentNeedsParentheses(secondArgument);
        }
    }
}
