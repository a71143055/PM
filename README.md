# Profile Management Web App

Spring Boot 기반의 프로필 관리 웹 애플리케이션입니다.  
사용자는 회원가입/로그인을 통해 계정을 만들고, 자신의 프로필을 등록/수정/삭제할 수 있습니다.

## 🚀 주요 기능
- 회원가입 / 로그인
- 프로필 CRUD (생성, 조회, 수정, 삭제)
- 프로필 공개/비공개 설정
- Thymeleaf 기반 UI

## 🛠️ 기술 스택
- Spring Boot 3.x
- Spring MVC / Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Lombok

## ⚙️ 실행 방법
1. MySQL에 `profiledb` 데이터베이스 생성
2. `application.properties`에 DB 계정 정보 입력
3. 프로젝트 빌드 및 실행
   ```bash
   mvn spring-boot:run

---

## 🟢 Getter/Setter 처리 방법

엔티티 클래스(`User`, `Profile`)에서 Getter/Setter를 처리하는 방법은 두 가지가 있습니다:

### 1. **직접 작성**
```java
public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }
