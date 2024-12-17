package io.github.runkang10.openss.paper.utils

import io.papermc.paper.command.brigadier.BasicCommand
import io.papermc.paper.command.brigadier.CommandSourceStack

abstract class CommandClassUtils : BasicCommand {
    override abstract fun execute(commandSourceStack: CommandSourceStack, args: Array<out String>)
}