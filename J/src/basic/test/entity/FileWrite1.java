package basic.test.entity;

import basic.test.FileWriteSyncHandler;

public class FileWrite1 extends FileWriteSyncHandler {
    @Override
    protected String run() {
        System.out.println("FileWrite1.run(), then return");
        return this.getClass().getName();
    }
}
