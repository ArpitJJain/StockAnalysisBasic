package com.arpit.stock.input;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.messaging.support.GenericMessage;
import static com.arpit.stock.utility.UtilityClass.*;

import java.io.File;
import java.lang.reflect.Method;

public class FileMovePostProcessingAdvice implements AfterReturningAdvice {
    static Logger logger = Logger.getLogger(FileMovePostProcessingAdvice.class);
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println(o);
        logger.debug("Hello");
        if(null != o && o instanceof GenericMessage){
         GenericMessage g = (GenericMessage)o;
         String fileName = getStringValue(g.getHeaders().get("file_originalFile"));
         String newFileName=fileName.replace("\\data\\","\\data\\archive\\").replace(".csv",System.currentTimeMillis()+".csv");
            File f = new File(fileName);
            boolean result = f.renameTo(new File(newFileName));
            if(result){
                System.out.println("File moved");
            }else{
                System.out.println("File Not moved");
            }
        }
    }
}
