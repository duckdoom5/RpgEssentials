package me.duckdoom5.RpgEssentials.RpgPets.pets;

import java.io.Serializable;

import net.minecraft.server.Entity;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.EntityTameableAnimal;
import net.minecraft.server.Packet18ArmAnimation;
import net.minecraft.server.WorldServer;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.getspout.spoutapi.Spout;
import org.getspout.spoutapi.player.EntitySkinType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class RpgWolf extends RpgEntity implements Serializable{
	private static final long serialVersionUID = -7969133142360239780L;
	private BeltColor beltcolor;
	
	public RpgWolf(Entity entity, int id){
		super(entity, RpgEntityType.WOLF, id);
	}
	
	public RpgWolf(Entity entity, OfflinePlayer owner, int id){
		super(entity, RpgEntityType.WOLF, owner, "wolf", id);
	}
	
	public void actAsHurt() {
		((WorldServer) getEntity().world).tracker.a(getEntity(), new Packet18ArmAnimation(getEntity(), 2));
	}
	
	public void setAge(int age){
		((Wolf)getBukkitEntity()).setAge(age);
	}
	
	public void lockAge(boolean lock){
		((Wolf)getBukkitEntity()).setAgeLock(lock);
	}
	
	public void setSprinting(boolean sprint){
		getEntity().setSprinting(sprint);
		sprinting = sprint;
		save();
	}
	
	public void setSneaking(boolean sneak) {
		getEntity().setSneaking(sneak);
		sneaking = sneak;
		save();
	}
	
	public void setSitting(boolean sit){
		((EntityTameableAnimal)getEntity()).setSitting(sit);
		sitting = sit;
		save();
	}
	
	public void setBeltColor(BeltColor bc){
		SpoutPlayer splayer = (SpoutPlayer)owner;
		Spout.getServer().setEntitySkin((LivingEntity) getEntity(), bc.getUrl(), EntitySkinType.WOLF_TAMED);
		this.beltcolor = bc;
		save();
		
		Player player = (Player)owner;
		player.sendMessage(ChatColor.GREEN + "Your wolf's belt color is set to " + bc.getChatColor() + bc.toString().toLowerCase().replace("_", " "));
	}
	
	public BeltColor getBeltColor(BeltColor bc){
		return this.beltcolor;
	}
	
	public void lookAtPoint(Location point) {
		if (getEntity().getBukkitEntity().getWorld() != point.getWorld()) {
			return;
		}
		Location npcLoc = ((LivingEntity) getEntity().getBukkitEntity()).getEyeLocation();
		double xDiff = point.getX() - npcLoc.getX();
		double yDiff = point.getY() - npcLoc.getY();
		double zDiff = point.getZ() - npcLoc.getZ();
		double DistanceXZ = Math.sqrt(xDiff * xDiff + zDiff * zDiff);
		double DistanceY = Math.sqrt(DistanceXZ * DistanceXZ + yDiff * yDiff);
		double newYaw = Math.acos(xDiff / DistanceXZ) * 180 / Math.PI;
		double newPitch = Math.acos(yDiff / DistanceY) * 180 / Math.PI - 90;
		if (zDiff < 0.0) {
			newYaw = newYaw + Math.abs(180 - newYaw) * 2;
		}
		getEntity().yaw = (float) (newYaw - 90);
		getEntity().pitch = (float) newPitch;
		((EntityPlayer)getEntity()).as = (float)(newYaw - 90);
	}
	
	public static enum BeltColor{
		WHITE("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/white.png", ChatColor.WHITE),
		ORANGE("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/orange.png", ChatColor.GOLD),
		MAGENTA("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/magenta.png", ChatColor.LIGHT_PURPLE),
		LIGHT_BLUE("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/light_blue.png", ChatColor.AQUA),
		YELLOW("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/yellow.png", ChatColor.YELLOW),
		LIME("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/lime_green.png", ChatColor.GREEN),
		PINK("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/pink.png", ChatColor.LIGHT_PURPLE),
		GRAY("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/gray.png", ChatColor.DARK_GRAY),
		LIGHT_GRAY("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/light_gray.png", ChatColor.GRAY),
		CYAN("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/cyan.png", ChatColor.DARK_AQUA),
		PURPLE("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/purple.png", ChatColor.DARK_PURPLE),
		BLUE("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/dark_blue.png", ChatColor.BLUE),
		BROWN("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/brown.png", ChatColor.GOLD),
		GREEN("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/green.png", ChatColor.DARK_GREEN),
		RED("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/red.png", ChatColor.DARK_RED), 
		BLACK("http://dl.lynxdragon.com/rpgessentials/mobs/wolfs/black.png", ChatColor.BLACK);
		
		private final String url;
		private final ChatColor chatcolor;
		
		BeltColor(String url, ChatColor chatcolor){
			this.url = url;
			this.chatcolor = chatcolor;
		}
		
		public String getUrl(){
			return this.url;
		}
		
		public ChatColor getChatColor(){
			return this.chatcolor;
		}
		
		public static BeltColor getBeltColor(String bc){
			BeltColor beltc = BeltColor.RED;
			bc = bc.toUpperCase().replace(" ", "_");
			for(BeltColor beltcolor:BeltColor.values()){
				if(beltcolor.toString().equals(bc)){
					beltc = beltcolor;
				}
			}
			return beltc;
		}
	}
}
