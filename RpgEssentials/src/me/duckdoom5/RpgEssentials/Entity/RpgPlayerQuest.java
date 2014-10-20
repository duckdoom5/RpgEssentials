package me.duckdoom5.RpgEssentials.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Quest;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.QuestState;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.Task;
import me.duckdoom5.RpgEssentials.RpgQuests.Quests.Tasks.TaskState;

import org.bukkit.entity.Player;

public class RpgPlayerQuest extends RpgPlayer {
    private static final long serialVersionUID = -5669993327836299292L;
    private final HashMap<Task, TaskState> tasks = new HashMap<>();
    private final HashMap<Quest, QuestState> quests = new HashMap<>();

    public RpgPlayerQuest(Player player) {
        super(player);
    }

    public QuestState getQuestState(Quest quest) {
        if (!quests.containsKey(quest)) {
            quests.put(quest, QuestState.UNSTARTED);
            return QuestState.UNSTARTED;
        }
        return quests.get(quest);
    }

    public void setQuestState(Quest quest, QuestState queststate) {
        quests.put(quest, queststate);
    }

    public Quest[] getStartedQuests() {
        final List<Quest> started = new ArrayList<>();

        for (final Quest quest : quests.keySet()) {
            if (quests.get(quest) == QuestState.STARTED) {
                started.add(quest);
            }
        }
        return started.toArray(new Quest[started.size()]);
    }

    public TaskState getTaskState(Task task) {
        if (!tasks.containsKey(task)) {
            tasks.put(task, TaskState.UNSTARTED);
            return TaskState.UNSTARTED;
        }
        return tasks.get(task);
    }

    public void setTaskState(Task task, TaskState taskstate) {
        tasks.put(task, taskstate);
    }
}
