
# Eagler Context Redacted Diff
# Copyright (c) 2024 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> CHANGE  2 : 6  @  2 : 8

~ import java.io.InputStream;
~ import java.io.OutputStream;
~ import java.util.List;
~ 

> DELETE  4  @  4 : 5

> CHANGE  2 : 6  @  2 : 7

~ import net.lax1dude.eaglercraft.v1_8.internal.vfs2.VFile2;
~ import net.lax1dude.eaglercraft.v1_8.log4j.LogManager;
~ import net.lax1dude.eaglercraft.v1_8.log4j.Logger;
~ import net.lax1dude.eaglercraft.v1_8.sp.server.WorldsDB;

> CHANGE  3 : 6  @  3 : 6

~ 	private final VFile2 worldDirectory;
~ 	private final VFile2 playersDirectory;
~ 	private final VFile2 mapDataDir;

> CHANGE  3 : 7  @  3 : 9

~ 	public SaveHandler(VFile2 savesDirectory, String directoryName) {
~ 		this.worldDirectory = WorldsDB.newVFile(savesDirectory, directoryName);
~ 		this.playersDirectory = WorldsDB.newVFile(this.worldDirectory, "player");
~ 		this.mapDataDir = WorldsDB.newVFile(this.worldDirectory, "data");

> DELETE  1  @  1 : 4

> DELETE  1  @  1 : 2

> CHANGE  2 : 3  @  2 : 20

~ 	public VFile2 getWorldDirectory() {

> DELETE  3  @  3 : 21

> CHANGE  1 : 2  @  1 : 2

~ 		throw new RuntimeException("eagler");

> CHANGE  3 : 4  @  3 : 4

~ 		VFile2 file1 = WorldsDB.newVFile(this.worldDirectory, "level.dat");

> CHANGE  1 : 3  @  1 : 3

~ 			try (InputStream is = file1.getInputStream()) {
~ 				NBTTagCompound nbttagcompound2 = CompressedStreamTools.readCompressed(is);

> CHANGE  3 : 5  @  3 : 4

~ 				logger.error("Failed to load level.dat!");
~ 				logger.error(exception1);

> CHANGE  3 : 4  @  3 : 4

~ 		file1 = WorldsDB.newVFile(this.worldDirectory, "level.dat_old");

> CHANGE  1 : 3  @  1 : 3

~ 			try (InputStream is = file1.getInputStream()) {
~ 				NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(is);

> CHANGE  3 : 5  @  3 : 4

~ 				logger.error("Failed to load level.dat_old!");
~ 				logger.error(exception);

> CHANGE  12 : 18  @  12 : 16

~ 			VFile2 file1 = WorldsDB.newVFile(this.worldDirectory, "level.dat_new");
~ 			VFile2 file2 = WorldsDB.newVFile(this.worldDirectory, "level.dat_old");
~ 			VFile2 file3 = WorldsDB.newVFile(this.worldDirectory, "level.dat");
~ 			try (OutputStream os = file1.getOutputStream()) {
~ 				CompressedStreamTools.writeCompressed(nbttagcompound2, os);
~ 			}

> CHANGE  14 : 16  @  14 : 15

~ 			logger.error("Failed to write level.dat!");
~ 			logger.error(exception);

> CHANGE  10 : 16  @  10 : 14

~ 			VFile2 file1 = WorldsDB.newVFile(this.worldDirectory, "level.dat_new");
~ 			VFile2 file2 = WorldsDB.newVFile(this.worldDirectory, "level.dat_old");
~ 			VFile2 file3 = WorldsDB.newVFile(this.worldDirectory, "level.dat");
~ 			try (OutputStream os = file1.getOutputStream()) {
~ 				CompressedStreamTools.writeCompressed(nbttagcompound1, os);
~ 			}

> CHANGE  14 : 16  @  14 : 15

~ 			logger.error("Failed to write level.dat!");
~ 			logger.error(exception);

> CHANGE  8 : 14  @  8 : 11

~ 			String s = player.getName().toLowerCase();
~ 			VFile2 file1 = WorldsDB.newVFile(this.playersDirectory, s + ".dat.tmp");
~ 			VFile2 file2 = WorldsDB.newVFile(this.playersDirectory, s + ".dat");
~ 			try (OutputStream os = file1.getOutputStream()) {
~ 				CompressedStreamTools.writeCompressed(nbttagcompound, os);
~ 			}

> CHANGE  6 : 8  @  6 : 7

~ 			logger.error("Failed to save player data for {}", player.getName());
~ 			logger.error(var5);

> CHANGE  8 : 13  @  8 : 11

~ 			VFile2 file1 = WorldsDB.newVFile(this.playersDirectory, player.getName().toLowerCase() + ".dat");
~ 			if (file1.exists()) {
~ 				try (InputStream is = file1.getInputStream()) {
~ 					nbttagcompound = CompressedStreamTools.readCompressed(is);
~ 				}

> CHANGE  2 : 4  @  2 : 3

~ 			logger.error("Failed to load player data for {}", player.getName());
~ 			logger.error(var4);

> CHANGE  14 : 15  @  14 : 18

~ 		List<String> astring = this.playersDirectory.listFilenames(false);

> CHANGE  1 : 5  @  1 : 4

~ 		for (int i = 0, l = astring.size(); i < l; ++i) {
~ 			String str = astring.get(i);
~ 			if (str.endsWith(".dat")) {
~ 				astring.set(i, str.substring(0, str.length() - 4));

> CHANGE  3 : 4  @  3 : 4

~ 		return astring.toArray(new String[astring.size()]);

> CHANGE  5 : 7  @  5 : 7

~ 	public VFile2 getMapFileFromName(String mapName) {
~ 		return WorldsDB.newVFile(this.mapDataDir, mapName + ".dat");

> EOF
