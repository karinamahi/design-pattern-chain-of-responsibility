package com.khirata.chain.core;

import com.khirata.chain.core.handler.impl.ErrorExampleHandler;
import com.khirata.chain.core.handler.impl.PrintDataHandler;
import com.khirata.chain.core.handler.impl.SayGoodByeHandler;
import com.khirata.chain.core.handler.impl.SayHelloHandler;
import org.testng.annotations.Test;

import java.util.List;

public class ChainProcessorTest {

    @Test
    public void processTest() {

        List handlers = List.of(new PrintDataHandler(),
                                new SayHelloHandler(),
                                new ErrorExampleHandler(),
                                new SayGoodByeHandler());

        ChainProcessor processor = new ChainProcessor<>(handlers);
        processor.process(new Exchange("World"));
    }
}
