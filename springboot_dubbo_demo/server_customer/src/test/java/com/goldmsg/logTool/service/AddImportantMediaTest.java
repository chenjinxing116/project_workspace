package com.goldmsg.logTool.service;

import com.goldmsg.logTool.entity.LogInfo;
import org.junit.Test;
import sun.misc.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Vector;

public class AddImportantMediaTest {

    @Test
    public void testSPI() {

        Iterator<SPIService> provider=Service.providers(SPIService.class);
        ServiceLoader<SPIService> loader = ServiceLoader.load(SPIService.class);

        while(provider.hasNext()){
            SPIService spiService=provider.next();
            spiService.execute();
        }

        System.out.println("--------------------------------------");

        Iterator<SPIService> iterator = loader.iterator();
        while (iterator.hasNext()){
            SPIService spiService=iterator.next();
            spiService.execute();
        }


    }


    @Test
    public void testVector() {

        Vector<String> vector = new Vector<>();
        vector.add("123");
        String s = vector.get(0);
        System.out.println(s);
    }


    @Test
    public void testSerialization(){

//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("log.txt"));
//            LogInfo logInfo = new LogInfo();
//            logInfo.setDevice_code("1111");
//            oos.writeObject(logInfo);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("log.txt"));
            LogInfo logInfo = (LogInfo)ois.readObject();
            System.out.println(logInfo.getDevice_code());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}