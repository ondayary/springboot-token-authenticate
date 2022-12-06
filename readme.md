# 프로젝트 설명
<hr>
이 프르젝트는 Spring Security를 이용한 인증을 구현한 예제 프로젝트입니다. <br>
Token이 잘 발행되는지, 발행된 Token을 이용해 인증 시도를 했을 때 <br>
유효한 Token인지, 잘못된 Token인지 확인하는 기능을 구현합니다.

# EndPoints
<hr>
POST /api/v1/login -- 단순 토큰 발급 <br>
POST /api/v1/reviews -- 토큰 인증

# 실행 방법
<hr>
http://localhost:8080/reviews 를 호출 할 때 <br>
Header에 Authorization에 Bearer </login에서 받은token> 을 넣어서 요청 합니다.