package basic.test;

import basic.test.entity.Handler;

public abstract class AbstractSyncHandler implements SyncHandler {
    @Override
    public void process() {
        System.out.println("AbstractSyncHandler.process(), then find protected doProcess ");
        doProcess();
    }

    protected abstract void doProcess();
}
