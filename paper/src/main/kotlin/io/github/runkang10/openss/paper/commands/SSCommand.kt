package io.github.runkang10.openss.paper.commands

import io.github.runkang10.openss.paper.utils.CommandClassUtils
import io.papermc.paper.command.brigadier.CommandSourceStack

class SSCommand : CommandClassUtils() {
    override fun execute(commandSourceStack: CommandSourceStack, args: Array<out String>) {
        commandSourceStack.sender.sendMessage("Hi!")
    }
}