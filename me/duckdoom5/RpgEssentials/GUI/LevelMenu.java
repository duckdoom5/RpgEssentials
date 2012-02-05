package me.duckdoom5.RpgEssentials.GUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.levels.LevelingSystem;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericItemWidget;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.ScreenType;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class LevelMenu extends GenericPopup{
	
	static YamlConfiguration playerconfig = new YamlConfiguration();
	private static String connectionString;
	private static PreparedStatement pst;
	private static int Y = 15;
	private static int X = -165;
	public static void open(Plugin plugin, SpoutPlayer splayer) {
		GenericTexture BG = (GenericTexture) new GenericTexture().setUrl("http://82.74.70.243/server/shop/bg.png").setMinWidth(800).setMinHeight(400).setPriority(RenderPriority.High).setAnchor(WidgetAnchor.TOP_LEFT);
		GenericPopup stats = new GenericPopup();
		if(splayer.getActiveScreen() != ScreenType.GAME_SCREEN){
			try {
				splayer.getMainScreen().getActivePopup().close();
			} catch (Exception e) {
			}
		}
		try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://82.74.70.243:3306/Users";
        String user = "bukkit";
        try {
            con = DriverManager.getConnection(url, user, "bukkit");
            st = con.createStatement();
            rs = st.executeQuery("SELECT skillpoints FROM users WHERE MC_name = \"" + splayer.getName() + "\"");

            if (rs.next()) {
            	playerconfig.set("players." + splayer.getName() + ".SP", rs.getInt(1));
                try {
					playerconfig.save("plugins/RpgEssentials/Players.yml");
				} catch (IOException e) {
					e.printStackTrace();
				}
            }

        } catch (SQLException ex) {
            System.out.println(ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
            	System.out.println(ex);
            }
        }
        
        try {
			playerconfig.load("plugins/RpgEssentials/Players.yml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] names = {"Mining", "Woodcutting", "Farming", "Attack", "Defence", "Firemaking", "Construction", "Excavation", "Cooking", "Ranged", "Smithing"};
		WidgetAnchor anchor;
		stats.removeWidgets(plugin);
		int sp = playerconfig.getInt("players." + splayer.getName() + ".SP");
		for(int row = 0; row < names.length; row++){
			anchor = WidgetAnchor.TOP_CENTER;
			int currentlevel = playerconfig.getInt("players." + splayer.getName() + "." + names[row] + ".level");
			stats.attachWidget(plugin, new GenericItemWidget(new ItemStack(getmaterial(names[row]))).setDepth(8).setHeight(8).setWidth(8).setTooltip(names[row]).setX(X).setY((int) (Y + (row * 20))).setAnchor(anchor));
			stats.attachWidget(plugin, new GenericLabel().setText(names[row]).setHeight(10).setX(X + 22).setY((int) (Y + 5 + (row * 20))).setAnchor(anchor));
			stats.attachWidget(plugin, new GenericLabel().setText(currentlevel+"/"+currentlevel).setHeight(10).setX(X + 150).setY((int) (Y + 5 + (row * 20))).setAnchor(anchor));
			stats.attachWidget(plugin, new GenericButton("Spend").setEnabled(sp>0?true:false).setHeight(20).setX(X + 200).setY((int) (Y + (row * 20))).setAnchor(anchor));
			stats.attachWidget(plugin, new GenericButton("Unlockables").setEnabled(sp>0?true:false).setHeight(20).setWidth(70).setX(X + 260).setY((int) (Y + (row * 20))).setAnchor(anchor));
			
			stats.attachWidget(plugin,BG);
		}
		GenericLabel points = new GenericLabel();
		stats.attachWidget(plugin, new GenericItemWidget(new ItemStack(Material.DIAMOND_SWORD)).setDepth(8).setHeight(8).setWidth(8).shiftXPos(- 50).shiftYPos(- 40).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		stats.attachWidget(plugin, new GenericLabel().setText("Combat level: " + playerconfig.getInt("players." + splayer.getName() + ".combatlvl")).setWidth(60).setHeight(15).shiftXPos(- 30).shiftYPos(- 40).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		stats.attachWidget(plugin, new GenericLabel().setText("Skill Points: " + sp).setWidth(60).setHeight(15).shiftXPos(- 30).shiftYPos(- 30).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		stats.attachWidget(plugin, new GenericButton("Get Free Skill Points !").setWidth(200).setHeight(20).shiftXPos(- 100).shiftYPos(- 20).setAnchor(WidgetAnchor.BOTTOM_CENTER));
		stats.attachWidget(plugin, new GenericLabel().setText("Stats").setHeight(15).setWidth(30).shiftXPos(- 15).setAnchor(WidgetAnchor.TOP_CENTER));
		
		splayer.getMainScreen().attachPopupScreen(stats);
	}

	private static Material getmaterial(String type) {
		if(type == "Mining"){
			return Material.DIAMOND_PICKAXE;
		}else if(type == "Woodcutting"){
			return Material.DIAMOND_AXE;
		}else if(type == "Farming"){
			return Material.DIAMOND_HOE;
		}else if(type == "Attack"){
			return Material.DIAMOND_SWORD;
		}else if(type == "Defence"){
			return Material.DIAMOND_CHESTPLATE;
		}else if(type == "Firemaking"){
			return Material.FLINT_AND_STEEL;
		}else if(type == "Construction"){
			return Material.WOOD_DOOR;
		}else if(type == "Excavation"){
			return Material.DIAMOND_SPADE;
		}else if(type == "Cooking"){
			return Material.FURNACE;
		}else if(type == "Ranged"){
			return Material.BOW;
		}else{
			return Material.IRON_INGOT;
		}
	}

	public static void getpoints(RpgEssentials plugin, SpoutPlayer splayer) {	
	}

	public static void spend(RpgEssentials plugin, SpoutPlayer splayer, Button button) {
		Connection con = null;
        Statement st = null;

        String url = "jdbc:mysql://82.74.70.243:3306/users";
        String user = "bukkit";
        int sp = playerconfig.getInt("players." + splayer.getName() + ".SP");
        playerconfig.set("players." + splayer.getName() + ".SP", sp - 1);
		try {
            con = DriverManager.getConnection(url, user, "bukkit");
            st = con.createStatement();
            st.executeUpdate("UPDATE users SET skillpoints='" + (sp-1>=0?sp-1:sp) + "' WHERE MC_name = \"" + splayer.getName() + "\"");

        } catch (SQLException ex) {
            System.out.println(ex);

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
            	System.out.println(ex);
            }
        }
		
		int row = (int) ((button.getY() -Y) / 12.5);
		WidgetAnchor anchor = (button.getAnchor());
		if(anchor.equals(WidgetAnchor.TOP_CENTER)){
			row = row + 1;
		}
		String Skill;
		if(row == 0){
			Skill = "Mining";
		}else if(row == 1){
			Skill = "Woodcutting";
		}else if(row == 2){
			Skill = "Farming";
		}else if(row == 3){
			Skill = "Attack";
		}else if(row == 4){
			Skill = "Defence";
		}else if(row == 5){
			Skill = "Firemaking";
		}else if(row == 6){
			Skill = "Construction";
		}else if(row == 7){
			Skill = "Excavation";
		}else if(row == 8){
			Skill = "Cooking";
		}else if(row == 9){
			Skill = "Ranged";
		}else{
			Skill = "Smithing";
		}
		int old = playerconfig.getInt("players." + splayer.getName() + "." + Skill + ".level");
		int currentlevel = playerconfig.getInt("players." + splayer.getName() + "." + Skill + ".level");
		int xptolvl = 0;
		for(int level = 0; level <= currentlevel; level++){
			xptolvl += (int) Math.floor( Math.floor( ( Math.pow(2.0, (level/7.5)) * (level + 300) ) ) / 4 );
		}
		playerconfig.set("players." + splayer.getName() + "." + Skill + ".exp", xptolvl);
		playerconfig.set("players." + splayer.getName() + "." + Skill + ".level", old +1);
		try {
			playerconfig.save("plugins/RpgEssentials/Players.yml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		LevelingSystem.checknewcombat(splayer, plugin);
		open(plugin, splayer);
		
	}
	public static void leaderboard(Plugin plugin, SpoutPlayer splayer){
		
	}
}
