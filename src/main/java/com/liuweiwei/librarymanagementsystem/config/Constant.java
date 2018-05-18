package com.liuweiwei.librarymanagementsystem.config;

import com.liuweiwei.librarymanagementsystem.SpringContextHolder;
import org.springframework.context.ApplicationContext;

/**
 * 公共加载DAO、service
 */
public class Constant {

    public static ApplicationContext BF = null;

    public static ServiceFacade ServiceFacade;
    public static DaoFacade DaoFacade;

    static {
        if (BF == null) {
            BF = SpringContextHolder.getApplicationContext();
            if (BF != null) {
                if (ServiceFacade == null) {
                    ServiceFacade = (ServiceFacade) BF.getBean("ServiceFacade");
                }
                if (DaoFacade == null) {
                    DaoFacade = (DaoFacade) BF.getBean("DaoFacade");
                }
            }
        }

    }
}
