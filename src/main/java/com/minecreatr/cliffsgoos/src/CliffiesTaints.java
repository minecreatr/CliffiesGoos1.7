package com.minecreatr.cliffsgoos.src;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = "CliffiesTaints", name = "Cliffie's Goos",
        version = "1.7.2-1.0")
public class CliffiesTaints
{
    public final static CreativeTabs tab = new TaintedTab("taintedTab");
    public final static GooStep soundSplutFootstep = new GooStep("cliffiestaints:splut", 1, 1);
    public final static GooStep soundThunkFootstep = new GooStep("cliffiestaints:thunk", 1, 1);
    public final static GooStep soundWooshFootstep = new GooStep("cliffiestaints:woosh", 1, 1);
    public final static GooStep soundZapFootstep = new GooStep("cliffiestaints:zap", 1, 1);
    public final static GooStep soundSplurgFootstep = new GooStep("cliffiestaints:splurg", 1, 1);
    public static ItemArmor.ArmorMaterial gasMask = EnumHelper.addArmorMaterial("cliffiesGasMask", 500, new int[]{2, 6, 5, 2}, 9);
    public boolean worldGenEnabled = false;
    public boolean expensiveAntiTaint = false;
    public boolean dangerousTaintCrafting = false;
    public static int rMaskI;
    public static int oMaskI;
    public static int yMaskI;
    public static int lMaskI;
    public static int gMaskI;
    public static int cMaskI;
    public static int bMaskI;
    public static int pMaskI;
    public final static Block rTaint = new NormalTaint(2000,
            Material.ground, "rTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("rTaint").setCreativeTab(tab);
    public final static Block rATaint = new NormalBlock(2001,
            Material.ground, "rATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("rATaint").setCreativeTab(tab);
    public final static Block oTaint = new NormalTaint(2002,
            Material.ground, "oTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("oTaint").setCreativeTab(tab);
    public final static Block oATaint = new NormalBlock(2003,
            Material.ground, "oATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("oATaint").setCreativeTab(tab);
    public final static Block yTaint = new NormalTaint(2004,
            Material.ground, "yTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("yTaint").setCreativeTab(tab);
    public final static Block yATaint = new NormalBlock(2005,
            Material.ground, "yATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("yATaint").setCreativeTab(tab);
    public final static Block lTaint = new NormalTaint(2006,
            Material.ground, "lTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("lTaint").setCreativeTab(tab);
    public final static Block lATaint = new NormalBlock(2007,
            Material.ground, "lATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("lATaint").setCreativeTab(tab);
    public final static Block gTaint = new NormalTaint(2008,
            Material.ground, "gTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("gTaint").setCreativeTab(tab);
    public final static Block gATaint = new NormalBlock(2009,
            Material.ground, "gATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("gATaint").setCreativeTab(tab);
    public final static Block cTaint = new NormalTaint(2010,
            Material.ground, "cTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("cTaint").setCreativeTab(tab);
    public final static Block cATaint = new NormalBlock(2011,
            Material.ground, "cATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("cATaint").setCreativeTab(tab);
    public final static Block bTaint = new NormalTaint(2012,
            Material.ground, "bTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("bTaint").setCreativeTab(tab);
    public final static Block bATaint = new NormalBlock(2013,
            Material.ground, "bATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("bATaint").setCreativeTab(tab);
    public final static Block pTaint = new NormalTaint(2014,
            Material.ground, "pTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("pTaint").setCreativeTab(tab);
    public final static Block pATaint = new NormalBlock(2015,
            Material.ground, "pATaint").setHardness(2F).setResistance(100F)
            .setStepSound(soundThunkFootstep)
            .setBlockName("pATaint").setCreativeTab(tab);
    public final static Block rTaint1 = new Tier1Taint(2016,
            Material.ground, "rTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("rTaint1").setCreativeTab(tab);
    public final static Block oTaint1 = new Tier1Taint(2017,
            Material.ground, "oTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("oTaint1").setCreativeTab(tab);
    public final static Block yTaint1 = new Tier1Taint(2018,
            Material.ground, "yTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("yTaint1").setCreativeTab(tab);
    public final static Block lTaint1 = new Tier1Taint(2019,
            Material.ground, "lTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("lTaint1").setCreativeTab(tab);
    public final static Block gTaint1 = new Tier1Taint(2020,
            Material.ground, "gTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("gTaint1").setCreativeTab(tab);
    public final static Block cTaint1 = new Tier1Taint(2021,
            Material.ground, "cTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("cTaint1").setCreativeTab(tab);
    public final static Block bTaint1 = new Tier1Taint(2022,
            Material.ground, "bTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("bTaint1").setCreativeTab(tab);
    public final static Block pTaint1 = new Tier1Taint(2023,
            Material.ground, "pTaint1").setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("pTaint1").setCreativeTab(tab);
    public final static Block rTaint2 = new Tier2Taint(2024,
            Material.vine, "rTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("rTaint2").setCreativeTab(tab);
    public final static Block oTaint2 = new Tier2Taint(2025,
            Material.vine, "oTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("oTaint2").setCreativeTab(tab);
    public final static Block yTaint2 = new Tier2Taint(2026,
            Material.vine, "yTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("yTaint2").setCreativeTab(tab);
    public final static Block lTaint2 = new Tier2Taint(2027,
            Material.vine, "lTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("lTaint2").setCreativeTab(tab);
    public final static Block gTaint2 = new Tier2Taint(2028,
            Material.vine, "gTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("gTaint2").setCreativeTab(tab);
    public final static Block cTaint2 = new Tier2Taint(2029,
            Material.vine, "cTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("cTaint2").setCreativeTab(tab);
    public final static Block bTaint2 = new Tier2Taint(2030,
            Material.vine, "bTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("bTaint2").setCreativeTab(tab);
    public final static Block pTaint2 = new Tier2Taint(2031,
            Material.vine, "pTaint2").setHardness(0.1F)
            .setStepSound(soundWooshFootstep)
            .setBlockName("pTaint2").setCreativeTab(tab);
    public final static Block rFField = new AntiTaintTransp(2032,
            Material.rock, "rFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("rFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block oFField = new AntiTaintTransp(2033,
            Material.rock, "oFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("oFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block yFField = new AntiTaintTransp(2034,
            Material.rock, "yFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("yFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block lFField = new AntiTaintTransp(2035,
            Material.rock, "lFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("lFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block gFField = new AntiTaintTransp(2036,
            Material.rock, "gFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("gFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block cFField = new AntiTaintTransp(2037,
            Material.rock, "cFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("cFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block bFField = new AntiTaintTransp(2038,
            Material.rock, "bFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("bFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block pFField = new AntiTaintTransp(2039,
            Material.rock, "pFField").setHardness(10F)
            .setStepSound(soundZapFootstep)
            .setBlockName("pFField").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block rFFieldAL = new AirlockType(2040,
            Material.rock, "rFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("rFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block oFFieldAL = new AirlockType(2041,
            Material.rock, "oFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("oFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block yFFieldAL = new AirlockType(2042,
            Material.rock, "yFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("yFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block lFFieldAL = new AirlockType(2043,
            Material.rock, "lFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("lFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block gFFieldAL = new AirlockType(2044,
            Material.rock, "gFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("gFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block cFFieldAL = new AirlockType(2045,
            Material.rock, "cFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("cFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block bFFieldAL = new AirlockType(2046,
            Material.rock, "bFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("bFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block pFFieldAL = new AirlockType(2047,
            Material.rock, "pFFieldAL").setHardness(0.25F)
            .setStepSound(soundZapFootstep)
            .setBlockName("pFFieldAL").setCreativeTab(tab).setLightLevel(1.0F).setResistance(500F);
    public final static Block rTaint3 = new Tier3Taint(2048,
            Material.vine, "rTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("rTaint3").setCreativeTab(tab);
    public final static Block oTaint3 = new Tier3Taint(2049,
            Material.vine, "oTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("oTaint3").setCreativeTab(tab);
    public final static Block yTaint3 = new Tier3Taint(2050,
            Material.vine, "yTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("yTaint3").setCreativeTab(tab);
    public final static Block lTaint3 = new Tier3Taint(2051,
            Material.vine, "lTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("lTaint3").setCreativeTab(tab);
    public final static Block gTaint3 = new Tier3Taint(2052,
            Material.vine, "gTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("gTaint3").setCreativeTab(tab);
    public final static Block cTaint3 = new Tier3Taint(2053,
            Material.vine, "cTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("cTaint3").setCreativeTab(tab);
    public final static Block bTaint3 = new Tier3Taint(2054,
            Material.vine, "bTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("bTaint3").setCreativeTab(tab);
    public final static Block pTaint3 = new Tier3Taint(2055,
            Material.vine, "pTaint3").setHardness(0.1F)
            .setStepSound(soundSplurgFootstep)
            .setBlockName("pTaint3").setCreativeTab(tab);
    public final static Block rSpeedGoo = new SpeedChangeGoo(2056,
            Material.ground, "rSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("rSpeedGoo").setCreativeTab(tab);
    public final static Block oSpeedGoo = new SpeedChangeGoo(2057,
            Material.ground, "oSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("oSpeedGoo").setCreativeTab(tab);
    public final static Block ySpeedGoo = new SpeedChangeGoo(2058,
            Material.ground, "ySpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("ySpeedGoo").setCreativeTab(tab);
    public final static Block lSpeedGoo = new SpeedChangeGoo(2059,
            Material.ground, "lSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("lSpeedGoo").setCreativeTab(tab);
    public final static Block gSpeedGoo = new SpeedChangeGoo(2060,
            Material.ground, "gSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("gSpeedGoo").setCreativeTab(tab);
    public final static Block cSpeedGoo = new SpeedChangeGoo(2061,
            Material.ground, "cSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("cSpeedGoo").setCreativeTab(tab);
    public final static Block bSpeedGoo = new SpeedChangeGoo(2062,
            Material.ground, "bSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("bSpeedGoo").setCreativeTab(tab);
    public final static Block pSpeedGoo = new SpeedChangeGoo(2063,
            Material.ground, "pSpeedGoo", 1.075f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("pSpeedGoo").setCreativeTab(tab);
    public final static Block rSlowGoo = new SpeedChangeGoo(2064,
            Material.ground, "rSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("rSlowGoo").setCreativeTab(tab);
    public final static Block oSlowGoo = new SpeedChangeGoo(2065,
            Material.ground, "oSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("oSlowGoo").setCreativeTab(tab);
    public final static Block ySlowGoo = new SpeedChangeGoo(2066,
            Material.ground, "ySlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("ySlowGoo").setCreativeTab(tab);
    public final static Block lSlowGoo = new SpeedChangeGoo(2067,
            Material.ground, "lSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("lSlowGoo").setCreativeTab(tab);
    public final static Block gSlowGoo = new SpeedChangeGoo(2068,
            Material.ground, "gSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("gSlowGoo").setCreativeTab(tab);
    public final static Block cSlowGoo = new SpeedChangeGoo(2069,
            Material.ground, "cSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("cSlowGoo").setCreativeTab(tab);
    public final static Block bSlowGoo = new SpeedChangeGoo(2070,
            Material.ground, "bSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("bSlowGoo").setCreativeTab(tab);
    public final static Block pSlowGoo = new SpeedChangeGoo(2071,
            Material.ground, "pSlowGoo", 0.88f).setHardness(0.75F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("pSlowGoo").setCreativeTab(tab);
    public final static Block antiGoo = new AntiGoo(Material.ground, "gTaint").setHardness(0.75F).setStepSound(soundSplurgFootstep)
            .setBlockName("antiGoo").setCreativeTab(tab);
	public final static Block greyTaint = new NormalTaint(2073,
            Material.ground, "greyTaint").setHardness(0.25F)
            .setStepSound(soundSplutFootstep)
            .setBlockName("greyTaint").setCreativeTab(tab);
    public final static Item rGasMask = new CustomArmor(0, 0, "rMask", gasMask, rMaskI);
    public final static Item oGasMask = new CustomArmor(0, 0, "oMask", gasMask, oMaskI);
    public final static Item yGasMask = new CustomArmor(0, 0, "yMask", gasMask, yMaskI);
    public final static Item lGasMask = new CustomArmor(0, 0, "lMask", gasMask, lMaskI);
    public final static Item gGasMask = new CustomArmor(0, 0, "gMask", gasMask, gMaskI);
    public final static Item cGasMask = new CustomArmor(0, 0, "cMask", gasMask, cMaskI);
    public final static Item bGasMask = new CustomArmor(0, 0, "bMask", gasMask, bMaskI);
    public final static Item pGasMask = new CustomArmor(0, 0, "pMask", gasMask, pMaskI);
    static List blacklistedDims = new ArrayList();
    
    @Mod.Instance("CliffiesTaints")
    public static CliffiesTaints instance;
    
    @SidedProxy(clientSide = "com.minecreatr.cliffsgoos.src.ClientProxy",
            serverSide = "com.minecreatr.cliffsgoos.src.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Openblocks donation station support.  Support the modders, without them needing to resort to adfly!  =D
        FMLInterModComms.sendMessage("CliffiesTaints", "donateUrl", "http://cliffracerx.github.io/CliffiesTaints/donate.html");
        //Config.
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        worldGenEnabled = config.get(Configuration.CATEGORY_GENERAL, "Generate Goo", false).getBoolean(false);
        expensiveAntiTaint = config.get(Configuration.CATEGORY_GENERAL, "Expensive anti-taint", false).getBoolean(false);
        dangerousTaintCrafting = config.get(Configuration.CATEGORY_GENERAL, "Can the dangerous taints be made?", true).getBoolean(true);
        int blacklistedDimList = config.get(Configuration.CATEGORY_GENERAL, "How many blacklisted dimensions are there?", 0).getInt(0);
        for(int i = 0; i<blacklistedDimList; i++)
        {
            blacklistedDims.add(config.get(Configuration.CATEGORY_GENERAL, "Blacklisted dim #"+i, 0).getInt(0));
        }
        // saving the configuration to its file
        config.save();
    }
    
    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
    public void load(FMLInitializationEvent event)
    {
        ClientProxy.registerRenderers();
        rMaskI = ClientProxy.addArmour("rMask");
        oMaskI = ClientProxy.addArmour("oMask");
        yMaskI = ClientProxy.addArmour("yMask");
        lMaskI = ClientProxy.addArmour("lMask");
        gMaskI = ClientProxy.addArmour("gMask");
        cMaskI = ClientProxy.addArmour("cMask");
        bMaskI = ClientProxy.addArmour("bMask");
        pMaskI = ClientProxy.addArmour("pMask");
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //Block naming and registering
        LanguageRegistry.addName(rTaint, "Red Tainted goo (lv 0)");
        GameRegistry.registerBlock(rTaint, "rTaint");
        LanguageRegistry.addName(rATaint, "Red Anti-Taint wall");
        GameRegistry.registerBlock(rATaint, "rATaint");
        LanguageRegistry.addName(oTaint, "Orange Tainted goo (lv 0)");
        GameRegistry.registerBlock(oTaint, "oTaint");
        LanguageRegistry.addName(oATaint, "Orange Anti-Taint wall");
        GameRegistry.registerBlock(oATaint, "oATaint");
        LanguageRegistry.addName(yTaint, "Yellow Tainted goo (lv 0)");
        GameRegistry.registerBlock(yTaint, "yTaint");
        LanguageRegistry.addName(yATaint, "Yellow Anti-Taint wall");
        GameRegistry.registerBlock(yATaint, "yATaint");
        LanguageRegistry.addName(lTaint, "Lime Tainted goo (lv 0)");
        GameRegistry.registerBlock(lTaint, "lTaint");
        LanguageRegistry.addName(lATaint, "Lime Anti-Taint wall");
        GameRegistry.registerBlock(lATaint, "lATaint");
        LanguageRegistry.addName(gTaint, "Green Tainted goo (lv 0)");
        GameRegistry.registerBlock(gTaint, "gTaint");
        LanguageRegistry.addName(gATaint, "Green Anti-Taint wall");
        GameRegistry.registerBlock(gATaint, "gATaint");
        LanguageRegistry.addName(cTaint, "Cyan Tainted goo (lv 0)");
        GameRegistry.registerBlock(cTaint, "cTaint");
        LanguageRegistry.addName(cATaint, "Cyan Anti-Taint wall");
        GameRegistry.registerBlock(cATaint, "cATaint");
        LanguageRegistry.addName(bTaint, "Blue Tainted goo (lv 0)");
        GameRegistry.registerBlock(bTaint, "bTaint");
        LanguageRegistry.addName(bATaint, "Blue Anti-Taint wall");
        GameRegistry.registerBlock(bATaint, "bATaint");
        LanguageRegistry.addName(pTaint, "Purple Tainted goo (lv 0)");
        GameRegistry.registerBlock(pTaint, "pTaint");
        LanguageRegistry.addName(pATaint, "Purple Anti-Taint wall");
        GameRegistry.registerBlock(pATaint, "pATaint");
        LanguageRegistry.addName(rTaint1, "Red Tainted goo (lv 1)");
        GameRegistry.registerBlock(rTaint1, "rTaint1");
        LanguageRegistry.addName(oTaint1, "Orange Tainted goo (lv 1)");
        GameRegistry.registerBlock(oTaint1, "oTaint1");
        LanguageRegistry.addName(yTaint1, "Yellow Tainted goo (lv 1)");
        GameRegistry.registerBlock(yTaint1, "yTaint1");
        LanguageRegistry.addName(lTaint1, "Lime Tainted goo (lv 1)");
        GameRegistry.registerBlock(lTaint1, "lTaint1");
        LanguageRegistry.addName(gTaint1, "Green Tainted goo (lv 1)");
        GameRegistry.registerBlock(gTaint1, "gTaint1");
        LanguageRegistry.addName(cTaint1, "Cyan Tainted goo (lv 1)");
        GameRegistry.registerBlock(cTaint1, "cTaint1");
        LanguageRegistry.addName(bTaint1, "Blue Tainted goo (lv 1)");
        GameRegistry.registerBlock(bTaint1, "bTaint1");
        LanguageRegistry.addName(pTaint1, "Purple Tainted goo (lv 1)");
        GameRegistry.registerBlock(pTaint1, "pTaint1");
        LanguageRegistry.addName(rTaint2, "Red Tainted gas (lv 2)");
        GameRegistry.registerBlock(rTaint2, "rTaint2");
        LanguageRegistry.addName(oTaint2, "Orange Tainted gas (lv 2)");
        GameRegistry.registerBlock(oTaint2, "oTaint2");
        LanguageRegistry.addName(yTaint2, "Yellow Tainted gas (lv 2)");
        GameRegistry.registerBlock(yTaint2, "yTaint2");
        LanguageRegistry.addName(lTaint2, "Lime Tainted gas (lv 2)");
        GameRegistry.registerBlock(lTaint2, "lTaint2");
        LanguageRegistry.addName(gTaint2, "Green Tainted gas (lv 2)");
        GameRegistry.registerBlock(gTaint2, "gTaint2");
        LanguageRegistry.addName(cTaint2, "Cyan Tainted gas (lv 2)");
        GameRegistry.registerBlock(cTaint2, "cTaint2");
        LanguageRegistry.addName(bTaint2, "Blue Tainted gas (lv 2)");
        GameRegistry.registerBlock(bTaint2, "bTaint2");
        LanguageRegistry.addName(pTaint2, "Purple Tainted gas (lv 2)");
        GameRegistry.registerBlock(pTaint2, "pTaint2");
        LanguageRegistry.addName(rFField, "Red Force Field");
        GameRegistry.registerBlock(rFField, "rFField");
        LanguageRegistry.addName(oFField, "Orange Force Field");
        GameRegistry.registerBlock(oFField, "oFField");
        LanguageRegistry.addName(yFField, "Yellow Force Field");
        GameRegistry.registerBlock(yFField, "yFField");
        LanguageRegistry.addName(lFField, "Lime Force Field");
        GameRegistry.registerBlock(lFField, "lFField");
        LanguageRegistry.addName(gFField, "Green Force Field");
        GameRegistry.registerBlock(gFField, "gFField");
        LanguageRegistry.addName(cFField, "Cyan Force Field");
        GameRegistry.registerBlock(cFField, "cFField");
        LanguageRegistry.addName(bFField, "Blue Force Field");
        GameRegistry.registerBlock(bFField, "bFField");
        LanguageRegistry.addName(pFField, "Purple Force Field");
        GameRegistry.registerBlock(pFField, "pFField");
        LanguageRegistry.addName(rFFieldAL, "Red Air Lock");
        GameRegistry.registerBlock(rFFieldAL, "rFFieldAL");
        LanguageRegistry.addName(oFFieldAL, "Orange Air Lock");
        GameRegistry.registerBlock(oFFieldAL, "oFFieldAL");
        LanguageRegistry.addName(yFFieldAL, "Yellow Air Lock");
        GameRegistry.registerBlock(yFFieldAL, "yFFieldAL");
        LanguageRegistry.addName(lFFieldAL, "Lime Air Lock");
        GameRegistry.registerBlock(lFFieldAL, "lFFieldAL");
        LanguageRegistry.addName(gFFieldAL, "Green Air Lock");
        GameRegistry.registerBlock(gFFieldAL, "gFFieldAL");
        LanguageRegistry.addName(cFFieldAL, "Cyan Air Lock");
        GameRegistry.registerBlock(cFFieldAL, "cFFieldAL");
        LanguageRegistry.addName(bFFieldAL, "Blue Air Lock");
        GameRegistry.registerBlock(bFFieldAL, "bFFieldAL");
        LanguageRegistry.addName(pFFieldAL, "Purple Air Lock");
        GameRegistry.registerBlock(pFFieldAL, "pFFieldAL");
        LanguageRegistry.addName(rTaint3, "Red Tainted goo (lv 3)");
        GameRegistry.registerBlock(rTaint3, "rTaint3");
        LanguageRegistry.addName(oTaint3, "Orange Tainted goo (lv 3)");
        GameRegistry.registerBlock(oTaint3, "oTaint3");
        LanguageRegistry.addName(yTaint3, "Yellow Tainted goo (lv 3)");
        GameRegistry.registerBlock(yTaint3, "yTaint3");
        LanguageRegistry.addName(lTaint3, "Lime Tainted goo (lv 3)");
        GameRegistry.registerBlock(lTaint3, "lTaint3");
        LanguageRegistry.addName(gTaint3, "Green Tainted goo (lv 3)");
        GameRegistry.registerBlock(gTaint3, "gTaint3");
        LanguageRegistry.addName(cTaint3, "Cyan Tainted goo (lv 3)");
        GameRegistry.registerBlock(cTaint3, "cTaint3");
        LanguageRegistry.addName(bTaint3, "Blue Tainted goo (lv 3)");
        GameRegistry.registerBlock(bTaint3, "bTaint3");
        LanguageRegistry.addName(pTaint3, "Purple Tainted goo (lv 3)");
        GameRegistry.registerBlock(pTaint3, "pTaint3");
        LanguageRegistry.addName(rSpeedGoo, "Red Speed goo");
        GameRegistry.registerBlock(rSpeedGoo, "rSpeedGoo");
        LanguageRegistry.addName(oSpeedGoo, "Orange Speed goo");
        GameRegistry.registerBlock(oSpeedGoo, "oSpeedGoo");
        LanguageRegistry.addName(ySpeedGoo, "Yellow Speed goo");
        GameRegistry.registerBlock(ySpeedGoo, "ySpeedGoo");
        LanguageRegistry.addName(lSpeedGoo, "Lime Speed goo");
        GameRegistry.registerBlock(lSpeedGoo, "lSpeedGoo");
        LanguageRegistry.addName(gSpeedGoo, "Green Speed goo");
        GameRegistry.registerBlock(gSpeedGoo, "gSpeedGoo");
        LanguageRegistry.addName(cSpeedGoo, "Cyan Speed goo");
        GameRegistry.registerBlock(cSpeedGoo, "cSpeedGoo");
        LanguageRegistry.addName(bSpeedGoo, "Blue Speed goo");
        GameRegistry.registerBlock(bSpeedGoo, "bSpeedGoo");
        LanguageRegistry.addName(pSpeedGoo, "Purple Speed goo");
        GameRegistry.registerBlock(pSpeedGoo, "pSpeedGoo");
        LanguageRegistry.addName(rSlowGoo, "Red Slow goo");
        GameRegistry.registerBlock(rSlowGoo, "rSlowGoo");
        LanguageRegistry.addName(oSlowGoo, "Orange Slow goo");
        GameRegistry.registerBlock(oSlowGoo, "oSlowGoo");
        LanguageRegistry.addName(ySlowGoo, "Yellow Slow goo");
        GameRegistry.registerBlock(ySlowGoo, "ySlowGoo");
        LanguageRegistry.addName(lSlowGoo, "Lime Slow goo");
        GameRegistry.registerBlock(lSlowGoo, "lSlowGoo");
        LanguageRegistry.addName(gSlowGoo, "Green Slow goo");
        GameRegistry.registerBlock(gSlowGoo, "gSlowGoo");
        LanguageRegistry.addName(cSlowGoo, "Cyan Slow goo");
        GameRegistry.registerBlock(cSlowGoo, "cSlowGoo");
        LanguageRegistry.addName(bSlowGoo, "Blue Slow goo");
        GameRegistry.registerBlock(bSlowGoo, "bSlowGoo");
        LanguageRegistry.addName(pSlowGoo, "Purple Slow goo");
        GameRegistry.registerBlock(pSlowGoo, "pSlowGoo");
		LanguageRegistry.addName(greyTaint, "Grey tier 0 taint");
        GameRegistry.registerBlock(greyTaint, "greyTaint");
        GameRegistry.registerBlock(antiGoo, "antiGoo");
        LanguageRegistry.addName(antiGoo, "Goo Remover (WIP)");
        //Register gas masks
        GameRegistry.registerItem(rGasMask, "rGasMask");
        GameRegistry.registerItem(oGasMask, "oGasMask");
        GameRegistry.registerItem(yGasMask, "yGasMask");
        GameRegistry.registerItem(lGasMask, "lGasMask");
        GameRegistry.registerItem(gGasMask, "gGasMask");
        GameRegistry.registerItem(cGasMask, "cGasMask");
        GameRegistry.registerItem(bGasMask, "bGasMask");
        GameRegistry.registerItem(pGasMask, "pGasMask");
        //Turn on the world gen if it's enabled.
        if(worldGenEnabled)
            GameRegistry.registerWorldGenerator(new GenerateGoo(), 10);
        //Name items
        LanguageRegistry.addName(rGasMask, "Red gas mask");
        LanguageRegistry.addName(oGasMask, "Orange gas mask");
        LanguageRegistry.addName(yGasMask, "Yellow gas mask");
        LanguageRegistry.addName(lGasMask, "Lime gas mask");
        LanguageRegistry.addName(gGasMask, "Green gas mask");
        LanguageRegistry.addName(cGasMask, "Cyan gas mask");
        LanguageRegistry.addName(bGasMask, "Blue gas mask");
        LanguageRegistry.addName(pGasMask, "Purple gas mask");
        //Crafting
        if(expensiveAntiTaint)
        {
            GameRegistry.addRecipe(new ItemStack(rATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', rTaint);
            GameRegistry.addRecipe(new ItemStack(oATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', oTaint);
            GameRegistry.addRecipe(new ItemStack(yATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', yTaint);
            GameRegistry.addRecipe(new ItemStack(lATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', lTaint);
            GameRegistry.addRecipe(new ItemStack(gATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', gTaint);
            GameRegistry.addRecipe(new ItemStack(cATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', cTaint);
            GameRegistry.addRecipe(new ItemStack(bATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', bTaint);
            GameRegistry.addRecipe(new ItemStack(pATaint, 16), "###",
                    "#$#", "###", '$', Items.diamond, '#', pTaint);
        }
        else
        {
            GameRegistry.addRecipe(new ItemStack(rATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', rTaint);
            GameRegistry.addRecipe(new ItemStack(oATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', oTaint);
            GameRegistry.addRecipe(new ItemStack(yATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', yTaint);
            GameRegistry.addRecipe(new ItemStack(lATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', lTaint);
            GameRegistry.addRecipe(new ItemStack(gATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', gTaint);
            GameRegistry.addRecipe(new ItemStack(cATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', cTaint);
            GameRegistry.addRecipe(new ItemStack(bATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', bTaint);
            GameRegistry.addRecipe(new ItemStack(pATaint, 16), "###",
                    "#$#", "###", '$', Blocks.stone, '#', pTaint);
        }
        	GameRegistry.addRecipe(new ItemStack(greyTaint, 1), "###",
                    "#$#", "###", '$', Blocks.dirt, '#', Items.slime_ball);
			GameRegistry.addRecipe(new ItemStack(rTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 1));
			GameRegistry.addRecipe(new ItemStack(oTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 14));
			GameRegistry.addRecipe(new ItemStack(yTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 11));
			GameRegistry.addRecipe(new ItemStack(lTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 10));
			GameRegistry.addRecipe(new ItemStack(gTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 2));
			GameRegistry.addRecipe(new ItemStack(cTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 12));
			GameRegistry.addRecipe(new ItemStack(bTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 4));
			GameRegistry.addRecipe(new ItemStack(pTaint, 1), "###",
                    "#$#", "###", '$', greyTaint, '#', new ItemStack(Items.dye, 1, 5));
        GameRegistry.addRecipe(new ItemStack(rTaint1, 1), "###",
                "#$#", "###", '$', rTaint, '#', rTaint);
        GameRegistry.addRecipe(new ItemStack(oTaint1, 1), "###",
                "#$#", "###", '$', oTaint, '#', oTaint);
        GameRegistry.addRecipe(new ItemStack(yTaint1, 1), "###",
                "#$#", "###", '$', yTaint, '#', yTaint);
        GameRegistry.addRecipe(new ItemStack(lTaint1, 1), "###",
                "#$#", "###", '$', lTaint, '#', lTaint);
        GameRegistry.addRecipe(new ItemStack(gTaint1, 1), "###",
                "#$#", "###", '$', gTaint, '#', gTaint);
        GameRegistry.addRecipe(new ItemStack(cTaint1, 1), "###",
                "#$#", "###", '$', cTaint, '#', cTaint);
        GameRegistry.addRecipe(new ItemStack(bTaint1, 1), "###",
                "#$#", "###", '$', bTaint, '#', bTaint);
        GameRegistry.addRecipe(new ItemStack(pTaint1, 1), "###",
                "#$#", "###", '$', pTaint, '#', pTaint);
        if(dangerousTaintCrafting)
        {
        GameRegistry.addRecipe(new ItemStack(rTaint2, 1), "###",
                "#$#", "###", '$', rTaint, '#', rTaint1);
        GameRegistry.addRecipe(new ItemStack(oTaint2, 1), "###",
                "#$#", "###", '$', oTaint, '#', oTaint1);
        GameRegistry.addRecipe(new ItemStack(yTaint2, 1), "###",
                "#$#", "###", '$', yTaint, '#', yTaint1);
        GameRegistry.addRecipe(new ItemStack(lTaint2, 1), "###",
                "#$#", "###", '$', lTaint, '#', lTaint1);
        GameRegistry.addRecipe(new ItemStack(gTaint2, 1), "###",
                "#$#", "###", '$', gTaint, '#', gTaint1);
        GameRegistry.addRecipe(new ItemStack(cTaint2, 1), "###",
                "#$#", "###", '$', cTaint, '#', cTaint1);
        GameRegistry.addRecipe(new ItemStack(bTaint2, 1), "###",
                "#$#", "###", '$', bTaint, '#', bTaint1);
        GameRegistry.addRecipe(new ItemStack(pTaint2, 1), "###",
                "#$#", "###", '$', pTaint, '#', pTaint1);
        GameRegistry.addRecipe(new ItemStack(rTaint3, 1), "###",
                "#$#", "###", '$', rTaint1, '#', rTaint2);
        GameRegistry.addRecipe(new ItemStack(oTaint3, 1), "###",
                "#$#", "###", '$', oTaint1, '#', oTaint2);
        GameRegistry.addRecipe(new ItemStack(yTaint3, 1), "###",
                "#$#", "###", '$', yTaint1, '#', yTaint2);
        GameRegistry.addRecipe(new ItemStack(lTaint3, 1), "###",
                "#$#", "###", '$', lTaint1, '#', lTaint2);
        GameRegistry.addRecipe(new ItemStack(gTaint3, 1), "###",
                "#$#", "###", '$', gTaint1, '#', gTaint2);
        GameRegistry.addRecipe(new ItemStack(cTaint3, 1), "###",
                "#$#", "###", '$', cTaint1, '#', cTaint2);
        GameRegistry.addRecipe(new ItemStack(bTaint3, 1), "###",
                "#$#", "###", '$', bTaint1, '#', bTaint2);
        GameRegistry.addRecipe(new ItemStack(pTaint3, 1), "###",
                "#$#", "###", '$', pTaint1, '#', pTaint2);
        }
        GameRegistry.addRecipe(new ItemStack(rGasMask, 1), "###",
                "#$#", "###", '$', rFFieldAL, '#', rATaint);
        GameRegistry.addRecipe(new ItemStack(oGasMask, 1), "###",
                "#$#", "###", '$', oFFieldAL, '#', oATaint);
        GameRegistry.addRecipe(new ItemStack(yGasMask, 1), "###",
                "#$#", "###", '$', yFFieldAL, '#', yATaint);
        GameRegistry.addRecipe(new ItemStack(lGasMask, 1), "###",
                "#$#", "###", '$', lFFieldAL, '#', lATaint);
        GameRegistry.addRecipe(new ItemStack(gGasMask, 1), "###",
                "#$#", "###", '$', gFFieldAL, '#', gATaint);
        GameRegistry.addRecipe(new ItemStack(cGasMask, 1), "###",
                "#$#", "###", '$', cFFieldAL, '#', cATaint);
        GameRegistry.addRecipe(new ItemStack(bGasMask, 1), "###",
                "#$#", "###", '$', bFFieldAL, '#', bATaint);
        GameRegistry.addRecipe(new ItemStack(pGasMask, 1), "###",
                "#$#", "###", '$', pFFieldAL, '#', pATaint);
        GameRegistry.addRecipe(new ItemStack(rFField, 4), "###",
                "#$#", "###", '$', rTaint2, '#', rATaint);
        GameRegistry.addRecipe(new ItemStack(oFField, 4), "###",
                "#$#", "###", '$', oTaint2, '#', oATaint);
        GameRegistry.addRecipe(new ItemStack(yFField, 4), "###",
                "#$#", "###", '$', yTaint2, '#', yATaint);
        GameRegistry.addRecipe(new ItemStack(lFField, 4), "###",
                "#$#", "###", '$', lTaint2, '#', lATaint);
        GameRegistry.addRecipe(new ItemStack(gFField, 4), "###",
                "#$#", "###", '$', gTaint2, '#', gATaint);
        GameRegistry.addRecipe(new ItemStack(cFField, 4), "###",
                "#$#", "###", '$', cTaint2, '#', cATaint);
        GameRegistry.addRecipe(new ItemStack(bFField, 4), "###",
                "#$#", "###", '$', bTaint2, '#', bATaint);
        GameRegistry.addRecipe(new ItemStack(pFField, 4), "###",
                "#$#", "###", '$', pTaint2, '#', pATaint);
        GameRegistry.addRecipe(new ItemStack(rFFieldAL, 4), "###",
                "#$#", "###", '$', rTaint2, '#', rFField);
        GameRegistry.addRecipe(new ItemStack(oFFieldAL, 4), "###",
                "#$#", "###", '$', oTaint2, '#', oFField);
        GameRegistry.addRecipe(new ItemStack(yFFieldAL, 4), "###",
                "#$#", "###", '$', yTaint2, '#', yFField);
        GameRegistry.addRecipe(new ItemStack(lFFieldAL, 4), "###",
                "#$#", "###", '$', lTaint2, '#', lFField);
        GameRegistry.addRecipe(new ItemStack(gFFieldAL, 4), "###",
                "#$#", "###", '$', gTaint2, '#', gFField);
        GameRegistry.addRecipe(new ItemStack(cFFieldAL, 4), "###",
                "#$#", "###", '$', cTaint2, '#', cFField);
        GameRegistry.addRecipe(new ItemStack(bFFieldAL, 4), "###",
                "#$#", "###", '$', bTaint2, '#', bFField);
        GameRegistry.addRecipe(new ItemStack(pFFieldAL, 4), "###",
                "#$#", "###", '$', pTaint2, '#', pFField);
        GameRegistry.addRecipe(new ItemStack(rSpeedGoo, 16), "###",
                "#$#", "###", '$', rTaint2, '#', rTaint);
        GameRegistry.addRecipe(new ItemStack(oSpeedGoo, 16), "###",
                "#$#", "###", '$', oTaint2, '#', oTaint);
        GameRegistry.addRecipe(new ItemStack(ySpeedGoo, 16), "###",
                "#$#", "###", '$', yTaint2, '#', yTaint);
        GameRegistry.addRecipe(new ItemStack(lSpeedGoo, 16), "###",
                "#$#", "###", '$', lTaint2, '#', lTaint);
        GameRegistry.addRecipe(new ItemStack(gSpeedGoo, 16), "###",
                "#$#", "###", '$', gTaint2, '#', gTaint);
        GameRegistry.addRecipe(new ItemStack(cSpeedGoo, 16), "###",
                "#$#", "###", '$', cTaint2, '#', cTaint);
        GameRegistry.addRecipe(new ItemStack(bSpeedGoo, 16), "###",
                "#$#", "###", '$', bTaint2, '#', bTaint);
        GameRegistry.addRecipe(new ItemStack(pSpeedGoo, 16), "###",
                "#$#", "###", '$', pTaint2, '#', pTaint);
        GameRegistry.addRecipe(new ItemStack(rSlowGoo, 16), "###",
                "#$#", "###", '$', rTaint1, '#', rTaint);
        GameRegistry.addRecipe(new ItemStack(oSlowGoo, 16), "###",
                "#$#", "###", '$', oTaint1, '#', oTaint);
        GameRegistry.addRecipe(new ItemStack(ySlowGoo, 16), "###",
                "#$#", "###", '$', yTaint1, '#', yTaint);
        GameRegistry.addRecipe(new ItemStack(lSlowGoo, 16), "###",
                "#$#", "###", '$', lTaint1, '#', lTaint);
        GameRegistry.addRecipe(new ItemStack(gSlowGoo, 16), "###",
                "#$#", "###", '$', gTaint1, '#', gTaint);
        GameRegistry.addRecipe(new ItemStack(cSlowGoo, 16), "###",
                "#$#", "###", '$', cTaint1, '#', cTaint);
        GameRegistry.addRecipe(new ItemStack(bSlowGoo, 16), "###",
                "#$#", "###", '$', bTaint1, '#', bTaint);
        GameRegistry.addRecipe(new ItemStack(pSlowGoo, 16), "###",
                "#$#", "###", '$', pTaint1, '#', pTaint);
    }
}
