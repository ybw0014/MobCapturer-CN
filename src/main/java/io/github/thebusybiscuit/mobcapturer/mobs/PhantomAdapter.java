package io.github.thebusybiscuit.mobcapturer.mobs;

import com.google.gson.JsonObject;
import io.github.thebusybiscuit.mobcapturer.MobAdapter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Phantom;

import java.util.List;

public class PhantomAdapter implements MobAdapter<Phantom> {

    @Override
    public List<String> getLore(JsonObject json) {
        List<String> lore = MobAdapter.super.getLore(json);

        lore.add(ChatColor.GRAY + "大小: " + ChatColor.WHITE + (json.get("size").getAsInt() + 1));

        return lore;
    }

    @Override
    public void apply(Phantom entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        entity.setSize(json.get("size").getAsInt());
    }

    @Override
    public JsonObject saveData(Phantom entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("size", entity.getSize());

        return json;
    }

    @Override
    public Class<Phantom> getEntityClass() {
        return Phantom.class;
    }

}
