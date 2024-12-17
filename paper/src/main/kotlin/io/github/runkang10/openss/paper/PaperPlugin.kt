package io.github.runkang10.openss.paper

import io.github.runkang10.openss.paper.commands.SSCommand
import io.github.runkang10.openss.paper.utils.ConsoleUtils
import net.luckperms.api.LuckPerms
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.plugin.java.JavaPlugin


class PaperPlugin : JavaPlugin() {
    // Utils & Managers
    private lateinit var console: ConsoleUtils
    private lateinit var commandRegistry: CommandRegistry

    // Dependencies
    private lateinit var LuckPermsAPI: LuckPerms

    override fun onEnable() {
        // Plugin startup
        super.onEnable()
        console = ConsoleUtils(this.getConsoleSender())

        // LuckPerms setup
        val provider = this.server.servicesManager.getRegistration(
            LuckPerms::class.java
        )
        if (provider != null) {
            LuckPermsAPI = provider.provider
        }

        // Command registry
        commandRegistry = CommandRegistry(this)
        commandRegistry.setup()

        // Commands
        console.info("Loading commands ...")

        commandRegistry.add("sayhi", "Just say hi.", SSCommand())

        console.success("Successfully loaded commands.")

        // Events
        console.info("Loading events ...")



        console.success("Successfully loaded events.")

        console.success("Done.")
    }

    override fun onDisable() {
        // Plugin shutdown logic
        console.info("Bye! 👋")
    }

    fun getConsoleSender(): ConsoleCommandSender {
        return this.server.consoleSender
    }

    fun getLuckPerms(): LuckPerms {
        return LuckPermsAPI
    }
}
