package pl.merskip.mathalfa.latex.elementary;

import pl.merskip.mathalfa.base.core.Symbol;
import pl.merskip.mathalfa.base.elementary.*;
import pl.merskip.mathalfa.latex.core.RendererRegister;
import pl.merskip.mathalfa.latex.core.SymbolRenderer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ElementaryRenderer implements RendererRegister {
    
    private Map<Class<? extends Symbol>, SymbolRenderer<?>> rendererMap;
    
    public ElementaryRenderer() {
        rendererMap = new LinkedHashMap<>();
        registerRenderer();
    }
    
    private void registerRenderer() {
        register(RationalNumber.class, new RationalNumberRenderer());
        register(NumberAddition.class, new NumberAdditionRenderer());
        register(NumberSubtraction.class, new NumberSubtractionRenderer());
        register(NumberMultiplication.class, new NumberMultiplicationRenderer());
        register(NumberDivision.class, new NumberDivisionRenderer());
        register(NumberExponentiation.class, new NumberExponentiationRenderer());
    }
    
    private <T extends Symbol> void register(Class<T> symbolClass, SymbolRenderer<T> renderer) {
        this.rendererMap.put(symbolClass, renderer);
    }
    
    @Override
    public String renderEquation(List<Symbol> members) {
        List<String> membersRendered = new ArrayList<>(members.size());
        members.forEach(symbol -> membersRendered.add(renderSymbol(symbol)));
        return String.join(" = ", membersRendered);
    }
    
    @Override
    public String renderSymbol(Symbol symbol) {
        return getRendererForSymbol(symbol).renderSymbol(this, symbol);
    }
    
    private <T extends Symbol> SymbolRenderer<T> getRendererForSymbol(T symbol) {
        if (!rendererMap.containsKey(symbol.getClass())) {
            throw new UnsupportedOperationException("Not found renderer for " + symbol.getClass());
        }
    
        //noinspection unchecked
        return (SymbolRenderer<T>) rendererMap.get(symbol.getClass());
    }
}
