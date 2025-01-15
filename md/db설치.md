- ### Docker postgres 다운
    - ```docker pull postgres:16```

- ### Docker Container Run
    - ```docker run --name miniproject -e POSTGRES_PASSWORD=manager -d -p 5437:5432 postgres:14 ```

- ### Docker Run 확인
    - ```docker ps ```


- ### 컨테이너 진입
    - ```docker exec -it miniproject /bin/bash```


- ### PostgresSql 진입 (기본 사용자 : postgres)
    - ```psql -U postgres```


- ### 사용자 만들기
    - ``` create database miniproject;```


- ### chat_be 와 연결

