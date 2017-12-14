package com.lanou3g;

public class Cooker extends Peson implements UserInter{
    @Override
    public void onLine() {
        // TODO Auto-generated method stub
        System.out.println("厨师开始炒菜了");
        cooking();
    }

    @Override
    public void offLine() {
        // TODO Auto-generated method stub
        System.out.println("厨师下班了");
    }
    public void cooking() {
        System.out.println("厨师正在给客人做饭");
    }
}
