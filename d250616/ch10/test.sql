-- 샘플 확인용 시퀀스 만들기
    -- 세미콜론으로 문장 구분을 안했을경우, 
    -- 해당 문장 직접 드래그해서, ctrl + enter 로 실행 해주세요.
create sequence member501_seq start with 1 increment by 1;
    drop sequence member501_seq;
    drop table member501;
-- 샘플 확인용 테이블만들기
create table member501 (
   id       number primary key,
   name     varchar2(100),
   password varchar2(100),
   email    varchar2(100),
   reg_date varchar2(50)
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
SELECT * from member501 WHERE ID = 2;
SELECT * from MEMBER501 WHERE NAME LIKE '%이상용';

-- 전체조회, 아이디 기준으로 내림차순(최신등록일순)
SELECT * FROM MEMBER501 ORDER BY ID DESC;