package com.component.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.component.base.annotation.ModuleEvent;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ModuleBus {

    private ModuleBus(){}

    private static final String TAG = "ModuleBus";

    public static final int MODULE_RESULLT = 1001;

    private static ArrayMap<Object,ArrayMap<String,MethodInfo>> moduleEventMethods = new ArrayMap<Object, ArrayMap<String, MethodInfo>>();

    private static ArrayMap<Class<?>, ArrayMap<String,ArrayList<Object>>> moduleMethodClient = new ArrayMap<Class<?>, ArrayMap<String, ArrayList<Object>>>();

    private ArrayMap<String,Object> moduleAct = new ArrayMap<>();

    private volatile static ModuleBus instance;

    private String PK_NAME = "";

    public static ModuleBus getInstance() {
        if (instance==null) {
            synchronized (ModuleBus.class) {
                if (instance == null) {
                    instance = new ModuleBus();
                }
            }
        }
        return instance;
    }


    public void register(Object client) {
        if (client==null) return;
        Class<?> orginalClass = client.getClass();
        if (orginalClass == null) return;
        Method[] methods = orginalClass.getMethods();
        for (Method method: methods) {
            ModuleEvent event = method.getAnnotation(ModuleEvent.class);
            if (event != null){
                Class<?> clientClass = event.coreClientClass();
                addClient(clientClass,client,method);
                addEventMethod(client,method,event.single());
            }
        }
    }

    private void addClient(Class<?> clientClass, Object client, Method m) {
        ArrayMap<String,ArrayList<Object>> clientMethodList = moduleMethodClient.get(clientClass);
        if (clientMethodList == null) {
            clientMethodList = new ArrayMap<>();
            moduleMethodClient.put(clientClass,clientMethodList);
        }
        ArrayList<Object> clientList = clientMethodList.get(m.getName());
        if (clientList == null) {
            clientList = new ArrayList<Object>();
            clientMethodList.put(m.getName(),clientList);
        }
        clientList.add(client);
    }

    private void addEventMethod(Object client, Method m, boolean single) {
        ArrayMap<String, MethodInfo> methods = moduleEventMethods.get(client);
        if (methods == null) {
            methods = new ArrayMap<String, MethodInfo>();
            moduleEventMethods.put(client,methods);
        }
        methods.put(m.getName(),new MethodInfo(m.getName(),m,single));

    }

    public void unregister(Object client) {
        if (client == null) return;
        Class<?> orginalClass = client.getClass();
        if (orginalClass == null) return;
        Method[] methods = orginalClass.getMethods();
        for (Method method: methods) {
            ModuleEvent event = method.getAnnotation(ModuleEvent.class);
            if (event != null) {
                Class<?> clientClass = event.coreClientClass();
                moduleMethodClient.remove(clientClass);
            }
        }
    }

    public ArrayList<Object> getClient(Class<?> clientClass, String methodName) {
        if (clientClass == null || methodName == null) return null;
        return moduleMethodClient.get(clientClass).get(methodName);
    }

    public void post(Class<?> clientClass, String methodName,Object...args) {
        if (clientClass == null|| methodName == null || methodName.length() == 0) return;
        ArrayList<Object> clientList = getClient(clientClass,methodName);
        if (clientList == null) return;
        try {
            for (Object c: clientList) {
                ArrayMap<String,MethodInfo> methos = moduleEventMethods.get(c);
                Method method = methos.get(methodName).m;
                if(method == null){
                    Log.e(TAG,"cannot find client method"+methodName +"for args["+args.length+"]" + Arrays.toString(args));
                    return;
                }else if(method.getParameterTypes() == null){
                    Log.e(TAG,"cannot find client method param:"+method.getParameterTypes() +"for args["+args.length+"]" + Arrays.toString(args));
                    return;
                }else if(method.getParameterTypes().length != args.length){
                    Log.e(TAG,"method "+methodName +" param number not matched:method("+method.getParameterTypes().length+"), args(" + args.length+")");
                    return;
                }
                method.invoke(c,args);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object postSingle(Class<?> clientClass,String methodName,Object...args){
        if(clientClass == null || methodName == null ||methodName.length() == 0) return null;
        ArrayList<Object> clientList = getClient(clientClass,methodName);
        if(clientList == null) return null;
        try{
            MethodInfo methodInfo = moduleEventMethods.get(clientClass).get(methodName);
            boolean single = methodInfo.single;
            Method method = methodInfo.m;
            if (!single || clientList.size() != 1){
                Log.e(TAG,"method"+methodName +"for args["+args.length+"]" + Arrays.toString(args) + " is not single");
                return null;
            } else if(method == null){
                Log.e(TAG,"cannot find client method"+methodName +"for args["+args.length+"]" + Arrays.toString(args));
                return null;
            }else if(method.getParameterTypes() == null){
                Log.e(TAG,"cannot find client method param:"+method.getParameterTypes() +"for args["+args.length+"]" + Arrays.toString(args));
                return null;
            }else if(method.getParameterTypes().length != args.length){
                Log.e(TAG,"method "+methodName +" param number not matched:method("+method.getParameterTypes().length+"), args(" + args.length+")");
                return null;
            }
            for(Object c: clientList){
                try{
                    return method.invoke(c,args);
                }catch (Throwable e){
                    Log.e(TAG,"Notifiy client method invoke error.",e);
                }
            }

        }catch (Throwable e){
            Log.e(TAG,"Notify client error",e);
            return null;
        }
        return null;
    }

    public void startModuleActivity(Object object,String className){
        startModuleActivity(object,className,null);
    }

    public void startModuleActivity(Object object,String className, Bundle bundle){
        if(className == null) return;
        moduleAct.put(className,object);
        post(IBaseClient.class,"startModuleActivity",className,bundle);
    }


    public void moduleResult(Object object,Intent data){
        if (data==null)return;
        post(IBaseClient.class,"moduleResult",moduleAct.get(object.getClass().getName()),data);
    }

    public String getPackageName() {
        return PK_NAME;
    }

    public void setPackageName(String name) {
        this.PK_NAME = name;
    }
}
