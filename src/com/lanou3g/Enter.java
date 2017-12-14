package com.lanou3g;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Enter {

    public  void enter() throws DocumentException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户账号");
        String userName = scanner.nextLine();
        System.out.println("请输入用户密码");
        String userPasswd  = scanner.nextLine();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/output.xml"));

        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for(int i = 0;i<elements.size();i++){
            Element element = elements.get(i);
            Element user =  element.element("userName");
            Element passd = element.element("userPasswd");
            Element userProfession = element.element("userProfession");
            if(user.getText().equals(userName) && passd.getText().equals(userPasswd)) {
                 Attribute name = element.attribute("name");
                 System.out.println("姓名:"+name.getValue()+"   "+"职业:"+userProfession.getText());
                 System.out.println("登录成功");
             }
        }

    }

}
