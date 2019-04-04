package com.example.mall.common;

/**
 * redis的key管理，每一个key在这里生成，避免key重复
 * @author willenfoo
 */
public enum RedisKeyManage {

    //定时任务的key
    TASK_LOCK_DOME("task:lock:dome", "定时任务,拉取充值记录", 300L),



    ;

    /**
     * redis的key
     */
    private String key;

    /**
     * key的描述
     */
    private String desc;

    /**
     * 键的过期时间,单位为秒,有效期默认为20秒
     */
    private Long expiredTime;

    RedisKeyManage(String key, String desc, Long expiredTime) {
        this.key = key;
        this.desc = desc;
        this.expiredTime = expiredTime;
    }

    /**
     * 生成reids的key
     * @param reidsKey
     * @param args
     * @return
     */
    public static String generate(RedisKeyManage reidsKey, Object... args) {
        return SYSTEM_REDIS_KEY_PREFIX + String.format(reidsKey.getKey(), args);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Long expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * 系统redis，key的前缀，防止多系统key冲突
     */
    private static String SYSTEM_REDIS_KEY_PREFIX = "message:"; // TODO: 2018/7/26 项目中修改

}
