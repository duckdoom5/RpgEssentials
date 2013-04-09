package com.topcat.npclib.nms;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.server.v1_4_R1.DedicatedPlayerList;
import net.minecraft.server.v1_4_R1.DedicatedServer;
import net.minecraft.server.v1_4_R1.MinecraftServer;
import net.minecraft.server.v1_4_R1.PropertyManager;
import net.minecraft.server.v1_4_R1.WorldServer;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_4_R1.CraftServer;
import org.bukkit.craftbukkit.libs.jline.console.ConsoleReader;

/**
 * Server hacks for Bukkit
 * 
 * @author Kekec852
 */
public class BServer {

	private static BServer	ins;

	public static BServer getInstance() {
		if (ins == null) {
			ins = new BServer();
		}
		return ins;
	}

	private MinecraftServer					mcServer;
	private CraftServer						cServer;
	private final Server					server;

	private final HashMap<String, BWorld>	worlds	= new HashMap<String, BWorld>();

	private BServer() {
		server = Bukkit.getServer();
		try {
			cServer = (CraftServer) server;
			mcServer = cServer.getServer();
		} catch (final Exception ex) {
			Logger.getLogger("Minecraft").log(Level.SEVERE, null, ex);
		}
	}

	public void disablePlugins() {
		cServer.disablePlugins();
	}

	public void dispatchCommand(final CommandSender sender, final String msg) {
		cServer.dispatchCommand(sender, msg);
	}

	public DedicatedPlayerList getHandle() {
		return cServer.getHandle();
	}

	public Logger getLogger() {
		return cServer.getLogger();
	}

	public MinecraftServer getMCServer() {
		return mcServer;
	}

	public PropertyManager getPropertyManager() {
		return mcServer.getPropertyManager();
	}

	public ConsoleReader getReader() {
		return cServer.getReader();
	}

	public Server getServer() {
		return server;
	}

	public int getSpawnProtationRadius() {
		return mcServer.server.getSpawnRadius();
	}

	public BWorld getWorld(final String worldName) {
		if (worlds.containsKey(worldName)) {
			return worlds.get(worldName);
		}
		final BWorld w = new BWorld(this, worldName);
		worlds.put(worldName, w);
		return w;
	}

	public List<WorldServer> getWorldServers() {
		return mcServer.worlds;
	}

	public void loadPlugins() {
		cServer.loadPlugins();
	}

	public void sendConsoleCommand(final String cmd) {
		if (mcServer.isRunning()) {
			((DedicatedServer) mcServer).issueCommand(cmd, mcServer);
		}
	}

	public void stop() {
		mcServer.safeShutdown();
	}

}