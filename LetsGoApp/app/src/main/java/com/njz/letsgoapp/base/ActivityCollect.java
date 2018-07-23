package com.njz.letsgoapp.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.List;
import java.util.Stack;

public class ActivityCollect {
    private static Stack<BaseActivity> activityStack;
    private static ActivityCollect instance;

    private ActivityCollect() {
    }

    /**
     * ��ʵ�� , UI���迼�Ƕ��߳�ͬ������
     */
    public static ActivityCollect getAppCollect() {
        if (instance == null) {
            instance = new ActivityCollect();
        }
        return instance;
    }


    /**
     * ���Activity��ջ
     */
    public void addActivity(BaseActivity activity) {
        if (activityStack == null) {
            activityStack = new Stack<BaseActivity>();
        }
        activityStack.add(activity);
    }

    /**
     * ��ȡ��ǰActivity��ջ��Activity��
     */
    public BaseActivity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) {
            return null;
        }
        BaseActivity activity = activityStack.lastElement();
        return activity;
    }


    /**
     * ����ָ����Activity(����)
     */
    public void finishAllNotHome() {
//        for (BaseActivity activity : activityStack) {
//            if (!activity.getClass().equals(HomeActivity.class)) {
//                activity.finish();
//            }
//        }

    }


    /**
     * ��ȡ��ǰActivity��ջ��Activity�� û���ҵ��򷵻�null
     */
    public BaseActivity findActivity(Class<?> cls) {
        BaseActivity activity = null;
        for (BaseActivity aty : activityStack) {
            if (aty.getClass().equals(cls)) {
                activity = aty;
                break;
            }
        }
        return activity;
    }

    /**
     * �Дஔǰactivity�Ƿ��ڶї������ڶ���
     *
     * @param cls
     * @return
     */
    public boolean isLastActivity(Class<?> cls) {
        int position = activityStack.size() - 2;
        if (position < 0) {
            return false;
        }
        if (cls == activityStack.get(position).getClass()) {
            return true;
        }
        return false;
    }

    /**
     * ������ǰActivity��ջ��Activity��
     */
    public void finishActivity() {
        BaseActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * ����ָ����Activity(����)
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * ����ָ����Activity(����)
     */
    public void finishActivity(Class<?> cls) {
        for (BaseActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    public void clearTop(Class<?> cls) {
        int i = 0;
        for (; i < activityStack.size(); i++) {
            if (cls.equals(activityStack.get(i).getClass())) {
                break;
            }
        }

        int startPosition = i + 1, endPosition = activityStack.size();

        if (startPosition < activityStack.size() && endPosition >= startPosition) {
            List<BaseActivity> list = activityStack.subList(startPosition, endPosition);
            if (null != list && !list.isEmpty()) {
                for (BaseActivity acts : list) {
                    acts.finish();
                }
            }
        }
    }

    /**
     * ��������Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * Ӧ�ó����˳�
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
