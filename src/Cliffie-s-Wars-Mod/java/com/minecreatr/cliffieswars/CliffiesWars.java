package com.minecreatr.cliffieswars;

import com.minecreatr.cliffieswars.block.FakeTurf;
import com.minecreatr.cliffieswars.block.NukeBlock;
import com.minecreatr.cliffieswars.block.WallBlock;
import com.minecreatr.cliffieswars.entity.LaserEntity;
import com.minecreatr.cliffieswars.entity.NukeEntity;
import com.minecreatr.cliffieswars.entity.RPGEntity;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.minecreatr.cliffieswars.item.BatteryItem;
import com.minecreatr.cliffieswars.item.HandheldDeathray;
import com.minecreatr.cliffieswars.item.HandheldRocketLauncher;
import com.minecreatr.cliffieswars.item.RocketItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import com.minecreatr.cliffieswars.tile.FakeBlockTileEntity;

@Mod(modid="CliffiesWarsMod", name="Cliffie's War mod", version="Alpha 0.01a")
public class CliffiesWars
{
    public static CreativeTabs tab = new WarTab("warTab");
    public static StepSound soundMetalFootstep = new StepSound("cliffieswarsmod:clang", 1.0F, 1.0F);
    public static StepSound soundSwooshFootstep = new StepSound("cliffieswarsmod:swoosh", 1.0F, 1.0F);
    public static int dWallID = 3000;
    public static int rWallID = 3001;
    public static int oWallID = 3002;
    public static int yWallID = 3003;
    public static int lWallID = 3004;
    public static int gWallID = 3005;
    public static int cWallID = 3006;
    public static int bWallID = 3007;
    public static int pWallID = 3008;
    public static int fakeTurfID = 3009;
    public static int batteryID = 5009;
    public static int rDeathrayID = 5010;
    public static int oDeathrayID = 5011;
    public static int yDeathrayID = 5012;
    public static int lDeathrayID = 5013;
    public static int gDeathrayID = 5014;
    public static int cDeathrayID = 5015;
    public static int bDeathrayID = 5016;
    public static int pDeathrayID = 5017;
    public static int rRPGID = 5018;
    public static int oRPGID = 5019;
    public static int yRPGID = 5020;
    public static int lRPGID = 5021;
    public static int gRPGID = 5022;
    public static int cRPGID = 5023;
    public static int bRPGID = 5024;
    public static int pRPGID = 5025;
    public static int rocketID = 5026;
    public static Block dWall;
    public static Block rWall;
    public static Block oWall;
    public static Block yWall;
    public static Block lWall;
    public static Block gWall;
    public static Block cWall;
    public static Block bWall;
    public static Block pWall;
    public static Block fakeTurf;
    public static Block nukeBlock;
    public static Item battery;
    public static Item rDeathray;
    public static Item oDeathray;
    public static Item yDeathray;
    public static Item lDeathray;
    public static Item gDeathray;
    public static Item cDeathray;
    public static Item bDeathray;
    public static Item pDeathray;
    public static Item rRPG;
    public static Item oRPG;
    public static Item yRPG;
    public static Item lRPG;
    public static Item gRPG;
    public static Item cRPG;
    public static Item bRPG;
    public static Item pRPG;
    public static Item rocket;
    @Mod.Instance("WarsMod")
    public static CliffiesWars instance = new CliffiesWars();
    @SidedProxy(clientSide="com.minecreatr.cliffieswars.ClientProxy", serverSide="com.minecreatr.cliffieswars.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLInterModComms.sendMessage("WarsMod", "donateUrl", "http://cliffracerx.github.io/Cliffie-s-Wars-Mod/donate.html");

        EntityRegistry.registerModEntity(LaserEntity.class, "EntityLaserOfWars", 0, this, 64, 1, true);

        EntityRegistry.registerModEntity(RPGEntity.class, "EntityRPGOfWars", 1, this, 64, 1, true);

        EntityRegistry.registerModEntity(NukeEntity.class, "nukeEntity", 2, this, 64, 1, true);


        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        dWallID = config.get("Block", "Default wall BlockID", 3000).getInt(3000);
        rWallID = config.get("Block", "Red wall BlockID", 3001).getInt(3001);
        oWallID = config.get("Block", "Orange wall BlockID", 3002).getInt(3002);
        yWallID = config.get("Block", "Yellow wall BlockID", 3003).getInt(3003);
        lWallID = config.get("Block", "Lime wall BlockID", 3004).getInt(3004);
        gWallID = config.get("Block", "Green wall BlockID", 3005).getInt(3005);
        cWallID = config.get("Block", "Cyan wall BlockID", 3006).getInt(3006);
        bWallID = config.get("Block", "Blue wall BlockID", 3007).getInt(3007);
        pWallID = config.get("Block", "Purple wall BlockID", 3008).getInt(3008);
        fakeTurfID = config.get("Block", "Fake turf BlockID", 3009).getInt(3009);
        batteryID = config.get("Item", "Battery ItemID", 5009).getInt(5009);
        rDeathrayID = config.get("Item", "Red deathray ItemID", 5010).getInt(5010);
        oDeathrayID = config.get("Item", "Orange deathray ItemID", 5011).getInt(5011);
        yDeathrayID = config.get("Item", "Yellow deathray ItemID", 5012).getInt(5012);
        lDeathrayID = config.get("Item", "Lime deathray ItemID", 5013).getInt(5013);
        gDeathrayID = config.get("Item", "Green deathray ItemID", 5014).getInt(5014);
        cDeathrayID = config.get("Item", "Cyan deathray ItemID", 5015).getInt(5015);
        bDeathrayID = config.get("Item", "Blue deathray ItemID", 5016).getInt(5016);
        pDeathrayID = config.get("Item", "Purple deathray ItemID", 5017).getInt(5017);
        rRPGID = config.get("Item", "Red rpg ItemID", 5018).getInt(5018);
        oRPGID = config.get("Item", "Orange rpg ItemID", 5019).getInt(5019);
        yRPGID = config.get("Item", "Yellow rpg ItemID", 5020).getInt(5020);
        lRPGID = config.get("Item", "Lime rpg ItemID", 5021).getInt(5021);
        gRPGID = config.get("Item", "Green rpg ItemID", 5022).getInt(5022);
        cRPGID = config.get("Item", "Cyan rpg ItemID", 5023).getInt(5023);
        bRPGID = config.get("Item", "Blue rpg ItemID", 5024).getInt(5024);
        pRPGID = config.get("Item", "Purple rpg ItemID", 5025).getInt(5025);
        rocketID = config.get("Item", "RPG/rocket ItemID", 5026).getInt(5026);

        config.save();
    }

    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event) {}

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        dWall = new WallBlock(dWallID, Material.ground, "defaultPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("dWall").setCreativeTab(tab);



        LanguageRegistry.addName(dWall, "Default colored armored wall");
        GameRegistry.registerBlock(dWall, "dWall");
        rWall = new WallBlock(rWallID, Material.ground, "rPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("rWall").setCreativeTab(tab);



        LanguageRegistry.addName(rWall, "Red colored armored wall");
        GameRegistry.registerBlock(rWall, "rWall");
        oWall = new WallBlock(oWallID, Material.ground, "oPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("oWall").setCreativeTab(tab);



        LanguageRegistry.addName(oWall, "Orange colored armored wall");
        GameRegistry.registerBlock(oWall, "oWall");
        yWall = new WallBlock(yWallID, Material.ground, "yPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("yWall").setCreativeTab(tab);



        LanguageRegistry.addName(yWall, "Yellow colored armored wall");
        GameRegistry.registerBlock(yWall, "yWall");
        lWall = new WallBlock(lWallID, Material.ground, "lPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("lWall").setCreativeTab(tab);



        LanguageRegistry.addName(lWall, "Lime colored armored wall");
        GameRegistry.registerBlock(lWall, "lWall");
        gWall = new WallBlock(gWallID, Material.ground, "gPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("gWall").setCreativeTab(tab);



        LanguageRegistry.addName(gWall, "Green colored armored wall");
        GameRegistry.registerBlock(gWall, "gWall");
        cWall = new WallBlock(cWallID, Material.ground, "cPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("cWall").setCreativeTab(tab);



        LanguageRegistry.addName(cWall, "Cyan colored armored wall");
        GameRegistry.registerBlock(cWall, "cWall");
        bWall = new WallBlock(bWallID, Material.ground, "bPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("bWall").setCreativeTab(tab);



        LanguageRegistry.addName(bWall, "Blue colored armored wall");
        GameRegistry.registerBlock(bWall, "bWall");
        pWall = new WallBlock(pWallID, Material.ground, "pPlating").setHardness(15.0F).setStepSound(soundMetalFootstep).setResistance(100.0F).setBlockName("pWall").setCreativeTab(tab);



        LanguageRegistry.addName(pWall, "Purple colored armored wall");
        GameRegistry.registerBlock(pWall, "pWall");
        fakeTurf = new FakeTurf(fakeTurfID, Material.ground, "fakeTurf").setHardness(15.0F).setStepSound(soundSwooshFootstep).setResistance(100.0F).setBlockName("fakeTurf").setCreativeTab(tab);



        LanguageRegistry.addName(fakeTurf, "Fake turf");
        GameRegistry.registerBlock(fakeTurf, "fakeTurf");
        nukeBlock = new NukeBlock();


        LanguageRegistry.addName(nukeBlock, "Nuke");
        GameRegistry.registerBlock(nukeBlock, "nukeBlock");

        battery = new BatteryItem(batteryID, "emptyBattery").setUnlocalizedName("emptyBat");
        GameRegistry.registerItem(battery, "emptyBat");
        LanguageRegistry.addName(battery, "Battery");
        rDeathray = new HandheldDeathray(rDeathrayID, "rDeathray", "r").setUnlocalizedName("rDeathray");
        GameRegistry.registerItem(rDeathray, "rDeathray");
        LanguageRegistry.addName(rDeathray, "Red handheld deathray");
        oDeathray = new HandheldDeathray(oDeathrayID, "oDeathray", "o").setUnlocalizedName("oDeathray");
        GameRegistry.registerItem(oDeathray, "oDeathray");
        LanguageRegistry.addName(oDeathray, "Orange handheld deathray");
        yDeathray = new HandheldDeathray(yDeathrayID, "yDeathray", "y").setUnlocalizedName("yDeathray");
        GameRegistry.registerItem(yDeathray, "yDeathray");
        LanguageRegistry.addName(yDeathray, "Yellow handheld deathray");
        lDeathray = new HandheldDeathray(lDeathrayID, "lDeathray", "l").setUnlocalizedName("lDeathray");
        GameRegistry.registerItem(lDeathray, "lDeathray");
        LanguageRegistry.addName(lDeathray, "Lime handheld deathray");
        gDeathray = new HandheldDeathray(gDeathrayID, "gDeathray", "g").setUnlocalizedName("gDeathray");
        GameRegistry.registerItem(gDeathray, "gDeathray");
        LanguageRegistry.addName(gDeathray, "Green handheld deathray");
        cDeathray = new HandheldDeathray(cDeathrayID, "cDeathray", "c").setUnlocalizedName("cDeathray");
        GameRegistry.registerItem(cDeathray, "cDeathray");
        LanguageRegistry.addName(cDeathray, "Cyan handheld deathray");
        bDeathray = new HandheldDeathray(bDeathrayID, "bDeathray", "b").setUnlocalizedName("bDeathray");
        GameRegistry.registerItem(bDeathray, "bDeathray");
        LanguageRegistry.addName(bDeathray, "Blue handheld deathray");
        pDeathray = new HandheldDeathray(pDeathrayID, "pDeathray", "p").setUnlocalizedName("pDeathray");
        GameRegistry.registerItem(pDeathray, "pDeathray");
        LanguageRegistry.addName(pDeathray, "Purple handheld deathray");
        rRPG = new HandheldRocketLauncher(rRPGID, "rRPG", "r").setUnlocalizedName("rRPG");
        GameRegistry.registerItem(rRPG, "rRPG");
        LanguageRegistry.addName(rRPG, "Red RPG");
        oRPG = new HandheldRocketLauncher(oRPGID, "oRPG", "o").setUnlocalizedName("oRPG");
        GameRegistry.registerItem(oRPG, "oRPG");
        LanguageRegistry.addName(oRPG, "Orange RPG");
        yRPG = new HandheldRocketLauncher(yRPGID, "yRPG", "y").setUnlocalizedName("yRPG");
        GameRegistry.registerItem(yRPG, "yRPG");
        LanguageRegistry.addName(yRPG, "Yellow RPG");
        lRPG = new HandheldRocketLauncher(lRPGID, "lRPG", "l").setUnlocalizedName("lRPG");
        GameRegistry.registerItem(lRPG, "lRPG");
        LanguageRegistry.addName(lRPG, "Lime RPG");
        gRPG = new HandheldRocketLauncher(gRPGID, "gRPG", "g").setUnlocalizedName("gRPG");
        GameRegistry.registerItem(gRPG, "gRPG");
        LanguageRegistry.addName(gRPG, "Green RPG");
        cRPG = new HandheldRocketLauncher(cRPGID, "cRPG", "c").setUnlocalizedName("cRPG");
        GameRegistry.registerItem(cRPG, "cRPG");
        LanguageRegistry.addName(cRPG, "Cyan RPG");
        bRPG = new HandheldRocketLauncher(bRPGID, "bRPG", "b").setUnlocalizedName("bRPG");
        GameRegistry.registerItem(bRPG, "bRPG");
        LanguageRegistry.addName(bRPG, "Blue RPG");
        pRPG = new HandheldRocketLauncher(pRPGID, "pRPG", "p").setUnlocalizedName("pRPG");
        GameRegistry.registerItem(pRPG, "pRPG");
        LanguageRegistry.addName(pRPG, "Purple RPG");
        rocket = new RocketItem(rocketID, "rocket").setUnlocalizedName("RPGAmmo");
        GameRegistry.registerItem(rocket, "RPGAmmo");
        LanguageRegistry.addName(rocket, "RPG ammo");
        GameRegistry.registerTileEntity(FakeBlockTileEntity.class, "fakeBlockTileEntity");

        GameRegistry.addRecipe(new ItemStack(rDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), rWall });
        GameRegistry.addRecipe(new ItemStack(oDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), oWall });
        GameRegistry.addRecipe(new ItemStack(yDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), yWall });
        GameRegistry.addRecipe(new ItemStack(lDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), lWall });
        GameRegistry.addRecipe(new ItemStack(gDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), gWall });
        GameRegistry.addRecipe(new ItemStack(cDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), cWall });
        GameRegistry.addRecipe(new ItemStack(bDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), bWall });
        GameRegistry.addRecipe(new ItemStack(pDeathray, 1), new Object[] { "#$", Character.valueOf('$'), battery, Character.valueOf('#'), pWall });
        GameRegistry.addRecipe(new ItemStack(rRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), rDeathray });
        GameRegistry.addRecipe(new ItemStack(oRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), oDeathray });
        GameRegistry.addRecipe(new ItemStack(yRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), yDeathray });
        GameRegistry.addRecipe(new ItemStack(lRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), lDeathray });
        GameRegistry.addRecipe(new ItemStack(gRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), gDeathray });
        GameRegistry.addRecipe(new ItemStack(cRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), cDeathray });
        GameRegistry.addRecipe(new ItemStack(bRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), bDeathray });
        GameRegistry.addRecipe(new ItemStack(pRPG, 1), new Object[] { "#$", Character.valueOf('$'), dWall, Character.valueOf('#'), pDeathray });
        GameRegistry.addRecipe(new ItemStack(rWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 1), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(oWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 14), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(yWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 11), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(lWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 10), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(gWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 2), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(cWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 12), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(bWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 4), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(pWall, 8), new Object[] { "###", "#$#", "###", Character.valueOf('$'), new ItemStack(Items.dye, 1, 5), Character.valueOf('#'), dWall });
        GameRegistry.addRecipe(new ItemStack(dWall, 32), new Object[] { "###", "#$#", "###", Character.valueOf('$'), Blocks.iron_block, Character.valueOf('#'), Blocks.stone });
        GameRegistry.addRecipe(new ItemStack(battery, 8), new Object[] { " # ", "#$#", " # ", Character.valueOf('$'), Items.redstone, Character.valueOf('#'), Items.iron_ingot });
        GameRegistry.addRecipe(new ItemStack(rocket, 8), new Object[] { " # ", "#$#", " # ", Character.valueOf('$'), Items.gunpowder, Character.valueOf('#'), Blocks.stone });
    }
}
