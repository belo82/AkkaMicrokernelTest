package com.belo82;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.kernel.Bootable;
import com.typesafe.config.ConfigFactory;

/**
 * @author Peter Belko
 */
public class TestSys implements Bootable {
    private final ActorSystem system = ActorSystem.create("TestSys", ConfigFactory.load().getConfig("TestSys"));

    @Override
    public void startup() {

        system.actorOf(new Props(EchoActor.class), "echoActor");
    }

    @Override
    public void shutdown() {
        system.shutdown();
    }
}
