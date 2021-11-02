package basic.test.entity;

import basic.test.FileReadSyncHandler;

public class FileRead1 extends FileReadSyncHandler {
    @Override
    protected String run() {
        System.out.println("FileRead1.run(), then return");
        return this.getClass().getName();
    }
}
