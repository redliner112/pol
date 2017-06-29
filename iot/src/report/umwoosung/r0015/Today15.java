package report.umwoosung.r0015;
/*
 * statement 받자마자 쿼리실행
 * preparedstatement 미리 준비를한다.(쿼리를 메모리에 올려놓고 실행함.)
 * 
 *차이. 다중작업시 preparedstatement 가 빠르다.(단일작업시 근소한차이)
 *
 *바인딩 ?<= "내가 이곳에 어떤것을 치완하겠다."는 의미.
 *  
 * 1)String sql = "select ID,PWD,NAME from user";
 *  if(!name.equals("")){
				sql += " WHERE NAME='" + name + "'";
			}
			PreparedStatement prestmt = con.prepareStatement(sql);
 *  에서
 *  
 *  2)String sql = "select ID,PWD,NAME from user";
			if(!name.equals("")){
				sql += " WHERE NAME =?";
			}
			
			PreparedStatement prestmt = con.prepareStatement(sql);
			if(!name.equals("")){
				prestmt.setString(1, name);
 *
 *
 *1)에서 '" + name + "'을 "?"로 바꾸고
 *그?를 prestmt.setString(1,name);으로 ArrayList를 이용해서 순차적으로 집어넣는다.
 *
 *제너릭 ?를 넣으면 어떤것을 넣던 내가 넣을수있다.
 *====================================================================================
 *
 *mysql select *from user_info
where name = '청길동'
or name = '황길동'
order by age desc,num ;                          desc 반대로 정렬

or 또는 
and 두개다 만족했을때

select age,num, count(age) from user
group by age;     select에 묶은것들만 나온다. 

select sum(age),avg(age),count(1) from user;             - avg() 평균,sum()더하기,count()갯수

alter table user_info
add column class_num int(5) not null;               - alter 수정한다.

select ui.*,ci.*from user_info as ui,class_info as ci   -as 별칭(별명)  user_info as ui <=ui로 별칭한다.
where ui.class_num=ci.class_num;                              ui.*<= ui 의 *(모든것).


select count(*) from user_info  전체 로우갯수표시.
for(변수 : 배열) 배열에 변수를 하나씩 넣겠다.

Iterator 알아오기.

hm.keyset(); 키값을 찾을수있는 명령어.

 */

