/*
 * Copyright 2004-2014 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.lealone.storage.aose.cache;

import java.io.IOException;
import java.nio.channels.FileChannel;

import org.lealone.storage.fs.impl.FilePathWrapper;

/**
 * A file with a read cache.
 */
public class FilePathCache extends FilePathWrapper {

    public static FileChannel wrap(FileChannel f) {
        return new FileCache(f);
    }

    @Override
    public String getScheme() {
        return "cache";
    }

    @Override
    public FileChannel open(String mode) throws IOException {
        return new FileCache(getBase().open(mode));
    }
}