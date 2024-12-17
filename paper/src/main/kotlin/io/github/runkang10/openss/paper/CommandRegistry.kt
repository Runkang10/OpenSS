package io.github.runkang10.openss.paper

import io.github.runkang10.openss.paper.utils.CommandClassUtils
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager
import io.papermc.paper.plugin.lifecycle.event.registrar.ReloadableRegistrarEvent
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin


class CommandRegistry(private var plugin: JavaPlugin) {
    private lateinit var manager: LifecycleEventManager<Plugin>
    private lateinit var commands: Commands
    private var initialized = false

    fun setup() {
        manager = plugin.lifecycleManager
        initialized = true
    }

    fun add(commandString: String, description: String, commandClass: CommandClassUtils): Boolean {
        when (initialized) {
            initialized -> {
                manager.registerEventHandler<ReloadableRegistrarEvent<Commands>>(
                    LifecycleEvents.COMMANDS
                ) { event: ReloadableRegistrarEvent<Commands> ->
                    commands = event.registrar()
                    commands.register(commandString, description, commandClass)
                }
                return true
            }

            else -> {
                return false
            }
        }
    }
}