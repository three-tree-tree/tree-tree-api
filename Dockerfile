#베이스 이미지 선택
FROM amazoncorretto:11

#내 로컬 jar 파일 경로
ARG JAR_FILE=build/libs/*.jar

#내 로컬 컴퓨터의 jar을 컨테이너로 copy
COPY ${JAR_FILE} app.jar

#도커 이미지 생성 전 수행 할 명령어
#RUN apk update && apk add python3 py3-pip

COPY . /app

#작업디렉토리 생성
WORKDIR /app

# 포트 8080 열기
EXPOSE 8080

#컨테이너 최종 단계 명령어
#컨테이너가 실행될때 변하지 않을 명령어는 entrypoint 사용
#shell 명령어로도 쓸 수 있지만 리스트포맷으로 정리해주는게 좋다
# CMD ["flask", "--app", "index", "--debug", "run", "--host", "0.0.0.0", "--port", "1205"]
# 자바 명령어로, 
#코틀린은 자바로 바뀐다
ENTRYPOINT ["java","-jar","/app.jar"]

#인텔리제이를 깔고 -> jdk 설정하고 -> 내 파일 ./gradlew build 하고 -> 도커 이미지 생성해보기
