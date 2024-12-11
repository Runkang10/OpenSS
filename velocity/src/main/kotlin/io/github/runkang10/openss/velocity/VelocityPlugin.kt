package io.github.runkang10.openss.velocity;

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import org.slf4j.Logger

const val version = "1.0.0"

@Plugin(
    id = "openss",
    name = "OpenSS",
    version = version
    ,authors = ["Runkang10"]
)
class VelocityPlugin @Inject constructor(val logger: Logger) {

    @Subscribe
    fun onProxyInitialization(event: ProxyInitializeEvent) {
    }
}
