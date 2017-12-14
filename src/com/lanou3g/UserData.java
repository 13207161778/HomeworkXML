package com.lanou3g;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserData {

    public static Scanner scanner = new Scanner(System.in);

    public void login() throws IOException, DocumentException {


        System.out.println("请注册用户");
        String user = scanner.nextLine();
        System.out.println("请注册用户名");
        String userName = scanner.nextLine();
        System.out.println("请注册用户名密码");
        String userPasswd = scanner.nextLine();
        System.out.println("请注册用户职业");
        String userProfession = scanner.nextLine();
        witer(user,userName,userPasswd,userProfession);
        contunue();

    }
    public static Map<String,Peson> witer(String user1,String username,String userpasswd,String userprofession) throws IOException {
        Map<String,Peson> map = new HashMap<>();
        Document document = DocumentHelper.createDocument();
        Element user = document.addElement("user");
        Element peson = user.addElement("Peson");
        peson.addAttribute("name",user1);
        Element userName = peson.addElement("userName");
        userName.addText(username);
        Element userPasswd = peson.addElement("userPasswd");
        userPasswd.addText(userpasswd);
        Element userProfession = peson.addElement("userProfession");
        userProfession.addText(userprofession);
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/output.xml"),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        map.put(user1,new Peson(user1,username,userpasswd,userprofession));
        return map;
    }
    public static void contunue() throws DocumentException, IOException {
        System.out.println("是否注册?    (1:Yes      2.No)");
        int input = scanner.nextInt();
        scanner.nextLine();
        if(input==1){
            System.out.println("请注册用户");
            String user = scanner.nextLine();
            System.out.println("请注册用户名");
            String userName = scanner.nextLine();
            System.out.println("请注册用户名密码");
            String userPasswd = scanner.nextLine();
            System.out.println("请注册用户职业");
            String userProfession = scanner.nextLine();
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(new File("src/output.xml"));
            Element rootElement = read.getRootElement();
            Element peson = rootElement.addElement("Peson");
            peson.addAttribute("name",user);
            Element userName1 = peson.addElement("userName");
            userName1.addText(userName);
            Element userPasswd1 = peson.addElement("userPasswd");
            userPasswd1.addText(userPasswd);
            Element userProfession1 = peson.addElement("userProfession");
            userProfession1.addText(userProfession);
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("UTF-8");
            XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/output.xml"),outputFormat);
            xmlWriter.write(read);
            xmlWriter.close();
            contunue();
        }
        if(input==2){
                start();
        }
    }
    //XML删除
    public static void delect(String str) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/output.xml"));
        Element rootElement = read.getRootElement();
        List<Element> peson = rootElement.elements("Peson");
        for(int i = 0;i<peson.size();i++){
            Element element = peson.get(i);
            Attribute name = element.attribute("name");
            if(name.getValue().equals(str)){
                peson.remove(element);
                System.out.println("删除成功");
            }

        }
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/output.xml"),outputFormat);
        xmlWriter.write(rootElement);
        xmlWriter.close();
    }
    public static void alter(String userName,String user,String passwad,String profession) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/output.xml"));
        Element rootElement = read.getRootElement();
        List<Element> peson = rootElement.elements("Peson");
        for (int i = 0;i<peson.size();i++){
            Element element = peson.get(i);
            Attribute attribute = element.attribute("name");
            if(attribute.getValue().equals(userName)) {
                Element user1 = element.element("userName");
                user1.setText(user);
                Element userPasswd = element.element("userPasswd");
                userPasswd.setText(passwad);
                Element userProfession = element.element("userProfession");
                userProfession.setText(profession);
                System.out.println("修改成功");
            }

        }
        OutputFormat outputFormat = new OutputFormat();
        outputFormat.setEncoding("UTF-8");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("src/output.xml"),outputFormat);
        xmlWriter.write(rootElement);
        xmlWriter.close();

    }
    public static void start() throws IOException, DocumentException {
        System.out.println("1:注册         2:登录        3:删除用户信息        4:修改用户信息");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    contunue();
                    break;
                case "2":
                    Enter enter = new Enter();
                    enter.enter();
                    break;
                case "3":
                    System.out.println("请输入删除用户");
                    String user = scanner.nextLine();
                    delect(user);
                    break;
                case "4":
                    System.out.println("请输入要修改的用户");
                    String userName1 = scanner.nextLine();
                    System.out.println("请输入要修改的用户名");
                    String user1 = scanner.nextLine();
                    System.out.println("请输入要修改的用户密码");
                    String userPasswd = scanner.nextLine();
                    System.out.println("请输入要修改的用户职业");
                    String userProfession = scanner.nextLine();
                    alter(userName1, user1, userPasswd, userProfession);
                    break;
                default:
                    break;
            }

    }
}
