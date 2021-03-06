package de.epsdev.plugins.MMO.events;

import de.epsdev.plugins.MMO.data.DataManager;
import de.epsdev.plugins.MMO.data.output.Out;
import de.epsdev.plugins.MMO.tools.HiddenItemData;
import org.bukkit.GameMode;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class e_ClickEvent implements Listener {
    @EventHandler
    void playerClick(InventoryClickEvent e) {

        Inventory inventory = e.getClickedInventory();
        if(inventory == null) return;

        Player player = (Player) e.getWhoClicked();

        if (inventory.getName().contains("[MMO]")) {

            ItemStack item = e.getCurrentItem();

            if (!(item == DataManager.GUI_FILLER)) {
                ItemMeta meta = item.getItemMeta();
                List<String> lore = meta.getLore();

                if (lore != null && lore.size() > 0 && HiddenItemData.hasHiddenString(lore.get(0))) {

                    String json = HiddenItemData.extractHiddenString(lore.get(0));

                    json = json.replace("{", "");
                    json = json.replace("}", "");
                    json = json.replace("ID:", "");
                    json = json.replace(" ", "");

                    DataManager.performClickFunction((Player) e.getWhoClicked(), Integer.parseInt(json), item, e.getClickedInventory());

                }


            }

            e.setCancelled(true);
        }else {
            if(e.getSlot() <= 8){
                if(player.getGameMode() != GameMode.CREATIVE){
                    e.setCancelled(true);
                }
            }
        }
    }
}

