package com.scouter.oceansdelight;

import com.scouter.oceansdelight.setup.ClientSetup;
import com.scouter.oceansdelight.setup.Registration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Set;

public class OceansDelight implements ModInitializer {
    public static final String MODID = "oceansdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger("oceansdelight");

    @Override
    public void onInitialize() {
        Registration.init();
        ClientSetup.init();
        this.registerLootTable();
    }


    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }
    protected void registerLootTable() {
        Set<ResourceKey<LootTable>> scavengingEntityIdList = Set.of(
                EntityType.SQUID.getDefaultLootTable(),
                EntityType.GUARDIAN.getDefaultLootTable(),
                EntityType.ELDER_GUARDIAN.getDefaultLootTable()
        );


        //LootTableEvents.MODIFY.register(((key, tableBuilder, source) -> {
        //    ResourceLocation injectId =  ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "inject/" + key.location());
        //    if (scavengingEntityIdList.contains(key)) {
        //        tableBuilder.withPool(LootPool.lootPool().add(LootTableReference.lootTableReference(injectId)).build());
        //    }
        //}));
    }
}

