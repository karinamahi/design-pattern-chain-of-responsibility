package com.learning.pattern.chain.desconto;

import com.learning.pattern.chain.desconto.models.Orcamento;

public interface Desconto {

    double desconta(Orcamento orcamento);
    void setDesconto(Desconto proximo);
    
}
