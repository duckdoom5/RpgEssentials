package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.topcat.npclib.entity.HumanNPC;
import com.topcat.npclib.entity.NPC;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Config.Configuration;
import me.duckdoom5.RpgEssentials.RpgQuests.GUI.TextSelectMenu;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.BreakTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.CraftTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.DeliveryTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.EscortTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.KillTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.PlaceTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.SmeltTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TalkToTask;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task.TaskType;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TaskState;
import me.duckdoom5.RpgEssentials.RpgRegions.RpgRegions;
import me.duckdoom5.RpgEssentials.util.MessageUtils;

public class QuestHandler {
		
	private RpgQuests plugin;
	
	public QuestHandler(RpgQuests plugin){
		this.plugin = plugin;
	}
	
	/**
	 * 
	 * @param rpgplayer player to check for
	 * @param type type of task to check for
	 * @param e event to run
	 */
	
	public void startQuestCheck(RpgPlayer rpgplayer, TaskType type, Event e){
		for(Quest quest:RpgQuests.qm.getQuests()){
			QuestState state = rpgplayer.getQuestState(quest);
			if(state.equals(QuestState.STARTED)){
				for(Task task:quest.getTasks()){
					if(task.getType().equals(type)){
						startTaskCheck(quest, rpgplayer, task, e);
					}
				}
			}
		}
	}
	
	private void startTaskCheck(Quest quest, RpgPlayer rpgplayer, Task task, Event e){
		if(task.getType().equals(TaskType.PLACE)){
			PlaceTask placetask = (PlaceTask)task;
			BlockPlaceEvent event = (BlockPlaceEvent)e;
			Material material = event.getBlock().getType();
			
			if(material != placetask.getMaterial())
				return;
			
			if(event.getBlock().getData() != placetask.getDurability())
				return;
			
			if(placetask.getAmount() == 1){
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}else{
				if(placetask.remaining.containsKey(rpgplayer)){
					int amount = placetask.remaining.get(rpgplayer);
					if((amount - 1) == placetask.getAmount()){
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
						rpgplayer.setTaskState(task, TaskState.DONE);
					}else{
						placetask.remaining.put(rpgplayer, amount - 1);
						rpgplayer.setTaskState(task, TaskState.STARTED);
					}
					
				}else{
					placetask.remaining.put(rpgplayer, placetask.getAmount() -1);
					rpgplayer.setTaskState(task, TaskState.DONE);
				}
			}
		}else if(task.getType().equals(TaskType.BREAK)){
			BreakTask breaktask = (BreakTask)task;
			BlockBreakEvent event = (BlockBreakEvent)e;
			Material material = event.getBlock().getType();
			
			if(material != breaktask.getMaterial())
				return;
			
			if(event.getBlock().getData() != breaktask.getDurability())
				return;
			
			if(breaktask.getAmount() == 1){
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}else{
				if(breaktask.remaining.containsKey(rpgplayer)){
					int amount = breaktask.remaining.get(rpgplayer);
					if((amount - 1) == breaktask.getAmount()){
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
						rpgplayer.setTaskState(task, TaskState.DONE);
					}else{
						breaktask.remaining.put(rpgplayer, amount - 1);
						rpgplayer.setTaskState(task, TaskState.STARTED);
					}
				}else{
					breaktask.remaining.put(rpgplayer, breaktask.getAmount() -1);
				}
			}
		}else if(task.getType().equals(TaskType.CRAFT)){
			CraftTask crafttask = (CraftTask)task;
			InventoryClickEvent event = (InventoryClickEvent)e;
			Material material = event.getCurrentItem().getType();
			
			if(material != crafttask.getMaterial())
				return;
			
			if(event.getCurrentItem().getDurability() != crafttask.getDurability())
				return;
			
			if(crafttask.getAmount() == 1){
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}else{
				if(crafttask.remaining.containsKey(rpgplayer)){
					int amount = crafttask.remaining.get(rpgplayer);
					if((amount - 1) == crafttask.getAmount()){
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
						rpgplayer.setTaskState(task, TaskState.DONE);
					}else{
						crafttask.remaining.put(rpgplayer, amount - 1);
						rpgplayer.setTaskState(task, TaskState.STARTED);
					}
				}else{
					crafttask.remaining.put(rpgplayer, crafttask.getAmount() -1);
				}
			}
		}else if(task.getType().equals(TaskType.SMELT)){
			SmeltTask smelttask = (SmeltTask)task;
			InventoryClickEvent event = (InventoryClickEvent)e;
			Material material = event.getCurrentItem().getType();
			
			if(material != smelttask.getMaterial())
				return;
			
			if(event.getCurrentItem().getDurability() != smelttask.getDurability())
				return;
			
			if(smelttask.getAmount() == 1){
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}else{
				if(smelttask.remaining.containsKey(rpgplayer)){
					int amount = smelttask.remaining.get(rpgplayer);
					if((amount - 1) == smelttask.getAmount()){
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
						rpgplayer.setTaskState(task, TaskState.DONE);
					}else{
						smelttask.remaining.put(rpgplayer, amount - 1);
						rpgplayer.setTaskState(task, TaskState.STARTED);
					}
				}else{
					smelttask.remaining.put(rpgplayer, smelttask.getAmount() -1);
				}
			}
		}else if(task.getType().equals(TaskType.DELIVER)){
			DeliveryTask deliverytask = (DeliveryTask)task;
			InventoryClickEvent event = (InventoryClickEvent)e;
			Material material = event.getCurrentItem().getType();
			
			if(material != deliverytask.getMaterial())
				return;
			
			if(event.getCurrentItem().getDurability() != deliverytask.getDurability())
				return;
			
			if(deliverytask.getAmount() == 1){
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}else{
				//TODO edit amount-1 to actual item remover...
				
				if(deliverytask.remaining.containsKey(rpgplayer)){
					int amount = deliverytask.remaining.get(rpgplayer);
					if((amount - 1) == deliverytask.getAmount()){
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
						rpgplayer.setTaskState(task, TaskState.DONE);
					}else{
						deliverytask.remaining.put(rpgplayer, amount - 1);
						rpgplayer.setTaskState(task, TaskState.STARTED);
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have " + (amount - 1) + " " + deliverytask.getMaterial().toString().toLowerCase().replace("_", " ") +" remaining before you have completed this task!");
					}
				}else{
					deliverytask.remaining.put(rpgplayer, deliverytask.getAmount() -1);
				}
			}
		}else if(task.getType().equals(TaskType.KILL)){
			KillTask killtask = (KillTask)task;
			EntityDeathEvent event = (EntityDeathEvent)e;
			EntityType type = event.getEntityType();
			
			if(type != killtask.getEntityType())
				return;
			
			if(killtask.getAmount() == 1){
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}else{
				if(killtask.remaining.containsKey(rpgplayer)){
					int amount = killtask.remaining.get(rpgplayer);
					if((amount - 1) == killtask.getAmount()){
						((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
						rpgplayer.setTaskState(task, TaskState.DONE);
					}else{
						killtask.remaining.put(rpgplayer, amount - 1);
						rpgplayer.setTaskState(task, TaskState.STARTED);
					}
				}else{
					killtask.remaining.put(rpgplayer, killtask.getAmount() -1);
				}
			}
		}else if(task.getType().equals(TaskType.ESCORT)){
			EscortTask escorttask = (EscortTask)task;
			PlayerMoveEvent event = (PlayerMoveEvent)e;
			Player player = event.getPlayer();
			
			if(RpgEssentials.RpgRegions != null){
				if(!RpgRegions.listener.isInRegion(player))
					return;
				
				String region = RpgRegions.listener.getRegion(player);
				
				if(!region.equals(escorttask.getRegionName()))
					return;
				
			}else{
				if(!event.getTo().toVector().equals(escorttask.getLocation().toVector()))
					return;
			}
			
			rpgplayer.setTaskState(task, TaskState.DONE);
			((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			
		}else if(task.getType().equals(TaskType.TALKTO)){
			TalkToTask talktotask = (TalkToTask)task;
			PlayerInteractEntityEvent event = (PlayerInteractEntityEvent)e;
			
			NPC npc = talktotask.getNpcToTalkTo();
			
			if(RpgEssentials.nm.isNPC(event.getRightClicked()) && RpgEssentials.nm.getNPCIdFromEntity(event.getRightClicked()).equals(npc)){
				event.getPlayer();
				
				String text = talktotask.getText();
				
				String [] buttons = {"Close"};
				TextSelectMenu menu = new TextSelectMenu(plugin, (SpoutPlayer)rpgplayer.getPlayer(), quest.getName(), MessageUtils.TextMenuSplit(text), buttons, EntityType.PLAYER);
				
				
				rpgplayer.setTaskState(task, TaskState.DONE);
				((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
			}
		}
		
		if(isFinished(rpgplayer, quest, true)){
			((Player)rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed quest \"" + quest.getName() + "\"");
		}
	}
	
	/**
	 * 
	 * @param rpgplayer RpgPlayer to check
	 * @param quest quest to check
	 * @param save true if you want to save QuestState.COMPLETED to the RpgPlayer
	 * @return returns true if the quest is finished
	 */
	
	public boolean isFinished(RpgPlayer rpgplayer, Quest quest, boolean save){
		for(Task task:quest.getTasks()){
			if(!rpgplayer.getTaskState(task).equals(TaskState.DONE))
				return false;
		}
		if(save){
			rpgplayer.setQuestState(quest, QuestState.COMPLETED);
		}
		return true;
	}
	
	public void npcRightClicked(NPC npc, RpgPlayer rpgplayer){
		boolean showDone = false;
		Quest doneQuest = null;
		for(Quest quest:RpgQuests.qm.getQuests()){
			if(rpgplayer.getQuestState(quest).equals(QuestState.UNSTARTED)){
				((Player)rpgplayer.getPlayer()).sendMessage("unstarted");
				if(quest.getQuestGiver().equalsIgnoreCase(((HumanNPC)npc).getName())){
					((Player)rpgplayer.getPlayer()).sendMessage("true");
					showDone = false;
					
					String welcome = quest.getStartText();
					String task = quest.getTaskText();
					String [] raw = MessageUtils.TextMenuSplit(task);
					String [] text = new String[raw.length + 1];
					for(int i = 0; i - 1 < raw.length; i++){
						if(i == 0){
							text[i] = welcome;
						}else{
							text[i] = raw[i-1];
						}
					}
					String [] buttons = {"Accept Quest", "Close"};
					((Player)rpgplayer.getPlayer()).sendMessage("open");
					
					TextSelectMenu menu = new TextSelectMenu(plugin, quest, ((SpoutPlayer)rpgplayer.getPlayer()), quest.getName(), text, buttons, EntityType.PLAYER);
					break;
				}
			}else if(rpgplayer.getQuestState(quest).equals(QuestState.STARTED)){
				if(quest.getQuestGiver().equalsIgnoreCase(((HumanNPC)npc).getName())){
					for(Task task:RpgQuests.qm.getCurrentTasks(quest, rpgplayer)){
						if(task.getType().equals(TaskType.DELIVER)){
							
						}else{
							showDone = false;
		
							String text = quest.getBetweenText();
							String [] buttons = {"Close"};
							TextSelectMenu menu = new TextSelectMenu(plugin, (SpoutPlayer)rpgplayer.getPlayer(), quest.getName(), MessageUtils.TextMenuSplit(text), buttons, EntityType.PLAYER);
						}
					}
					break;
				}
			}else if(rpgplayer.getQuestState(quest).equals(QuestState.COMPLETED)){
				if(quest.getQuestEnder().equalsIgnoreCase(((HumanNPC)npc).getName())){
					showDone = false;

					String text = quest.getCompleteText();
					String [] buttons = {"Close"};
					TextSelectMenu menu = new TextSelectMenu(plugin, (SpoutPlayer)rpgplayer.getPlayer(), quest.getName(), MessageUtils.TextMenuSplit(text), buttons, EntityType.PLAYER);
					
					break;
				}
			}else if(rpgplayer.getQuestState(quest).equals(QuestState.DONE)){
				if(quest.getQuestEnder().equalsIgnoreCase(((HumanNPC)npc).getName())){
					showDone = true;
					doneQuest = quest;
				}
			}
		}
		
		if(showDone){
			String text = doneQuest.getDoneText();
			String [] buttons = {"Close"};
			TextSelectMenu menu = new TextSelectMenu(plugin, (SpoutPlayer)rpgplayer.getPlayer(), doneQuest.getName(), MessageUtils.TextMenuSplit(text), buttons, EntityType.PLAYER);
		}
	}
	
	public static void accepted(RpgQuests plugin, RpgPlayer rpgplayer, Quest quest){
		String name = quest.getId();
		
		rpgplayer.setQuestState(quest, QuestState.STARTED);
		
		String [] buttons = {"Close"};
		TextSelectMenu menu = new TextSelectMenu(plugin, ((SpoutPlayer)rpgplayer.getPlayer()), name, MessageUtils.TextMenuSplit("Accepted " + name), buttons, EntityType.PLAYER);
	}
}
