package com.github.technus.tectech.thing.item;

import com.github.technus.tectech.util.CommonValues;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

import static com.github.technus.tectech.Reference.MODID;
import static com.github.technus.tectech.thing.CustomItemList.enderLinkFluidCover;
import static net.minecraft.util.StatCollector.translateToLocal;

public final class PowerPassUpgradeCover extends Item {
    public static PowerPassUpgradeCover INSTANCE;

    private PowerPassUpgradeCover() {
        setHasSubtypes(true);
        setUnlocalizedName("tm.powerpassupgradecover");
        setTextureName(MODID + ":itemPowerPassUpgradeCover");
    }

    @Override
    public void addInformation(ItemStack aStack, EntityPlayer ep, List aList, boolean boo) {
        aList.add(CommonValues.BASS_MARK);
        aList.add(translateToLocal("item.tm.powerpassupgradecover.desc.0"));//Ender-Fluid-Enables Machines!
        aList.add(EnumChatFormatting.BLUE + translateToLocal("item.tm.powerpassupgradecover.desc.1"));//Use on any side of a fluid tank to link it to the Ender
        aList.add(EnumChatFormatting.BLUE + translateToLocal("item.tm.powerpassupgradecover.desc.2"));//Ender Tanks so are laggy -Bot from the Chads of NH
    }

    public static void run() {
        INSTANCE = new PowerPassUpgradeCover();
        GameRegistry.registerItem(INSTANCE, INSTANCE.getUnlocalizedName());
        enderLinkFluidCover.set(INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(getIconString());
    }
}