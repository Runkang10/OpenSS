package io.github.runkang10.openss.paper.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.command.ConsoleCommandSender

class ConsoleUtils(private var consoleSender: ConsoleCommandSender) {

    fun send(content: Component) {
        consoleSender.sendMessage(content)
    }

    fun info(msg: String) {
        this.sendWithColors(msg, NamedTextColor.AQUA)
    }

    fun success(msg: String) {
        this.sendWithColors(msg, NamedTextColor.GREEN)
    }

    fun warning(msg: String) {
        this.sendWithColors(msg, NamedTextColor.YELLOW)
    }

    fun error(msg: String) {
        this.sendWithColors(msg, NamedTextColor.RED)
    }

    private fun sendWithColors(msg: String, defaultColor: NamedTextColor) {
        consoleSender.sendMessage(Component.text(msg).color(defaultColor))
    }
}