package basic.test;

import basic.test.entity.JobContext;

public class FileJob implements Job {

    public static void main(String[] args) {
        JobContext jobContext = new JobContext();
        jobContext.setJobName("basic.test.entity.FileRead1");
        jobContext.setJobName("basic.test.entity.FileWrite1");
        Job job = new FileJob();
        job.execute(jobContext);
    }

    /*
                                            | --- jobContext中 file1规则
                        |--- 第二层抽象 读文件  ---- jobContext中 file1规则
        开始---- 第一层抽象(已经指定了最终实现类)
                        |--- 第二层抽象 写文件  ---- jobContext中 write1规则
                                       | --- jobContext中 write1规则


     */
    @Override
    public void execute(JobContext context) {
        try {
            String jobName = context.getJobName();
            Class<?> aClass = Class. forName(jobName);
            // 这里是具体实现类，实现类执行父类的方法
            SyncHandler newInstance = (SyncHandler) aClass.newInstance();
            newInstance.process();
        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }

    }
}
