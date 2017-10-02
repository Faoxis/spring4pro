package org.faoxis.spring4pro.chapter3.hierarchicalContext;

public class TargetPrinter {

    private Target target;

    public TargetPrinter(Target target) {
        this.target = target;
    }

    public void print() {
        System.out.println(target.getVal());
    }

}
