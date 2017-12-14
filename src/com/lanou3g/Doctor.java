package com.lanou3g;

public class Doctor extends Peson implements UserInter{
    @Override
    public void onLine() {
        // TODO Auto-generated method stub
        System.out.println("医生开始给人看病了");
        research();
    }

    @Override
    public void offLine() {
        // TODO Auto-generated method stub
        System.out.println("医生下班了");
    }

    public  void research() {
        System.out.println("医生正在研究新型癌症");
    }

}
