import commands.CraftCMD
import listeners.MainListener
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(), CommandExecutor {
    override fun onEnable() {
        MainListener(this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            val player: Player = sender
            return when (command?.name) {
                "craft" -> {
                    CraftCMD(player)
                    true
                }
                else -> {
                    player.sendMessage(ChatColor.RED.toString() + "Command not found!")
                    true
                }
            }
        } else {
            sender?.sendMessage("You must be a player!")
            return true
        }
    }
}