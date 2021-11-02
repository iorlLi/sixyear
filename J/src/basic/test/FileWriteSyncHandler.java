package basic.test;

public abstract class FileWriteSyncHandler extends AbstractSyncHandler{
    @Override
    protected void doProcess() {
        System.out.println("FileWriteSyncHandler.doProcess(), then write file ");
        String run = run();
        System.out.println(run);
    }

    protected abstract String run();
}
