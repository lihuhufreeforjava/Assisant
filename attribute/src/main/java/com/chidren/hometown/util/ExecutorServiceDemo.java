package com.chidren.hometown.util;

import com.chidren.hometown.dataobject.HumanDO;
import com.children.gernater.core.DataGenerateAssist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class MyRunnable implements Runnable {
    DataGenerateAssist<HumanDO> dataGenerateAssist =new DataGenerateAssist<HumanDO>();
    private long submitTime;
    private AtomicInteger ai;
    public MyRunnable(long d,AtomicInteger ai){
        this.submitTime=d;
        this.ai=ai;
    }
    @Override
    public void run() {
        HumanDO humanInfo=null;
            humanInfo=new HumanDO();
            try {
                dataGenerateAssist.injectData(humanInfo);
            } catch (IllegalAccessException e) {
                e.printStackTrace() ;
            }
        C3p0Utils.insert(humanInfo);
        long e=System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"------"+submitTime+"---"+(e-submitTime)+"-----------"+ai.incrementAndGet());
    }
}

public class ExecutorServiceDemo {
    public static void main(String[] args) {
     // 创建一个线程池对象，控制要创建几个线程对象。
     // public static ExecutorService newFixedThreadPool(int nThreads)
     ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
     AtomicInteger ai=new AtomicInteger(0);
     for (long i=0;i<10000;i++){
         pool.submit(new MyRunnable(System.currentTimeMillis(), ai));
     }
        System.out.println("提交完成");
    //结束线程池
    pool.shutdown();
   }
}