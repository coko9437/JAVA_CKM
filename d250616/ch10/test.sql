-- 샘플 확인용 시퀀스 만들기
create sequence member501_seq start with 1 increment by 1;

-- 샘플 확인용 테이블만들기
create table member501 (
   id       number primary key,
   name     varchar2(100),
   password varchar2(100),
   email    varchar2(100),
   reg_date varchar2(30)
)

-- 샘플 데이터 하나 넣기
INSERT INTO member501 (id, name, password, email, reg_date) VALUES (
    member501_seq.nextval,
    '이상용',
    '1234',
    'lsy@naver.com',
    '2025년06월16일12시09분'

);
commit;
select * from member501;