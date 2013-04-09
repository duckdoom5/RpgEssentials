package com.topcat.npclib.nms;

import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityTargetEvent;

public class NpcEntityTargetEvent extends EntityTargetEvent {

	public static enum NpcTargetReason {
		CLOSEST_PLAYER, NPC_RIGHTCLICKED, NPC_BOUNCED
	}

	@SuppressWarnings("unused")
	private static final long		serialVersionUID	= -8103432985035183865L;

	private final NpcTargetReason	reason;

	public NpcEntityTargetEvent(final Entity entity, final Entity target, final NpcTargetReason reason) {
		super(entity, target, TargetReason.CUSTOM);
		this.reason = reason;
	}

	public NpcTargetReason getNpcReason() {
		return reason;
	}

}