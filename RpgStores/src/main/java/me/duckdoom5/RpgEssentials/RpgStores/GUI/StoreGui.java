package me.duckdoom5.RpgEssentials.RpgStores.GUI;

import java.util.ArrayList;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgLeveling.Skill;
import me.duckdoom5.RpgEssentials.RpgStores.RpgStores;
import me.duckdoom5.RpgEssentials.RpgStores.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgStores.Util.StoreHashmaps;
import me.duckdoom5.RpgEssentials.config.PlayerConfig;
import me.duckdoom5.RpgEssentials.util.Methods;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.material.item.GenericCustomItem;
import org.getspout.spoutapi.player.SpoutPlayer;

public class StoreGui extends Gui{
	
	private Material[] materials;
	private ItemStack[] dataMaterials;
	private org.getspout.spoutapi.material.Material[] customMaterials;
	short[] monsterEggData = {50,51,52,53,54,55,56,57,58,59,60,61,62,63,90,91,92,93,94,95,96,97,98,99,120};
		
	private GenericLabel storelb = (GenericLabel) new GenericLabel().setText("Store").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER);
	private SpoutPlayer splayer;
	private GenericButton close = (GenericButton) new GenericButton("Close").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
	private GenericButton back = (GenericButton) new GenericButton("Back").setWidth(100).setHeight(20).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER).setTooltip("Back to group selection");
	private GenericTexture BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
	private GenericButton amount = (GenericButton) new GenericButton().setTooltip("Amount").setHeight(15).setWidth(20).setAnchor(WidgetAnchor.TOP_LEFT);
	private GenericLabel moneylb = (GenericLabel) new GenericLabel().setHeight(15).setWidth(50).shiftXPos(- 50).setAnchor(WidgetAnchor.TOP_RIGHT);
	private WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
	private RpgStores plugin;
	private GenericPopup popup;
	private int page, price, maxPage;
	private String currency, type;
	private short data;
	int i; 
	int X = -200;
	int Y = 20;
	private String subgroupstr;
	
	private String amountText = "1";
	
	public StoreGui(RpgStores plugin, SpoutPlayer splayer, String subgroupstr){
		this.plugin = plugin;
		this.splayer = splayer;
		page = 0;
		currency = me.duckdoom5.RpgEssentials.config.Configuration.config.getString("Currency");
		
		Gui gui = GuiManager.gui.get(splayer);
		if(gui == null || splayer.getActiveScreen() == ScreenType.GAME_SCREEN){
			popup = new GenericPopup();
			prepairPopup(true, false, subgroupstr);
		}else{
			popup = gui.getPopup();
			prepairPopup(false, true, subgroupstr);
		}
		
		GuiManager.gui.put(splayer, this);
	}
	
	public void nextPage(){
		popup.removeWidgets(plugin);
		this.page++;
		if(page > maxPage){
			page = maxPage;
		}
		createPopup(false, true, subgroupstr);
	}
	
	public void prevPage(){
		popup.removeWidgets(plugin);
		this.page--;
		if(page < 0){
			page = 0;
		}
		createPopup(false, true, subgroupstr);
	}
	
	public void back(){
		StoreSelectGui gui = new StoreSelectGui(plugin, splayer);
	}
	
	public Integer getPage(){
		return page;
	}
	
	private void prepairPopup(boolean attach, boolean remove, String subgroupstr){
		List<org.getspout.spoutapi.material.Material> customMaterialsList = new ArrayList<org.getspout.spoutapi.material.Material>();
		List<Material> materialsList = new ArrayList<Material>();
		List<ItemStack> dataMaterialsList = new ArrayList<ItemStack>();
		this.subgroupstr = subgroupstr;
		if(subgroupstr.equals("Food")) {
    		for (org.getspout.spoutapi.material.Material food:StoreHashmaps.customfood) {
    			customMaterialsList.add(food);
        	}
    		for (Material food:StoreHashmaps.food) {
    			materialsList.add(food);
        	}
		}else if(subgroupstr.equals("Tools")){
        	for (org.getspout.spoutapi.material.Material tool:StoreHashmaps.customtools) {
        		customMaterialsList.add(tool);
        	}
        	for (Material material:StoreHashmaps.tools) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("Armor")){
			for (org.getspout.spoutapi.material.Material armor:StoreHashmaps.customarmor) {
        		customMaterialsList.add(armor);
        	}
        	for (Material material:StoreHashmaps.armor) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("Mechanisms")){
			for (org.getspout.spoutapi.material.Material mechanisms:StoreHashmaps.custommechanisms) {
        		customMaterialsList.add(mechanisms);
        	}
        	for (Material material:StoreHashmaps.mechanisms) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("Gardening")){
			for (org.getspout.spoutapi.material.Material plant:StoreHashmaps.customgardening) {
        		customMaterialsList.add(plant);
        	}
        	for (Material material:StoreHashmaps.gardening) {
        		if(material.equals(Material.SAPLING) || material.equals(Material.LONG_GRASS) || material.equals(Material.LEAVES)){
        			for(int idata = 0; idata < Methods.getDataAmount(material);idata++){
        				dataMaterialsList.add(new ItemStack(material, 1, (short) idata));
        			}
        		}else{
        			materialsList.add(material);
        		}
        	}
		}else if(subgroupstr.equals("Raw Materials")){
			for (org.getspout.spoutapi.material.Material tool:StoreHashmaps.customrawmaterials) {
        		customMaterialsList.add(tool);
        	}
        	for (Material material:StoreHashmaps.rawmaterials) {
        		if(material.equals(Material.COAL)){
        			for(int idata = 0; idata < Methods.getDataAmount(material);idata++){
        				dataMaterialsList.add(new ItemStack(material, 1, (short) idata));
        			}
        		}else{
        			materialsList.add(material);
        		}
        	}
		}else if(subgroupstr.equals("Furniture")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.customfurniture) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.furniture) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("Miscellaneous")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.custommisc) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.misc) {
        		if(material.equals(Material.MONSTER_EGG)){
        			for(int idata = 0; idata < Methods.getDataAmount(material);idata++){
        				dataMaterialsList.add(new ItemStack(material, 1, monsterEggData[idata]));
        			}
        		}else{
        			materialsList.add(material);
        		}
        	}
		}else if(subgroupstr.equals("Materials")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.custommaterials) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.materials) {
        		if(material.equals(Material.LOG) || material.equals(Material.WOOD) || material.equals(Material.SANDSTONE) || material.equals(Material.LEAVES) || material.equals(Material.SMOOTH_BRICK) || material.equals(Material.STEP) || material.equals(Material.DOUBLE_STEP)){
        			for(int idata = 0; idata < Methods.getDataAmount(material);idata++){
        				dataMaterialsList.add(new ItemStack(material, 1, (short) idata));
        			}
        		}else{
        			materialsList.add(material);
        		}
        	}
		}else if(subgroupstr.equals("Nether")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.customnether) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.nether) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("The End")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.customtheend) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.theend) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("Ores")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.customores) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.ores) {
        		materialsList.add(material);
        	}
		}else if(subgroupstr.equals("Painting")){
			for (org.getspout.spoutapi.material.Material material:StoreHashmaps.custompainting) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.painting) {
        		if(material.equals(Material.WOOL) || material.equals(Material.INK_SACK)){
        			for(int idata = 0; idata < Methods.getDataAmount(material); idata++){
        				dataMaterialsList.add(new ItemStack(material, 1, (short) idata));
        			}
        		}else{
        			materialsList.add(material);
        		}
        	}
        }else if(subgroupstr.equals("Mob Drops")){
        	for (org.getspout.spoutapi.material.Material material:StoreHashmaps.custommobdrops) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.mobdrops) {
        		materialsList.add(material);
        	}
        }else if(subgroupstr.equals("Brewing")){
        	for (org.getspout.spoutapi.material.Material material:StoreHashmaps.custombrewing) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.brewing) {
        		materialsList.add(material);
        	}
        }else if(subgroupstr.equals("Music")){
        	for (org.getspout.spoutapi.material.Material material:StoreHashmaps.custommusic) {
        		customMaterialsList.add(material);
        	}
        	for (Material material:StoreHashmaps.music) {
        		materialsList.add(material);
        	}
        }
		
		materials = new Material[materialsList.size()];
		dataMaterials = new ItemStack[dataMaterialsList.size()];
		customMaterials = new org.getspout.spoutapi.material.Material[customMaterialsList.size()];
		
		i = 0;
		for(Material material:materialsList){
			materials[i] = material;
			i++;
		}
		i = 0;
		for(ItemStack material:dataMaterialsList){
			dataMaterials[i] = material;
			i++;
		}
		i = 0;
		for(org.getspout.spoutapi.material.Material material:customMaterialsList){
			customMaterials[i] = material;
			i++;
		}
		
		createPopup(attach, remove, subgroupstr);
	}
	private int length;
	private void createPopup(boolean attach, boolean remove, String type) {
		if(remove){
			popup.removeWidgets(plugin);
		}
		
		this.type = type;
		length = materials.length + customMaterials.length + dataMaterials.length;
		
		maxPage = (int) (Math.ceil((length/10.0) -1));
    	
    	int i1 = page * 10;
		int i2 = i1 + 10;
		
		if(i2 > length){
			i2 = length;
		}
		
		for(int row = i1; row < i2; row++){
			int pos = (page > 0 ? row-(page*10) : row);
			if(row < customMaterials.length){
				price = Configuration.store.getInt("Store.custom." + type + "."+ customMaterials[row].getName() +".Buy Price");
				popup.attachWidget(plugin, new GenericItemWidget(new SpoutItemStack(customMaterials[row])).setDepth(18).setHeight(18).setWidth(18).setTooltip(customMaterials[row].getName()).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
				
				popup.attachWidget(plugin, new GenericLabel().setText(customMaterials[row].getName()).setX(X + 21).setHeight(10).setY((Y + 5 + (pos * 20))).setAnchor(anchor));
								
				if(PlayerConfig.getMoney(splayer.getName()) >= price){
					popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price +" "+ currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price +" "+ currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				}
				
				//level
				if(RpgEssentials.RpgLeveling != null){
					RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
					Skill skill = Methods.getCustomSkill(customMaterials[row]);
					if(skill != null){
						if(rpgplayer.getLvl(skill) >= me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + customMaterials[row].getName())){
							popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + customMaterials[row].getName())).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
						} else {
							popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + customMaterials[row].getName())).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
						}
					}else{
						popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY((Y + 5 + (pos * 20))).setAnchor(anchor));
					}
				}
				
				//buy
				if(PlayerConfig.getMoney(splayer.getName()) >= price && StoreHashmaps.buycustomitems.contains(customMaterials[row])){
					popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));	
				}
				
				if(customMaterials[row] instanceof GenericCustomItem){
					ItemStack[] items = splayer.getInventory().getContents();
					boolean sell = false;
					for(int i = 0; i < items.length; i++){
						if(items[i] != null){
							if(items[i].getTypeId() == 318 && items[i].getDurability() == ((GenericCustomItem) customMaterials[row]).getCustomId()){
								sell = true;
								break;
							}
						}
					}
					//sell
					if(sell && StoreHashmaps.sellcustomitems.contains(customMaterials[row])){
						popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
					} else {
						popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));	
					}
				}else{
					ItemStack[] items = splayer.getInventory().getContents();
					boolean sell = false;
					for(int i = 0; i < items.length; i++){
						if(items[i] != null){
							if(items[i].getTypeId() == ((GenericCustomBlock) customMaterials[row]).getBlockId() && items[i].getDurability() == ((GenericCustomBlock) customMaterials[row]).getCustomId()){
								sell = true;
								break;
							}
						}
					}
					//sell
					if(sell && StoreHashmaps.sellcustomblocks.contains(customMaterials[row])){
						popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
					} else {
						popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));	
					}
				}
			}else if(row < (customMaterials.length + dataMaterials.length)){
				int id = row - customMaterials.length;
				
				data = dataMaterials[id].getDurability();
				
				String name2 = Methods.getDataName(dataMaterials[id].getType(), data);
				price = Configuration.store.getInt("Store." + type + "."+ dataMaterials[id].getType().toString().toLowerCase().replace("_", " ") +".Buy Price");
				popup.attachWidget(plugin, new GenericItemWidget(dataMaterials[id]).setData(data).setDepth(18).setHeight(18).setWidth(18).setTooltip(dataMaterials[id].getType().toString().toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
				
				popup.attachWidget(plugin, new GenericLabel().setText(name2).setX(X + 21).setHeight(10).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				
				if(PlayerConfig.getMoney(splayer.getName()) >= price){
					popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price +" "+ currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price +" "+ currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				}
				
				//level
				if(RpgEssentials.RpgLeveling != null){
					RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
					Skill skill = Methods.getSkill(dataMaterials[id].getType());
					if(skill != null){
						if(rpgplayer.getLvl(skill) >= me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + dataMaterials[id].getType().toString().toLowerCase().replace("_", " "))){
							popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + dataMaterials[id].getType().toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
						} else {
							popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + dataMaterials[id].getType().toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
						}
					}else{
						popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
					}
				}
				
				//buy
				if(PlayerConfig.getMoney(splayer.getName()) >= price && StoreHashmaps.buy.contains(dataMaterials[id].getType())){
					popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));	
				}
				
				//sell
				ItemStack[] items = splayer.getInventory().getContents();
				boolean sell = false;
				for(int i = 0; i < items.length; i++){
					if(items[i] != null){
						if(items[i].getType().equals(dataMaterials[id].getType()) && items[i].getDurability() == data){
							sell = true;
							break;
						}
					}
				}
				if(sell && StoreHashmaps.sell.contains(dataMaterials[id].getType())){
					popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));	
				}
			}else if(row < (length)){
				int id = row - customMaterials.length - dataMaterials.length;
				price = Configuration.store.getInt("Store." + type + "."+ materials[id].toString().toLowerCase().replace("_", " ") +".Buy Price");
				popup.attachWidget(plugin, new GenericItemWidget(new ItemStack(materials[id])).setDepth(18).setHeight(18).setWidth(18).setTooltip(materials[id].toString().toLowerCase().replace("_", " ")).setX(X).setY(Y + (pos * 20)).setAnchor(anchor));
				
				popup.attachWidget(plugin, new GenericLabel().setText(materials[id].toString().toLowerCase().replace("_", " ")).setX(X + 21).setHeight(10).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				
				//money
				if(PlayerConfig.getMoney(splayer.getName()) >= price){
					popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText(price +" "+ currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText(price +" "+ currency).setHeight(10).setX(X + 220).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
				}
				
				//level
				if(RpgEssentials.RpgLeveling != null){
					RpgPlayer rpgplayer = RpgEssentials.pm.getRpgPlayer(splayer);
					Skill skill = Methods.getSkill(materials[id]);
					if(skill != null){
						if(rpgplayer.getLvl(skill) >= me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + materials[id].toString().toLowerCase().replace("_", " "))){
							popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(0, 1.0F, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + materials[id].toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
						} else {
							popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 0, 0, 1.0F)).setText("Level: " + me.duckdoom5.RpgEssentials.RpgLeveling.Config.Configuration.level.getInt("UnlockLevel." + materials[id].toString().toLowerCase().replace("_", " "))).setTooltip("Required level").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
						}
					}else{
						popup.attachWidget(plugin, new GenericLabel().setTextColor(new Color(1.0F, 1.0F, 0, 1.0F)).setText("No Unlocks").setHeight(10).setX(X + 130).setY(Y + 5 + (pos * 20)).setAnchor(anchor));
					}
				}
				
				//buy
				if(PlayerConfig.getMoney(splayer.getName()) >= price && StoreHashmaps.buy.contains(materials[id])){
					popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(true).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericButton("Buy").setEnabled(false).setWidth(50).setHeight(20).setX(X + 300).setY(Y + (pos * 20)).setAnchor(anchor));	
				}
				//sell
				if(splayer.getInventory().contains(materials[id]) && StoreHashmaps.sell.contains(materials[id])){
					popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(true).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));
				} else {
					popup.attachWidget(plugin, new GenericButton("Sell").setEnabled(false).setWidth(50).setHeight(20).setX(X + 350).setY(Y + (pos * 20)).setAnchor(anchor));	
				}
			}
		}
		
		double money = PlayerConfig.getMoney(splayer.getName());
		amount.setText(amountText);
		popup.attachWidget(plugin, amount);
		moneylb.setText(Double.toString(money));
		popup.attachWidget(plugin, moneylb);
		popup.attachWidget(plugin, storelb);
		
		popup.attachWidget(plugin, new GenericButton("Next").setEnabled(page==maxPage?false:true).setTooltip("Next page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(+ 100).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, new GenericButton("Prev").setEnabled(page==0?false:true).setTooltip("Previous page").setWidth(100).setHeight(20).shiftYPos(- 20).shiftXPos(- 200).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		popup.attachWidget(plugin, close);
    	popup.attachWidget(plugin, back);
		popup.attachWidget(plugin, BG);
		
		if(attach){
			GuiManager.close(splayer);
			GuiManager.attach(splayer, popup, plugin);
		}
	}
	
	public void setMoney(double money){
		moneylb.setText(Double.toString(money));
	}
	
	public void setAmount(String amountText){
		this.amountText = amountText;
		amount.setText(amountText);
	}
	
	public String getAmount(){
		return amountText;
	}
	
	public String getType(){
		return type;
	}
	
	public int getCustomLength(){
		return customMaterials.length;
	}
	
	public int getDataLength(){
		return dataMaterials.length;
	}
	
	public int getMaterialLength(){
		return materials.length;
	}
	
	public org.getspout.spoutapi.material.Material getCustomMaterial(int row){
		return customMaterials[row];
	}
	
	public  ItemStack getDataMaterial(int row){
		return dataMaterials[row - customMaterials.length];
	}
	
	public Material getMaterial(int row){
		return materials[row - customMaterials.length - dataMaterials.length];
	}
	
	public void save() {
		
	}

	@Override
	public GenericPopup getPopup() {
		return popup;
	}
}
