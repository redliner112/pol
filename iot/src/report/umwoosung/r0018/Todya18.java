package report.umwoosung.r0018;
/*foreign key(user_id) references user_info(user_id) 를 할시 foreign key에서의 
 * user_id가 int 인경우 references user_info의 user_id가 varchar라면 
 * 입력하는 값이 다르기때문에 성립하지않는다. 
 * 결국 데이터타입을 마춰줘야한다.
 * 
 * createstatement 아무것도없는 입력할수있는창만 만들수있는것.
 * (입력하자마자 실행이 되는것.)
 * preparestatement 입력한 단계에서 실행하기전에 기다리는것.
 * 
 * st.cloase() createstatement 로 생성된창을 끄는것.
 * 
 * 
 * <<<<<<<<<<<<<시험문제<<<<<<<<<<<<<<<<
 * alter table comment_info
add foreign key(ui_num) references user_info(num);
ddl dml dcl 트렌젝션
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 */
