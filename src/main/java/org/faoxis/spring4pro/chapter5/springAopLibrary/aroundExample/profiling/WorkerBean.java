package org.faoxis.spring4pro.chapter5.springAopLibrary.aroundExample.profiling;

public class WorkerBean {

    public void soSomeWork(int noOfTimes) {
        for (int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.println("");
    }

}
