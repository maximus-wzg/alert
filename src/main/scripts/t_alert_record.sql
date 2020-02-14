-- 告警记录表
create table t_alert_record (
    id varchar2(50) primary key,
    host varchar2(50) not null,
    app_name varchar2(50) not null,
    term varchar2(50) not null,
    message varchar2(500),
    es_idx varchar2(50) not null,
    msg_time date, -- 日志的生成时间
    insert_time date -- 记录的插入时间
)