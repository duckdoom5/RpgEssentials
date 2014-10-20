package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import me.duckdoom5.RpgEssentials.RpgeManager;
import me.duckdoom5.RpgEssentials.Entity.RpgPlayer;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
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

public class QuestHandler {

    private final RpgQuests plugin;

    public QuestHandler(RpgQuests plugin) {
        this.plugin = plugin;
    }

    /**
     * @param rpgplayer
     *            player to check for
     * @param type
     *            type of task to check for
     * @param e
     *            event to run
     */

    public void startQuestCheck(RpgPlayer rpgplayer, TaskType type, Event e) {
        for (final Quest quest : RpgQuests.qm.getQuests()) {
            final QuestState state = rpgplayer.getQuestState(quest);
            if (state.equals(QuestState.STARTED)) {
                for (final Task task : quest.getTasks()) {
                    if (task.getType().equals(type)) {
                        startTaskCheck(quest, rpgplayer, task, e);
                    }
                }
            }
        }
    }

    private void startTaskCheck(Quest quest, RpgPlayer rpgplayer, Task task,
            Event e) {
        if (task.getType().equals(TaskType.PLACE)) {
            final PlaceTask placetask = (PlaceTask) task;
            final BlockPlaceEvent event = (BlockPlaceEvent) e;
            final Material material = event.getBlock().getType();

            if (material != placetask.getMaterial())
                return;

            if (event.getBlock().getData() != placetask.getDurability())
                return;

            if (placetask.getAmount() == 1) {
                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            } else {
                if (placetask.remaining.containsKey(rpgplayer)) {
                    final int amount = placetask.remaining.get(rpgplayer);
                    if ((amount - 1) == placetask.getAmount()) {
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
                        rpgplayer.setTaskState(task, TaskState.DONE);
                    } else {
                        placetask.remaining.put(rpgplayer, amount - 1);
                        rpgplayer.setTaskState(task, TaskState.STARTED);
                    }

                } else {
                    placetask.remaining.put(rpgplayer,
                            placetask.getAmount() - 1);
                    rpgplayer.setTaskState(task, TaskState.DONE);
                }
            }
        } else if (task.getType().equals(TaskType.BREAK)) {
            final BreakTask breaktask = (BreakTask) task;
            final BlockBreakEvent event = (BlockBreakEvent) e;
            final Material material = event.getBlock().getType();

            if (material != breaktask.getMaterial())
                return;

            if (event.getBlock().getData() != breaktask.getDurability())
                return;

            if (breaktask.getAmount() == 1) {
                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            } else {
                if (breaktask.remaining.containsKey(rpgplayer)) {
                    final int amount = breaktask.remaining.get(rpgplayer);
                    if ((amount - 1) == breaktask.getAmount()) {
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
                        rpgplayer.setTaskState(task, TaskState.DONE);
                    } else {
                        breaktask.remaining.put(rpgplayer, amount - 1);
                        rpgplayer.setTaskState(task, TaskState.STARTED);
                    }
                } else {
                    breaktask.remaining.put(rpgplayer,
                            breaktask.getAmount() - 1);
                }
            }
        } else if (task.getType().equals(TaskType.CRAFT)) {
            final CraftTask crafttask = (CraftTask) task;
            final InventoryClickEvent event = (InventoryClickEvent) e;
            final Material material = event.getCurrentItem().getType();

            if (material != crafttask.getMaterial())
                return;

            if (event.getCurrentItem().getDurability() != crafttask.getDurability())
                return;

            if (crafttask.getAmount() == 1) {
                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            } else {
                if (crafttask.remaining.containsKey(rpgplayer)) {
                    final int amount = crafttask.remaining.get(rpgplayer);
                    if ((amount - 1) == crafttask.getAmount()) {
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
                        rpgplayer.setTaskState(task, TaskState.DONE);
                    } else {
                        crafttask.remaining.put(rpgplayer, amount - 1);
                        rpgplayer.setTaskState(task, TaskState.STARTED);
                    }
                } else {
                    crafttask.remaining.put(rpgplayer,
                            crafttask.getAmount() - 1);
                }
            }
        } else if (task.getType().equals(TaskType.SMELT)) {
            final SmeltTask smelttask = (SmeltTask) task;
            final InventoryClickEvent event = (InventoryClickEvent) e;
            final Material material = event.getCurrentItem().getType();

            if (material != smelttask.getMaterial())
                return;

            if (event.getCurrentItem().getDurability() != smelttask.getDurability())
                return;

            if (smelttask.getAmount() == 1) {
                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            } else {
                if (smelttask.remaining.containsKey(rpgplayer)) {
                    final int amount = smelttask.remaining.get(rpgplayer);
                    if ((amount - 1) == smelttask.getAmount()) {
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
                        rpgplayer.setTaskState(task, TaskState.DONE);
                    } else {
                        smelttask.remaining.put(rpgplayer, amount - 1);
                        rpgplayer.setTaskState(task, TaskState.STARTED);
                    }
                } else {
                    smelttask.remaining.put(rpgplayer,
                            smelttask.getAmount() - 1);
                }
            }
        } else if (task.getType().equals(TaskType.DELIVER)) {
            final DeliveryTask deliverytask = (DeliveryTask) task;
            final InventoryClickEvent event = (InventoryClickEvent) e;
            final Material material = event.getCurrentItem().getType();

            if (material != deliverytask.getMaterial())
                return;

            if (event.getCurrentItem().getDurability() != deliverytask.getDurability())
                return;

            if (deliverytask.getAmount() == 1) {
                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            } else {
                // TODO edit amount-1 to actual item remover...

                if (deliverytask.remaining.containsKey(rpgplayer)) {
                    final int amount = deliverytask.remaining.get(rpgplayer);
                    if ((amount - 1) == deliverytask.getAmount()) {
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
                        rpgplayer.setTaskState(task, TaskState.DONE);
                    } else {
                        deliverytask.remaining.put(rpgplayer, amount - 1);
                        rpgplayer.setTaskState(task, TaskState.STARTED);
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have " + (amount - 1) + " " + deliverytask.getMaterial().toString().toLowerCase().replace("_", " ") + " remaining before you have completed this task!");
                    }
                } else {
                    deliverytask.remaining.put(rpgplayer,
                            deliverytask.getAmount() - 1);
                }
            }
        } else if (task.getType().equals(TaskType.KILL)) {
            final KillTask killtask = (KillTask) task;
            final EntityDeathEvent event = (EntityDeathEvent) e;
            final EntityType type = event.getEntityType();

            if (type != killtask.getEntityType())
                return;

            if (killtask.getAmount() == 1) {
                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            } else {
                if (killtask.remaining.containsKey(rpgplayer)) {
                    final int amount = killtask.remaining.get(rpgplayer);
                    if ((amount - 1) == killtask.getAmount()) {
                        ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
                        rpgplayer.setTaskState(task, TaskState.DONE);
                    } else {
                        killtask.remaining.put(rpgplayer, amount - 1);
                        rpgplayer.setTaskState(task, TaskState.STARTED);
                    }
                } else {
                    killtask.remaining.put(rpgplayer, killtask.getAmount() - 1);
                }
            }
        } else if (task.getType().equals(TaskType.ESCORT)) {
            final EscortTask escorttask = (EscortTask) task;
            final PlayerMoveEvent event = (PlayerMoveEvent) e;
            final Player player = event.getPlayer();

            if (RpgeManager.getInstance().isAddonEnabled("RpgRegions")) {
                if (!RpgRegions.listener.isInRegion(player))
                    return;

                final String region = RpgRegions.listener.getRegion(player);

                if (!region.equals(escorttask.getRegionName()))
                    return;

            } else {
                if (!event.getTo().toVector().equals(escorttask.getLocation().toVector()))
                    return;
            }

            rpgplayer.setTaskState(task, TaskState.DONE);
            ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");

        } else if (task.getType().equals(TaskType.TALKTO)) {
            final TalkToTask talktotask = (TalkToTask) task;
            final PlayerInteractEntityEvent event = (PlayerInteractEntityEvent) e;

            final NPC npc = RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPC(talktotask.getNpcToTalkTo());

            if (RpgeManager.getInstance().getRpgNpcManager().getNPCManager().isNPC(event.getRightClicked()) && RpgeManager.getInstance().getRpgNpcManager().getNPCManager().getNPCIdFromEntity(event.getRightClicked()).equals(npc)) {
                event.getPlayer();

                final String text = talktotask.getText();

                final String[] buttons = { "Close" };
                final TextSelectMenu menu = new TextSelectMenu(plugin, quest,
                        (SpoutPlayer) rpgplayer.getPlayer(), quest.getName(),
                        MessageUtils.TextMenuSplit(text), buttons);

                rpgplayer.setTaskState(task, TaskState.DONE);
                ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed one of your tasks!");
            }
        }

        if (isFinished(rpgplayer, quest, true)) {
            ((Player) rpgplayer.getPlayer()).sendMessage(ChatColor.GREEN + "You have completed quest \"" + quest.getName() + "\"");
        }
    }

    /**
     * 
     * @param rpgplayer
     *            RpgPlayer to check
     * @param quest
     *            quest to check
     * @param save
     *            true if you want to save QuestState.COMPLETED to the RpgPlayer
     * @return returns true if the quest is finished
     */

    public boolean isFinished(RpgPlayer rpgplayer, Quest quest, boolean save) {
        for (final Task task : quest.getTasks()) {
            if (!rpgplayer.getTaskState(task).equals(TaskState.DONE))
                return false;
        }
        if (save) {
            rpgplayer.setQuestState(quest, QuestState.COMPLETED);
        }
        return true;
    }

    public void npcRightClicked(NPC npc, RpgPlayer rpgplayer) {
        boolean showDone = false;
        Quest doneQuest = null;
        for (final Quest quest : RpgQuests.qm.getQuests()) {
            if (rpgplayer.getQuestState(quest).equals(QuestState.UNSTARTED)) {
                if (quest.getQuestGiver().equalsIgnoreCase(
                        ((HumanNPC) npc).getName())) {
                    showDone = false;

                    final String welcome = quest.getStartText();
                    final String task = quest.getTaskText();
                    final String[] raw = MessageUtils.TextMenuSplit(task);
                    final String[] text = new String[raw.length + 1];
                    for (int i = 0; i - 1 < raw.length; i++) {
                        if (i == 0) {
                            text[i] = welcome;
                        } else {
                            text[i] = raw[i - 1];
                        }
                    }
                    final String[] buttons = { "Accept Quest", "Close" };

                    final TextSelectMenu menu = new TextSelectMenu(plugin,
                            quest, ((SpoutPlayer) rpgplayer.getPlayer()),
                            quest.getName(), text, buttons);
                    break;
                }
            } else if (rpgplayer.getQuestState(quest).equals(QuestState.STARTED)) {
                if (quest.getQuestGiver().equalsIgnoreCase(
                        ((HumanNPC) npc).getName())) {
                    for (final Task task : RpgQuests.qm.getCurrentTasks(quest,
                            rpgplayer)) {
                        if (task.getType().equals(TaskType.DELIVER)) {

                        } else {
                            showDone = false;

                            final String text = quest.getBetweenText();
                            final String[] buttons = { "Close" };
                            final TextSelectMenu menu = new TextSelectMenu(
                                    plugin, quest,
                                    (SpoutPlayer) rpgplayer.getPlayer(),
                                    quest.getName(),
                                    MessageUtils.TextMenuSplit(text), buttons);
                        }
                    }
                    break;
                }
            } else if (rpgplayer.getQuestState(quest).equals(
                    QuestState.COMPLETED)) {
                if (quest.getQuestEnder().equalsIgnoreCase(
                        ((HumanNPC) npc).getName())) {
                    showDone = false;

                    final String text = quest.getCompleteText();
                    final String[] buttons = { "Close" };
                    final TextSelectMenu menu = new TextSelectMenu(plugin,
                            quest, (SpoutPlayer) rpgplayer.getPlayer(),
                            quest.getName(), MessageUtils.TextMenuSplit(text),
                            buttons);

                    break;
                }
            } else if (rpgplayer.getQuestState(quest).equals(QuestState.DONE)) {
                if (quest.getQuestEnder().equalsIgnoreCase(
                        ((HumanNPC) npc).getName())) {
                    showDone = true;
                    doneQuest = quest;
                }
            }
        }

        if (showDone) {
            final String text = doneQuest.getDoneText();
            final String[] buttons = { "Close" };
            final TextSelectMenu menu = new TextSelectMenu(plugin, doneQuest,
                    (SpoutPlayer) rpgplayer.getPlayer(), doneQuest.getName(),
                    MessageUtils.TextMenuSplit(text), buttons);
        }
    }

    public void accepted(RpgQuests plugin, RpgPlayer rpgplayer, Quest quest) {
        final String name = quest.getId();

        rpgplayer.setQuestState(quest, QuestState.STARTED);

        final String[] buttons = { "Close" };
        final TextSelectMenu menu = new TextSelectMenu(plugin, quest,
                ((SpoutPlayer) rpgplayer.getPlayer()), name,
                MessageUtils.TextMenuSplit("Accepted " + name), buttons);
    }
}
