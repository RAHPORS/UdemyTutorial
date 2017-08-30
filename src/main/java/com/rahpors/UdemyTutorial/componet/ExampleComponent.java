package com.rahpors.UdemyTutorial.componet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ramon on 30/08/17.
 */
@Component("exampleComponent")
public class ExampleComponent {
    private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);

    public void sayHello(){
        LOGGER.info("HELLO FROM EXAMPLECOMPONET");
    }
}
