package report.umwoosung.r0013;
/*InterFace.
 * 
 * 1.인터페이스는 선언만 가능하다.!!!!!!!!!!!!!!!!!!!!!!!!!
 * 1.2 인터페이스에서 선언한것은 절대로 다른곳에서 바뀌지않느다.
 * 2.상용하는데 있어서 반듯이 있어야하는 서로간의 약속.
 * (ex.윈도우의 더블클릭으로 오픈되는 것)
 * 3.똑같이 대문자로 작성해줘야한다
 * 4.생성자가있을 이유가없다.(생성자를 가질수없다.)
 * 5.implements 상속받기위해 쓰는것.
 * 6.하나의 데이터 타입으로 다형성을 제공해준다.
 * 7.인터페이스는 다중구현이 가능하다
 * 8.인터페이스로 여러가지 생성자를 호출할수있다.
 * 9.인터페이스에서 받은것을 반듯이 재정의 해야한다.
 * 10.인터페이스가 인터페이스를 상속가능
 * 
 * Array.asList() - ()안의 변수를 배열에서 리스트로 만들수있다.
 * 
 *클래스에서 쓸수있는 값을 정의해주고 구현하는 상위상속인?? 
 *
 * @<=어노테이션.  - 주석이 하는 어떤일.
 * 
 * 새로운 jar설치<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<시험
 * 
 * google guava download jar 검색
 * Maven Repository: com.google.guava » guava » 16.0.1 클릭
 * Download (BUNDLE) (1.2 MB) 클릭
 * 다운로드후 받은 jar파일을
 * C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext 에 복사 붙여넣기.
 * 재시작
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * 
 * DBMS란.
 * 
 * 1.Oarcle
 * 2.MS-SQL
 * 3.MYSQL(mariaDB)
 * 
 * 데이터=/=정보 (데이터=(가공)=>정보)
 * 
 * HediSQR 
 * 1.테이블의 key와 value 의 숫자는 항상 같아야한다.(use 테이블명;해야 사용가능)
 * 2.select * from test; 테이블구성을 보여준다.*부분에 키값을 입력하면 부분부분으로 볼수있다.
 *   insert 입력한다.
 *   delete 지운다.
 *   update 수정한다.
 *  where 1열='찾고자하는것'
 *  update 테이블명
     set 수정할열의이름 = '수정할것.'
     where 수정할열의 컬럼정보='수정할 열의 ';
     
 * 3.insert into test
      values('test1','test1','윤길이');
      테이블에 위의 형식으로 집어넣는다.
 *4.HediSQR에서 =는 대입이아니라 같다이다.
 * 5.;은 그라인의 끝을 말한다. 
 * 6.=대신 like를쓰면 그글자를쓴것이 나온다.
 * 7.'%길%'%%사이의 글자중간에 길이라고쓴 글자는 모두다 나온다 .
 * 앞자리에쓴거라면 '홍%'뒷지라리면 '%동'
 * 8.varchr 길이를 30개로 적어놨으면 31개이상의 글자는 들어가지 않는다.
 * 9.delete from test
 * where 행='테스트' 지우고싶은것이 있을땐 where 조건으로 찾아서 지우지않으면 다지워진다.
 * 10.update 수정하는것.
 * 11.중복이되도 상관없다. 그래서 중복되는것을 따로따로 절대 지울수 없기때문에 uniq로 기본키를 만들어줘야한다.
 * drop database 테이블명 테이블을 지운다.
 * 할때마다 f5눌러줘야한다.
 * 
 * 
 * 
 * 
/*
 iot_test2  데이터베이스 생성
 user라는 테이블을 생성해주세요컬럼정보는 아래와 같습니다.
 -컬럼정보-
 1.id varchar(30)
 2.password varchar(30)
 3.name varchar(100)
 4. age varchar(3)
 5.zip-code varchar(5)
 6.address1 varchar(100)
 7.address2 varchar(100)
 
 각컬럼에 맞는 값을 10개로우 입력해주세요
 test1,pass1,name1,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test2,pass2,name2,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test3,pass3,name3,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test4,pass4,name4,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test5,pass5,name5,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test6,pass6,name6,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test7,pass7,name7,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test8,pass8,name8,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test9,pass9,name9,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 test10,pass10,name10,30,12345,서울 강서구 등촌1동,보람3차아파트 101동 301호
 
 id의 값이 test3인 사람의 address1의 정보를 "서울 강남구 역삼동"으로 수정해주세요
 id의 값이 test5인 사람의 address1의 정보를 "서울 영등포기 여의도동으로 수정해주세요
 
 address1의 값중에 등촌1동이라는 값을 가지고 있는 사람의 address1정보를
 "서울 강서구 화곡동"으로 수정해주세요
 
 password의 값중 pass1,pass2의 값인 사람의 비밀번호를 pass로 변경해주세요.
 
 */
 
