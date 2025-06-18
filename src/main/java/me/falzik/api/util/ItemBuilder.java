package me.falzik.api.util;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class ItemBuilder {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material, int amount) {
        itemStack = new ItemStack(material, amount);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder displayName(String value) {
        itemMeta.setDisplayName(ChatUtil.translateCodes(value));

        return this;
    }

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();

        itemStack.setLore(itemMeta.getLore());
        itemMeta.setDisplayName(itemMeta.getDisplayName());
        itemStack.setType(itemStack.getType());
    }

    public ItemBuilder setLore(List<String> lore, @Nullable Map<String, String> args) {
        for (int i = 0; i < lore.size(); i++) {
            for (String key: args.keySet()) {
                lore.set(i, lore.get(i).replace(key, args.get(key)));
            }

            lore.set(i,  ChatUtil.translateCodes(lore.get(i)));
        }

        itemMeta.setLore(lore);

        return this;
    }

    public ItemBuilder addPersistent(String key, PersistentDataType dataType, Object value) {
        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString(key), dataType, value);

        return this;
    }

    public ItemBuilder addItemFlag(ItemFlag... itemFlags) {
        itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemBuilder addAttributeModificate(Attribute attribute, String key, double value) {
        itemMeta.addAttributeModifier(attribute, new AttributeModifier(NamespacedKey.fromString(key), value, AttributeModifier.Operation.ADD_NUMBER));

        return this;
    }

    public ItemBuilder setUnbreakable(boolean value) {
        itemMeta.setUnbreakable(true);

        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
