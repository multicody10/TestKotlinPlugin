package listeners

import Main
import org.bukkit.Bukkit
import org.bukkit.ChatColor

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class MainListener(plugin: Main) : Listener {
    init {
        Bukkit.getPluginManager().registerEvents(this, plugin)
    }

    @EventHandler
    fun onPlayerChat(event: AsyncPlayerChatEvent) {
        val message = event.message
        if (message.startsWith(">") && message[1] != ':') {
            event.message = ChatColor.GREEN.toString() + message
        }
    }
}