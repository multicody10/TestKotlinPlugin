package commands

import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.Player

class CraftCMD(player: Player) {
    private val prefix = ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "CRAFT " + ChatColor.DARK_GRAY + ChatColor.BOLD + ">> " + ChatColor.RESET
    init {
        if (player.hasPermission("stellar.craft") || player.gameMode == GameMode.CREATIVE || player.isOp) {
            player.openWorkbench(null, true)
        } else if (player.inventory.contains(Material.CRAFTING_TABLE)) {
            player.openWorkbench(null, true)
        } else {
            player.sendMessage(prefix + ChatColor.GOLD + "You don't have a crafting table!")
        }
    }
}