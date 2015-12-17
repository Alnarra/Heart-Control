package heartControl.items;

import java.util.List;
import heartControl.heartControl;
import heartControl.config.configHandler;
import heartControl.core.heartLogic;
import heartControl.utility.hcLogger;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class baseHeart extends Item{
	
	public baseHeart(){
		this.setHasSubtypes(true);
		this.setMaxDamage(0); 
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setUnlocalizedName("hc.heart");
		this.setMaxStackSize(64);
	}
	
	protected int numItems = 5; 
	protected String texturePath = heartControl.modID + ":heart_";  
	
	public IIcon[] icons = new IIcon[numItems];
	
    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < numItems; i++)
            icons[i] = iconRegister.registerIcon(texturePath + i);
    }

    @Override
    public IIcon getIconFromDamage(int meta)
    {
        if (meta > numItems) meta = 0;
        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < numItems; i++)
            list.add(new ItemStack(item, 1, i));
    }

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
        return this.getUnlocalizedName() + ":" + item.getItemDamage();
    }
    
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		//make sure we're actually Client Side here
		if(!world.isRemote)
		{
			int meta = stack.getItemDamage(); 
			hcLogger.logger(player + "used a Heart");
			heartLogic.attemptHeartAdd(meta, player);
			player.inventory.decrStackSize(player.inventory.currentItem, 1); 
			
			//We also want the heart to Give us a potion effect don't we? Let's find out
			if(configHandler.enableExtraEffects == true)
			{
				switch(meta)
				{
				case 0: 
					player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2400, 1));
					break; 
				case 1: 
					player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 2400, 1));
					break; 
				case 2: 
					player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 2400, 1));
					break; 
				case 3: 
					player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(),2400,1));
					break; 
				case 4: 
					player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 2400, 1));
					player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(),2400,1));
					player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(),2400,1));
					break; 
				default: 
					break; 
				}
			}
		}
		return stack;
	}

}
