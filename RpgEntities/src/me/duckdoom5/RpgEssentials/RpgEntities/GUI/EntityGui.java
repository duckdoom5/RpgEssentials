package me.duckdoom5.RpgEssentials.RpgEntities.GUI;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.GUI.Gui;
import me.duckdoom5.RpgEssentials.GUI.GuiManager;
import me.duckdoom5.RpgEssentials.RpgEntities.RpgEntities;
import me.duckdoom5.RpgEssentials.RpgEntities.Config.Configuration;
import me.duckdoom5.RpgEssentials.util.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.getspout.spoutapi.event.screen.TextFieldChangeEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericEntityWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class EntityGui extends Gui {
    private final GenericButton close = (GenericButton) new GenericButton("Close").setWidth(200).setHeight(20).shiftYPos(-20).shiftXPos(-100).setAnchor(WidgetAnchor.BOTTOM_CENTER);
    private GenericTexture BG = null;
    private final WidgetAnchor anchor = WidgetAnchor.TOP_CENTER;
    private final GenericLabel label = (GenericLabel) new GenericLabel().setText("Stats").setHeight(15).shiftXPos(-15).setAnchor(anchor);
    private final int spacing;
    private final int Y = 20;
    private final int X = -200;
    private final RpgEssentials plugin2;
    private final LivingEntity e;
    private GenericTextField textfield;
    
    public EntityGui(RpgEntities plugin, RpgEssentials plugin2, SpoutPlayer splayer, LivingEntity e) {
        super(plugin, splayer);
        this.plugin2 = plugin2;
        this.e = e;
        this.spacing = Configuration.entities.getInt("Entities.heart.spacing");
        BG = (GenericTexture) new GenericTexture().setUrl(Configuration.config.getString("Background")).setWidth(splayer.getMainScreen().getWidth()).setHeight(splayer.getMainScreen().getHeight()).setPriority(RenderPriority.Highest);

        //maxPage = (int) (Math.ceil(SkillType.values().length / 9.0) - 1);

        final Gui gui = GuiManager.gui.get(splayer);
        if (gui == null || splayer.getActiveScreen() == ScreenType.GAME_SCREEN) {
            popup = new GenericPopup();
            createPopup(true, false);
        } else {
            popup = gui.getPopup();
            createPopup(false, true);
        }

        GuiManager.gui.put(splayer, this);
    }

    @Override
    protected void createPopup(boolean attach, boolean remove) {
        if (remove) {
            if (plugin2 != null) {
                popup.getPlugin();
                popup.removeWidgets(plugin2);
            }
            popup.removeWidgets(plugin);
        }
        popup.attachWidget(plugin, new GenericTexture().setUrl(getEntityIcon()).setWidth(50).setHeight(50).setX(X).setY(Y).setAnchor(anchor));
        popup.attachWidget(plugin, (textfield = new GenericTextField()).setText(StringUtils.replaceChatColors(e.getCustomName())).setWidth(240).setHeight(18).setX(X + 80).setY(Y).setAnchor(anchor));
        
        double health = e.getHealth();
        double maxHealth = Math.ceil(e.getMaxHealth()/2);
        
        int y = (int) Math.ceil(maxHealth / 10);
        int x = 10;
        
        for(int j = 0; j < y; j++){
            if(j == y-1 && maxHealth % 10 != 0){
                x = (int) Math.ceil(maxHealth % 10);
            }
            for(int i = 0; i < x; i++){
                popup.attachWidget(plugin, new GenericTexture().setUrl(Configuration.entities.getString("Entities.heartbg.icon")).setWidth(9).setHeight(9).setX(X + 80 + spacing * i).setY(Y + 30 + spacing * j).setAnchor(anchor).setPriority(RenderPriority.High));
            }
        }
        
        int y2 = (int) Math.ceil(health / 20);
        int x2 = 20;
        
        for(int j = 0; j < y2; j++){
            if(j == y2-1 && health % 20 != 0){
                x2 = (int) Math.ceil(health % 20);
            }
            for(int i = 0; i < x2; i++){
                if(j == y2-1 && i == x2 - 1){
                    popup.attachWidget(plugin, new GenericTexture().setUrl(Configuration.entities.getString("Entities.halfheart.icon")).setWidth(9).setHeight(9).setX(X + 80 + spacing * i/2).setY(Y + 30 + spacing * j).setAnchor(anchor).setPriority(RenderPriority.Lowest));
                }else{
                    popup.attachWidget(plugin, new GenericTexture().setUrl(Configuration.entities.getString("Entities.heart.icon")).setWidth(9).setHeight(9).setX(X + 80 + spacing * i/2).setY(Y + 30 + spacing * j).setAnchor(anchor).setPriority(RenderPriority.Lowest));
                    i++;
                }
            }
        }
        int level = 80;
        int attackdmg = 10;
        int defense = 3;
        int speed = 10;
        boolean hasInventory = false;
        boolean canMount = true;
        int currentExp = 580;
        int requiredExp = 9000;
        
        popup.attachWidget(plugin, new GenericLabel().setText("Health:").setHeight(10).setX(X + 80).setY(Y + 100).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("Exp Until Next level:").setHeight(10).setX(X + 200).setY(Y + 100).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("Attack:").setHeight(10).setX(X + 80).setY(Y + 110).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("Has Inventory:").setHeight(10).setX(X + 200).setY(Y + 110).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("Defense:").setHeight(10).setX(X + 80).setY(Y + 120).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("Can Mount:").setHeight(10).setX(X + 200).setY(Y + 120).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("Speed:").setHeight(10).setX(X + 80).setY(Y + 130).setAnchor(anchor));
        
        popup.attachWidget(plugin, new GenericLabel().setText("" + ChatColor.DARK_RED + (int)health + "/" + (int)e.getMaxHealth()).setHeight(10).setX(X + 155).setY(Y + 100).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("" + ChatColor.AQUA + (requiredExp - currentExp)).setHeight(10).setX(X + 320).setY(Y + 100).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("" + ChatColor.YELLOW + attackdmg).setHeight(10).setX(X + 155).setY(Y + 110).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("" + (hasInventory ? ChatColor.GREEN : ChatColor.DARK_RED) + StringUtils.UCFirst(String.valueOf(hasInventory))).setHeight(10).setX(X + 320).setY(Y + 110).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("" + ChatColor.GRAY + defense).setHeight(10).setX(X + 155).setY(Y + 120).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("" + (canMount ? ChatColor.GREEN : ChatColor.DARK_RED) + StringUtils.UCFirst(String.valueOf(canMount))).setHeight(10).setX(X + 320).setY(Y + 120).setAnchor(anchor));
        popup.attachWidget(plugin, new GenericLabel().setText("" + ChatColor.BLUE + speed).setHeight(10).setX(X + 155).setY(Y + 130).setAnchor(anchor));
        
        int bgStart = (int) Math.floor(18.0 / requiredExp * currentExp);
        popup.attachWidget(plugin, new GenericLabel().setText("Level:   " + ChatColor.GOLD + level).setHeight(10).shiftYPos(-60).shiftXPos(-30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        popup.attachWidget(plugin, new GenericLabel().setText("Exp: " + ChatColor.AQUA + currentExp + "/" + requiredExp).setHeight(10).shiftYPos(-50).shiftXPos(-30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
        for(int k = 1; k <= 18; k++){
            popup.attachWidget(plugin, new GenericTexture().setUrl("http://rpgessentials.lynxdragon.com/plugin/mobs/exp/" + (k > bgStart ? "bg" : "") + k + ".png").setWidth(10).setHeight(5).setAnchor(anchor).shiftYPos(-40).shiftXPos(-100 + 10 * k).setAnchor(WidgetAnchor.BOTTOM_CENTER).setPriority(RenderPriority.Lowest));
        }
        
        popup.attachWidget(plugin, label);
        popup.attachWidget(plugin, close);
        popup.attachWidget(plugin, BG);

        if (attach) {
            GuiManager.close(splayer);
            GuiManager.attach(splayer, popup, plugin);
        }
    }
    
    private String getEntityIcon(){
        String icon = Configuration.entities.getString("Entities." + e.getType().toString().toLowerCase() + ".faceIcon");
        if(icon == null || icon == ""){
            icon = "htpp://rpgessentials.lynxdragon.com/plugin/mobs/faces/" + e.getType().toString().toLowerCase() + ".png";
        }
        return icon;
        /*switch(e.getType()){
            case BAT:
                return "http://hydra-media.cursecdn.com/minecraft.gamepedia.com/2/2d/BatFace.png?version=ece9782d6aab8709fa916f18cea750db";
            case BLAZE:
                return "";
            case CAVE_SPIDER:
                return "";
            case CHICKEN:
                return "";
            case COW:
                return "";
            case CREEPER:
                return "";
            case ENDER_DRAGON:
                return "";
            case ENDERMAN:
                return "";
            case GHAST:
                return "";
            case HORSE:
                return "";
            case IRON_GOLEM:
                return "";
            case MAGMA_CUBE:
                return "";
            case MUSHROOM_COW:
                return "";
            case OCELOT:
                return "";
            case PIG:
                return "";
            case PIG_ZOMBIE:
                return "";
            case PLAYER:
                return "";
            case SHEEP:
                return "";
            case SILVERFISH:
                return "";
            case SKELETON:
                return "";
            case SLIME:
                return "";
            case SNOWMAN:
                return "";
            case SPIDER:
                return "";
            case SQUID:
                return "";
            case VILLAGER:
                return "";
            case WITCH:
                return "";
            case WITHER:
                return "";
            case WOLF:
                return "http://hydra-media.cursecdn.com/minecraft.gamepedia.com/9/9c/WolfFaceTamed.png?version=29a6202367c9ba3bce65cb155ef0fb9d";
            case GIANT:
            case ZOMBIE:
                return "";
            default:
                return "";
        }*/
    }
    
    public void onTextFieldChange(TextFieldChangeEvent event) {
        if(event.getTextField() == textfield){
            e.setCustomName(ChatColor.translateAlternateColorCodes('&', event.getNewText()));
            if(!e.isCustomNameVisible()){
                e.setCustomNameVisible(true);
            }
        }
    }
}