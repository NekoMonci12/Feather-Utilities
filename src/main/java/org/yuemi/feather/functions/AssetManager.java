package org.yuemi.feather.functions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.Enumeration;

public class AssetManager {

    private final File dataFolder;

    public AssetManager(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    public void copyAssets() {
        try {
            File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            try (JarFile jar = new JarFile(jarFile)) {
                Enumeration<JarEntry> entries = jar.entries();
                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();
                    String name = entry.getName();
                    
                    if (name.startsWith("assets/") && !entry.isDirectory()) {
                        File outFile = new File(dataFolder, name);
                        outFile.getParentFile().mkdirs();

                        try (InputStream in = jar.getInputStream(entry);
                             OutputStream out = java.nio.file.Files.newOutputStream(outFile.toPath())) {
                            in.transferTo(out);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("[FeatherUtils] §cError copying assets from JAR.");
            e.printStackTrace();
        }
    }
}
