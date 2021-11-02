package basic.test;

import basic.test.entity.JobContext;

public interface Job {
    void execute(JobContext context);
}
