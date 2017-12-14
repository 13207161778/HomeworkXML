package com.lanou3g;

public class Boss extends Peson implements UserInter{
    @Override
    public void onLine() {
        // TODO Auto-generated method stub
        System.out.println("老板上班了");
        tour();
    }

    @Override
    public void offLine() {
        // TODO Auto-generated method stub
        System.out.println("老板下班回家了");
    }
    public void tour() {
        System.out.println("老板正在巡视各个部门");
    }
}
