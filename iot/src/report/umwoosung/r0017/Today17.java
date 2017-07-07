package report.umwoosung.r0017;
/*트렌젝션
 * 1.작업을 하는 사람의 저장영역.
 * 2.뭘하던지 상관없지만 commit이나 rollback을 해야지 반영이됨.
 * 
 * 
 * 
 * 안되면 테이블락
 * 되면 로우락
 * 
 * rollback; 저장안한걸 되돌리는것
 * commit 저장.
 * 
 * 
 * 커넥션 풀링
 * 1.데이터베이스와 연결라인을  여러개 만들고
 * 순차적으로 그것으로 작업하는것.
 * 
 * desc user; user 테이블을 설명해주는것.
 * 
 *  foreign key
 *  
 *  1:n관계를 맺는것- 유일한것인 id와 무한으로 들어갈수있는 게시판에 들어가는 writer와의 관계
 * 
 */


