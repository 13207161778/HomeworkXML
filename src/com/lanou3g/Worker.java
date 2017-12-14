package com.lanou3g;

public class Worker extends Peson implements UserInter{
    @Override
    public void onLine() {
        // TODO Auto-generated method stub
        System.out.println("工人开始干活了");
        brick();
    }

    @Override
    public void offLine() {
        // TODO Auto-generated method stub
        System.out.println("工人下班了");
    }
    public void brick() {
        System.out.println("工人开始搬砖了");
    }
}
