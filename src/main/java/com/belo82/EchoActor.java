package com.belo82;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @author Peter Belko
 */
public class EchoActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);


    @Override
    public void onReceive(Object message) throws Exception {

        if (message instanceof String) {
            log.debug("this is received message: {}", message);
            getSender().tell("I got something: " + message, getSelf());

        } else {
            unhandled(message);
        }
    }
}
