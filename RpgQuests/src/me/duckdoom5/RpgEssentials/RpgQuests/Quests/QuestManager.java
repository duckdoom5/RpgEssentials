package me.duckdoom5.RpgEssentials.RpgQuests.Quests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import me.duckdoom5.RpgEssentials.RpgEssentials;
import me.duckdoom5.RpgEssentials.RpgQuests.RpgQuests;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.config.Configuration;

import org.getspout.spoutapi.player.SpoutPlayer;

public class QuestManager {

    private final HashMap<String, Quest> quests = new LinkedHashMap<>();

    public HashMap<SpoutPlayer, Quest> createQuest = new LinkedHashMap<>();

    public HashMap<SpoutPlayer, Quest> editQuest = new LinkedHashMap<>();

    public HashMap<SpoutPlayer, Task> editTask = new LinkedHashMap<>();

    public Set<SpoutPlayer> isCreating = new HashSet<>();

    public void saveQuests() {
        for (final Quest quest : quests.values()) {
            try {
                final File file = new File("plugins/RpgQuests/Temp/quests");
                if (!file.exists()) {
                    file.mkdirs();
                }
                Configuration.save(quest, "plugins/RpgQuests/Temp/quests/" + quest.getId() + ".quest");
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void loadQuests() {
        final File dir = new File("plugins/RpgQuests/Temp/quests");
        final String[] names = dir.list();
        if (names != null) {
            for (final String name : names) {
                RpgQuests.plugin.getLogger().info(name);
                try {
                    final Quest quest = (Quest) Configuration.load("plugins/RpgQuests/Temp/quests/" + name);
                    addQuest(quest);
                } catch (final FileNotFoundException e) {
                    RpgEssentials.getLog().info(name + " is not found.");
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Quest getQuestByid(String id) {
        if (quests.containsKey(id)) {
            return quests.get(id);
        }
        return null;
    }

    public Quest[] getQuests() {
        return quests.values().toArray(new Quest[quests.values().size()]);
    }

    public boolean containsQuest(String questname) {
        return quests.containsKey(questname);
    }

    /**
     * Adds a new quest
     * 
     * @param quest
     *            quest to be added
     * @return returns false if quest exists.
     */

    public boolean addQuest(Quest quest) {
        if (quests.containsKey(quest.getId())) {
            return false;
        }
        quests.put(quest.getId(), quest);
        saveQuests();
        return true;
    }

    public void updateQuest(Quest quest) {
        quests.put(quest.getId(), quest);
    }

    public boolean removeQuest(Quest quest) {
        if (!quests.containsKey(quest.getId())) {
            return false;
        }
        quests.remove(quest.getId());
        final File file = new File("plugins/RpgQuests/Temp/quests/" + quest.getId() + ".quest");
        file.delete();
        return true;
    }

    public void setState() {
        // rpgplayer.setQuestState(quest, queststate);
    }

    public Set<Task> orderById(Task[] tasks) {
        final Set<Task> set = new LinkedHashSet<>();
        int id = 0;
        while (set.size() != tasks.length) {
            for (final Task task : tasks) {
                if (id == task.getId()) {
                    set.add(task);
                }
            }
            id++;
        }

        return set;
    }

    public Set<Task> getCurrentTasks(Quest quest) {
        final Set<Task> tasks = orderById(quest.getTasks());
        int id = 0;

        final Set<Task> current = new LinkedHashSet<>();

        for (final Task task : tasks) {
            /*
             * if(rpgplayer.getTaskState(task).equals(TaskState.UNSTARTED)){
             * if(task.getId() == id){ current.add(task);
             * 
             * } }
             */
            if (id != task.getId()) {
                id = task.getId();
            }
        }
        return current;
    }
}
