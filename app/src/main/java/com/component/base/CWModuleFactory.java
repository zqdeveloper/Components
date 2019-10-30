package com.component.base;

public class CWModuleFactory {
    public static CWAbsModule newModuleInstance(String name)
    {
        if (name == null ||name.equals("")) {
            return null;
        }
        try{
            Class<? extends CWAbsModule>   moduleClassz = (Class<? extends CWAbsModule>)Class.forName(name);
            if (moduleClassz!=null) {
                CWAbsModule instance = (CWAbsModule)moduleClassz.newInstance();
                return instance;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
