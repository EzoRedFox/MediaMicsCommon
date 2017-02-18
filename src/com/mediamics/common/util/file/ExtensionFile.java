package com.mediamics.common.util.file;

import com.mediamics.common.util.date.DateType;
import com.mediamics.common.util.date.DateUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Matsu
 */
public class ExtensionFile {

    private final File file;

    public ExtensionFile(String parent, String... paths) {
        this.file = Paths.get(parent, paths).toFile();
    }

    public ExtensionFile(File file) {
        this.file = file;
    }
    
    public ExtensionFile(Path path){
        this.file = path.toFile();
    }

    public ExtensionFile getTempFile() throws IOException {
        ExtensionFile tmpFile = new ExtensionFile(file.getParentFile().getAbsolutePath()
                ,(file.getName() + DateUtil.getNowDate(DateType.yyyyMMddHHmmssSSS_simple)));
        if (file.exists()) {
            copyTo(tmpFile);
        }
        return tmpFile;
    }

    public void copyTo(ExtensionFile target) throws IOException {
        Files.copy(this.file.toPath(), target.file.toPath());
    }

    public File toFile() {
        return file;
    }
    
    public void delete(){
        file.delete();
    }
}
