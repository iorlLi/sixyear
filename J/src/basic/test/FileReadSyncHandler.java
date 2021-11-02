package basic.test;

public abstract class FileReadSyncHandler extends AbstractSyncHandler{
    @Override
    protected void doProcess() {
        System.out.println("FileSyncHandler.doProcess(), then read file ");
        String run = run();
        System.out.println(run);
    }

    protected abstract String run();
}
